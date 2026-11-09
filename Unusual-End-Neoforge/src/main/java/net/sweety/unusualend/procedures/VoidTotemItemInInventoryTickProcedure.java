package net.sweety.unusualend.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.client.ClientItemActivation;
import net.sweety.unusualend.configuration.UEConfig;

public class VoidTotemItemInInventoryTickProcedure {
    public static boolean shouldTrigger(Level level, Player player, ItemStack stack) {
        return !player.isSpectator()
                && player.getY() < level.getMinBuildHeight() + UEConfig.VOID_TOTEM_Y.get()
                && !player.getCooldowns().isOnCooldown(stack.getItem());
    }

    public static void execute(Level level, Player player, ItemStack stack) {
        if (!shouldTrigger(level, player, stack))
            return;
        player.getCooldowns().addCooldown(stack.getItem(), UEConfig.VOID_TOTEM.get().intValue());
        if (level.isClientSide()) {
            ClientItemActivation.display(stack.copyWithCount(1));
            return;
        }
        if (!(player instanceof ServerPlayer serverPlayer) || !(level instanceof ServerLevel serverLevel))
            return;
        ItemStack snapshot = stack.copyWithCount(1);
        stack.shrink(1);
        TeleportHelper.awardAdvancement(serverPlayer, "worse_than_death");
        if (NBTProcessor.getNBTBoolean(snapshot, "LinkedTotem") && teleportToAnchor(serverPlayer, snapshot))
            return;
        rescueFromVoid(serverPlayer, serverLevel);
    }

    private static boolean teleportToAnchor(ServerPlayer player, ItemStack snapshot) {
        ServerLevel target = TeleportHelper.linkedLevel(player, snapshot);
        if (!TeleportHelper.teleport(player, target, TeleportHelper.linkedPosition(snapshot)))
            return false;
        TeleportHelper.playArrivalEffects(target, player, SoundSource.NEUTRAL);
        if (UEConfig.NEED_ANCHOR_FOR_TOTEMS.get())
            TeleportHelper.rememberAnchorTarget(player, snapshot);
        return true;
    }

    private static void rescueFromVoid(ServerPlayer player, ServerLevel level) {
        Vec3 origin = player.position();
        Vec3 rescue = TeleportHelper.voidRescuePosition(level, origin.x, origin.z);
        TeleportHelper.teleport(player, level, rescue);
        level.playSound(null, rescue.x, rescue.y, rescue.z, SoundEvents.PHANTOM_AMBIENT, SoundSource.PLAYERS, 2, 1);
        level.sendParticles(ParticleTypes.REVERSE_PORTAL, rescue.x, rescue.y, rescue.z, 25, 0.5, 0.5, 0.5, 0);
        player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 600, 0, false, true));
        player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 100, 0));
    }
}

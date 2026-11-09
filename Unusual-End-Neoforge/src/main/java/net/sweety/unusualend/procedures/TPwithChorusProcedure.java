package net.sweety.unusualend.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.portal.DimensionTransition;
import net.sweety.unusualend.configuration.UEConfig;

public class TPwithChorusProcedure {
    public static void execute(Level level, LivingEntity entity, ItemStack stack) {
        entity.swing(entity.getMainHandItem() == stack ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND, true);
        if (level.isClientSide() || !(entity instanceof ServerPlayer player))
            return;
        boolean teleported = NBTProcessor.getNBTBoolean(stack, "LinkedMirror") ? teleportToAnchor(player, stack) : teleportToRespawn(player);
        if (!teleported) {
            player.displayClientMessage(Component.translatable("text.unusualend.not_linked"), true);
            return;
        }
        player.getCooldowns().addCooldown(stack.getItem(), UEConfig.PRISMATIC_MIRROR.get().intValue());
        if (!player.getAbilities().instabuild)
            stack.hurtAndBreak(1, player, player.getEquipmentSlotForItem(stack));
    }

    private static boolean teleportToAnchor(ServerPlayer player, ItemStack stack) {
        ServerLevel target = TeleportHelper.linkedLevel(player, stack);
        if (!TeleportHelper.teleport(player, target, TeleportHelper.linkedPosition(stack)))
            return false;
        TeleportHelper.playArrivalEffects(target, player, SoundSource.PLAYERS);
        if (UEConfig.NEED_ANCHOR.get())
            TeleportHelper.rememberAnchorTarget(player, stack);
        return true;
    }

    private static boolean teleportToRespawn(ServerPlayer player) {
        DimensionTransition transition = player.findRespawnPositionAndUseSpawnBlock(true, DimensionTransition.DO_NOTHING);
        if (transition.missingRespawnBlock())
            player.displayClientMessage(Component.translatable("block.minecraft.spawn.not_valid"), true);
        ServerLevel target = transition.newLevel();
        if (!TeleportHelper.teleport(player, target, transition.pos()))
            return false;
        TeleportHelper.playArrivalEffects(target, player, SoundSource.NEUTRAL);
        return true;
    }
}

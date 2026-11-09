package net.sweety.unusualend.procedures;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingUseTotemEvent;
import net.sweety.unusualend.configuration.UEConfig;

@EventBusSubscriber
public class LinkedTotemTriggerProcedure {
    @SubscribeEvent
    public static void whenEntityUsesTotem(LivingUseTotemEvent event) {
        LivingEntity entity = event.getEntity();
        ItemStack stack = event.getTotem();
        if (entity.level().isClientSide() || !NBTProcessor.getNBTBoolean(stack, "LinkedTotem"))
            return;
        if (entity instanceof ServerPlayer player)
            teleportPlayer(player, stack.copy());
        else if (entity.level() instanceof ServerLevel level)
            teleportMob(level, entity, stack);
    }

    private static void teleportPlayer(ServerPlayer player, ItemStack snapshot) {
        ServerLevel target = TeleportHelper.linkedLevel(player, snapshot);
        if (!TeleportHelper.teleport(player, target, TeleportHelper.linkedPosition(snapshot)))
            return;
        TeleportHelper.playArrivalEffects(target, player, SoundSource.NEUTRAL);
        if (UEConfig.NEED_ANCHOR_FOR_TOTEMS.get())
            TeleportHelper.rememberAnchorTarget(player, snapshot);
    }

    private static void teleportMob(ServerLevel level, LivingEntity entity, ItemStack stack) {
        boolean sameDimension = TeleportHelper.parseDimension(NBTProcessor.getNBTString(stack, "TpW"))
                .map(key -> key.equals(level.dimension()))
                .orElse(true);
        Vec3 target = TeleportHelper.linkedPosition(stack);
        if (!sameDimension || !TeleportHelper.isSafeDestination(level, target))
            return;
        entity.setDeltaMovement(Vec3.ZERO);
        entity.resetFallDistance();
        entity.teleportTo(target.x, target.y, target.z);
    }
}

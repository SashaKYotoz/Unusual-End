package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.init.UnusualEndBlocks;

@EventBusSubscriber
public class TeleportToWarpingWaystoneProcedure {
    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
    }

    private static void execute(PlayerInteractEvent.RightClickItem event, Level level, double x, double y, double z, Player player) {
        if (player == null)
            return;
        double raydistance;
        double lookX = 0;
        double lookY = 0;
        double lookZ = 0;
        if (DisplayOverlayWaystoneProcedure.execute(level, player)) {
            if (player.getMainHandItem().is(ItemTags.create(UnusualEnd.makeUEID("can_teleport_to_warping_waystone")))) {
                if (!player.isCreative())
                    player.getMainHandItem().shrink(1);
                player.getCooldowns().addCooldown(player.getMainHandItem().getItem(), 10);
                player.swing(InteractionHand.MAIN_HAND, true);
            } else {
                if (!player.isCreative())
                    player.getOffhandItem().shrink(1);
                player.getCooldowns().addCooldown(player.getOffhandItem().getItem(), 10);
                player.swing(InteractionHand.OFF_HAND, true);
            }
            if (event != null)
                event.setCanceled(true);
            if (!level.isClientSide())
                level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1, 1);
            else
                level.playLocalSound(x, y, z, SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1, 1, false);
            raydistance = 1;
            while (!((level.getBlockState(BlockPos.containing(lookX, lookY, lookZ))).getBlock() == UnusualEndBlocks.WARPING_WAYSTONE.get())) {
                lookX = player.level().clip(new ClipContext(player.getEyePosition(1f), player.getEyePosition(1f).add(player.getViewVector(1f).scale(raydistance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player)).getBlockPos().getX();
                lookY = player.level().clip(new ClipContext(player.getEyePosition(1f), player.getEyePosition(1f).add(player.getViewVector(1f).scale(raydistance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player)).getBlockPos().getY();
                lookZ = player.level().clip(new ClipContext(player.getEyePosition(1f), player.getEyePosition(1f).add(player.getViewVector(1f).scale(raydistance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player)).getBlockPos().getZ();
                raydistance = raydistance + 1;
                if (raydistance > 65) {
                    break;
                }
            }
            if (raydistance <= 64) {
                if (!level.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(lookX, lookY, lookZ);
                    BlockEntity _blockEntity = level.getBlockEntity(_bp);
                    BlockState _bs = level.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putDouble("RedstoneLevel", 60);
                    level.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
                player.teleportTo((lookX + 0.5), (lookY + 1), (lookZ + 0.5));
                if (player instanceof ServerPlayer serverPlayer)
                    serverPlayer.connection.teleport((lookX + 0.5), (lookY + 1), (lookZ + 0.5), player.getYRot(), player.getXRot());
            }
        }
    }
}

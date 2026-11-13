package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sweety.unusualend.init.UnusualendModTags;
import net.sweety.unusualend.util.LookHelper;
import net.sweety.unusualend.util.ProcedureHelper;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TeleportToWarpingWaystoneProcedure {
	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (!(entity instanceof LivingEntity living) || !LookHelper.isLookingAtWaystone(entity))
			return;
		InteractionHand hand = living.getMainHandItem().is(UnusualendModTags.Items.CAN_TELEPORT_TO_WARPING_WAYSTONE) ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;
		ItemStack key = living.getItemInHand(hand);
		if (entity instanceof Player player)
			player.getCooldowns().addCooldown(key.getItem(), 10);
		if (!ProcedureHelper.isCreative(entity))
			key.shrink(1);
		living.swing(hand, true);
		if (event != null && event.isCancelable())
			event.setCanceled(true);
		ProcedureHelper.playSound(world, x, y, z, SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1, 1);
		BlockPos target = LookHelper.raycast(entity, LookHelper.WAYSTONE_RANGE, ClipContext.Block.COLLIDER).getBlockPos();
		if (!world.isClientSide()) {
			BlockEntity blockEntity = world.getBlockEntity(target);
			if (blockEntity != null)
				blockEntity.getPersistentData().putDouble("RedstoneLevel", 60);
			BlockState state = world.getBlockState(target);
			if (world instanceof Level level)
				level.sendBlockUpdated(target, state, state, 3);
		}
		entity.teleportTo(target.getX() + 0.5, target.getY() + 1, target.getZ() + 0.5);
		if (entity instanceof ServerPlayer serverPlayer)
			serverPlayer.connection.teleport(target.getX() + 0.5, target.getY() + 1, target.getZ() + 0.5, entity.getYRot(), entity.getXRot());
	}
}

package net.sweety.unusualend.util;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.init.UnusualendModBlocks;
import net.sweety.unusualend.init.UnusualendModTags;

public final class LookHelper {
	public static final double ALTAR_RANGE = 5;
	public static final double WAYSTONE_RANGE = 64;

	private LookHelper() {
	}

	public static BlockHitResult raycast(Entity entity, double range, ClipContext.Block shape) {
		Vec3 eye = entity.getEyePosition(1f);
		return entity.level().clip(new ClipContext(eye, eye.add(entity.getViewVector(1f).scale(range)), shape, ClipContext.Fluid.NONE, entity));
	}

	public static boolean isLookingAt(Entity entity, Block block, double range, ClipContext.Block shape) {
		if (entity == null)
			return false;
		BlockHitResult hit = raycast(entity, range, shape);
		return hit.getType() == HitResult.Type.BLOCK && entity.level().getBlockState(hit.getBlockPos()).is(block);
	}

	public static boolean isLookingAtAltar(Entity entity, boolean holdingDragonBreath) {
		return isLookingAt(entity, UnusualendModBlocks.GOLEM_ALTAR.get(), ALTAR_RANGE, ClipContext.Block.OUTLINE)
				&& entity instanceof LivingEntity living && living.getMainHandItem().is(Items.DRAGON_BREATH) == holdingDragonBreath;
	}

	public static boolean holdsWaystoneKey(Entity entity) {
		return entity instanceof LivingEntity living
				&& (living.getMainHandItem().is(UnusualendModTags.Items.CAN_TELEPORT_TO_WARPING_WAYSTONE) || living.getOffhandItem().is(UnusualendModTags.Items.CAN_TELEPORT_TO_WARPING_WAYSTONE));
	}

	public static boolean isLookingAtWaystone(Entity entity) {
		return holdsWaystoneKey(entity) && isLookingAt(entity, UnusualendModBlocks.WARPING_WAYSTONE.get(), WAYSTONE_RANGE, ClipContext.Block.COLLIDER);
	}
}

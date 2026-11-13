package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.init.UnusualendModBlocks;

public class DrippingGloopstoneGrowthConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("unusualend:gloopstone_valid_placement")))
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == UnusualendModBlocks.POLISHED_GLOOPSTONE.get()
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == UnusualendModBlocks.GLOOPSTONE_BRICKS.get();
	}
}

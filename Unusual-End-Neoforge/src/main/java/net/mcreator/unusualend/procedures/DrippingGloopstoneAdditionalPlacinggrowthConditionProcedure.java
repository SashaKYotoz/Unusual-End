package net.mcreator.unusualend.procedures;

import net.mcreator.unusualend.UnusualEnd;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModBlocks;

public class DrippingGloopstoneAdditionalPlacinggrowthConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(UnusualEnd.makeUEID("gloopstone_valid_placement")))
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == UnusualendModBlocks.POLISHED_GLOOPSTONE.get()
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == UnusualendModBlocks.GLOOPSTONE_BRICKS.get();
	}
}

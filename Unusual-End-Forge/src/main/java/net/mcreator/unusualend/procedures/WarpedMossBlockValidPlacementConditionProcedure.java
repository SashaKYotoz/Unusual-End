package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModBlocks;

public class WarpedMossBlockValidPlacementConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return Blocks.MOSS_CARPET.defaultBlockState().canSurvive(world, BlockPos.containing(x, y, z)) && !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == UnusualendModBlocks.WARPED_MOSS.get());
	}
}

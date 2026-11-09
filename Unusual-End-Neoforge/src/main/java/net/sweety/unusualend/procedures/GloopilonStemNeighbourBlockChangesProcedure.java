package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.init.UnusualEndBlocks;
import net.sweety.unusualend.util.ProcedureHelper;

public class GloopilonStemNeighbourBlockChangesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == UnusualEndBlocks.GLOOPILON_BULB.get())) {
			ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z), UnusualEndBlocks.GLOOPILON_SEEDS.get().defaultBlockState(), 3);
		}
	}
}

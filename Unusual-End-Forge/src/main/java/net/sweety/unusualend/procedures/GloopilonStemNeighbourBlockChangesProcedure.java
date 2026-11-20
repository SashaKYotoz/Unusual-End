package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.init.UnusualendModBlocks;
import net.sweety.unusualend.util.ProcedureHelper;

public class GloopilonStemNeighbourBlockChangesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == UnusualendModBlocks.GLOOPILON_BULB.get())) {
			ProcedureHelper.replaceBlockKeepingState(world, new BlockPos(x, y, z), UnusualendModBlocks.GLOOPILON_SEEDS.get().defaultBlockState(), 3);
		}
	}
}

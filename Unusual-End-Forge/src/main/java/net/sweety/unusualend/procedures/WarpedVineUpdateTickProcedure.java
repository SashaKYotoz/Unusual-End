package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.init.UnusualendModBlocks;
import net.sweety.unusualend.util.ProcedureHelper;

public class WarpedVineUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.2) {
			ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z), UnusualendModBlocks.GROWN_WARPED_BUSH.get().defaultBlockState(), 3);
		}
	}
}

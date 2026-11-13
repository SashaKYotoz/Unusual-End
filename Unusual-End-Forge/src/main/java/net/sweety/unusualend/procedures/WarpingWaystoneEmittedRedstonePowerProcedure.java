package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.util.ProcedureHelper;

public class WarpingWaystoneEmittedRedstonePowerProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		if (ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "RedstoneLevel") >= 1) {
			return 15;
		}
		return 0;
	}
}

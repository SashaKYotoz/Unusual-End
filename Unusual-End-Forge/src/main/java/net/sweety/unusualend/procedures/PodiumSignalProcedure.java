package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.util.ProcedureHelper;

public class PodiumSignalProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		if (ProcedureHelper.getItemCount(world, BlockPos.containing(x, y, z), 0) >= 1) {
			return 15;
		}
		return 0;
	}
}

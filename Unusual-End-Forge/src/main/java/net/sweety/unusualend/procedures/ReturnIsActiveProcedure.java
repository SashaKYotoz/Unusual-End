package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.util.ProcedureHelper;

public class ReturnIsActiveProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "isActive") > 0;
	}
}

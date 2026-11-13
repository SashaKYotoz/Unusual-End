package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.util.ProcedureHelper;

public class ReturnIsinhibActiveProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return Math.round(ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "isActive")) > 0;
	}
}

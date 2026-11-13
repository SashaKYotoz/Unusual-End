package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.init.UnusualendModBlocks;
import net.sweety.unusualend.util.ProcedureHelper;

public class ChorusGrassOnBoneMealSuccessProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
		ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z), UnusualendModBlocks.FLOWERING_PURPUR_GRASS.get().defaultBlockState(), 3);
	}
}

package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.init.UnusualEndBlocks;
import net.sweety.unusualend.util.ProcedureHelper;

public class SmallWarpedAlgaeOnBoneMealSuccessProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z), UnusualEndBlocks.WARPED_ALGAE.get().defaultBlockState(), 3);
    }
}

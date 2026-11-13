package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.init.UnusualendModBlocks;

public class EndstoneSproutsOnBoneMealSuccessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.5) {
			world.setBlock(BlockPos.containing(x, y, z), UnusualendModBlocks.PURPUR_GRASS.get().defaultBlockState(), 3);
		} else {
			world.setBlock(BlockPos.containing(x, y, z), UnusualendModBlocks.CHORUS_ROOTS.get().defaultBlockState(), 3);
		}
	}
}

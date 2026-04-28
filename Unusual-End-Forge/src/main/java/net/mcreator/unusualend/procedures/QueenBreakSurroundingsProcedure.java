package net.mcreator.unusualend.procedures;

import net.mcreator.unusualend.init.UnusualendModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

public class QueenBreakSurroundingsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = -1;
		for (int index0 = 0; index0 < 4; index0++) {
			sy = 0;
			for (int index1 = 0; index1 < 5; index1++) {
				sz = -1;
				for (int index2 = 0; index2 < 4; index2++) {
					if (!world.isEmptyBlock(BlockPos.containing(x + sx, y + sy, z + sz))) {
						if (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getDestroySpeed(world, BlockPos.containing(x + sx, y + sy, z + sz)) >= 0) {
							world.destroyBlock(BlockPos.containing(x + sx, y + sy, z + sz), false);
							world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(UnusualendModBlocks.VOID_PARTICLES_BLOCK.get().defaultBlockState()));
						}
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
	}
}

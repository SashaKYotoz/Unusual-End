package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModBlocks;

public class LensHardglassBlockDestroyedByExplosionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.95) {
			world.setBlock(BlockPos.containing(x, y, z), UnusualendModBlocks.LENS_HARDGLASS.get().defaultBlockState(), 3);
		} else {
			world.setBlock(BlockPos.containing(x, y, z), UnusualendModBlocks.CRACKED_LENS_HARDGLASS.get().defaultBlockState(), 3);
		}
	}
}

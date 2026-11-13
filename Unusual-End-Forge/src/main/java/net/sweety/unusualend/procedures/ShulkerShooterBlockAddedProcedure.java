package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;

public class ShulkerShooterBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), 20);
	}
}
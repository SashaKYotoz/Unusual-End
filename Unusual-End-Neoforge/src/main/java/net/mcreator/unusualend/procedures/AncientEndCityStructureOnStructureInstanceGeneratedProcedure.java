package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModBlocks;

public class AncientEndCityStructureOnStructureInstanceGeneratedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (!entity.level().isClientSide())
			entity.discard();
		sx = -2;
		for (int index0 = 0; index0 < 4; index0++) {
			sy = -3;
			for (int index1 = 0; index1 < 6; index1++) {
				sz = -2;
				for (int index2 = 0; index2 < 4; index2++) {
					if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == UnusualendModBlocks.SHULKER_SHOOTER.get()) {
						world.scheduleTick(BlockPos.containing(x + sx, y + sy, z + sz), world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getBlock(), 20);
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
	}
}

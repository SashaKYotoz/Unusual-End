package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModParticleTypes;

public class WarpedLanternOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level0 && _level0.hasNeighborSignal(BlockPos.containing(x, y, z))) {
			world.addParticle((SimpleParticleType) (UnusualendModParticleTypes.CITRINE_SHINE.get()), (x + Mth.nextDouble(RandomSource.create(), 0.1, 0.9)), (y + Mth.nextDouble(RandomSource.create(), 0.1, 0.9)),
					(z + Mth.nextDouble(RandomSource.create(), 0.1, 0.9)), 0, 0, 0);
		}
	}
}

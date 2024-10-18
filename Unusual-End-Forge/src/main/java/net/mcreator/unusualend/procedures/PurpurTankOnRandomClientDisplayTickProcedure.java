package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class PurpurTankOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()) {
			world.addParticle(ParticleTypes.PORTAL, (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.3, 0.3)), (y + 0.75 + Mth.nextDouble(RandomSource.create(), -0.3, 0.3)), (z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.3, 0.3)), 0.1, 0.1,
					0.1);
		}
	}
}

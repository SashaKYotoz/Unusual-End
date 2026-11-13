package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelAccessor;

public class PurpurTankOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()) {
			world.addParticle(ParticleTypes.PORTAL, (x + 0.5 + Mth.nextDouble(world.getRandom(), -0.3, 0.3)), (y + 0.75 + Mth.nextDouble(world.getRandom(), -0.3, 0.3)), (z + 0.5 + Mth.nextDouble(world.getRandom(), -0.3, 0.3)), 0.1, 0.1,
					0.1);
		}
	}
}

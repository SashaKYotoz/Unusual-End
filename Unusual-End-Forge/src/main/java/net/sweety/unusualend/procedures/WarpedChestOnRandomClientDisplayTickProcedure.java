package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.init.UnusualendModParticleTypes;
import net.sweety.unusualend.util.ProcedureHelper;

public class WarpedChestOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(ProcedureHelper.getBlockEntityString(world, BlockPos.containing(x, y, z), "UUID")).contains(entity.getStringUUID())) {
			world.addParticle(ParticleTypes.DRIPPING_WATER, (x + Mth.nextDouble(world.getRandom(), -0.1, 1.1)), (y + Mth.nextDouble(world.getRandom(), 0.4, 0.85)), (z + Mth.nextDouble(world.getRandom(), -0.1, 1.1)), 0, 0, 0);
			world.addParticle(UnusualendModParticleTypes.BOLOK_PARTICLE.get(), (x + Mth.nextDouble(world.getRandom(), -0.1, 1.1)), (y + Mth.nextDouble(world.getRandom(), 0.4, 0.85)),
					(z + Mth.nextDouble(world.getRandom(), -0.1, 1.1)), 0, 0, 0);
			if (Math.random() < 0.3) {
				world.addParticle(UnusualendModParticleTypes.WARPED_BUBBLES.get(), (x + Mth.nextDouble(world.getRandom(), 0.2, 0.8)), (y + Mth.nextDouble(world.getRandom(), 0.7, 0.85)),
						(z + Mth.nextDouble(world.getRandom(), 0.2, 0.8)), 0, 0, 0);
			}
		} else {
			if (Math.random() < 0.3) {
				world.addParticle(ParticleTypes.SMOKE, (x + Mth.nextDouble(world.getRandom(), -0.1, 1.1)), (y + Mth.nextDouble(world.getRandom(), 0.4, 0.85)), (z + Mth.nextDouble(world.getRandom(), -0.1, 1.1)), 0, 0, 0);
			}
		}
	}
}

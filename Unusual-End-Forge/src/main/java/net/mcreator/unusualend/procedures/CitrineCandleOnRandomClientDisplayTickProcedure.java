package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.ParticleTypes;

public class CitrineCandleOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.addParticle(ParticleTypes.FLAME, (x + 0.5), (y + 0.92), (z + 0.5), 0, 0, 0);
		if (Math.random() < 0.1) {
			world.addParticle(ParticleTypes.EFFECT, (x + 0.5), (y + 0.92), (z + 0.5), 0, 0, 0);
		}
	}
}

package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.unusualend.init.UnusualendModParticleTypes;

public class BolokBootsBootsTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (UnusualendModParticleTypes.BOLOK_PARTICLE.get()), x, (y + 0.1), z, 1, 0.2, 0.2, 0.2, 0);
	}
}

package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.unusualend.init.UnusualendModParticleTypes;

public class WarpedBalloonProjWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor level, double x, double y, double z) {
		if (level instanceof ServerLevel _level)
			_level.sendParticles(UnusualendModParticleTypes.WARPED_BUBBLES.get(), x, y, z, 2, 0.2, 0.2, 0.2, 0);
		if (level instanceof ServerLevel _level)
			_level.sendParticles(UnusualendModParticleTypes.BOLOK_PARTICLE.get(), x, y, z, 1, 0.1, 0.1, 0.1, 0);
	}
}
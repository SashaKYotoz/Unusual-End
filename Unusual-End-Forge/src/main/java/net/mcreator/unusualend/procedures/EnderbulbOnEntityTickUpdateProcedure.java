package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.unusualend.UnusualendMod;

public class EnderbulbOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.PORTAL, x, (y - 0.2), z, 1, 0.2, 0.2, 0.2, 0.2);
		if (Math.random() < 0.005) {
			entity.getPersistentData().putBoolean("BulbClose", true);
			UnusualendMod.queueServerWork(10, () -> {
				entity.getPersistentData().putBoolean("BulbClose", false);
			});
		}
	}
}

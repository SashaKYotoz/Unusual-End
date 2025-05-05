package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class EnderbulbOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.PORTAL, x, (y - 0.2), z, 1, 0.2, 0.2, 0.2, 0.2);
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2) {
			if (entity.getPersistentData().getBoolean("BulbClose") == false) {
				entity.getPersistentData().putBoolean("BulbClose", true);
			}
		} else {
			if (!(entity.getPersistentData().getBoolean("BulbClose") == false)) {
				entity.getPersistentData().putBoolean("BulbClose", false);
			}
		}
	}
}

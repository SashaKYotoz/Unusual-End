package net.sweety.unusualend.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class EnderTrapperOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("despawnFix", (entity.getPersistentData().getDouble("despawnFix") + 1));
		if (entity.getPersistentData().getDouble("despawnFix") >= 60) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.PORTAL, (entity.getX()), (entity.getY()), (entity.getZ()), 20, 0.2, 0.2, 0.2, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.POOF, (entity.getX()), (entity.getY()), (entity.getZ()), 20, 0.2, 0.2, 0.2, 0);
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}

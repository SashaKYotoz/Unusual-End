package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

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

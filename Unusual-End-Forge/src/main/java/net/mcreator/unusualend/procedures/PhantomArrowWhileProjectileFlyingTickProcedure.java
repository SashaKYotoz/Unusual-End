package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class PhantomArrowWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		immediatesourceentity.getPersistentData().putDouble("Despawn", (immediatesourceentity.getPersistentData().getDouble("Despawn") + 1));
		if (!immediatesourceentity.getPersistentData().getBoolean("Grav")) {
			immediatesourceentity.getPersistentData().putBoolean("Grav", true);
			immediatesourceentity.setNoGravity(true);
		}
		if (immediatesourceentity.getPersistentData().getDouble("Despawn") == 80) {
			immediatesourceentity.setNoGravity(false);
		}
		if (immediatesourceentity.getPersistentData().getDouble("Despawn") == 240) {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 10, 0.3, 0.3, 0.3, 0);
		}
	}
}

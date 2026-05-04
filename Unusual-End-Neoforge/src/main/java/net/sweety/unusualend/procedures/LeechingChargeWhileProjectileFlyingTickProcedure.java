package net.sweety.unusualend.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.entity.BenevolentLeechingChargeProjectileEntity;
import net.sweety.unusualend.entity.BondLeechingChargeProjectileEntity;

public class LeechingChargeWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.WITCH, x, y, z, 2, 0.1, 0.1, 0.1, 0);
		if (immediatesourceentity instanceof BondLeechingChargeProjectileEntity) {
			if (Math.random() < 0.2) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 1, 0.1, 0.1, 0.1, 0);
			}
		} else if (immediatesourceentity instanceof BenevolentLeechingChargeProjectileEntity) {
			if (Math.random() < 0.2) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HEART, x, y, z, 1, 0.1, 0.1, 0.1, 0);
			}
		}
	}
}

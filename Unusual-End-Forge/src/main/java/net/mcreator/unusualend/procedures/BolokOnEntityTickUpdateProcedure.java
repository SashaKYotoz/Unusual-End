package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.unusualend.init.UnusualendModParticleTypes;

public class BolokOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.5) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (UnusualendModParticleTypes.BOLOK_PARTICLE.get()), x, y, z, 1, 0.4, 0.4, 0.4, 0);
		}
		if ((entity.level().dimension()) == Level.END) {
			if (y < 30) {
				if (entity instanceof Mob _entity)
					_entity.getNavigation().moveTo(x, 45, z, 0.8);
				if (y < 10) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 60, 0));
				}
			} else {
				if (!(entity.getPersistentData().getBoolean("coords") == true)) {
					entity.getPersistentData().putBoolean("coords", true);
					entity.getPersistentData().putDouble("x", x);
					entity.getPersistentData().putDouble("y", y);
					entity.getPersistentData().putDouble("z", z);
				}
				if (Math.random() < 0.005) {
					if (entity instanceof Mob _entity)
						_entity.getNavigation().moveTo((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z")), 0.8);
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt15 && _livEnt15.hasEffect(MobEffects.REGENERATION)) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.REGENERATION);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 1));
		}
	}
}

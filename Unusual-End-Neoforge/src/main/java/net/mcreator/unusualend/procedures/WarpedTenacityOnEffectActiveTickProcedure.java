package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

import net.mcreator.unusualend.init.UnusualendModMobEffects;

public class WarpedTenacityOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(UnusualendModMobEffects.WARPED_TENACITY.get()) ? _livEnt.getEffect(UnusualendModMobEffects.WARPED_TENACITY.get()).getAmplifier() : 0) >= 5) {
			if (Math.random() < 0.01) {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.CRAMMING)),
						(float) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(UnusualendModMobEffects.WARPED_TENACITY.get()) ? _livEnt.getEffect(UnusualendModMobEffects.WARPED_TENACITY.get()).getAmplifier() : 0) / 4));
			}
		}
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(UnusualendModMobEffects.WARPED_TENACITY.get()) ? _livEnt.getEffect(UnusualendModMobEffects.WARPED_TENACITY.get()).getAmplifier() : 0) >= 4) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 6) {
				if (Math.random() < 0.01) {
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.CRAMMING)), 1);
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(UnusualendModMobEffects.WARPED_TENACITY.get()) ? _livEnt.getEffect(UnusualendModMobEffects.WARPED_TENACITY.get()).getAmplifier() : 0) >= 3) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 100, 0));
		}
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(UnusualendModMobEffects.WARPED_TENACITY.get()) ? _livEnt.getEffect(UnusualendModMobEffects.WARPED_TENACITY.get()).getAmplifier() : 0) >= 2) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 0));
		}
	}
}

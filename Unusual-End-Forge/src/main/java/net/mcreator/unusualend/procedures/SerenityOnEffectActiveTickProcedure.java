package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.unusualend.init.UnusualendModMobEffects;

public class SerenityOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getRemainingFireTicks() > 0 || entity.isInLava()) && !(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.FIRE_RESISTANCE))) {
			entity.clearFire();
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, x, (y + 1), z, 30, 1, 0.5, 1, 0);
			DivideSerenityProcedure.execute(entity);
		}
		if (entity.getAirSupply() < 40) {
			entity.setAirSupply(300);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 300, 0));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SPLASH, x, (y + 1), z, 30, 1, 0.5, 1, 0);
			DivideSerenityProcedure.execute(entity);
		}
		if (entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(UnusualendModMobEffects.ENDER_INFECTION.get())) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(UnusualendModMobEffects.ENDER_INFECTION.get());
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.PORTAL, x, (y + 1), z, 30, 1, 0.5, 1, 0);
			DivideSerenityProcedure.execute(entity);
		}
		if (entity instanceof LivingEntity _livEnt13 && _livEnt13.hasEffect(MobEffects.DARKNESS) && !(entity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect(MobEffects.NIGHT_VISION))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600, 0));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.END_ROD, x, (y + 1), z, 30, 1, 0.5, 1, 0);
			DivideSerenityProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 4 && !(entity instanceof LivingEntity _livEnt18 && _livEnt18.hasEffect(MobEffects.REGENERATION))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 0));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.HEART, x, (y + 1), z, 30, 1, 0.5, 1, 0);
			DivideSerenityProcedure.execute(entity);
		}
		if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) < 7) {
			if (entity instanceof Player) {
				if (entity instanceof Player _player)
					_player.getFoodData().setFoodLevel(15);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.COMPOSTER, x, (y + 1), z, 30, 1, 0.5, 1, 0);
				DivideSerenityProcedure.execute(entity);
			}
		}
	}
}

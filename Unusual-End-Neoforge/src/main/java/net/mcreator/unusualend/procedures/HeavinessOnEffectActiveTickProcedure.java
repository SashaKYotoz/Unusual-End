package net.mcreator.unusualend.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

import net.mcreator.unusualend.init.UnusualendModMobEffects;

public class HeavinessOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MobEffects.LEVITATION)) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()),
					(entity.getDeltaMovement().y() - (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(UnusualendModMobEffects.HEAVINESS.get()) ? _livEnt.getEffect(UnusualendModMobEffects.HEAVINESS.get()).getAmplifier() : 0) * 0.03),
					(entity.getDeltaMovement().z())));
		}
	}
}

package net.mcreator.unusualend.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.unusualend.init.UnusualendModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CitrineFallDamageBounceProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity) {
		execute(null, world, x, y, z, damagesource, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity) {
		if (damagesource == null || entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(UnusualendModMobEffects.SERENITY.get())) {
			if (damagesource.is(DamageTypes.FALL)) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
				entity.fallDistance = 0;
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.POOF, x, (y + 1), z, 30, 1, 0.5, 1, 0);
				DivideSerenityProcedure.execute(entity);
			}
		}
	}
}

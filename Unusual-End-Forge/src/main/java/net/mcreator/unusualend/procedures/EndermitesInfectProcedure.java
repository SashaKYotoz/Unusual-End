package net.mcreator.unusualend.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.unusualend.init.UnusualendModMobEffects;
import net.mcreator.unusualend.entity.EnderblobEntity;
import net.mcreator.unusualend.configuration.ConfigurationFileConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EndermitesInfectProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof Endermite || sourceentity instanceof EnderblobEntity) {
			if (entity instanceof EnderMan) {
				if (Math.random() < 0.5) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(UnusualendModMobEffects.ENDER_INFECTION.get(), 36000, 0));
				}
			} else {
				if (Math.random() < (double) ConfigurationFileConfiguration.ENDERMITES_PROBABILITY_TO_INFECT.get() / 100) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(UnusualendModMobEffects.ENDER_INFECTION.get(), 600, 0));
				}
			}
		}
	}
}

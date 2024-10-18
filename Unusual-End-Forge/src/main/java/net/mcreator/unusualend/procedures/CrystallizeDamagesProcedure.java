package net.mcreator.unusualend.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.unusualend.init.UnusualendModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CrystallizeDamagesProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity entity, double amount) {
		execute(null, entity, amount);
	}

	private static void execute(@Nullable Event event, Entity entity, double amount) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(UnusualendModMobEffects.CRYSTALLIZATION.get())) {
			entity.getPersistentData().putDouble("CrystalDamages", (entity.getPersistentData().getDouble("CrystalDamages") + amount));
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
	}
}

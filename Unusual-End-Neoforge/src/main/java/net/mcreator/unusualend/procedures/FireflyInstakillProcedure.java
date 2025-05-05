package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

import net.mcreator.unusualend.entity.SmallEnderbulbEntity;
import net.mcreator.unusualend.entity.EnderbulbEntity;
import net.mcreator.unusualend.entity.EnderblobEntity;
import net.mcreator.unusualend.entity.EnderBugEntity;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingHurtEvent;

@Mod.EventBusSubscriber
public class FireflyInstakillProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	private static void execute(Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof SmallEnderbulbEntity) {
			if (sourceentity instanceof Frog) {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 20);
			}
		}
		if (sourceentity instanceof EnderBugEntity) {
			if (entity instanceof Endermite || entity instanceof EnderblobEntity || entity instanceof EnderbulbEntity || entity instanceof SmallEnderbulbEntity) {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 15);
			}
		}
	}
}

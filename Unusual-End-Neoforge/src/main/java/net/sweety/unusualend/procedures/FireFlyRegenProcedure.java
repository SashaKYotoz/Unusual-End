package net.sweety.unusualend.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.sweety.unusualend.entity.EnderblobEntity;
import net.sweety.unusualend.entity.FlampyrEntity;
import net.sweety.unusualend.init.UnusualEndBlocks;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.util.ProcedureHelper;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FireFlyRegenProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof EnderblobEntity) {
			if (sourceentity instanceof FlampyrEntity entity1) {
				if (!entity1.level().isClientSide())
					entity1.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 1));
				if (Math.random() < 0.2) {
					ProcedureHelper.dropItem(world, x, y, z, new ItemStack(UnusualEndItems.ENDER_FIREFLY_EGG.get()), 10);
				} else if (Math.random() < 0.2) {
					ProcedureHelper.dropItem(world, x, y, z, new ItemStack(UnusualEndBlocks.FIREFLY_BULB.get()), 10);
				}
			}
		}
	}
}

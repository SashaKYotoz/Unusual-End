package net.sweety.unusualend.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sweety.unusualend.entity.EnderblobEntity;
import net.sweety.unusualend.entity.FlampyrEntity;
import net.sweety.unusualend.init.UnusualendModBlocks;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.util.ProcedureHelper;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class FireFlyRegenProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof EnderblobEntity) {
			if (sourceentity instanceof FlampyrEntity) {
				ProcedureHelper.addEffect(sourceentity, new MobEffectInstance(MobEffects.REGENERATION, 300, 1));
				if (Math.random() < 0.2) {
					ProcedureHelper.dropItem(world, x, y, z, new ItemStack(UnusualendModItems.ENDER_FIREFLY_EGG.get()), 10);
				} else if (Math.random() < 0.2) {
					ProcedureHelper.dropItem(world, x, y, z, new ItemStack(UnusualendModBlocks.FIREFLY_BULB.get()), 10);
				}
			}
		}
	}
}

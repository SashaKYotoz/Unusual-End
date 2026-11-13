package net.sweety.unusualend.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.config.Config;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.util.ProcedureHelper;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class FeedBolokFinProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getTarget(), event.getEntity());
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Wolf) {
			if (!(entity.getPersistentData().getBoolean("CooldownBolok") == true)) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualendModItems.BOLOK_FIN.get()) {
					if (entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
						if (!(ProcedureHelper.isCreative(sourceentity))) {
							(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
						}
						if (event != null && event.isCancelable()) {
							event.setCanceled(true);
						}
						if (sourceentity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
						if (entity instanceof LivingEntity _entity)
							_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 9));
						ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, (int) ((double) Config.BOLOK_FIN_TIME.get() * 20), 0));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HEART, (entity.getX()), (entity.getY()), (entity.getZ()), 10, 0.3, 0.5, 0.3, 0);
						entity.getPersistentData().putBoolean("CooldownBolok", true);
						UnusualEnd.queueServerWork(200, () -> {
							entity.getPersistentData().putBoolean("CooldownBolok", false);
						});
					}
				} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualendModItems.COOKED_BOLOK_FIN.get()) {
					if (entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
						if (!(ProcedureHelper.isCreative(sourceentity))) {
							(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
						}
						if (event != null && event.isCancelable()) {
							event.setCanceled(true);
						}
						if (sourceentity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
						if (entity instanceof LivingEntity _entity)
							_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 6));
						ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, (int) ((double) Config.COOKED_BOLOK_FIN_TIME.get() * 20), 1));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HEART, (entity.getX()), (entity.getY()), (entity.getZ()), 10, 0.3, 0.5, 0.3, 0);
						entity.getPersistentData().putBoolean("CooldownBolok", true);
						UnusualEnd.queueServerWork(200, () -> {
							entity.getPersistentData().putBoolean("CooldownBolok", false);
						});
					}
				}
			}
		}
	}
}

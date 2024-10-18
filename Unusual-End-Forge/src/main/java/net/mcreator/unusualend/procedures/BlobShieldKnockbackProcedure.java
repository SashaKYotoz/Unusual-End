package net.mcreator.unusualend.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.unusualend.init.UnusualendModItems;
import net.mcreator.unusualend.configuration.ConfigurationFileConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BlobShieldKnockbackProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getDirectEntity());
		}
	}

	public static void execute(Entity entity, Entity immediatesourceentity) {
		execute(null, entity, immediatesourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		double speed = 0;
		double yaw = 0;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.isBlocking()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualendModItems.ENDERBLOB_SHIELD.get()
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == UnusualendModItems.ENDERBLOB_SHIELD.get()) {
				if (!(immediatesourceentity instanceof Player) || !(immediatesourceentity instanceof ServerPlayer) || ConfigurationFileConfiguration.SHIELD_PVP.get() == true) {
					speed = 0.8;
					yaw = entity.getYRot();
					immediatesourceentity.setDeltaMovement(new Vec3((speed * Math.cos((yaw + 90) * (Math.PI / 180))), (immediatesourceentity.getDeltaMovement().y() + 0.1), (speed * Math.sin((yaw + 90) * (Math.PI / 180)))));
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("unusualend:forced_social_distancing"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
		}
	}
}

package net.sweety.unusualend.procedures;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sweety.unusualend.config.Config;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.util.ProcedureHelper;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BlobShieldKnockbackProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getDirectEntity());
		}
	}

	private static void execute(@Nullable Event event, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		double speed = 0;
		double yaw = 0;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.isBlocking()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualendModItems.ENDERBLOB_SHIELD.get()
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == UnusualendModItems.ENDERBLOB_SHIELD.get()) {
				if (!(immediatesourceentity instanceof Player) || !(immediatesourceentity instanceof ServerPlayer) || Config.SHIELD_PVP.get() == true) {
					speed = 0.8;
					yaw = entity.getYRot();
					immediatesourceentity.setDeltaMovement(new Vec3((speed * Math.cos((yaw + 90) * (Math.PI / 180))), (immediatesourceentity.getDeltaMovement().y() + 0.1), (speed * Math.sin((yaw + 90) * (Math.PI / 180)))));
					ProcedureHelper.awardAdvancement(entity, "forced_social_distancing");
				}
			}
		}
	}
}

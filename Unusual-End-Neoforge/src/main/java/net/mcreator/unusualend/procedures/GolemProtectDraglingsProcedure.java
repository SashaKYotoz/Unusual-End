package net.mcreator.unusualend.procedures;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.unusualend.entity.EndstoneGolemEntity;
import net.mcreator.unusualend.entity.DraglingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingHurtEvent;

@Mod.EventBusSubscriber
public class GolemProtectDraglingsProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}
	private static void execute(LivingHurtEvent event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof DraglingEntity) {
			if (sourceentity instanceof EndstoneGolemEntity) {
				if (event != null) {
					event.setCanceled(true);
				}
				if (entity instanceof Mob _entity && (sourceentity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _ent)
					_entity.setTarget(_ent);
			}
		}
	}
}

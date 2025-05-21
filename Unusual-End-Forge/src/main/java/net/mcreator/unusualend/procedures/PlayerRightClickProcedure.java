package net.mcreator.unusualend.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.unusualend.entity.WarpedJellyfishEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerRightClickProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double number = 0;
		if (entity.isVehicle()) {
			if ((entity.getFirstPassenger()) instanceof WarpedJellyfishEntity) {
				if (entity.isShiftKeyDown()) {
					(entity.getFirstPassenger()).stopRiding();
				}
			}
		}
	}
}

package net.mcreator.unusualend.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.unusualend.entity.WarpedJellyfishEntity;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@Mod.EventBusSubscriber
public class PlayerRightClickProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getEntity());
	}

	private static void execute(Event event, Entity entity) {
		if (entity == null)
			return;
        if (entity.isVehicle()) {
			if ((entity.getFirstPassenger()) instanceof WarpedJellyfishEntity) {
				if (entity.isShiftKeyDown()) {
					(entity.getFirstPassenger()).stopRiding();
				}
			}
		}
	}
}

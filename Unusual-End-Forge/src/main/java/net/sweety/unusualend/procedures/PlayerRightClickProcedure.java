package net.sweety.unusualend.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sweety.unusualend.entity.GlubEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerRightClickProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getEntity());
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double number = 0;
		if (entity.isVehicle()) {
			if ((entity.getFirstPassenger()) instanceof GlubEntity) {
				if (entity.isShiftKeyDown()) {
					(entity.getFirstPassenger()).stopRiding();
				}
			}
		}
	}
}

package net.mcreator.unusualend.procedures;

import net.mcreator.unusualend.entity.GlubEntity;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

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
			if ((entity.getFirstPassenger()) instanceof GlubEntity) {
				if (entity.isShiftKeyDown()) {
					(entity.getFirstPassenger()).stopRiding();
				}
			}
		}
	}
}

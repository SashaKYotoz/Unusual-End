package net.mcreator.unusualend.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.unusualend.network.UnusualendModVariables;

public class ScrapeClothOverlayDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		UnusualendModVariables.PlayerVariables variables = entity.getData(UnusualendModVariables.PLAYER_VARIABLES.get());
		return variables.ScrapeOverlay > 0;
	}
}

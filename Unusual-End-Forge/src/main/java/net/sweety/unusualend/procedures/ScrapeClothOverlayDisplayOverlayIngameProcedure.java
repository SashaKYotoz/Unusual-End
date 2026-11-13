package net.sweety.unusualend.procedures;

import net.minecraft.world.entity.Entity;
import net.sweety.unusualend.network.UnusualendModVariables;

public class ScrapeClothOverlayDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getCapability(UnusualendModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UnusualendModVariables.PlayerVariables())).ScrapeOverlay > 0;
	}
}

package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceKey;

public class EndSkyProcedure {
	public static void execute(ResourceKey<Level> dimension) {
		if (dimension == null)
			return;
		if (dimension == Level.END) {
		}
	}
}

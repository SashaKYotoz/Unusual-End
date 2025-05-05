package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.configuration.ConfigurationFileConfiguration;

public class EndPlantsAdditionsProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return !world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("unusualend:gloopstone_lands")) && ConfigurationFileConfiguration.HIGHLAND_PLANTS.get() == true;
	}
}

package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class WarpedIslandsAreaProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return y > 30 && y < 100 && world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("unusualend:warped_reef"));
	}
}

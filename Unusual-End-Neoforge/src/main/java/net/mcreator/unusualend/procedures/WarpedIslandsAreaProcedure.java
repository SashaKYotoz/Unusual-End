package net.mcreator.unusualend.procedures;

import net.mcreator.unusualend.UnusualEnd;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class WarpedIslandsAreaProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return y > 30 && y < 100 && world.getBiome(BlockPos.containing(x, y, z)).is(UnusualEnd.makeUEID("warped_reef"));
	}
}

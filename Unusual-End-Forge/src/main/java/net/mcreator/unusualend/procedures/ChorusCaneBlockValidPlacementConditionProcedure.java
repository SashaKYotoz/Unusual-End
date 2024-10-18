package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModBlocks;

public class ChorusCaneBlockValidPlacementConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == UnusualendModBlocks.CHORUS_CANE.get() || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == UnusualendModBlocks.BLOOMING_CHORUS_CANE.get()
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == UnusualendModBlocks.PURPUR_EMBEDDED_END_STONE.get()
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("chorus_lib:end_stones")));
	}
}

package net.sweety.unusualend.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class FadingBlockEmittedRedstonePowerProcedure {
	public static double execute(BlockState blockstate) {
		return (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1) + 1;
	}
}

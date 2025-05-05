package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;

public class GloopilonSproutCanBoneMealBeUsedOnThisBlockProcedure {
	public static boolean execute(double y, BlockState blockstate) {
		return y >= 120 && (blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1) < 2;
	}
}

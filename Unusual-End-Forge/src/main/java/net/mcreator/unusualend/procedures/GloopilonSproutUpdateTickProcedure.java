package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;

public class GloopilonSproutUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (y >= 120) {
			if (Math.random() < 0.01) {
				GrowGloopilonProcedure.execute(world, x, y, z, blockstate);
			}
		} else {
			if (Math.random() < 0.005) {
				GrowGloopilonProcedure.execute(world, x, y, z, blockstate);
			}
		}
	}
}

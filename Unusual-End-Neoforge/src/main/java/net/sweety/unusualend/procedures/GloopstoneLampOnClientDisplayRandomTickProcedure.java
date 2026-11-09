package net.sweety.unusualend.procedures;

import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.sweety.unusualend.init.UnusualEndMiscRegister;

public class GloopstoneLampOnClientDisplayRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1) == 1) {
			world.addParticle(UnusualEndMiscRegister.PINK_FLAME.get(), (x + Mth.nextDouble(world.getRandom(), -1, 2)), (y + Mth.nextDouble(world.getRandom(), 0.1, 1.5)),
					(z + Mth.nextDouble(world.getRandom(), -1, 2)), 0, 0, 0);
		}
	}
}

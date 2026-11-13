package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.init.UnusualendModParticleTypes;

public class WarpedLanternOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level0 && _level0.hasNeighborSignal(BlockPos.containing(x, y, z))) {
			world.addParticle(UnusualendModParticleTypes.CITRINE_SHINE.get(), (x + Mth.nextDouble(world.getRandom(), 0.1, 0.9)), (y + Mth.nextDouble(world.getRandom(), 0.1, 0.9)),
					(z + Mth.nextDouble(world.getRandom(), 0.1, 0.9)), 0, 0, 0);
		}
	}
}

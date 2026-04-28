package net.mcreator.unusualend.procedures;

import net.mcreator.unusualend.init.UnusualendModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class GloopstoneLampOnClientDisplayRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1) == 1) {
			world.addParticle(UnusualendModParticleTypes.PINK_FLAME.get(), (x + Mth.nextDouble(RandomSource.create(), -1, 2)), (y + Mth.nextDouble(RandomSource.create(), 0.1, 1.5)),
					(z + Mth.nextDouble(RandomSource.create(), -1, 2)), 0, 0, 0);
		}
	}
}

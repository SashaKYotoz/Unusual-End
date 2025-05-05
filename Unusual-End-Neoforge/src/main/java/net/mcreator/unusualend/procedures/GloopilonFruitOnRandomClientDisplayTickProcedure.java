package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.ParticleTypes;

public class GloopilonFruitOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1) == 2) {
			if (Math.random() < 0.3) {
				world.addParticle(ParticleTypes.FIREWORK, (x + Mth.nextDouble(RandomSource.create(), 0.2, 0.8)), (y + Mth.nextDouble(RandomSource.create(), 0.2, 0.8)), (z + Mth.nextDouble(RandomSource.create(), 0.2, 0.8)), 0, 0, 0);
			} else if (Math.random() < 0.3) {
				world.addParticle(ParticleTypes.FALLING_OBSIDIAN_TEAR, (x + Mth.nextDouble(RandomSource.create(), 0.2, 0.8)), (y + Mth.nextDouble(RandomSource.create(), 0.2, 0.8)), (z + Mth.nextDouble(RandomSource.create(), 0.2, 0.8)), 0, 0, 0);
			}
		}
	}
}

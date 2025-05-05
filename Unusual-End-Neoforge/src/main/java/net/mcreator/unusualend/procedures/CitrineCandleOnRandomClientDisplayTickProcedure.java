package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModParticleTypes;

public class CitrineCandleOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("unusualend:candle_soul_flames")))) {
			world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, (x + 0.5), (y + 0.92), (z + 0.5), 0, 0, 0);
		} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("unusualend:candle_shiny_flames")))) {
			world.addParticle((SimpleParticleType) (UnusualendModParticleTypes.PINK_FLAME.get()), (x + 0.5), (y + 0.92), (z + 0.5), 0, 0, 0);
		} else {
			world.addParticle(ParticleTypes.FLAME, (x + 0.5), (y + 0.92), (z + 0.5), 0, 0, 0);
		}
		if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip8 ? blockstate.getValue(_getip8) : -1) == 1) {
			if (Math.random() < 0.5) {
				world.addParticle(ParticleTypes.FIREWORK, (x + Mth.nextDouble(RandomSource.create(), 0.3, 0.7)), (y + 0.92), (z + Mth.nextDouble(RandomSource.create(), 0.3, 0.7)), 0, 0, 0);
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip13 ? blockstate.getValue(_getip13) : -1) == 2) {
			if (Math.random() < 0.5) {
				world.addParticle(ParticleTypes.WITCH, (x + 0.5), (y + 0.92), (z + 0.5), 0, 0, 0);
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip16 ? blockstate.getValue(_getip16) : -1) == 3) {
			if (Math.random() < 0.5) {
				world.addParticle(ParticleTypes.EFFECT, (x + 0.5), (y + 0.92), (z + 0.5), 0, 0, 0);
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip19 ? blockstate.getValue(_getip19) : -1) == 4) {
			if (Math.random() < 0.5) {
				world.addParticle(ParticleTypes.END_ROD, (x + Mth.nextDouble(RandomSource.create(), 0.3, 0.7)), (y + 0.92), (z + Mth.nextDouble(RandomSource.create(), 0.3, 0.7)), 0, 0, 0);
			}
		} else {
			if (Math.random() < 0.05) {
				world.addParticle(ParticleTypes.EFFECT, (x + 0.5), (y + 0.92), (z + 0.5), 0, 0, 0);
			}
		}
	}
}

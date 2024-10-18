package net.mcreator.unusualend.mixins;

import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.level.levelgen.synth.ImprovedNoise;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.biome.Climate;

import net.mcreator.unusualend.endbiomes.SamplerHooks;

import com.google.common.base.Preconditions;

@Mixin(Climate.Sampler.class)
public class ClimateSamplerMixin implements SamplerHooks {
	@Unique
	private Long seed = null;
	@Unique
	private ImprovedNoise endBiomesSampler = null;

	@Override
	public void setSeed(long seed) {
		this.seed = seed;
	}

	@Override
	public long getSeed() {
		return this.seed;
	}

	@Override
	public ImprovedNoise getEndBiomesSampler() {
		if (endBiomesSampler == null) {
			Preconditions.checkState(seed != null, "MultiNoiseSampler doesn't have a seed set, created using different method?");
			endBiomesSampler = new ImprovedNoise(new WorldgenRandom(new LegacyRandomSource(seed)));
		}
		return endBiomesSampler;
	}
}

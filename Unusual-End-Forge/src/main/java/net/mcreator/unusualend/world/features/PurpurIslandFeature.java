
package net.mcreator.unusualend.world.features;

import net.mcreator.unusualend.configuration.Config;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.SimpleRandomSelectorFeature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleRandomFeatureConfiguration;

public class PurpurIslandFeature extends SimpleRandomSelectorFeature {
	public PurpurIslandFeature() {
		super(SimpleRandomFeatureConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<SimpleRandomFeatureConfiguration> context) {
		if (!Config.PURPUR_ISLANDS.get())
			return false;
		return context.origin().getY() > 16;
	}
}


package net.sweety.unusualend.world.features;

import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.SimpleRandomSelectorFeature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleRandomFeatureConfiguration;
import net.sweety.unusualend.config.Config;

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

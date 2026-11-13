
package net.sweety.unusualend.world.features;

import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.sweety.unusualend.config.Config;

public class RawPurpurFeature extends OreFeature {
	public RawPurpurFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		if (!Config.RAW_PURPUR.get())
			return false;
		return super.place(context);
	}
}

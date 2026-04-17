
package net.mcreator.unusualend.world.features;

import net.mcreator.unusualend.configuration.Config;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

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

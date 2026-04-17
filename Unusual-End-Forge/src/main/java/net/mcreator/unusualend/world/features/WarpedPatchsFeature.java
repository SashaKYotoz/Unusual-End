
package net.mcreator.unusualend.world.features;

import net.mcreator.unusualend.configuration.Config;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.RandomPatchFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;

public class WarpedPatchsFeature extends RandomPatchFeature {
	public WarpedPatchsFeature() {
		super(RandomPatchConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<RandomPatchConfiguration> context) {
		if (!Config.INFESTED_ENDSTONE.get())
			return false;
		return super.place(context);
	}
}

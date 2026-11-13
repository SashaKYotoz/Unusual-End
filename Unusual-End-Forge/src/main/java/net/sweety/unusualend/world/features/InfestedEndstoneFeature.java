
package net.sweety.unusualend.world.features;

import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.RandomPatchFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.sweety.unusualend.config.Config;

public class InfestedEndstoneFeature extends RandomPatchFeature {
	public InfestedEndstoneFeature() {
		super(RandomPatchConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<RandomPatchConfiguration> context) {
		if (!Config.INFESTED_ENDSTONE.get())
			return false;
		return super.place(context);
	}
}

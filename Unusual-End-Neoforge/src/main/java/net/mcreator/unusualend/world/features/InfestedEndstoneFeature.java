
package net.mcreator.unusualend.world.features;

import net.mcreator.unusualend.configuration.UEConfig;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.RandomPatchFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class InfestedEndstoneFeature extends RandomPatchFeature {
	public InfestedEndstoneFeature() {
		super(RandomPatchConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<RandomPatchConfiguration> context) {
		if (!UEConfig.INFESTED_ENDSTONE.get())
			return false;
		return super.place(context);
	}
}

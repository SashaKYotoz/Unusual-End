
package net.mcreator.unusualend.world.features;

import net.mcreator.unusualend.configuration.Config;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.RandomPatchFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;

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

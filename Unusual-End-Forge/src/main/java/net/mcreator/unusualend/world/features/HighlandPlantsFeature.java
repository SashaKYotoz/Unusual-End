
package net.mcreator.unusualend.world.features;

import net.mcreator.unusualend.configuration.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.SimpleRandomSelectorFeature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleRandomFeatureConfiguration;

public class HighlandPlantsFeature extends SimpleRandomSelectorFeature {
	public HighlandPlantsFeature() {
		super(SimpleRandomFeatureConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<SimpleRandomFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!(!world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("unusualend:gloopstone_lands")) && Config.HIGHLAND_PLANTS.get()))
			return false;
		return super.place(context);
	}
}


package net.mcreator.unusualend.world.features;

import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.RandomPatchFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

import net.mcreator.unusualend.procedures.InfestedEndstoneAdditionalGenerationConditionProcedure;

public class InfestedEndstoneFeature extends RandomPatchFeature {
	public InfestedEndstoneFeature() {
		super(RandomPatchConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<RandomPatchConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!InfestedEndstoneAdditionalGenerationConditionProcedure.execute())
			return false;
		return super.place(context);
	}
}

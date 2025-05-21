
package net.mcreator.unusualend.world.features;

import net.mcreator.unusualend.UnusualEnd;
import net.mcreator.unusualend.configuration.UEConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleRandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.SimpleRandomSelectorFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

public class HighlandPlantsFeature extends SimpleRandomSelectorFeature {
    public HighlandPlantsFeature() {
        super(SimpleRandomFeatureConfiguration.CODEC);
    }

    public boolean place(FeaturePlaceContext<SimpleRandomFeatureConfiguration> context) {
        WorldGenLevel world = context.level();
        int x = context.origin().getX();
        int y = context.origin().getY();
        int z = context.origin().getZ();
        if (!world.getBiome(BlockPos.containing(x, y, z)).is(UnusualEnd.makeUEID("gloopstone_lands"))
                && UEConfig.HIGHLAND_PLANTS.get())
            return false;
        return super.place(context);
    }
}

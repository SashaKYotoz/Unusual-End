package net.mcreator.unusualend.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.unusualend.world.features.WarpedPatchsFeature;
import net.mcreator.unusualend.world.features.RawPurpurFeatureFeature;
import net.mcreator.unusualend.world.features.PurpurIsland1FeatureFeature;
import net.mcreator.unusualend.world.features.InfestedEndstoneFeature;
import net.mcreator.unusualend.world.features.HighlandPlantsFeature;
import net.mcreator.unusualend.UnusualendMod;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
public class UnusualendModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.FEATURE, UnusualendMod.MODID);
	public static final DeferredHolder<Feature<?>, PurpurIsland1FeatureFeature> PURPUR_ISLAND_1_FEATURE = REGISTRY.register("purpur_island_1_feature", PurpurIsland1FeatureFeature::new);
	public static final DeferredHolder<Feature<?>, HighlandPlantsFeature> HIGHLAND_PLANTS = REGISTRY.register("highland_plants", HighlandPlantsFeature::new);
	public static final DeferredHolder<Feature<?>, InfestedEndstoneFeature> INFESTED_ENDSTONE = REGISTRY.register("infested_endstone", InfestedEndstoneFeature::new);
	public static final DeferredHolder<Feature<?>, RawPurpurFeatureFeature> RAW_PURPUR_FEATURE = REGISTRY.register("raw_purpur_feature", RawPurpurFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, WarpedPatchsFeature> WARPED_PATCHS = REGISTRY.register("warped_patchs", WarpedPatchsFeature::new);
}
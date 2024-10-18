
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.unusualend.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.unusualend.world.features.WarpedPatchsFeature;
import net.mcreator.unusualend.world.features.RawPurpurFeatureFeature;
import net.mcreator.unusualend.world.features.PurpurIsland1FeatureFeature;
import net.mcreator.unusualend.world.features.InfestedEndstoneFeature;
import net.mcreator.unusualend.world.features.HighlandPlantsFeature;
import net.mcreator.unusualend.UnusualendMod;

@Mod.EventBusSubscriber
public class UnusualendModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, UnusualendMod.MODID);
	public static final RegistryObject<Feature<?>> PURPUR_ISLAND_1_FEATURE = REGISTRY.register("purpur_island_1_feature", PurpurIsland1FeatureFeature::new);
	public static final RegistryObject<Feature<?>> HIGHLAND_PLANTS = REGISTRY.register("highland_plants", HighlandPlantsFeature::new);
	public static final RegistryObject<Feature<?>> INFESTED_ENDSTONE = REGISTRY.register("infested_endstone", InfestedEndstoneFeature::new);
	public static final RegistryObject<Feature<?>> RAW_PURPUR_FEATURE = REGISTRY.register("raw_purpur_feature", RawPurpurFeatureFeature::new);
	public static final RegistryObject<Feature<?>> WARPED_PATCHS = REGISTRY.register("warped_patchs", WarpedPatchsFeature::new);
}

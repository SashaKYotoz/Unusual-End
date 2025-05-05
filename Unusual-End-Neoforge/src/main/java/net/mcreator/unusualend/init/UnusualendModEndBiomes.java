package net.mcreator.unusualend.init;

import net.mcreator.unusualend.configuration.ConfigurationFileConfiguration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.unusualend.endbiomes.TheEndBiomes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusualendModEndBiomes {
    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            double high = 0.82 * ConfigurationFileConfiguration.BIOME_SIZE.get();
            double mid = 0.82 * ConfigurationFileConfiguration.BIOME_SIZE.get() * 0.25;
            double small = 0.6 * ConfigurationFileConfiguration.BIOME_SIZE.get();
            TheEndBiomes.addHighlandsBiome(ResourceKey.create(Registries.BIOME, new ResourceLocation("unusualend:gloopstone_lands")), high);
            TheEndBiomes.addMidlandsBiome(ResourceKey.create(Registries.BIOME, new ResourceLocation("unusualend:gloopstone_lands")), ResourceKey.create(Registries.BIOME, new ResourceLocation("unusualend:gloopstone_midlands")), mid);
            TheEndBiomes.addSmallIslandsBiome(ResourceKey.create(Registries.BIOME, new ResourceLocation("unusualend:warped_reef")), small);
        });
    }
}
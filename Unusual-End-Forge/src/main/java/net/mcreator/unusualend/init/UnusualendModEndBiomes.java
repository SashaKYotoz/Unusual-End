package net.mcreator.unusualend.init;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.unusualend.endbiomes.TheEndBiomes;
import net.mcreator.unusualend.configuration.ConfigurationFileConfiguration;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusualendModEndBiomes {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			double high;
			high = 0.82 * ConfigurationFileConfiguration.BIOME_SIZE.get();
			TheEndBiomes.addHighlandsBiome(ResourceKey.create(Registries.BIOME, new ResourceLocation("unusualend:gloopstone_lands")), high);
			double mid = 0;
			mid = 0.82 * ConfigurationFileConfiguration.BIOME_SIZE.get() * 0.25;
			TheEndBiomes.addMidlandsBiome(ResourceKey.create(Registries.BIOME, new ResourceLocation("unusualend:gloopstone_lands")), ResourceKey.create(Registries.BIOME, new ResourceLocation("unusualend:gloopstone_midlands")), mid);
			double small = 0;
			small = 0.6 * ConfigurationFileConfiguration.BIOME_SIZE.get();
			TheEndBiomes.addSmallIslandsBiome(ResourceKey.create(Registries.BIOME, new ResourceLocation("unusualend:warped_reef")), small);
		});
	}
}

package net.mcreator.unusualend.init;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.unusualend.endbiomes.TheEndBiomes;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusualendModEndBiomes {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			TheEndBiomes.addHighlandsBiome(ResourceKey.create(Registries.BIOME, new ResourceLocation("unusualend:gloopstone_lands")), 0.73d);
			TheEndBiomes.addMidlandsBiome(ResourceKey.create(Registries.BIOME, new ResourceLocation("unusualend:gloopstone_lands")), ResourceKey.create(Registries.BIOME, new ResourceLocation("unusualend:gloopstone_midlands")), 0.73d);
			TheEndBiomes.addSmallIslandsBiome(ResourceKey.create(Registries.BIOME, new ResourceLocation("unusualend:warped_reef")), 0.52d);
		});
	}
}

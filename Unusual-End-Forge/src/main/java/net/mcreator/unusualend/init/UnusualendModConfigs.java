package net.mcreator.unusualend.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.mcreator.unusualend.configuration.ConfigurationFileConfiguration;
import net.mcreator.unusualend.UnusualendMod;

@Mod.EventBusSubscriber(modid = UnusualendMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusualendModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigurationFileConfiguration.SPEC, "unusualend-common.toml");
		});
	}
}

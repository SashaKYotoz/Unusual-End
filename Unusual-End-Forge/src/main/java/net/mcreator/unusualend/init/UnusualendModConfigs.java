package net.mcreator.unusualend.init;

import net.mcreator.unusualend.UnusualEnd;
import net.mcreator.unusualend.configuration.Config;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;

@Mod.EventBusSubscriber(modid = UnusualEnd.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusualendModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC, "unusualend-common.toml");
		});
	}
}

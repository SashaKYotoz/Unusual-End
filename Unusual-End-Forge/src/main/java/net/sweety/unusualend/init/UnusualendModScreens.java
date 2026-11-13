package net.sweety.unusualend.init;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.sweety.unusualend.client.gui.BolokNotesScreen;
import net.sweety.unusualend.client.gui.BuildingInhibitorGUIScreen;
import net.sweety.unusualend.client.gui.InfuserGUIScreen;
import net.sweety.unusualend.client.gui.PurpurTankGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class UnusualendModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(UnusualendModMenus.PURPUR_TANK_GUI.get(), PurpurTankGUIScreen::new);
			MenuScreens.register(UnusualendModMenus.BOLOK_NOTES.get(), BolokNotesScreen::new);
			MenuScreens.register(UnusualendModMenus.BUILDING_INHIBITOR_GUI.get(), BuildingInhibitorGUIScreen::new);
			MenuScreens.register(UnusualendModMenus.INFUSER_GUI.get(), InfuserGUIScreen::new);
		});
	}
}

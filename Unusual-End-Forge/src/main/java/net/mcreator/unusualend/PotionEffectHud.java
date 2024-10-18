
package net.mcreator.unusualend;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

import net.mcreator.unusualend.init.UnusualendModMobEffects;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PotionEffectHud {
	public PotionEffectHud() {
	}

	@Mod.EventBusSubscriber
	private static class ForgeBusEvents {
		@SubscribeEvent
		public static void serverLoad(ServerStartingEvent event) {
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void clientLoad(FMLClientSetupEvent event) {
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void renderOverlay(RenderGuiOverlayEvent.Pre event) {
			Player entity = Minecraft.getInstance().player;
			if (entity.hasEffect(UnusualendModMobEffects.CRYSTALLIZATION.get())) {
				if (VanillaGuiOverlay.PLAYER_HEALTH.type() == event.getOverlay()) {
					event.setCanceled(true);
				}
				if (VanillaGuiOverlay.ARMOR_LEVEL.type() == event.getOverlay()) {
					event.setCanceled(true);
				}
			}
		}
	}
}

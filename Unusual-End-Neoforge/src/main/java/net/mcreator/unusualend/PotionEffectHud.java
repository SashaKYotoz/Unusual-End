
package net.mcreator.unusualend;

import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

import net.mcreator.unusualend.init.UnusualendModMobEffects;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RenderGuiOverlayEvent;
import net.neoforged.neoforge.client.gui.overlay.VanillaGuiOverlay;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PotionEffectHud {
    public PotionEffectHud() {
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void renderOverlay(RenderGuiOverlayEvent.Pre event) {
        Player player = Minecraft.getInstance().player;
        if (player != null && player.hasEffect(UnusualendModMobEffects.CRYSTALLIZATION.get())) {
            if (VanillaGuiOverlay.PLAYER_HEALTH.type() == event.getOverlay()) {
                event.setCanceled(true);
            }
            if (VanillaGuiOverlay.ARMOR_LEVEL.type() == event.getOverlay()) {
                event.setCanceled(true);
            }
        }
    }
}
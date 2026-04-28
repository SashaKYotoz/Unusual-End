
package net.mcreator.unusualend;

import net.mcreator.unusualend.init.UnusualendModMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PotionEffectHud {
    public PotionEffectHud() {
    }

    @Mod.EventBusSubscriber
    private static class ForgeBusEvents {

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
}

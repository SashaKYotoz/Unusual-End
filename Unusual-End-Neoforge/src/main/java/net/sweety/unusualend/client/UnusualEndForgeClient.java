package net.sweety.unusualend.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;
import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.client.gui.BolokNotesScreen;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.init.UnusualEndMiscRegister;
import net.sweety.unusualend.procedures.*;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class UnusualEndForgeClient {
    @SubscribeEvent
    public static void renderOverlay(RenderGuiLayerEvent.Pre event) {
        Player player = Minecraft.getInstance().player;
        if (player != null && player.hasEffect(UnusualEndMiscRegister.CRYSTALLIZATION)) {
            if (event.getName().equals(VanillaGuiLayers.ARMOR_LEVEL) || event.getName().equals(VanillaGuiLayers.PLAYER_HEALTH))
                event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onItemDropped(ItemTossEvent event) {
        if (event.getEntity().getItem().getItem() == UnusualEndItems.BOLOK_RESEARCH_NOTES.get()) {
            if (Minecraft.getInstance().screen instanceof BolokNotesScreen)
                Minecraft.getInstance().player.closeContainer();
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void eventHandler(RenderGuiEvent.Pre event) {
        int w = event.getGuiGraphics().guiWidth();
        int h = event.getGuiGraphics().guiHeight();
        Level level = null;
        Player player = Minecraft.getInstance().player;
        if (player != null)
            level = player.level();
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        RenderSystem.setShaderColor(1, 1, 1, 1);
        if (GetLookingValidAltarProcedure.execute(level, player))
            event.getGuiGraphics().blit(UnusualEnd.makeUEID("textures/screens/dragon_breath_valid_overlay.png"), w / 2 + 6, h / 2 + -9, 0, 0, 16, 16, 16, 16);
        if (GetLookingAltarProcedure.execute(level, player))
            event.getGuiGraphics().blit(UnusualEnd.makeUEID("textures/screens/dragon_breath_overlay.png"), w / 2 + 6, h / 2 + -9, 0, 0, 16, 16, 16, 16);
        if (GetLookingWaystoneProcedure.execute(level, player))
            event.getGuiGraphics().blit(UnusualEnd.makeUEID("textures/screens/bubble_overlay.png"), w / 2 + 6, h / 2 + -9, 0, 0, 16, 16, 16, 16);
        if (IsCristallizedProcedure.execute(player))
            event.getGuiGraphics().blit(UnusualEnd.makeUEID("textures/screens/crystalisation.png"), w / 2 + -91, h - 49, 0, 0, 81, 19, 81, 19);
        if (ScrapeClothOverlayDisplayOverlayIngameProcedure.execute(player))
            event.getGuiGraphics().blit(UnusualEnd.makeUEID("textures/screens/cloth_overlay.png"), 0, 0, 0, 0, w, h, w, h);
        RenderSystem.depthMask(true);
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
        RenderSystem.setShaderColor(1, 1, 1, 1);
    }
}
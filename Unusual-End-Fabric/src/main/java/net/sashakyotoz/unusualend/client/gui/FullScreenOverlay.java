package net.sashakyotoz.unusualend.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;
import net.sashakyotoz.unusualend.UnusualEnd;
import net.sashakyotoz.unusualend.common.networking.IEntityDataSaver;
import net.sashakyotoz.unusualend.common.networking.data.ClothOverlayValuesHandler;

public class FullScreenOverlay implements HudRenderCallback {
    private static final Identifier COVERING = UnusualEnd.makeID(
            "textures/gui/cloth_overlay.png");

    @Override
    public void onHudRender(DrawContext context, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client != null && client.player != null && ClothOverlayValuesHandler.get((IEntityDataSaver) client.player) > 0) {
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();
            RenderSystem.disableDepthTest();
            RenderSystem.depthMask(false);
            context.setShaderColor(1.0F, 1.0F, 1.0F, 0.85f);
            context.drawTexture(COVERING, 0, 0, -90, 0.0F, 0.0F, width, height, width, height);
            RenderSystem.depthMask(true);
            RenderSystem.enableDepthTest();
            context.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}
package net.sashakyotoz.unusualend.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.sashakyotoz.unusualend.client.gui.FullScreenOverlay;
import net.sashakyotoz.unusualend.common.networking.KeyInputHandler;
import net.sashakyotoz.unusualend.common.networking.ModMessages;

public class UnusualEndClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
        ModMessages.registerS2CPackets();
        HudRenderCallback.EVENT.register(new FullScreenOverlay());
    }
}
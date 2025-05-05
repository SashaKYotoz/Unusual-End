package net.sashakyotoz.unusualend.common.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;
import net.sashakyotoz.unusualend.UnusualEnd;
import net.sashakyotoz.unusualend.common.networking.packets.ScrapClothOverlayS2CPacket;

public class ModMessages {
    public static final Identifier SCRAP_CLOTH_HANDLER = UnusualEnd.makeID("scrap_cloth_handler");

    public static void registerC2SPackets() {
//        ServerPlayNetworking.registerGlobalReceiver(GRIPCRYSTAL_ABILITY_HANDLER, GripcrystalWeaponsC2SPacket::receive);
    }

    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(SCRAP_CLOTH_HANDLER, ScrapClothOverlayS2CPacket::receive);
    }
}
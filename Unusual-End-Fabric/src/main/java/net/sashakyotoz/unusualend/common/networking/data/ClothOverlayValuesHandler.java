package net.sashakyotoz.unusualend.common.networking.data;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.sashakyotoz.unusualend.common.networking.IEntityDataSaver;
import net.sashakyotoz.unusualend.common.networking.ModMessages;

public class ClothOverlayValuesHandler {
    public static int add(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int mana = nbt.getInt("ScrapClothOverlay");
        if (mana + amount >= 1400)
            mana = 1400;
        else
            mana += amount;
        nbt.putInt("ScrapClothOverlay", mana);
        sync(mana, (ServerPlayerEntity) player);
        return mana;
    }
    public static int get(IEntityDataSaver player){
        return player.getPersistentData().getInt("ScrapClothOverlay");
    }
    public static int remove(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int value = nbt.getInt("ScrapClothOverlay");
        if (value - amount < 0) {
            value = 0;
        } else
            value -= amount;

        nbt.putInt("ScrapClothOverlay", value);
        sync(value, (ServerPlayerEntity) player);
        return value;
    }

    public static void sync(int mana, ServerPlayerEntity player) {
        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeInt(mana);
        ServerPlayNetworking.send(player, ModMessages.SCRAP_CLOTH_HANDLER, buffer);
    }
}
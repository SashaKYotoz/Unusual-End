package net.sweety.unusualend.client;

import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;

public final class ClientItemActivation {
    private ClientItemActivation() {
    }

    public static void display(ItemStack stack) {
        Minecraft.getInstance().gameRenderer.displayItemActivation(stack);
    }
}
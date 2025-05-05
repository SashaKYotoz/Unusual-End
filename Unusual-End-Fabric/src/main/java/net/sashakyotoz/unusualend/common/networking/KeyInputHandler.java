package net.sashakyotoz.unusualend.common.networking;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
//    public static final String KEY_CATEGORY_UNSEEN_WORLD = "key.category.unseen_world.unseen_world";
//    public static final String KEY_GRIPCRYSTAL_ABILITY = "key.unseen_world.gripcrystal_weapons_abilities";
//    public static KeyBinding gripcrystalWeaponsAbilityKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
//            if (gripcrystalWeaponsAbilityKey.wasPressed())
//                ClientPlayNetworking.send(ModMessages.GRIPCRYSTAL_ABILITY_HANDLER, PacketByteBufs.create());
        });
    }

    public static void register() {
//        gripcrystalWeaponsAbilityKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
//                KEY_GRIPCRYSTAL_ABILITY,
//                InputUtil.Type.KEYSYM,
//                GLFW.GLFW_KEY_LEFT_ALT,
//                KEY_CATEGORY_UNSEEN_WORLD
//        ));
        registerKeyInputs();
    }
}
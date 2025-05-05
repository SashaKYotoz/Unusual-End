package net.sashakyotoz.unusualend;

import net.fabricmc.api.ModInitializer;
import net.sashakyotoz.unusualend.common.UnusualEndDataGenerator;
import net.sashakyotoz.unusualend.common.blocks.ModBlocks;
import net.sashakyotoz.unusualend.common.effects.ModEffects;
import net.sashakyotoz.unusualend.common.enchantments.ModEnchantments;
import net.minecraft.util.Identifier;
import net.sashakyotoz.unusualend.common.items.ModItemGroups;
import net.sashakyotoz.unusualend.common.items.ModItems;
import net.sashakyotoz.unusualend.common.networking.ModMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnusualEnd implements ModInitializer {
    public static final String MOD_ID = "unusualend";
    public static final Logger LOGGER = LoggerFactory.getLogger("Unusual End");

    @Override
    public void onInitialize() {
        ModItems.register();
        ModBlocks.register();
        ModItemGroups.register();
        ModEffects.register();
        ModEnchantments.register();

        ModMessages.registerC2SPackets();

        UnusualEndDataGenerator.registerBurnable();
        UnusualEndDataGenerator.registerFuels();
        UnusualEndDataGenerator.registerStripped();
    }

    public static Identifier makeID(String id) {
        return new Identifier(MOD_ID, id);
    }

    public static <T> T log(T message) {
        LOGGER.info(String.valueOf(message));
        return message;
    }
}
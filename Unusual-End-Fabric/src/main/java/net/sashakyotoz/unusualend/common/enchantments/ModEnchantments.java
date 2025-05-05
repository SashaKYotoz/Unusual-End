package net.sashakyotoz.unusualend.common.enchantments;

import net.sashakyotoz.unusualend.UnusualEnd;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.sashakyotoz.unusualend.common.enchantments.custom.*;

public class ModEnchantments {
    public static final Enchantment BONDING = register("bonding", new BondingEnchantment(EquipmentSlot.values()));
    public static final Enchantment BENEVOLENCE = register("benevolence", new BenevolenceEnchantment(EquipmentSlot.values()));
    public static final Enchantment BOLOKS_FURY = register("boloks_fury", new BoloksFuryEnchantment(EquipmentSlot.values()));
    public static final Enchantment BOLOKS_HEAD = register("boloks_head", new BoloksHeadEnchantment(EquipmentSlot.values()));
    public static final Enchantment BOLOKS_WINGS = register("boloks_wings", new BoloksWingsEnchantment(EquipmentSlot.values()));
    public static final Enchantment JOUST = register("joust", new JoustEnchantment(EquipmentSlot.values()));
    public static final Enchantment ARCANE_RECOVERY = register("arcane_recovery", new RecoveryEnchantment(EquipmentSlot.values()));
    public static final Enchantment EVERLASTING = register("everlasting", new EverlastingEnchantment(EquipmentSlot.values()));

    public static void register() {
    }

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, UnusualEnd.MOD_ID + ":" + name, enchantment);
    }
}
package net.sweety.unusualend.init;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class UnusualendModEnchants {
    public static final EnchantmentCategory ARCANE = EnchantmentCategory.create("arcane",
            item -> item == UnusualendModItems.CRYSTAL_CATALYST.get() || item == UnusualendModItems.PEARLESCENT_RING.get() || item == UnusualendModItems.LEECHING_WAND.get());
    public static final EnchantmentCategory BOLOK = EnchantmentCategory.create("bolok",
            item -> item instanceof AxeItem || item instanceof SwordItem || item instanceof TridentItem || item == UnusualendModItems.WARPED_ANCHOR.get());
    public static final EnchantmentCategory ELYTRA = EnchantmentCategory.create("elytra",
            item -> item instanceof ElytraItem);
    public static final EnchantmentCategory LEECHING_WAND = EnchantmentCategory.create("leeching_wand",
            item -> item == UnusualendModItems.LEECHING_WAND.get());
    public static final EnchantmentCategory WARPED_SPEAR = EnchantmentCategory.create("warped_spear",
            item -> item == UnusualendModItems.WARPED_SPEAR.get());
}
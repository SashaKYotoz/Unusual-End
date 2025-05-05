package net.mcreator.unusualend.enchantment.categories;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.AxeItem;

import net.mcreator.unusualend.init.UnusualendModItems;

public class BolokEnchant {
	public static final EnchantmentCategory BOLOK = EnchantmentCategory.create("bolok", item -> item instanceof AxeItem || item instanceof SwordItem || item instanceof TridentItem || item == UnusualendModItems.WARPED_ANCHOR.get());
}

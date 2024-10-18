package net.mcreator.unusualend;

import net.minecraft.world.item.enchantment.EnchantmentCategory;

import net.mcreator.unusualend.init.UnusualendModItems;

public class SpearEnchant {
	public static final EnchantmentCategory WARPED_SPEAR = EnchantmentCategory.create("warped_spear", item -> item == UnusualendModItems.WARPED_SPEAR.get());
}

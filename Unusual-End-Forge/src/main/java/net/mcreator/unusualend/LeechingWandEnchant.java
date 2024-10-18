
package net.mcreator.unusualend;

import net.minecraft.world.item.enchantment.EnchantmentCategory;

import net.mcreator.unusualend.init.UnusualendModItems;

public class LeechingWandEnchant {
	public static final EnchantmentCategory LEECHING_WAND = EnchantmentCategory.create("leeching_wand", item -> item == UnusualendModItems.LEECHING_WAND.get());
}

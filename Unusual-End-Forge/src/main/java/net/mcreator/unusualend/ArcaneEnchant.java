
package net.mcreator.unusualend;

import net.minecraft.world.item.enchantment.EnchantmentCategory;

import net.mcreator.unusualend.init.UnusualendModItems;

public class ArcaneEnchant {
	public static final EnchantmentCategory ARCANE = EnchantmentCategory.create("arcane",
			item -> item == UnusualendModItems.CRYSTAL_CATALYST.get() || item == UnusualendModItems.PEARLESCENT_RING.get() || item == UnusualendModItems.LEECHING_WAND.get());
}

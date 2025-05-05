package net.mcreator.unusualend.enchantment.categories;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.ElytraItem;

public class ElytraEnchant {
	public static final EnchantmentCategory ELYTRA = EnchantmentCategory.create("elytra", item -> item instanceof ElytraItem);
}


package net.mcreator.unusualend.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.unusualend.configuration.ConfigurationFileConfiguration;

import java.util.List;

public class EverlastingEnchantment extends Enchantment {
	public EverlastingEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.BREAKABLE, slots);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return this != ench && !List.of(Enchantments.VANISHING_CURSE).contains(ench);
	}

	@Override
	public boolean isTreasureOnly() {
		return !ConfigurationFileConfiguration.EVERLASTING.get();
	}

	@Override
	public boolean isAllowedOnBooks() {
		return ConfigurationFileConfiguration.EVERLASTING.get();
	}

	@Override
	public boolean isDiscoverable() {
		return ConfigurationFileConfiguration.EVERLASTING.get();
	}

	@Override
	public boolean isTradeable() {
		return ConfigurationFileConfiguration.EVERLASTING.get();
	}
}

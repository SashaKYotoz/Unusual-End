
package net.sashakyotoz.unusualend.common.enchantments.custom;


import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;

import java.util.Objects;

public class EverlastingEnchantment extends Enchantment {
	public EverlastingEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.BREAKABLE, slots);
	}

	protected boolean canAccept(Enchantment other) {
		return this != other && !Objects.equals(Enchantments.VANISHING_CURSE, other);
	}
}
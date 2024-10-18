
package net.mcreator.unusualend.enchantment;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.unusualend.BolokEnchant;

public class BoloksFuryEnchantment extends Enchantment {
	public BoloksFuryEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, BolokEnchant.BOLOK, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}

	@Override
	public boolean isTradeable() {
		return false;
	}

	@Override
	public boolean isDiscoverable() {
		return false;
	}
}

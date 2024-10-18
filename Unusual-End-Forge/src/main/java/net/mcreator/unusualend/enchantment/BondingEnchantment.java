
package net.mcreator.unusualend.enchantment;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.unusualend.init.UnusualendModEnchantments;
import net.mcreator.unusualend.LeechingWandEnchant;

import java.util.List;

public class BondingEnchantment extends Enchantment {
	public BondingEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, LeechingWandEnchant.LEECHING_WAND, slots);
	}

	public int getMinCost(int i) {
		return 18;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return this != ench && !List.of(UnusualendModEnchantments.BENEVOLENCE.get()).contains(ench);
	}

	@Override
	public boolean isTradeable() {
		return false;
	}
}

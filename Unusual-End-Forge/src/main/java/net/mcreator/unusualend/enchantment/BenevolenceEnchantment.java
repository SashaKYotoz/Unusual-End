
package net.mcreator.unusualend.enchantment;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.unusualend.init.UnusualendModEnchantments;
import net.mcreator.unusualend.LeechingWandEnchant;

import java.util.List;

public class BenevolenceEnchantment extends Enchantment {
	public BenevolenceEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, LeechingWandEnchant.LEECHING_WAND, slots);
	}

	public int getMinCost(int i) {
		return 31;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return this != ench && !List.of(UnusualendModEnchantments.BONDING.get()).contains(ench);
	}

	@Override
	public boolean isTradeable() {
		return false;
	}
}

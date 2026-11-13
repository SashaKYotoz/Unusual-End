
package net.sweety.unusualend.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.sweety.unusualend.init.UnusualendModEnchantments;
import net.sweety.unusualend.init.UnusualendModEnchants;

import java.util.List;

public class BenevolenceEnchantment extends Enchantment {
	public BenevolenceEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, UnusualendModEnchants.LEECHING_WAND, slots);
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


package net.sweety.unusualend.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.sweety.unusualend.init.UnusualendModEnchants;

public class BoloksWingsEnchantment extends Enchantment {
	public BoloksWingsEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, UnusualendModEnchants.ELYTRA, slots);
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
	public boolean isDiscoverable() {
		return false;
	}

	@Override
	public boolean isTradeable() {
		return false;
	}
}

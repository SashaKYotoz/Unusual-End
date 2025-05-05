
package net.sashakyotoz.unusualend.common.enchantments.custom;


import net.sashakyotoz.unusualend.common.enchantments.ModEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

import java.util.Objects;

public class BenevolenceEnchantment extends Enchantment {
	public BenevolenceEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentTarget.VANISHABLE, slots);
	}
	@Override
	public int getMinPower(int level) {
		return 31;
	}

	@Override
	protected boolean canAccept(Enchantment other) {
		return this != other && !Objects.equals(ModEnchantments.BENEVOLENCE, other);
	}

//	@Override
//	public boolean isAcceptableItem(ItemStack stack) {
//		return stack.getItem() == UnusualendModItems.LEECHING_WAND;
//	}

	@Override
	public boolean isAvailableForEnchantedBookOffer() {
		return false;
	}
}

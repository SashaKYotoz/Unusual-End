
package net.sashakyotoz.unusualend.common.enchantments.custom;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class BoloksFuryEnchantment extends Enchantment {
	public BoloksFuryEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentTarget.VANISHABLE, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

//	@Override
//	public boolean isAcceptableItem(ItemStack stack) {
//	Item item = stack.getItem();
//		return item instanceof AxeItem || item instanceof SwordItem || item instanceof TridentItem || item == UnusualendModItems.WARPED_ANCHOR.get();
//	}

	@Override
	public boolean isTreasure() {
		return true;
	}

	@Override
	public boolean isAvailableForRandomSelection() {
		return false;
	}

	@Override
	public boolean isAvailableForEnchantedBookOffer() {
		return false;
	}
}

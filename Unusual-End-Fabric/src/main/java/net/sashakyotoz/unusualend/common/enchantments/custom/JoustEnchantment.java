
package net.sashakyotoz.unusualend.common.enchantments.custom;


import net.sashakyotoz.unusualend.common.enchantments.ModEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;

import java.util.List;

public class JoustEnchantment extends Enchantment {
	public JoustEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentTarget.VANISHABLE, slots);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

	@Override
	protected boolean canAccept(Enchantment other) {
		return this != other && !List.of(Enchantments.SWEEPING, ModEnchantments.BOLOKS_FURY, Enchantments.SHARPNESS).contains(other);
	}

//	@Override
//	public boolean isAcceptableItem(ItemStack stack) {
//		return Ingredient.of(new ItemStack(Items.TRIDENT), new ItemStack(UnusualendModItems.WARPED_SPEAR.get())).test(itemstack);
//	}
}

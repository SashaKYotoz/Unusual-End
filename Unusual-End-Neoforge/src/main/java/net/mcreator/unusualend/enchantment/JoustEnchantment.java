
package net.mcreator.unusualend.enchantment;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.unusualend.init.UnusualendModItems;
import net.mcreator.unusualend.enchantment.categories.SpearEnchant;

public class JoustEnchantment extends Enchantment {
	public JoustEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, SpearEnchant.WARPED_SPEAR, slots);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

	//	@Override
	//	protected boolean checkCompatibility(Enchantment ench) {
	//		return this != ench && !List.of(Enchantments.SWEEPING_EDGE, UnusualendModEnchantments.BOLOKS_FURY.get(), Enchantments.SHARPNESS).contains(ench);
	//	}
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack itemstack) {
		return Ingredient.of(new ItemStack(Items.TRIDENT), new ItemStack(UnusualendModItems.WARPED_SPEAR.get())).test(itemstack);
	}
}

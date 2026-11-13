
package net.sweety.unusualend.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.sweety.unusualend.init.UnusualendModEnchants;
import net.sweety.unusualend.init.UnusualendModItems;

public class JoustEnchantment extends Enchantment {
	public JoustEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, UnusualendModEnchants.WARPED_SPEAR, slots);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack itemstack) {
		return Ingredient.of(new ItemStack(Items.TRIDENT), new ItemStack(UnusualendModItems.WARPED_SPEAR.get())).test(itemstack);
	}
}

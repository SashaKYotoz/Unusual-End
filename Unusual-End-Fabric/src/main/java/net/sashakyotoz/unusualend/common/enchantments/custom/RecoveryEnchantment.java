
package net.sashakyotoz.unusualend.common.enchantments.custom;


import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecoveryEnchantment extends Enchantment {
	public RecoveryEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.VANISHABLE, slots);
	}

//	@Override
//	public boolean isAcceptableItem(ItemStack stack) {
//		Item item = stack.getItem();
//		return item == UnusualendModItems.VOID_MIRROR.get() || item == UnusualendModItems.PRISMATIC_MIRROR.get() || item == UnusualendModItems.CRYSTAL_CATALYST.get()
//				|| item == UnusualendModItems.PEARLESCENT_RING.get() || item == UnusualendModItems.ANCIENT_SWORD.get() || item == UnusualendModItems.LEECHING_WAND.get();
//	}

	@Override
	public int getMaxLevel() {
		return 3;
	}
}

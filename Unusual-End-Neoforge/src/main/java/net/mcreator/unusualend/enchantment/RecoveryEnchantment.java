
package net.mcreator.unusualend.enchantment;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.unusualend.enchantment.categories.ArcaneEnchant;

public class RecoveryEnchantment extends Enchantment {
	public RecoveryEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, ArcaneEnchant.ARCANE, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}
}


package net.sweety.unusualend.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.sweety.unusualend.init.UnusualendModEnchants;

public class RecoveryEnchantment extends Enchantment {
	public RecoveryEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, UnusualendModEnchants.ARCANE, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}
}

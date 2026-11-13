
package net.sweety.unusualend.enchantment;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class BoloksHeadEnchantment extends Enchantment {
	public BoloksHeadEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.ARMOR_HEAD, slots);
	}

	@Override
	public int getDamageProtection(int level, DamageSource source) {
		return !source.isCreativePlayer() && source.is(DamageTypes.FLY_INTO_WALL) ? level * 6 : 0;
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

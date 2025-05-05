
package net.sashakyotoz.unusualend.common.enchantments.custom;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;

public class BoloksHeadEnchantment extends Enchantment {
    public BoloksHeadEnchantment(EquipmentSlot... slots) {
        super(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.ARMOR_HEAD, slots);
    }

    @Override
    public int getProtectionAmount(int level, DamageSource source) {
        return !source.isSourceCreativePlayer() && source.isOf(DamageTypes.FLY_INTO_WALL) ? level * 6 : 0;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

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

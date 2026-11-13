package net.sweety.unusualend.util;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.sweety.unusualend.init.UnusualendModEnchantments;

public final class ItemCooldownHelper {
	public static final double MAX_CHARGE = 400;

	private ItemCooldownHelper() {
	}

	public static void recharge(ItemStack stack, String key, double baseRate, double arcaneRecoveryRate) {
		CompoundTag tag = stack.getOrCreateTag();
		double charge = tag.getDouble(key);
		if (charge < MAX_CHARGE)
			charge += baseRate + arcaneRecoveryRate * stack.getEnchantmentLevel(UnusualendModEnchantments.ARCANE_RECOVERY.get());
		tag.putDouble(key, Math.min(charge, MAX_CHARGE));
	}
}

package net.mcreator.unusualend.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;

import net.mcreator.unusualend.init.UnusualendModEnchantments;

public class PearlescentRingInventoryTickProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("ringCooldown") < 400) {
			itemstack.getOrCreateTag().putDouble("ringCooldown", (itemstack.getOrCreateTag().getDouble("ringCooldown") + 0.4));
			if (EnchantmentHelper.getItemEnchantmentLevel(UnusualendModEnchantments.ARCANE_RECOVERY.get(), itemstack) != 0) {
				if (itemstack.getOrCreateTag().getDouble("ringCooldown") + 0.2 * itemstack.getEnchantmentLevel(UnusualendModEnchantments.ARCANE_RECOVERY.get()) >= 400) {
					itemstack.getOrCreateTag().putDouble("ringCooldown", 400);
				} else {
					itemstack.getOrCreateTag().putDouble("ringCooldown", (itemstack.getOrCreateTag().getDouble("ringCooldown") + 0.2 * itemstack.getEnchantmentLevel(UnusualendModEnchantments.ARCANE_RECOVERY.get())));
				}
			}
		} else {
			itemstack.getOrCreateTag().putDouble("ringCooldown", 400);
		}
	}
}

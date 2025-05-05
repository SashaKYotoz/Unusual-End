package net.mcreator.unusualend.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;

import net.mcreator.unusualend.init.UnusualendModEnchantments;

public class CrystalCatalystItemInInventoryTickProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("cataCooldown") < 400) {
			itemstack.getOrCreateTag().putDouble("cataCooldown", (itemstack.getOrCreateTag().getDouble("cataCooldown") + 0.3));
			if (EnchantmentHelper.getItemEnchantmentLevel(UnusualendModEnchantments.ARCANE_RECOVERY.get(), itemstack) != 0) {
				if (itemstack.getOrCreateTag().getDouble("cataCooldown") + 0.1 * itemstack.getEnchantmentLevel(UnusualendModEnchantments.ARCANE_RECOVERY.get()) >= 400) {
					itemstack.getOrCreateTag().putDouble("cataCooldown", 400);
				} else {
					itemstack.getOrCreateTag().putDouble("cataCooldown", (itemstack.getOrCreateTag().getDouble("cataCooldown") + 0.1 * itemstack.getEnchantmentLevel(UnusualendModEnchantments.ARCANE_RECOVERY.get())));
				}
			}
		} else {
			itemstack.getOrCreateTag().putDouble("cataCooldown", 400);
		}
	}
}

package net.mcreator.unusualend.procedures;

import net.minecraft.world.item.ItemStack;

public class VoidTrackerPropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("VoidState");
	}
}

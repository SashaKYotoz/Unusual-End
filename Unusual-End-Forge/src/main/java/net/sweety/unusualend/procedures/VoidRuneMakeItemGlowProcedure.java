package net.sweety.unusualend.procedures;

import net.minecraft.world.item.ItemStack;

public class VoidRuneMakeItemGlowProcedure {
	public static boolean execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("XP") > 0;
	}
}

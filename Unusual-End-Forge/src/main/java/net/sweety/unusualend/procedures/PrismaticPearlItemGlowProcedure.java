package net.sweety.unusualend.procedures;

import net.minecraft.world.item.ItemStack;

public class PrismaticPearlItemGlowProcedure {
	public static boolean execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getBoolean("LinkedMirror") || itemstack.getOrCreateTag().getBoolean("LinkedTotem");
	}
}

package net.mcreator.unusualend.procedures;

import net.minecraft.world.item.ItemStack;

public class PrismaticPearlItemGlowProcedure {
	public static boolean execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getBoolean("LinkedMirror") == true || itemstack.getOrCreateTag().getBoolean("LinkedTotem") == true;
	}
}

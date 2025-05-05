package net.mcreator.unusualend.procedures;

import net.minecraft.world.item.ItemStack;

public class CrystalCatalystPropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		if ((itemstack.getDisplayName().getString()).contains("beacon") || (itemstack.getDisplayName().getString()).contains("Beacon")) {
			return 1;
		} else if ((itemstack.getDisplayName().getString()).contains("conduit") || (itemstack.getDisplayName().getString()).contains("Conduit")) {
			return 2;
		} else if ((itemstack.getDisplayName().getString()).contains("infuser") || (itemstack.getDisplayName().getString()).contains("Infuser")) {
			return 3;
		}
		return 0;
	}
}

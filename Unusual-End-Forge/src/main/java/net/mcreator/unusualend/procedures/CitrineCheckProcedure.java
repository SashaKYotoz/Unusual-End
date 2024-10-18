package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class CitrineCheckProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double check = 0;
		sx = -1;
		for (int index0 = 0; index0 < 3; index0++) {
			sz = -1;
			for (int index1 = 0; index1 < 3; index1++) {
				if ((new ItemStack((world.getBlockState(BlockPos.containing(x + sx, y - 1, z + sz))).getBlock())).is(ItemTags.create(new ResourceLocation("forge:citrine_base")))) {
					check = check + 1;
				}
				sz = sz + 1;
			}
			sx = sx + 1;
		}
		return check >= 4;
	}
}

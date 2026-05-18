package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class ShinyCheckProcedure {
    public static boolean execute(LevelAccessor world, double x, double y, double z) {
        double sx = -1;
        double sz;
        double check = 0;
        for (int index0 = 0; index0 < 3; index0++) {
            sz = -1;
            for (int index1 = 0; index1 < 3; index1++) {
                if ((new ItemStack((world.getBlockState(BlockPos.containing(x + sx, y - 1, z + sz))).getBlock())).is(ItemTags.create(ResourceLocation.parse("c:shiny_base")))) {
                    check = check + 1;
                }
                sz = sz + 1;
            }
            sx = sx + 1;
        }
        return check >= 4;
    }
}

package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
import net.sweety.unusualend.init.UnusualEndItems;

import java.util.concurrent.atomic.AtomicReference;

public class ClearSlot3Procedure {
    public static void execute(LevelAccessor level, BlockPos pos) {
        if (getItemStack(level, pos).is(UnusualEndItems.INFUSER_INFOS.get())) {
            BlockEntity block = level.getBlockEntity(pos);
            if (block instanceof BaseContainerBlockEntity entity) {
                InvWrapper wrapper = new InvWrapper(entity);
                wrapper.setStackInSlot(3, ItemStack.EMPTY);
            }
        }
    }

    private static ItemStack getItemStack(LevelAccessor world, BlockPos pos) {
        AtomicReference<ItemStack> reference = new AtomicReference<>(ItemStack.EMPTY);
        BlockEntity block = world.getBlockEntity(pos);
        if (block instanceof BaseContainerBlockEntity entity)
            reference.set(entity.getItem(3).copy());
        return reference.get();
    }
}
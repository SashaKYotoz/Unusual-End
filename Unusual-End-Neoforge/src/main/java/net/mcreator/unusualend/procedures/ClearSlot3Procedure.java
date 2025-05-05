package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModItems;
import net.neoforged.neoforge.items.wrapper.InvWrapper;

import java.util.concurrent.atomic.AtomicReference;

public class ClearSlot3Procedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (getItemStack(world, BlockPos.containing(x, y, z), 3).getItem() == UnusualendModItems.INFUSER_INFOS.get()) {
            BlockEntity block = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (block instanceof BaseContainerBlockEntity entity) {
                final int _slotid = 3;
                InvWrapper wrapper = new InvWrapper(entity);
                wrapper.setStackInSlot(_slotid, ItemStack.EMPTY);
            }
        }
    }

    private static ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
        AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
        BlockEntity block = world.getBlockEntity(pos);
        if (block instanceof BaseContainerBlockEntity entity)
            _retval.set(entity.getItem(slotid).copy());
        return _retval.get();
    }
}
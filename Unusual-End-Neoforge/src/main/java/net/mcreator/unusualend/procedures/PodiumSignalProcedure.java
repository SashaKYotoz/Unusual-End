package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;
import net.neoforged.neoforge.items.wrapper.InvWrapper;

public class PodiumSignalProcedure {
    public static double execute(LevelAccessor world, double x, double y, double z) {
        if (getAmount(world, BlockPos.containing(x, y, z), 0) >= 1) {
            return 15;
        }
        return 0;
    }

    private static int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
        BlockEntity entity = world.getBlockEntity(pos);
        if (entity instanceof BaseContainerBlockEntity block) {
            InvWrapper wrapper = new InvWrapper(block);
            return wrapper.getStackInSlot(slotid).getCount();
        }
        return 0;
    }
}
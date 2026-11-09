package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.sweety.unusualend.init.UnusualEndBlocks;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.util.ProcedureHelper;

import java.util.Map;

public class OvergrownWarpedVineOnBlockRightClickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        BlockPos _bp = BlockPos.containing(x, y, z);
        BlockState _bs = UnusualEndBlocks.WARPED_BUSH.get().defaultBlockState();
        BlockState _bso = world.getBlockState(_bp);
        for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
            Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
            if (_property != null && _bs.getValue(_property) != null)
                try {
                    _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                } catch (Exception e) {
                }
        }
        world.setBlock(_bp, _bs, 3);
        for (int index0 = 0; index0 < Mth.nextInt(world.getRandom(), 1, 3); index0++) {
            ProcedureHelper.dropItem(world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(UnusualEndItems.WARPED_BERRIES.get()), 10);
        }
        if (world.isClientSide()) {
            ProcedureHelper.playSound(world, x, y, z, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1, 1);
        }
    }
}

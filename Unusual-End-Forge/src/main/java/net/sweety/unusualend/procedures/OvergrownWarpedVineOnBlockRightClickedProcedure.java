package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.init.UnusualendModBlocks;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.util.ProcedureHelper;

public class OvergrownWarpedVineOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z), UnusualendModBlocks.WARPED_BUSH.get().defaultBlockState(), 3);
		for (int index0 = 0; index0 < Mth.nextInt(world.getRandom(), 1, 3); index0++) {
			ProcedureHelper.dropItem(world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(UnusualendModItems.WARPED_BERRIES.get()), 10);
		}
		if (world.isClientSide()) {
			ProcedureHelper.playSound(world, x, y, z, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1, 1);
		}
	}
}

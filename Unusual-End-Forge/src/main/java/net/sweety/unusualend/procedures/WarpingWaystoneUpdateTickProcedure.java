package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.sweety.unusualend.util.ProcedureHelper;

public class WarpingWaystoneUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "RedstoneLevel") > 0) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("RedstoneLevel", ((ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "RedstoneLevel")) - 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof Level _level)
				_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
		}
	}
}

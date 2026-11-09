package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.sweety.unusualend.init.UnusualEndBlocks;
import net.sweety.unusualend.util.ProcedureHelper;

public class BuddingCitrineUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double randomNumber = Mth.nextInt(world.getRandom(), 1, 6);
		if (randomNumber == 1) {
			if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
				ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y + 1, z), UnusualEndBlocks.CITRINE_BUD.get().defaultBlockState(), 3);
				{
					String _value = "floor";
					BlockPos _pos = BlockPos.containing(x, y + 1, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _enumProp && _enumProp.getValue(_value).isPresent())
						world.setBlock(_pos, _bs.setValue(_enumProp, (Enum) _enumProp.getValue(_value).get()), 3);
				}
			} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == UnusualEndBlocks.CITRINE_BUD.get()) {
				ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y + 1, z), UnusualEndBlocks.LARGE_CITRINE_BUD.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == UnusualEndBlocks.LARGE_CITRINE_BUD.get()) {
				ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y + 1, z), UnusualEndBlocks.CITRINE_CLUSTER.get().defaultBlockState(), 3);
			}
		} else if (randomNumber == 2) {
			if (world.isEmptyBlock(BlockPos.containing(x, y - 1, z))) {
				ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y - 1, z), UnusualEndBlocks.CITRINE_BUD.get().defaultBlockState(), 3);
				{
					String _value = "ceiling";
					BlockPos _pos = BlockPos.containing(x, y - 1, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _enumProp && _enumProp.getValue(_value).isPresent())
						world.setBlock(_pos, _bs.setValue(_enumProp, (Enum) _enumProp.getValue(_value).get()), 3);
				}
			} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == UnusualEndBlocks.CITRINE_BUD.get()) {
				ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y - 1, z), UnusualEndBlocks.LARGE_CITRINE_BUD.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == UnusualEndBlocks.LARGE_CITRINE_BUD.get()) {
				ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y - 1, z), UnusualEndBlocks.CITRINE_CLUSTER.get().defaultBlockState(), 3);
			}
		} else if (randomNumber == 3) {
			if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
				ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z - 1), UnusualEndBlocks.CITRINE_BUD.get().defaultBlockState(), 3);
				{
					Direction _dir = Direction.NORTH;
					BlockPos _pos = BlockPos.containing(x, y, z - 1);
					BlockState _bs = world.getBlockState(_pos);
					Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
						world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
					} else {
						_property = _bs.getBlock().getStateDefinition().getProperty("axis");
						if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
					}
				}
			} else if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == UnusualEndBlocks.CITRINE_BUD.get()) {
				ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z - 1), UnusualEndBlocks.LARGE_CITRINE_BUD.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == UnusualEndBlocks.LARGE_CITRINE_BUD.get()) {
				ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z - 1), UnusualEndBlocks.CITRINE_CLUSTER.get().defaultBlockState(), 3);
			}
		} else if (randomNumber == 4) {
			if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
				ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z + 1), UnusualEndBlocks.CITRINE_BUD.get().defaultBlockState(), 3);
				{
					Direction _dir = Direction.SOUTH;
					BlockPos _pos = BlockPos.containing(x, y, z + 1);
					BlockState _bs = world.getBlockState(_pos);
					Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
						world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
					} else {
						_property = _bs.getBlock().getStateDefinition().getProperty("axis");
						if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
					}
				}
			} else if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == UnusualEndBlocks.CITRINE_BUD.get()) {
				ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z + 1), UnusualEndBlocks.LARGE_CITRINE_BUD.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == UnusualEndBlocks.LARGE_CITRINE_BUD.get()) {
				ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z + 1), UnusualEndBlocks.CITRINE_CLUSTER.get().defaultBlockState(), 3);
			}
		} else if (randomNumber == 5) {
			if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
				ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x - 1, y, z), UnusualEndBlocks.CITRINE_BUD.get().defaultBlockState(), 3);
				{
					Direction _dir = Direction.WEST;
					BlockPos _pos = BlockPos.containing(x - 1, y, z);
					BlockState _bs = world.getBlockState(_pos);
					Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
						world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
					} else {
						_property = _bs.getBlock().getStateDefinition().getProperty("axis");
						if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
					}
				}
			} else if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == UnusualEndBlocks.CITRINE_BUD.get()) {
				ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x - 1, y, z), UnusualEndBlocks.LARGE_CITRINE_BUD.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == UnusualEndBlocks.LARGE_CITRINE_BUD.get()) {
				ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x - 1, y, z), UnusualEndBlocks.CITRINE_CLUSTER.get().defaultBlockState(), 3);
			}
		} else if (randomNumber == 6) {
			if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
				ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x + 1, y, z), UnusualEndBlocks.CITRINE_BUD.get().defaultBlockState(), 3);
				{
					Direction _dir = Direction.EAST;
					BlockPos _pos = BlockPos.containing(x + 1, y, z);
					BlockState _bs = world.getBlockState(_pos);
					Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
						world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
					} else {
						_property = _bs.getBlock().getStateDefinition().getProperty("axis");
						if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
					}
				}
			} else if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == UnusualEndBlocks.CITRINE_BUD.get()) {
				ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x + 1, y, z), UnusualEndBlocks.LARGE_CITRINE_BUD.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == UnusualEndBlocks.LARGE_CITRINE_BUD.get()) {
				ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x + 1, y, z), UnusualEndBlocks.CITRINE_CLUSTER.get().defaultBlockState(), 3);
			}
		}
	}
}

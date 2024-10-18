package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModBlocks;

public class ChorusCaneFlowerBlockValidPlacementConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep1 ? blockstate.getValue(_getep1).toString() : "").equals("FLOOR")
				&& (world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude() || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == UnusualendModBlocks.BLOOMING_CHORUS_CANE.get()
						|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.CHAIN || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.IRON_BARS
						|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.END_ROD)
				|| (blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep12 ? blockstate.getValue(_getep12).toString() : "").equals("CEILING")
						&& (world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude() || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.CHAIN
								|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.IRON_BARS || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.END_ROD)
				|| (new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection(blockstate)) == Direction.NORTH && world.getBlockState(BlockPos.containing(x, y, z + 1)).canOcclude() || (new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection(blockstate)) == Direction.EAST && world.getBlockState(BlockPos.containing(x - 1, y, z)).canOcclude() || (new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection(blockstate)) == Direction.SOUTH && world.getBlockState(BlockPos.containing(x, y, z - 1)).canOcclude() || (new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection(blockstate)) == Direction.WEST && world.getBlockState(BlockPos.containing(x + 1, y, z)).canOcclude()) {
			return true;
		}
		return false;
	}
}

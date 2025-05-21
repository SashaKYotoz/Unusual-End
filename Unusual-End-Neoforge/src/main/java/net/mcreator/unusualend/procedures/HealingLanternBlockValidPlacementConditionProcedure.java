package net.mcreator.unusualend.procedures;

import net.mcreator.unusualend.UnusualEnd;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class HealingLanternBlockValidPlacementConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep1 ? blockstate.getValue(_getep1).toString() : "").equals("FLOOR")
				&& ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(UnusualEnd.makeUEID("valid_lantern"))) || world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()
						|| world.getBlockState(BlockPos.containing(x, y - 1, z)).isFaceSturdy(world, BlockPos.containing(x, y - 1, z), Direction.UP))
				|| (blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep7 ? blockstate.getValue(_getep7).toString() : "").equals("CEILING")
						&& ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(UnusualEnd.makeUEID("valid_lantern"))) || world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()
								|| world.getBlockState(BlockPos.containing(x, y + 1, z)).isFaceSturdy(world, BlockPos.containing(x, y + 1, z), Direction.DOWN))
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
				}.getDirection(blockstate)) == Direction.NORTH
						&& (world.getBlockState(BlockPos.containing(x, y, z + 1)).canOcclude() || world.getBlockState(BlockPos.containing(x, y, z + 1)).isFaceSturdy(world, BlockPos.containing(x, y, z + 1), Direction.SOUTH))
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
				}.getDirection(blockstate)) == Direction.EAST
						&& (world.getBlockState(BlockPos.containing(x - 1, y, z)).canOcclude() || world.getBlockState(BlockPos.containing(x - 1, y, z)).isFaceSturdy(world, BlockPos.containing(x - 1, y, z), Direction.WEST))
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
				}.getDirection(blockstate)) == Direction.SOUTH
						&& (world.getBlockState(BlockPos.containing(x, y, z - 1)).canOcclude() || world.getBlockState(BlockPos.containing(x, y, z - 1)).isFaceSturdy(world, BlockPos.containing(x, y, z - 1), Direction.NORTH))
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
				}.getDirection(blockstate)) == Direction.WEST
						&& (world.getBlockState(BlockPos.containing(x + 1, y, z)).canOcclude() || world.getBlockState(BlockPos.containing(x + 1, y, z)).isFaceSturdy(world, BlockPos.containing(x + 1, y, z), Direction.EAST))) {
			return true;
		}
		return false;
	}
}

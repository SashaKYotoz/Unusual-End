package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.sweety.unusualend.init.UnusualendModTags;
import net.sweety.unusualend.util.ProcedureHelper;

public class HealingLanternBlockValidPlacementConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep1 ? blockstate.getValue(_getep1).toString() : "").equals("FLOOR")
				&& ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(UnusualendModTags.Blocks.VALID_LANTERN) || world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()
						|| world.getBlockState(BlockPos.containing(x, y - 1, z)).isFaceSturdy(world, BlockPos.containing(x, y - 1, z), Direction.UP))
				|| (blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep7 ? blockstate.getValue(_getep7).toString() : "").equals("CEILING")
						&& ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(UnusualendModTags.Blocks.VALID_LANTERN) || world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()
								|| world.getBlockState(BlockPos.containing(x, y + 1, z)).isFaceSturdy(world, BlockPos.containing(x, y + 1, z), Direction.DOWN))
				|| (ProcedureHelper.getDirection(blockstate)) == Direction.NORTH
						&& (world.getBlockState(BlockPos.containing(x, y, z + 1)).canOcclude() || world.getBlockState(BlockPos.containing(x, y, z + 1)).isFaceSturdy(world, BlockPos.containing(x, y, z + 1), Direction.SOUTH))
				|| (ProcedureHelper.getDirection(blockstate)) == Direction.EAST
						&& (world.getBlockState(BlockPos.containing(x - 1, y, z)).canOcclude() || world.getBlockState(BlockPos.containing(x - 1, y, z)).isFaceSturdy(world, BlockPos.containing(x - 1, y, z), Direction.WEST))
				|| (ProcedureHelper.getDirection(blockstate)) == Direction.SOUTH
						&& (world.getBlockState(BlockPos.containing(x, y, z - 1)).canOcclude() || world.getBlockState(BlockPos.containing(x, y, z - 1)).isFaceSturdy(world, BlockPos.containing(x, y, z - 1), Direction.NORTH))
				|| (ProcedureHelper.getDirection(blockstate)) == Direction.WEST
						&& (world.getBlockState(BlockPos.containing(x + 1, y, z)).canOcclude() || world.getBlockState(BlockPos.containing(x + 1, y, z)).isFaceSturdy(world, BlockPos.containing(x + 1, y, z), Direction.EAST))) {
			return true;
		}
		return false;
	}
}

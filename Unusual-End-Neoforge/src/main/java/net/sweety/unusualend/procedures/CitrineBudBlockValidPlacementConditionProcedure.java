package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.sweety.unusualend.util.ProcedureHelper;

public class CitrineBudBlockValidPlacementConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep1 ? blockstate.getValue(_getep1).toString() : "").equals("FLOOR") && world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()
				|| (blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep4 ? blockstate.getValue(_getep4).toString() : "").equals("CEILING") && world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()
				|| (ProcedureHelper.getDirection(blockstate)) == Direction.NORTH && world.getBlockState(BlockPos.containing(x, y, z + 1)).canOcclude() || (ProcedureHelper.getDirection(blockstate)) == Direction.EAST && world.getBlockState(BlockPos.containing(x - 1, y, z)).canOcclude() || (ProcedureHelper.getDirection(blockstate)) == Direction.SOUTH && world.getBlockState(BlockPos.containing(x, y, z - 1)).canOcclude() || (ProcedureHelper.getDirection(blockstate)) == Direction.WEST && world.getBlockState(BlockPos.containing(x + 1, y, z)).canOcclude()) {
			return true;
		}
		return false;
	}
}

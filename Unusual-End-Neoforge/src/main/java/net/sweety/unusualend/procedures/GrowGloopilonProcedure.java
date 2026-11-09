package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.sweety.unusualend.init.UnusualEndBlocks;
import net.sweety.unusualend.util.ProcedureHelper;

public class GrowGloopilonProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualEndBlocks.GLOOPILON_SEEDS.get()) {
			if (world.isEmptyBlock(BlockPos.containing(x, y - 1, z))) {
				ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z), UnusualEndBlocks.GLOOPILON_STEM.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y - 1, z), UnusualEndBlocks.GLOOPILON_BULB.get().defaultBlockState(), 3);
				ProcedureHelper.playSound(world, x, y, z, SoundEvents.CHORUS_FLOWER_GROW, SoundSource.BLOCKS, 1, (float) 0.7);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualEndBlocks.GLOOPILON_BULB.get()) {
			ProcedureHelper.playSound(world, x, y, z, SoundEvents.CHORUS_FLOWER_GROW, SoundSource.BLOCKS, 1, (float) 0.7);
			if ((blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip10 ? blockstate.getValue(_getip10) : -1) < 2) {
				{
					int _value = (int) ((blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip12 ? blockstate.getValue(_getip12) : -1) + 1);
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
			}
		}
	}
}

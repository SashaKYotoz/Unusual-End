package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.registries.ForgeRegistries;
import net.sweety.unusualend.init.UnusualendModBlocks;
import net.sweety.unusualend.util.ProcedureHelper;

public class GrowGloopilonProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualendModBlocks.GLOOPILON_SEEDS.get()) {
			if (world.isEmptyBlock(BlockPos.containing(x, y - 1, z))) {
				ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z), UnusualendModBlocks.GLOOPILON_STEM.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y - 1, z), UnusualendModBlocks.GLOOPILON_BULB.get().defaultBlockState(), 3);
				ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chorus_flower.grow")), SoundSource.BLOCKS, 1, (float) 0.7);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualendModBlocks.GLOOPILON_BULB.get()) {
			if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip9 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip9) : -1) < 2) {
				ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chorus_flower.grow")), SoundSource.BLOCKS, 1, (float) 0.7);
				{
					int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip12
							? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip12)
							: -1) + 1);
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
			}
		}
	}
}

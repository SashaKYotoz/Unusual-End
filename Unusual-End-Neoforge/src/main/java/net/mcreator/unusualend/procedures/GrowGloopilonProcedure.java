package net.mcreator.unusualend.procedures;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModBlocks;

import java.util.Map;

public class GrowGloopilonProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualendModBlocks.GLOOPILON_SEEDS.get()) {
			if (world.isEmptyBlock(BlockPos.containing(x, y - 1, z))) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = UnusualendModBlocks.GLOOPILON_STEM.get().defaultBlockState();
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
				}
				world.setBlock(BlockPos.containing(x, y - 1, z), UnusualendModBlocks.GLOOPILON_BULB.get().defaultBlockState(), 3);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.CHORUS_FLOWER_GROW, SoundSource.BLOCKS, 1, (float) 0.7);
					} else {
						_level.playLocalSound(x, y, z, SoundEvents.CHORUS_FLOWER_GROW, SoundSource.BLOCKS, 1, (float) 0.7, false);
					}
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualendModBlocks.GLOOPILON_BULB.get()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.CHORUS_FLOWER_GROW, SoundSource.BLOCKS, 1, (float) 0.7);
				} else {
					_level.playLocalSound(x, y, z, SoundEvents.CHORUS_FLOWER_GROW, SoundSource.BLOCKS, 1, (float) 0.7, false);
				}
			}
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

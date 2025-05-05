package net.mcreator.unusualend.procedures;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModBlocks;

public class FadingBlockOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (!entity.isShiftKeyDown()) {
			if (!world.isClientSide()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.ENDERMAN_TELEPORT, SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, SoundEvents.ENDERMAN_TELEPORT, SoundSource.BLOCKS, 1, 1, false);
					}
				}
			}
			sx = -3;
			for (int index0 = 0; index0 < 7; index0++) {
				sy = -3;
				for (int index1 = 0; index1 < 7; index1++) {
					sz = -3;
					for (int index2 = 0; index2 < 7; index2++) {
						if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == UnusualendModBlocks.FADING_BLOCK.get()
								&& ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip6
										? (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getValue(_getip6)
										: -1) == 0) {
							world.scheduleTick(BlockPos.containing(x + sx, y + sy, z + sz), world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getBlock(), 0);
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x + sx, y + sy, z + sz);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("open", 60);
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							{
								int _value = 1;
								BlockPos _pos = BlockPos.containing(x + sx, y + sy, z + sz);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.DRAGON_BREATH, (x + sx + 0.5), (y + sy + 0.5), (z + sz + 0.5), 8, 0.3, 0.3, 0.3, 0);
						}
						sz = sz + 1;
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
		}
	}
}

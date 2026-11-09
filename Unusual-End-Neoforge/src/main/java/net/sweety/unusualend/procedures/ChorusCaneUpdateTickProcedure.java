package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.block.ChorusCaneFlowerBlock;
import net.sweety.unusualend.init.UnusualEndBlocks;
import net.sweety.unusualend.util.ProcedureHelper;

public class ChorusCaneUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
			if (Math.random() < 0.4) {
				if (Math.random() < 0.25) {
					world.setBlock(BlockPos.containing(x, y + 1, z), UnusualEndBlocks.BLOOMING_CHORUS_CANE.get().defaultBlockState(), 3);
					if (Math.random() < 0.25 && world.isEmptyBlock(BlockPos.containing(x, y + 2, z))) {
						world.setBlock(BlockPos.containing(x, y + 2, z), UnusualEndBlocks.CHORUS_CANE_FLOWER.get().defaultBlockState().setValue(ChorusCaneFlowerBlock.FACE, AttachFace.FLOOR), 3);
					}
				} else if (!world.isEmptyBlock(BlockPos.containing(x, y + 2, z))) {
					world.setBlock(BlockPos.containing(x, y + 1, z), UnusualEndBlocks.BLOOMING_CHORUS_CANE.get().defaultBlockState(), 3);
				} else {
					world.setBlock(BlockPos.containing(x, y + 1, z), UnusualEndBlocks.CHORUS_CANE.get().defaultBlockState(), 3);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.NOTE_BLOCK_FLUTE.value(), SoundSource.BLOCKS, 0.3f,
								(float) (Mth.nextDouble(world.getRandom(), 50, 70) * 0.01f));
					} else {
						_level.playLocalSound(x, y, z, SoundEvents.NOTE_BLOCK_FLUTE.value(), SoundSource.BLOCKS, (float) 0.3, (float) (Mth.nextDouble(world.getRandom(), 50, 70) * 0.01), false);
					}
				}
				UnusualEnd.queueServerWork(4, () -> {
					ProcedureHelper.playSound(world, x, y, z, SoundEvents.NOTE_BLOCK_FLUTE.value(), SoundSource.BLOCKS, (float) 0.3, (float) (Mth.nextDouble(world.getRandom(), 50, 70) * 0.01));
					UnusualEnd.queueServerWork(4, () -> {
						ProcedureHelper.playSound(world, x, y, z, SoundEvents.NOTE_BLOCK_FLUTE.value(), SoundSource.BLOCKS, (float) 0.3, (float) (Mth.nextDouble(world.getRandom(), 50, 70) * 0.01));
					});
				});
			}
		}
	}
}

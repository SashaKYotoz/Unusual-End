package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraftforge.registries.ForgeRegistries;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.block.ChorusCaneFlowerBlock;
import net.sweety.unusualend.init.UnusualendModBlocks;
import net.sweety.unusualend.util.ProcedureHelper;

public class ChorusCaneUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
			if (Math.random() < 0.4) {
				if (Math.random() < 0.25) {
					world.setBlock(BlockPos.containing(x, y + 1, z), UnusualendModBlocks.BLOOMING_CHORUS_CANE.get().defaultBlockState(), 3);
					if (Math.random() < 0.25 && world.isEmptyBlock(BlockPos.containing(x, y + 2, z))) {
						if (world instanceof ServerLevel _level)
							world.setBlock(BlockPos.containing(x, y + 2, z), UnusualendModBlocks.CHORUS_CANE_FLOWER.get().defaultBlockState().setValue(ChorusCaneFlowerBlock.FACE, AttachFace.FLOOR), 3);
					}
				} else if (!world.isEmptyBlock(BlockPos.containing(x, y + 2, z))) {
					world.setBlock(BlockPos.containing(x, y + 1, z), UnusualendModBlocks.BLOOMING_CHORUS_CANE.get().defaultBlockState(), 3);
				} else {
					world.setBlock(BlockPos.containing(x, y + 1, z), UnusualendModBlocks.CHORUS_CANE.get().defaultBlockState(), 3);
				}
				ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.flute")), SoundSource.BLOCKS, (float) 0.3, (float) (Mth.nextDouble(world.getRandom(), 50, 70) * 0.01));
				UnusualEnd.queueServerWork(4, () -> {
					ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.flute")), SoundSource.BLOCKS, (float) 0.3, (float) (Mth.nextDouble(world.getRandom(), 50, 70) * 0.01));
					UnusualEnd.queueServerWork(4, () -> {
						ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.flute")), SoundSource.BLOCKS, (float) 0.3, (float) (Mth.nextDouble(world.getRandom(), 50, 70) * 0.01));
					});
				});
			}
		}
	}
}

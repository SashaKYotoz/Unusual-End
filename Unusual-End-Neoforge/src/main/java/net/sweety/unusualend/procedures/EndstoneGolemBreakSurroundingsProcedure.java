package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.sweety.unusualend.util.ProcedureHelper;

public class EndstoneGolemBreakSurroundingsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		boolean found = false;
		found = false;
		sx = -3;
		for (int index0 = 0; index0 < 6; index0++) {
			sy = 0;
			for (int index1 = 0; index1 < 5; index1++) {
				sz = -3;
				for (int index2 = 0; index2 < 6; index2++) {
					if (!world.isEmptyBlock(BlockPos.containing(x + sx, y + sy, z + sz))) {
						if (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getDestroySpeed(world, BlockPos.containing(x + sx, y + sy, z + sz)) >= 0) {
							found = true;
							{
								BlockPos _pos = BlockPos.containing(x + sx, y + sy, z + sz);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + sx, y + sy, z + sz), null);
								world.destroyBlock(_pos, false);
							}
							world.levelEvent(2001, BlockPos.containing(x + sx, y + sy, z + sz), Block.getId((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)))));
						}
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		if (found) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x, y, z, 15, 1, 1, 1, 0);
			ProcedureHelper.playSound(world, x, y, z, SoundEvents.GENERIC_EXPLODE.value(), SoundSource.NEUTRAL, 1, 1);
		}
	}
}

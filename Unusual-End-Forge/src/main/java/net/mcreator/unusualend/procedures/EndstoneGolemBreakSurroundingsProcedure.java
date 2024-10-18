package net.mcreator.unusualend.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

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
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
	}
}

package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class EndstoneGolemBreakSurroundingsProcedure {
    private static final int MIN_OFFSET = -3;
    private static final int MAX_OFFSET = 2;

    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (!(world instanceof ServerLevel level))
            return;
        BlockPos origin = new BlockPos(x, y, z);
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        int broken = 0;
        for (int dx = MIN_OFFSET; dx <= MAX_OFFSET; dx++) {
            for (int dy = 0; dy < 5; dy++) {
                for (int dz = MIN_OFFSET; dz <= MAX_OFFSET; dz++) {
                    pos.setWithOffset(origin, dx, dy, dz);
                    BlockState state = level.getBlockState(pos);
                    if (state.isAir() || state.getDestroySpeed(level, pos) < 0)
                        continue;
                    BlockPos immutable = pos.immutable();
                    BlockEntity blockEntity = state.hasBlockEntity() ? level.getBlockEntity(immutable) : null;
                    Block.dropResources(state, level, immutable, blockEntity);
                    level.removeBlock(immutable, false);
                    if (broken % 3 == 0)
                        level.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, state), immutable.getX() + 0.5, immutable.getY() + 0.5, immutable.getZ() + 0.5, 6, 0.3, 0.3, 0.3, 0.1);
                    broken++;
                }
            }
        }
        if (broken > 0) {
            level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x, y, z, 3, 1, 1, 1, 0);
            level.playSound(null, x, y, z, SoundEvents.GENERIC_EXPLODE, SoundSource.HOSTILE, 1, 1);
        }
    }
}
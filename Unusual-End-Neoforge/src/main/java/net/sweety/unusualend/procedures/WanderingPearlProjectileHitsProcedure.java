package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class WanderingPearlProjectileHitsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double X = 0;
		double Y = 0;
		double Z = 0;
		{
            entity.teleportTo(x, y, z);
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(x, y, z, entity.getYRot(), entity.getXRot());
		}
		for (int index0 = 0; index0 < 1000; index0++) {
			X = x + Mth.nextInt(RandomSource.create(), -2, 2);
			Y = y + Mth.nextInt(RandomSource.create(), -4, 4);
			Z = z + Mth.nextInt(RandomSource.create(), -2, 2);
			if ((world.getBlockState(BlockPos.containing(X, Y, Z))).getBlock() == Blocks.CAVE_AIR || (world.getBlockState(BlockPos.containing(X, Y, Z))).getBlock() == Blocks.VOID_AIR
					|| (world.getBlockState(BlockPos.containing(X, Y, Z))).getBlock() == Blocks.AIR) {
				if ((world.getBlockState(BlockPos.containing(X, Y + 1, Z))).getBlock() == Blocks.CAVE_AIR || (world.getBlockState(BlockPos.containing(X, Y + 1, Z))).getBlock() == Blocks.VOID_AIR
						|| (world.getBlockState(BlockPos.containing(X, Y + 1, Z))).getBlock() == Blocks.AIR) {
					if (world.getBlockState(BlockPos.containing(X, Y - 1, Z)).canOcclude()) {
						{
                            entity.teleportTo(X, Y, Z);
							if (entity instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(X, Y, Z, entity.getYRot(), entity.getXRot());
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.PORTAL, X, Y, Z, 30, 0.5, 1.5, 0.5, 0);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.PLAYERS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.PLAYERS, 1, 1, false);
							}
						}
						entity.fallDistance = 0;
						break;
					}
				}
			}
		}
	}
}

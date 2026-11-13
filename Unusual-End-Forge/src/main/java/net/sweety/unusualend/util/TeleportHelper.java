package net.sweety.unusualend.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public final class TeleportHelper {
	private static final int MAX_ATTEMPTS = 1000;

	private TeleportHelper() {
	}

	public static void teleport(Entity entity, double x, double y, double z) {
		entity.teleportTo(x, y, z);
		if (entity instanceof ServerPlayer serverPlayer)
			serverPlayer.connection.teleport(x, y, z, entity.getYRot(), entity.getXRot());
	}

	public static boolean isSafeSpot(LevelAccessor world, BlockPos pos) {
		return world.getBlockState(pos).isAir() && world.getBlockState(pos.above()).isAir() && world.getBlockState(pos.below()).canOcclude();
	}

	public static boolean scatter(LevelAccessor world, Entity entity, double x, double y, double z, int horizontal, int vertical) {
		teleport(entity, x, y, z);
		RandomSource random = world.getRandom();
		for (int attempt = 0; attempt < MAX_ATTEMPTS; attempt++) {
			double tx = x + Mth.nextInt(random, -horizontal, horizontal);
			double ty = y + Mth.nextInt(random, -vertical, vertical);
			double tz = z + Mth.nextInt(random, -horizontal, horizontal);
			if (isSafeSpot(world, BlockPos.containing(tx, ty, tz))) {
				teleport(entity, tx, ty, tz);
				if (world instanceof ServerLevel level)
					level.sendParticles(ParticleTypes.PORTAL, tx, ty, tz, 30, 0.5, 1.5, 0.5, 0);
				ProcedureHelper.playSound(world, x, y, z, SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.PLAYERS, 1, 1);
				entity.resetFallDistance();
				return true;
			}
		}
		return false;
	}
}

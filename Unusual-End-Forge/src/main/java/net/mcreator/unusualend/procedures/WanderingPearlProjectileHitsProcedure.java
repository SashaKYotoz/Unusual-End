package net.mcreator.unusualend.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class WanderingPearlProjectileHitsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double X = 0;
		double Y = 0;
		double Z = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		{
			Entity _ent = entity;
			_ent.teleportTo(x, y, z);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
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
							Entity _ent = entity;
							_ent.teleportTo(X, Y, Z);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(X, Y, Z, _ent.getYRot(), _ent.getXRot());
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.PORTAL, X, Y, Z, 30, 0.5, 1.5, 0.5, 0);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.PLAYERS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.PLAYERS, 1, 1, false);
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

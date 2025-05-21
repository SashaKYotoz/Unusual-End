package net.mcreator.unusualend.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import java.util.Comparator;

public class ShulkerShooterRedstoneOnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double face = 0;
		if (!(world instanceof Level _level0 && _level0.hasNeighborSignal(BlockPos.containing(x, y, z)))) {
			if (!(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16, 16, 16), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)) == null)) {
				if (!(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
						} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
									&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
						}
						return false;
					}
				}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16, 16, 16), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null))) || new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
						} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
									&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
						}
						return false;
					}
				}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16, 16, 16), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null))))) {
					face = Mth.nextInt(RandomSource.create(), 1, 4);
					if (face == 1) {
						if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
							if (world.isClientSide()) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker.shoot")), SoundSource.BLOCKS, 1, (float) 0.6);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker.shoot")), SoundSource.BLOCKS, 1, (float) 0.6, false);
									}
								}
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.POOF, (x + 0.5), (y + 0.5), (z - 0.1), 3, 0.2, 0.2, 0.2, 0.1);
						}
					} else if (face == 2) {
						if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
							if (world.isClientSide()) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker.shoot")), SoundSource.BLOCKS, 1, (float) 0.6);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker.shoot")), SoundSource.BLOCKS, 1, (float) 0.6, false);
									}
								}
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.POOF, (x + 0.5), (y + 0.5), (z + 1.1), 3, 0.2, 0.2, 0.2, 0.1);
						}
					} else if (face == 3) {
						if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
							if (world.isClientSide()) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker.shoot")), SoundSource.BLOCKS, 1, (float) 0.6);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker.shoot")), SoundSource.BLOCKS, 1, (float) 0.6, false);
									}
								}
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.POOF, (x - 0.1), (y + 0.5), (z + 0.5), 3, 0.2, 0.2, 0.2, 0.1);
						}
					} else if (face == 4) {
						if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
							if (world.isClientSide()) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker.shoot")), SoundSource.BLOCKS, 1, (float) 0.6);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker.shoot")), SoundSource.BLOCKS, 1, (float) 0.6, false);
									}
								}
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.POOF, (x + 1.1), (y + 0.5), (z + 0.5), 3, 0.2, 0.2, 0.2, 0.1);
						}
					}
				}
			}
		}
	}
}

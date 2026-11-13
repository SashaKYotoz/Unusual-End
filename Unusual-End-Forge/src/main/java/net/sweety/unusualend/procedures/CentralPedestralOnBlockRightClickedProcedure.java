package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.entity.VoidCrackEntity;
import net.sweety.unusualend.init.UnusualendModBlocks;
import net.sweety.unusualend.init.UnusualendModEntities;
import net.sweety.unusualend.init.UnusualendModParticleTypes;
import net.sweety.unusualend.util.ProcedureHelper;

import java.util.Comparator;
import java.util.List;

public class CentralPedestralOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double altars = 0;
		altars = 0;
		if ((ProcedureHelper.getItemStack(world, BlockPos.containing(x + 8, y, z), 0)).getItem() == UnusualendModBlocks.PRISMATIC_PEARL_DISPLAY.get().asItem()) {
			altars = altars + 1;
		}
		if ((ProcedureHelper.getItemStack(world, BlockPos.containing(x - 8, y, z), 0)).getItem() == UnusualendModBlocks.PRISMATIC_PEARL_DISPLAY.get().asItem()) {
			altars = altars + 1;
		}
		if ((ProcedureHelper.getItemStack(world, BlockPos.containing(x, y, z + 8), 0)).getItem() == UnusualendModBlocks.PRISMATIC_PEARL_DISPLAY.get().asItem()) {
			altars = altars + 1;
		}
		if ((ProcedureHelper.getItemStack(world, BlockPos.containing(x, y, z - 8), 0)).getItem() == UnusualendModBlocks.PRISMATIC_PEARL_DISPLAY.get().asItem()) {
			altars = altars + 1;
		}
		if ((ProcedureHelper.getItemStack(world, BlockPos.containing(x - 5, y, z + 5), 0)).getItem() == UnusualendModBlocks.PRISMATIC_PEARL_DISPLAY.get().asItem()) {
			altars = altars + 1;
		}
		if ((ProcedureHelper.getItemStack(world, BlockPos.containing(x + 5, y, z - 5), 0)).getItem() == UnusualendModBlocks.PRISMATIC_PEARL_DISPLAY.get().asItem()) {
			altars = altars + 1;
		}
		if ((ProcedureHelper.getItemStack(world, BlockPos.containing(x - 5, y, z - 5), 0)).getItem() == UnusualendModBlocks.PRISMATIC_PEARL_DISPLAY.get().asItem()) {
			altars = altars + 1;
		}
		if ((ProcedureHelper.getItemStack(world, BlockPos.containing(x + 5, y, z + 5), 0)).getItem() == UnusualendModBlocks.PRISMATIC_PEARL_DISPLAY.get().asItem()) {
			altars = altars + 1;
		}
		if (altars == 0) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7d\u00A77\u25CE\u25CE\u25CE\u25CE\u25CE\u25CE\u25CE\u25CE"), true);
		} else if (altars == 1) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7d\u25CE\u00A77\u25CE\u25CE\u25CE\u25CE\u25CE\u25CE\u25CE"), true);
		} else if (altars == 2) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7d\u25CE\u25CE\u00A77\u25CE\u25CE\u25CE\u25CE\u25CE\u25CE"), true);
		} else if (altars == 3) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7d\u25CE\u25CE\u25CE\u00A77\u25CE\u25CE\u25CE\u25CE\u25CE"), true);
		} else if (altars == 4) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7d\u25CE\u25CE\u25CE\u25CE\u00A77\u25CE\u25CE\u25CE\u25CE"), true);
		} else if (altars == 5) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7d\u25CE\u25CE\u25CE\u25CE\u25CE\u00A77\u25CE\u25CE\u25CE"), true);
		} else if (altars == 6) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7d\u25CE\u25CE\u25CE\u25CE\u25CE\u25CE\u00A77\u25CE\u25CE"), true);
		} else if (altars == 7) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7d\u25CE\u25CE\u25CE\u25CE\u25CE\u25CE\u25CE\u00A77\u25CE"), true);
		} else if (altars == 8) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (entityiterator instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.translatable("text.unusualend.queen_theme"), true);
					}
				}
			}
			world.destroyBlock(BlockPos.containing(x, y, z), false);
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
			UnusualEnd.queueServerWork(1, () -> {
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 5, y, z + 5)));
					entityToSpawn.setVisualOnly(true);
					_level.addFreshEntity(entityToSpawn);
				}
				world.destroyBlock(BlockPos.containing(x + 5, y, z + 5), false);
				UnusualEnd.queueServerWork(1, () -> {
					if (world instanceof ServerLevel _level) {
						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
						entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x - 5, y, z - 5)));
						entityToSpawn.setVisualOnly(true);
						_level.addFreshEntity(entityToSpawn);
					}
					world.destroyBlock(BlockPos.containing(x - 5, y, z - 5), false);
					UnusualEnd.queueServerWork(1, () -> {
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x - 5, y, z + 5)));
							entityToSpawn.setVisualOnly(true);
							_level.addFreshEntity(entityToSpawn);
						}
						world.destroyBlock(BlockPos.containing(x - 5, y, z + 5), false);
						UnusualEnd.queueServerWork(1, () -> {
							if (world instanceof ServerLevel _level) {
								LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
								entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 5, y, z - 5)));
								entityToSpawn.setVisualOnly(true);
								_level.addFreshEntity(entityToSpawn);
							}
							world.destroyBlock(BlockPos.containing(x + 5, y, z - 5), false);
							UnusualEnd.queueServerWork(1, () -> {
								if (world instanceof ServerLevel _level) {
									LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
									entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 8, y, z)));
									entityToSpawn.setVisualOnly(true);
									_level.addFreshEntity(entityToSpawn);
								}
								world.destroyBlock(BlockPos.containing(x + 8, y, z), false);
								UnusualEnd.queueServerWork(1, () -> {
									if (world instanceof ServerLevel _level) {
										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
										entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x - 8, y, z)));
										entityToSpawn.setVisualOnly(true);
										_level.addFreshEntity(entityToSpawn);
									}
									world.destroyBlock(BlockPos.containing(x - 8, y, z), false);
									UnusualEnd.queueServerWork(1, () -> {
										if (world instanceof ServerLevel _level) {
											LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
											entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z + 8)));
											entityToSpawn.setVisualOnly(true);
											_level.addFreshEntity(entityToSpawn);
										}
										world.destroyBlock(BlockPos.containing(x, y, z + 8), false);
										UnusualEnd.queueServerWork(1, () -> {
											if (world instanceof ServerLevel _level) {
												LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
												entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z - 8)));
												entityToSpawn.setVisualOnly(true);
												_level.addFreshEntity(entityToSpawn);
											}
											world.destroyBlock(BlockPos.containing(x, y, z - 8), false);
											if (!world.getEntitiesOfClass(VoidCrackEntity.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
												if (!((Entity) world.getEntitiesOfClass(VoidCrackEntity.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(ProcedureHelper.byDistanceTo(x, y, z)).findFirst().orElse(null)).level().isClientSide())
													((Entity) world.getEntitiesOfClass(VoidCrackEntity.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(ProcedureHelper.byDistanceTo(x, y, z)).findFirst().orElse(null)).discard();
											}
											UnusualEnd.queueServerWork(20, () -> {
												if (world instanceof ServerLevel _level)
													_level.sendParticles((SimpleParticleType) (UnusualendModParticleTypes.PINK_FLAME.get()), x, y, z, 80, 2, 2, 2, 0);
												if (world instanceof ServerLevel _level)
													_level.sendParticles(ParticleTypes.SQUID_INK, x, y, z, 100, 1.5, 1.5, 1.5, 0);
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = UnusualendModEntities.ENDERBLOB_QUEEN.get().spawn(_level, BlockPos.containing(x + 0.5, y, z + 0.5), MobSpawnType.MOB_SUMMONED);
													if (entityToSpawn != null) {
														entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
													}
												}
											});
										});
									});
								});
							});
						});
					});
				});
			});
		}
	}
}

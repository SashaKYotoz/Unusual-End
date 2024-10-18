package net.mcreator.unusualend.procedures;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModParticleTypes;
import net.mcreator.unusualend.init.UnusualendModEntities;
import net.mcreator.unusualend.init.UnusualendModBlocks;
import net.mcreator.unusualend.entity.VoidCrackEntity;
import net.mcreator.unusualend.UnusualendMod;

import java.util.concurrent.atomic.AtomicReference;
import java.util.List;
import java.util.Comparator;

public class CentralPedestralOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sx = 0;
		double sy = 0;
		double altars = 0;
		double sz = 0;
		double altar_to_remove = 0;
		altars = 0;
		if ((new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, BlockPos.containing(x + 8, y, z), 0)).getItem() == UnusualendModBlocks.PRISMATIC_PEARL_DISPLAY.get().asItem()) {
			altars = altars + 1;
		}
		if ((new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, BlockPos.containing(x - 8, y, z), 0)).getItem() == UnusualendModBlocks.PRISMATIC_PEARL_DISPLAY.get().asItem()) {
			altars = altars + 1;
		}
		if ((new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, BlockPos.containing(x, y, z + 8), 0)).getItem() == UnusualendModBlocks.PRISMATIC_PEARL_DISPLAY.get().asItem()) {
			altars = altars + 1;
		}
		if ((new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, BlockPos.containing(x, y, z - 8), 0)).getItem() == UnusualendModBlocks.PRISMATIC_PEARL_DISPLAY.get().asItem()) {
			altars = altars + 1;
		}
		if ((new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, BlockPos.containing(x - 5, y, z + 5), 0)).getItem() == UnusualendModBlocks.PRISMATIC_PEARL_DISPLAY.get().asItem()) {
			altars = altars + 1;
		}
		if ((new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, BlockPos.containing(x + 5, y, z - 5), 0)).getItem() == UnusualendModBlocks.PRISMATIC_PEARL_DISPLAY.get().asItem()) {
			altars = altars + 1;
		}
		if ((new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, BlockPos.containing(x - 5, y, z - 5), 0)).getItem() == UnusualendModBlocks.PRISMATIC_PEARL_DISPLAY.get().asItem()) {
			altars = altars + 1;
		}
		if ((new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, BlockPos.containing(x + 5, y, z + 5), 0)).getItem() == UnusualendModBlocks.PRISMATIC_PEARL_DISPLAY.get().asItem()) {
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
							_player.displayClientMessage(Component.literal((Component.translatable("text.unusualend.queen_theme").getString())), true);
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
			UnusualendMod.queueServerWork(1, () -> {
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 5, y, z + 5)));
					entityToSpawn.setVisualOnly(true);
					_level.addFreshEntity(entityToSpawn);
				}
				world.destroyBlock(BlockPos.containing(x + 5, y, z + 5), false);
				UnusualendMod.queueServerWork(1, () -> {
					if (world instanceof ServerLevel _level) {
						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
						entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x - 5, y, z - 5)));
						entityToSpawn.setVisualOnly(true);
						_level.addFreshEntity(entityToSpawn);
					}
					world.destroyBlock(BlockPos.containing(x - 5, y, z - 5), false);
					UnusualendMod.queueServerWork(1, () -> {
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x - 5, y, z + 5)));
							entityToSpawn.setVisualOnly(true);
							_level.addFreshEntity(entityToSpawn);
						}
						world.destroyBlock(BlockPos.containing(x - 5, y, z + 5), false);
						UnusualendMod.queueServerWork(1, () -> {
							if (world instanceof ServerLevel _level) {
								LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
								entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 5, y, z - 5)));
								entityToSpawn.setVisualOnly(true);
								_level.addFreshEntity(entityToSpawn);
							}
							world.destroyBlock(BlockPos.containing(x + 5, y, z - 5), false);
							UnusualendMod.queueServerWork(1, () -> {
								if (world instanceof ServerLevel _level) {
									LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
									entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 8, y, z)));
									entityToSpawn.setVisualOnly(true);
									_level.addFreshEntity(entityToSpawn);
								}
								world.destroyBlock(BlockPos.containing(x + 8, y, z), false);
								UnusualendMod.queueServerWork(1, () -> {
									if (world instanceof ServerLevel _level) {
										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
										entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x - 8, y, z)));
										entityToSpawn.setVisualOnly(true);
										_level.addFreshEntity(entityToSpawn);
									}
									world.destroyBlock(BlockPos.containing(x - 8, y, z), false);
									UnusualendMod.queueServerWork(1, () -> {
										if (world instanceof ServerLevel _level) {
											LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
											entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z + 8)));
											entityToSpawn.setVisualOnly(true);
											_level.addFreshEntity(entityToSpawn);
										}
										world.destroyBlock(BlockPos.containing(x, y, z + 8), false);
										UnusualendMod.queueServerWork(1, () -> {
											if (world instanceof ServerLevel _level) {
												LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
												entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z - 8)));
												entityToSpawn.setVisualOnly(true);
												_level.addFreshEntity(entityToSpawn);
											}
											world.destroyBlock(BlockPos.containing(x, y, z - 8), false);
											if (!world.getEntitiesOfClass(VoidCrackEntity.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
												if (!((Entity) world.getEntitiesOfClass(VoidCrackEntity.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
													}
												}.compareDistOf(x, y, z)).findFirst().orElse(null)).level().isClientSide())
													((Entity) world.getEntitiesOfClass(VoidCrackEntity.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf(x, y, z)).findFirst().orElse(null)).discard();
											}
											UnusualendMod.queueServerWork(20, () -> {
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

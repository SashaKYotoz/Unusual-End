package net.mcreator.unusualend.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.unusualend.init.UnusualendModBlocks;
import net.mcreator.unusualend.configuration.ConfigurationFileConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BoneMealEndstoneProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BONE_MEAL) {
			if (ConfigurationFileConfiguration.REGULAR_BONEMEAL.get() == true) {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualendModBlocks.INFESTED_END_STONE.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.END_STONE) {
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
					}.checkGamemode(entity))) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (x + 0.5), (y + 0.5), (z + 0.5), 5, 1, 1, 1, 0);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bone_meal.use")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bone_meal.use")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
					sx = -3;
					for (int index0 = 0; index0 < 6; index0++) {
						sy = -1;
						for (int index1 = 0; index1 < 3; index1++) {
							sz = -3;
							for (int index2 = 0; index2 < 6; index2++) {
								if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.END_STONE
										|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == UnusualendModBlocks.INFESTED_END_STONE.get()) {
									if (world.isEmptyBlock(BlockPos.containing(x + sx, y + sy + 1, z + sz))) {
										if (!world.isClientSide()) {
											if (Math.random() < 0.08) {
												world.setBlock(BlockPos.containing(x + sx, y + sy + 1, z + sz), UnusualendModBlocks.ENDSTONE_SPROUTS.get().defaultBlockState(), 3);
												if (world instanceof ServerLevel _level)
													_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (x + sx + 0.5), (y + sy + 1.5 + 0.5), (z + sz + 0.5), 4, 1, 0.6, 1, 0);
											} else if (Math.random() < 0.04) {
												world.setBlock(BlockPos.containing(x + sx, y + sy + 1, z + sz), UnusualendModBlocks.CHORUS_ROOTS.get().defaultBlockState(), 3);
												if (world instanceof ServerLevel _level)
													_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (x + sx + 0.5), (y + sy + 1.5 + 0.5), (z + sz + 0.5), 4, 1, 0.6, 1, 0);
											} else if (Math.random() < 0.04) {
												world.setBlock(BlockPos.containing(x + sx, y + sy + 1, z + sz), UnusualendModBlocks.PURPUR_GRASS.get().defaultBlockState(), 3);
												if (world instanceof ServerLevel _level)
													_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (x + sx + 0.5), (y + sy + 1.5 + 0.5), (z + sz + 0.5), 4, 1, 0.6, 1, 0);
											}
										}
									}
								}
								sz = sz + 1;
							}
							sy = sy + 1;
						}
						sx = sx + 1;
					}
				}
			}
			if (ConfigurationFileConfiguration.GLOOPY_BONEMEAL.get() == true) {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualendModBlocks.GLOOPSLATE.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualendModBlocks.GLOOPSTONE.get()) {
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
					}.checkGamemode(entity))) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 5, 1, 1, 1, 0);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bone_meal.use")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bone_meal.use")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					sx = -3;
					for (int index3 = 0; index3 < 6; index3++) {
						sy = -1;
						for (int index4 = 0; index4 < 3; index4++) {
							sz = -3;
							for (int index5 = 0; index5 < 6; index5++) {
								if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == UnusualendModBlocks.GLOOPSLATE.get()
										|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == UnusualendModBlocks.GLOOPSTONE.get()
										|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == UnusualendModBlocks.SHINY_GLOOPSTONE.get()) {
									if (world.isEmptyBlock(BlockPos.containing(x + sx, y + sy + 1, z + sz))) {
										if (!world.isClientSide()) {
											if (Math.random() < 0.04) {
												world.setBlock(BlockPos.containing(x + sx, y + sy + 1, z + sz), UnusualendModBlocks.GLOOPY_BUSH.get().defaultBlockState(), 3);
												if (world instanceof ServerLevel _level)
													_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (x + sx + 0.5), (y + sy + 1.5 + 0.5), (z + sz + 0.5), 4, 1, 0.6, 1, 0);
											} else if (Math.random() < 0.06) {
												world.setBlock(BlockPos.containing(x + sx, y + sy + 1, z + sz), UnusualendModBlocks.SHINY_SPIREA.get().defaultBlockState(), 3);
												if (world instanceof ServerLevel _level)
													_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (x + sx + 0.5), (y + sy + 1.5 + 0.5), (z + sz + 0.5), 4, 1, 0.6, 1, 0);
											} else if (Math.random() < 0.08) {
												world.setBlock(BlockPos.containing(x + sx, y + sy + 1, z + sz), UnusualendModBlocks.GLOOPY_TENDRILS.get().defaultBlockState(), 3);
												if (world instanceof ServerLevel _level)
													_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (x + sx + 0.5), (y + sy + 1.5 + 0.5), (z + sz + 0.5), 4, 1, 0.6, 1, 0);
											} else if (Math.random() < 0.01) {
												world.setBlock(BlockPos.containing(x + sx, y + sy + 1, z + sz), UnusualendModBlocks.CRYSTAL_FLOWER.get().defaultBlockState(), 3);
												if (world instanceof ServerLevel _level)
													_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (x + sx + 0.5), (y + sy + 1.5 + 0.5), (z + sz + 0.5), 4, 1, 0.6, 1, 0);
											}
										}
									}
								}
								sz = sz + 1;
							}
							sy = sy + 1;
						}
						sx = sx + 1;
					}
				}
			}
			if (ConfigurationFileConfiguration.PURPUR_BONEMEAL.get() == true) {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualendModBlocks.RAW_PURPUR_BLOCK.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualendModBlocks.ROOTED_RAW_PURPUR.get()) {
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
					}.checkGamemode(entity))) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (x + 0.5), (y + 0.5), (z + 0.5), 5, 1, 1, 1, 0);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bone_meal.use")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bone_meal.use")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
					sx = -3;
					for (int index6 = 0; index6 < 6; index6++) {
						sy = -1;
						for (int index7 = 0; index7 < 3; index7++) {
							sz = -3;
							for (int index8 = 0; index8 < 6; index8++) {
								if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == UnusualendModBlocks.ROOTED_RAW_PURPUR.get()
										|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == UnusualendModBlocks.RAW_PURPUR_BLOCK.get()) {
									if (world.isEmptyBlock(BlockPos.containing(x + sx, y + sy + 1, z + sz))) {
										if (!world.isClientSide()) {
											if (Math.random() < 0.08) {
												world.setBlock(BlockPos.containing(x + sx, y + sy + 1, z + sz), UnusualendModBlocks.CHORUS_ROOTS.get().defaultBlockState(), 3);
												if (world instanceof ServerLevel _level)
													_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (x + sx + 0.5), (y + sy + 1.5 + 0.5), (z + sz + 0.5), 4, 1, 0.6, 1, 0);
											} else if (Math.random() < 0.04) {
												world.setBlock(BlockPos.containing(x + sx, y + sy + 1, z + sz), UnusualendModBlocks.CHORUS_FUNGUS.get().defaultBlockState(), 3);
												if (world instanceof ServerLevel _level)
													_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (x + sx + 0.5), (y + sy + 1.5 + 0.5), (z + sz + 0.5), 4, 1, 0.6, 1, 0);
											} else if (Math.random() < 0.04) {
												world.setBlock(BlockPos.containing(x + sx, y + sy + 1, z + sz), UnusualendModBlocks.PURPUR_GRASS.get().defaultBlockState(), 3);
												if (world instanceof ServerLevel _level)
													_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (x + sx + 0.5), (y + sy + 1.5 + 0.5), (z + sz + 0.5), 4, 1, 0.6, 1, 0);
											}
										}
									}
								}
								sz = sz + 1;
							}
							sy = sy + 1;
						}
						sx = sx + 1;
					}
				}
			}
		}
	}
}

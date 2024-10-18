package net.mcreator.unusualend.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.unusualend.init.UnusualendModEntities;
import net.mcreator.unusualend.entity.EndstoneGolemEntity;
import net.mcreator.unusualend.UnusualendMod;

import java.util.List;
import java.util.Comparator;

public class GolemAltarOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.DRAGON_BREATH) {
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
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
			world.destroyBlock(BlockPos.containing(x, y, z), false);
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 0.5, y, z + 0.5)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FIREWORK, (x + 0.5), (y + 1), (z + 0.5), 10, 0, 0, 0, 0.1);
			UnusualendMod.queueServerWork(10, () -> {
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 0.5, y, z + 0.5)));
					entityToSpawn.setVisualOnly(true);
					_level.addFreshEntity(entityToSpawn);
				}
				UnusualendMod.queueServerWork(20, () -> {
					if (world instanceof ServerLevel _level) {
						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
						entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 0.5, y, z + 0.5)));
						entityToSpawn.setVisualOnly(true);
						_level.addFreshEntity(entityToSpawn);
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.FIREWORK, (x + 0.5), (y + 1), (z + 0.5), 5, 0, 0, 0, 0.1);
					UnusualendMod.queueServerWork(5, () -> {
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 0.5, y, z + 0.5)));
							entityToSpawn.setVisualOnly(true);
							_level.addFreshEntity(entityToSpawn);
						}
						EndstoneGolemBreakSurroundingsProcedure.execute(world, x, (y - 1), z);
						UnusualendMod.queueServerWork(10, () -> {
							if (world instanceof ServerLevel _level) {
								LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
								entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 0.5, y, z + 0.5)));
								entityToSpawn.setVisualOnly(true);
								_level.addFreshEntity(entityToSpawn);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.EXPLOSION, (x + 0.5), y, (z + 0.5), 10, 0.5, 0.5, 0.5, 0);
							UnusualendMod.queueServerWork(10, () -> {
								if (world instanceof ServerLevel _level) {
									LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
									entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 0.5, y, z + 0.5)));
									entityToSpawn.setVisualOnly(true);
									_level.addFreshEntity(entityToSpawn);
								}
								{
									final Vec3 _center = new Vec3(x, y, z);
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (entityiterator instanceof Player) {
											if (entityiterator instanceof ServerPlayer _player) {
												Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("unusualend:use_golem_altar"));
												AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
												if (!_ap.isDone()) {
													for (String criteria : _ap.getRemainingCriteria())
														_player.getAdvancements().award(_adv, criteria);
												}
											}
											if (entityiterator instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal((Component.translatable("text.unusualend.golem_theme").getString())), true);
										}
									}
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x + 0.5, y, z + 0.5), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.place")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound((x + 0.5), y, (z + 0.5), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.place")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = UnusualendModEntities.ENDSTONE_GOLEM.get().spawn(_level, BlockPos.containing(x + 0.5, y - 1, z + 0.5), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								if ((((Entity) world.getEntitiesOfClass(EndstoneGolemEntity.class, AABB.ofSize(new Vec3((x + 0.5), (y - 1), (z + 0.5)), 16, 16, 16), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf((x + 0.5), (y - 1), (z + 0.5))).findFirst().orElse(null)).level().dimension()) == Level.END) {
									((Entity) world.getEntitiesOfClass(EndstoneGolemEntity.class, AABB.ofSize(new Vec3((x + 0.5), (y - 1), (z + 0.5)), 16, 16, 16), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((x + 0.5), (y - 1), (z + 0.5))).findFirst().orElse(null)).getPersistentData().putDouble("x", x);
									((Entity) world.getEntitiesOfClass(EndstoneGolemEntity.class, AABB.ofSize(new Vec3((x + 0.5), (y - 1), (z + 0.5)), 16, 16, 16), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((x + 0.5), (y - 1), (z + 0.5))).findFirst().orElse(null)).getPersistentData().putDouble("y", y);
									((Entity) world.getEntitiesOfClass(EndstoneGolemEntity.class, AABB.ofSize(new Vec3((x + 0.5), (y - 1), (z + 0.5)), 16, 16, 16), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((x + 0.5), (y - 1), (z + 0.5))).findFirst().orElse(null)).getPersistentData().putDouble("z", z);
								}
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"particle minecraft:block unusualend:raw_purpur_block ~ ~ ~ 1 2 1 0.1 100 force");
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"particle minecraft:block end_stone_bricks ~ ~ ~ 1 2 1 0.1 100 force");
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.EXPLOSION, (x + 0.5), (y + 1), (z + 0.5), 10, 0.5, 1, 0.5, 0);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.DRAGON_BREATH, (x + 0.5), y, (z + 0.5), 40, 0.8, 0.8, 0.8, 0.3);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.END_ROD, (x + 0.5), y, (z + 0.5), 40, 0.8, 0.8, 0.8, 0.3);
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"execute as @e[type=!minecraft:player,type=unusualend:endstone_golem] at @s run tp @s ~ ~ ~ facing entity @p[distance=..16]");
							});
						});
					});
				});
			});
		}
	}
}

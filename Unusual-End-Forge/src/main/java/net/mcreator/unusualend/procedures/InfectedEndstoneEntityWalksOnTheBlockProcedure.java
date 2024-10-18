package net.mcreator.unusualend.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.unusualend.init.UnusualendModEntities;
import net.mcreator.unusualend.entity.EnderTrapperEntity;
import net.mcreator.unusualend.UnusualendMod;

import java.util.List;
import java.util.Comparator;

public class InfectedEndstoneEntityWalksOnTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			if (!entity.isShiftKeyDown()) {
				if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.INVISIBILITY))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 4, false, false));
					if (!(world.getDifficulty() == Difficulty.PEACEFUL)) {
						if (!(!world.getEntitiesOfClass(EnderTrapperEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty())) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = UnusualendModEntities.ENDSTONE_TRAPPER.get().spawn(_level, BlockPos.containing(x + 0.5, Math.round(entity.getY() - 1), z + 0.5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof EnderTrapperEntity) {
										{
											Entity _ent = entityiterator;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
														_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
														("tp @s ~ ~ ~ facing entity " + entity));
											}
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.evoker_fangs.attack")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.evoker_fangs.attack")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										{
											Entity _ent = entityiterator;
											_ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 0.25), (entityiterator.getZ()));
											if (_ent instanceof ServerPlayer _serverPlayer)
												_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 0.25), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
										}
										UnusualendMod.queueServerWork(2, () -> {
											{
												Entity _ent = entityiterator;
												_ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 0.25), (entityiterator.getZ()));
												if (_ent instanceof ServerPlayer _serverPlayer)
													_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 0.25), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
											}
											{
												Entity _ent = entityiterator;
												if (!_ent.level().isClientSide() && _ent.getServer() != null) {
													_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
															_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
															("tp @s ~ ~ ~ facing entity " + entity));
												}
											}
											UnusualendMod.queueServerWork(1, () -> {
												{
													Entity _ent = entityiterator;
													_ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 0.25), (entityiterator.getZ()));
													if (_ent instanceof ServerPlayer _serverPlayer)
														_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 0.25), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
																_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																("tp @s ~ ~ ~ facing entity " + entity));
													}
												}
												if (world instanceof ServerLevel _level)
													_level.getServer().getCommands().performPrefixedCommand(
															new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y + 1), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
															"particle dust_color_transition 0.976 1.000 0.620 1.5 0.706 0.451 0.725 ~ ~0.2 ~ 0.3 0.3 0.3 0 20");
												UnusualendMod.queueServerWork(1, () -> {
													{
														Entity _ent = entityiterator;
														if (!_ent.level().isClientSide() && _ent.getServer() != null) {
															_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
																	_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																	("tp @s ~ ~ ~ facing entity " + entity));
														}
													}
													{
														Entity _ent = entityiterator;
														_ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 0.25), (entityiterator.getZ()));
														if (_ent instanceof ServerPlayer _serverPlayer)
															_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 0.25), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
													}
													entity.hurt(new DamageSource(
															world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("unusualend:trapper_damages")))), 2);
													if (entity instanceof ServerPlayer _player) {
														Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("unusualend:its_a_trap"));
														AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
														if (!_ap.isDone()) {
															for (String criteria : _ap.getRemainingCriteria())
																_player.getAdvancements().award(_adv, criteria);
														}
													}
													UnusualendMod.queueServerWork(10, () -> {
														if (!entityiterator.level().isClientSide())
															entityiterator.discard();
													});
												});
											});
										});
									}
								}
							}
						}
					}
				}
			}
		}
	}
}

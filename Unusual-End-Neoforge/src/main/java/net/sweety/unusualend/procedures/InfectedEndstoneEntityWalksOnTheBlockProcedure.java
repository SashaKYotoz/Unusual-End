package net.sweety.unusualend.procedures;

import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.entity.EnderTrapperEntity;
import net.sweety.unusualend.init.UnusualEndEntities;
import net.sweety.unusualend.util.ParticleHelper;
import net.sweety.unusualend.util.ProcedureHelper;

import java.util.Comparator;
import java.util.List;

public class InfectedEndstoneEntityWalksOnTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			if (!entity.isShiftKeyDown()) {
				if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.INVISIBILITY))) {
					ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 4, false, false));
					if (!(world.getDifficulty() == Difficulty.PEACEFUL)) {
						if (world.getEntitiesOfClass(EnderTrapperEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = UnusualEndEntities.ENDSTONE_TRAPPER.get().spawn(_level, BlockPos.containing(x + 0.5, Math.round(entity.getY() - 1), z + 0.5), MobSpawnType.MOB_SUMMONED);
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
												_ent.lookAt(EntityAnchorArgument.Anchor.FEET, entity.position());
											}
										}
										ProcedureHelper.playSound(world, x, y, z, SoundEvents.EVOKER_FANGS_ATTACK, SoundSource.NEUTRAL, 1, 1);
										{
											Entity _ent = entityiterator;
											_ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 0.25), (entityiterator.getZ()));
											if (_ent instanceof ServerPlayer _serverPlayer)
												_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 0.25), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
										}
										UnusualEnd.queueServerWork(2, () -> {
											{
												Entity _ent = entityiterator;
												_ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 0.25), (entityiterator.getZ()));
												if (_ent instanceof ServerPlayer _serverPlayer)
													_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 0.25), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
											}
											{
												Entity _ent = entityiterator;
												if (!_ent.level().isClientSide() && _ent.getServer() != null) {
													_ent.lookAt(EntityAnchorArgument.Anchor.FEET, entity.position());
												}
											}
											UnusualEnd.queueServerWork(1, () -> {
												{
													Entity _ent = entityiterator;
													_ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 0.25), (entityiterator.getZ()));
													if (_ent instanceof ServerPlayer _serverPlayer)
														_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 0.25), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.lookAt(EntityAnchorArgument.Anchor.FEET, entity.position());
													}
												}
												ParticleHelper.spawn(world, ParticleHelper.dustTransition(0.976f, 1.0f, 0.62f, 1.5f, 0.706f, 0.451f, 0.725f), new Vec3((x + 0.5), (y + 1), (z + 0.5)).add(0, 0.2, 0), 20, 0.3, 0.3, 0.3, 0);
												UnusualEnd.queueServerWork(1, () -> {
													{
														Entity _ent = entityiterator;
														if (!_ent.level().isClientSide() && _ent.getServer() != null) {
															_ent.lookAt(EntityAnchorArgument.Anchor.FEET, entity.position());
														}
													}
													{
														Entity _ent = entityiterator;
														_ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 0.25), (entityiterator.getZ()));
														if (_ent instanceof ServerPlayer _serverPlayer)
															_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 0.25), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
													}
													entity.hurt(new DamageSource(
															world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, UnusualEnd.makeUEID("trapper_damages")))), 2);
													ProcedureHelper.awardAdvancement(entity, "its_a_trap");
													UnusualEnd.queueServerWork(10, () -> {
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

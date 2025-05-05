package net.mcreator.unusualend.procedures;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModBlocks;
import net.mcreator.unusualend.entity.EndstoneGolemEntity;

import java.util.List;
import java.util.Comparator;

public class EndstoneGolemOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean is_target_exist = false;
		double distance = 0;
		double X = 0;
		double Y = 0;
		double Z = 0;
		double lcl_nb = 0;
		double xRadius = 0;
		double loop = 0;
		double zRadius = 0;
		double particleAmount = 0;
		if ((entity instanceof EndstoneGolemEntity _datEntI ? _datEntI.getEntityData().get(EndstoneGolemEntity.DATA_push) : 0) >= 1) {
			if (entity instanceof EndstoneGolemEntity _datEntSetI)
				_datEntSetI.getEntityData().set(EndstoneGolemEntity.DATA_push, (int) ((entity instanceof EndstoneGolemEntity _datEntI ? _datEntI.getEntityData().get(EndstoneGolemEntity.DATA_push) : 0) + 1));
		}
		if ((entity instanceof EndstoneGolemEntity _datEntI ? _datEntI.getEntityData().get(EndstoneGolemEntity.DATA_push) : 0) >= 9) {
			if (entity instanceof EndstoneGolemEntity _datEntSetI)
				_datEntSetI.getEntityData().set(EndstoneGolemEntity.DATA_push, 0);
		}
		if ((entity instanceof EndstoneGolemEntity _datEntI ? _datEntI.getEntityData().get(EndstoneGolemEntity.DATA_aoe_animtime) : 0) > 0) {
			if (entity instanceof EndstoneGolemEntity _datEntSetI)
				_datEntSetI.getEntityData().set(EndstoneGolemEntity.DATA_aoe_animtime, (int) ((entity instanceof EndstoneGolemEntity _datEntI ? _datEntI.getEntityData().get(EndstoneGolemEntity.DATA_aoe_animtime) : 0) - 1));
			if ((entity instanceof EndstoneGolemEntity _datEntI ? _datEntI.getEntityData().get(EndstoneGolemEntity.DATA_aoe_animtime) : 0) <= 18) {
				if ((entity instanceof EndstoneGolemEntity _datEntI ? _datEntI.getEntityData().get(EndstoneGolemEntity.DATA_aoe_animtime) : 0) == 18) {
					loop = 0;
					particleAmount = 20;
					xRadius = 3;
					zRadius = 3;
					while (loop < particleAmount) {
						world.levelEvent(2001, BlockPos.containing(x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius, y, z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius),
								Block.getId((world.getBlockState(BlockPos.containing(x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius, y - 1, z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius)))));
						loop = loop + 1;
					}
					lcl_nb = 0;
					{
						final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity) && entityiterator.onGround()
									&& !((entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && (entityiterator instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == entity)) {
								distance = Math.sqrt(Math.pow(entity.getX() - entityiterator.getX(), 2) + Math.pow(entity.getY() - entityiterator.getY(), 2) + Math.pow(entity.getZ() - entityiterator.getZ(), 2));
								entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x() + (distance == 0 ? 0 : ((entityiterator.getX() - entity.getX()) / distance) * 2.5)), (entityiterator.getDeltaMovement().y()),
										(entityiterator.getDeltaMovement().z() + (distance == 0 ? 0 : ((entityiterator.getZ() - entity.getZ()) / distance) * 2.5))));
								entityiterator.invulnerableTime = 0;
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.CRAMMING), entity),
										(float) (20 - (entityiterator != null ? entity.distanceTo(entityiterator) : -1)));
							}
						}
					}
					if (world.isClientSide()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.ZOMBIE_BREAK_WOODEN_DOOR, SoundSource.HOSTILE, 3, 1);
							} else {
								_level.playLocalSound(x, y, z, SoundEvents.ZOMBIE_BREAK_WOODEN_DOOR, SoundSource.HOSTILE, 3, 1, false);
							}
						}
					}
					EndstoneGolemBreakSurroundingsProcedure.execute(world, x, y, z);
				}
			} else {
				{
					final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator == entity)) {
							distance = Math.sqrt(Math.pow(entity.getX() - entityiterator.getX(), 2) + Math.pow(entity.getY() - entityiterator.getY(), 2) + Math.pow(entity.getZ() - entityiterator.getZ(), 2));
							entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x() + (distance == 0 ? 0 : ((entityiterator.getX() - entity.getX()) / distance) * (-0.02))), (entityiterator.getDeltaMovement().y()),
									(entityiterator.getDeltaMovement().z() + (distance == 0 ? 0 : ((entityiterator.getZ() - entity.getZ()) / distance) * (-0.02)))));
						}
					}
				}
			}
		}
		if ((entity instanceof EndstoneGolemEntity _datEntI ? _datEntI.getEntityData().get(EndstoneGolemEntity.DATA_aoe_cooldown) : 0) >= 120) {
			if ((entity instanceof EndstoneGolemEntity _datEntI ? _datEntI.getEntityData().get(EndstoneGolemEntity.DATA_push) : 0) == 0) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 2, false, false));
				if (entity instanceof EndstoneGolemEntity _datEntSetI)
					_datEntSetI.getEntityData().set(EndstoneGolemEntity.DATA_aoe_cooldown, 0);
				if ((entity instanceof EndstoneGolemEntity _datEntI ? _datEntI.getEntityData().get(EndstoneGolemEntity.DATA_aoe_animtime) : 0) == 0) {
					if (entity instanceof EndstoneGolemEntity _datEntSetI)
						_datEntSetI.getEntityData().set(EndstoneGolemEntity.DATA_aoe_animtime, 35);
					if (world.isClientSide()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), SoundEvents.ELDER_GUARDIAN_AMBIENT, SoundSource.HOSTILE, 3, 1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), SoundEvents.ELDER_GUARDIAN_AMBIENT, SoundSource.HOSTILE, 3, 1, false);
							}
						}
					}
				}
			}
		} else {
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
						if (entity instanceof EndstoneGolemEntity _datEntSetI)
							_datEntSetI.getEntityData().set(EndstoneGolemEntity.DATA_aoe_cooldown, (int) ((entity instanceof EndstoneGolemEntity _datEntI ? _datEntI.getEntityData().get(EndstoneGolemEntity.DATA_aoe_cooldown) : 0) + 1));
						if ((entity instanceof EndstoneGolemEntity _datEntI ? _datEntI.getEntityData().get(EndstoneGolemEntity.DATA_aoe_cooldown) : 0) == 110) {
							if (world.isClientSide()) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), SoundEvents.EVOKER_PREPARE_ATTACK, SoundSource.HOSTILE, 3,
												(float) 0.6);
									} else {
										_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), SoundEvents.EVOKER_PREPARE_ATTACK, SoundSource.HOSTILE, 3, (float) 0.6, false);
									}
								}
							}
						}
						if ((entity instanceof EndstoneGolemEntity _datEntI ? _datEntI.getEntityData().get(EndstoneGolemEntity.DATA_aoe_cooldown) : 0) >= 115) {
							lcl_nb = 0;
							for (int index1 = 0; index1 < 15; index1++) {
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.REVERSE_PORTAL, (entity.getX() + Math.sin(lcl_nb) * 1.5), (entity.getY() + 0.1), (entity.getZ() + Math.cos(lcl_nb) * 1.5), 1, 0.1, 0, 0.1, 0.1);
								lcl_nb = lcl_nb + 0.4;
							}
						}
						break;
					}
				}
			}
		}
		if (y <= -10) {
			if ((entity.level().dimension()) == Level.END) {
				if (world.isEmptyBlock(BlockPos.containing(entity.getPersistentData().getDouble("x"), entity.getPersistentData().getDouble("y"), entity.getPersistentData().getDouble("z")))) {
					world.setBlock(BlockPos.containing(entity.getPersistentData().getDouble("x"), entity.getPersistentData().getDouble("y"), entity.getPersistentData().getDouble("z")), UnusualendModBlocks.GOLEM_ALTAR.get().defaultBlockState(), 3);
					world.levelEvent(2001, BlockPos.containing(entity.getPersistentData().getDouble("x"), entity.getPersistentData().getDouble("y"), entity.getPersistentData().getDouble("z")),
							Block.getId(UnusualendModBlocks.ANCIENT_ENCASED_END_STONE.get().defaultBlockState()));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.REVERSE_PORTAL, x, y, z, 20, 2, 2, 2, 0.1);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.ENCHANT, x, y, z, 20, 1, 1, 1, 0);
					if (!world.isClientSide()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.ELDER_GUARDIAN_CURSE, SoundSource.HOSTILE, 2, (float) 0.5);
							} else {
								_level.playLocalSound(x, y, z, SoundEvents.ELDER_GUARDIAN_CURSE, SoundSource.HOSTILE, 2, (float) 0.5, false);
							}
						}
					}
					if (!entity.level().isClientSide())
						entity.discard();
				}
			}
		}
	}
}

package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import net.sweety.unusualend.entity.EnderblobEntity;
import net.sweety.unusualend.entity.EnderblobQueenEntity;
import net.sweety.unusualend.init.UnusualendModEntities;
import net.sweety.unusualend.init.UnusualendModMobEffects;
import net.sweety.unusualend.init.UnusualendModParticleTypes;
import net.sweety.unusualend.util.ParticleHelper;
import net.sweety.unusualend.util.ProcedureHelper;

import java.util.Comparator;
import java.util.List;

public class EnderblobQueenOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xRadius = 0;
		double loop = 0;
		double zRadius = 0;
		double particleAmount = 0;
		double dis = 0;
		if (entity instanceof EnderblobQueenEntity) {
			if (entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MobEffects.LEVITATION)) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.LEVITATION);
			}
			if (entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(UnusualendModMobEffects.ENDER_INFECTION.get())) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(UnusualendModMobEffects.ENDER_INFECTION.get());
			}
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			entity.getPersistentData().putDouble("IA", (entity.getPersistentData().getDouble("IA") + 1));
			if (entity.getPersistentData().getDouble("IA") == 100) {
				ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.endermite.death")), SoundSource.HOSTILE, 2, (float) 0.5);
				dis = Math.sqrt(Math.pow((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX(), 2) + Math.pow((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - entity.getY(), 2)
						+ Math.pow((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ(), 2));
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(UnusualendModMobEffects.CRYSTALLIZATION.get(), 100, 0, false, false));
					for (int index0 = 0; index0 < Mth.nextInt(world.getRandom(), 2, 3); index0++) {
						ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.endermite.step")), SoundSource.NEUTRAL, 1, (float) 0.75);
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = UnusualendModEntities.ENDER_BLOB.get().spawn(_level, BlockPos.containing((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX(),
								(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.ENDERMITE.spawn(_level, BlockPos.containing((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX(),
								(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
					if (dis >= 7) {
						{
							Entity _ent = (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null);
							_ent.teleportTo(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getX()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getY()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getZ()),
										_ent.getYRot(), _ent.getXRot());
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(UnusualendModParticleTypes.PINK_FLAME.get(), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()),
									((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()), 20, 1, 1, 1, 0.1);
						ParticleHelper.spawn(world, ParticleHelper.voidParticles(), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + 0.5), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + 0.5), 5, 0.5, 0.5, 0.5, 0);
						if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 9, false, false));
						if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 9, false, false));
					}
				}
			}
			if (entity.getPersistentData().getDouble("IA") == 300) {
				ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.endermite.hurt")), SoundSource.HOSTILE, 2, (float) 0.5);
				QueenBreakSurroundingsProcedure.execute(world, x, y, z);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(UnusualendModParticleTypes.PINK_FLAME.get(), x, y, z, 30, 2, 2, 2, 0.1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.PORTAL, x, y, z, 20, 1, 1, 1, 0.1);
			}
			if (entity.getPersistentData().getDouble("IA") == 340) {
				particleAmount = 60;
				xRadius = 8;
				zRadius = 8;
				loop = 0;
				ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.respawn_anchor.set_spawn")), SoundSource.NEUTRAL, 3, 2);
				while (loop < particleAmount) {
					ParticleHelper.spawn(world, ParticleHelper.voidParticles(), (x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), (y + 0.5), (z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 5, 0, 0.05, 0, 0);
					ParticleHelper.spawn(world, ParticleTypes.SQUID_INK, (x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), (y + 0.5), (z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 1, 0, 0.05, 0, 0);
					ParticleHelper.spawn(world, ParticleTypes.END_ROD, (x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), (y + 0.5), (z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 1, 0, 0.05, 0, 0);
					loop = loop + 1;
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(14 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:blobqueen_immune")))) {
							entityiterator.invulnerableTime = 0;
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FELL_OUT_OF_WORLD)), 8);
							if (!world.isClientSide()) {
								ProcedureHelper.addEffect(entityiterator, new MobEffectInstance(UnusualendModMobEffects.ENDER_INFECTION.get(), 400, 0, false, false));
								ProcedureHelper.addEffect(entityiterator, new MobEffectInstance(UnusualendModMobEffects.CRYSTALLIZATION.get(), 100, 0, false, false));
							}
							entityiterator.invulnerableTime = 0;
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FELL_OUT_OF_WORLD)), 6);
						}
					}
				}
			}
			if (entity.getPersistentData().getDouble("IA") == 400) {
				ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.endermite.ambient")), SoundSource.HOSTILE, 2, (float) 0.7);
				loop = 1;
				particleAmount = 3;
				xRadius = 3;
				zRadius = 3;
				while (loop < particleAmount) {
					ParticleHelper.spawn(world, ParticleHelper.voidParticles(), (x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), (y + 0.5), (z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 5, 0, 0.05, 0, 0);
					if (Math.random() < 0.5) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.ENDERMITE.spawn(_level,
									BlockPos.containing(x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius, y + 0.5, z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
							}
						}
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = UnusualendModEntities.ENDER_BLOB.get().spawn(_level,
									BlockPos.containing(x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius, y + 0.5, z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
							}
						}
					}
					loop = loop + 1;
				}
			}
			if (entity.getPersistentData().getDouble("IA") % 150 == 0) {
				if (!world.getEntitiesOfClass(EnderblobEntity.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SOUL, (world.getEntitiesOfClass(EnderblobEntity.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(ProcedureHelper.byDistanceTo(x, y, z)).findFirst().orElse(null).getX()), (world.getEntitiesOfClass(EnderblobEntity.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(ProcedureHelper.byDistanceTo(x, y, z)).findFirst().orElse(null).getY()), (world.getEntitiesOfClass(EnderblobEntity.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(ProcedureHelper.byDistanceTo(x, y, z)).findFirst().orElse(null).getZ()), 5, 0.5, 0.5, 0.5, 0);
					ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.REGENERATION, 100, 1));
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 100 && !(entity.getPersistentData().getBoolean("SecondPhase"))) {
				QueenBreakSurroundingsProcedure.execute(world, x, y, z);
				entity.getPersistentData().putBoolean("SecondPhase", true);
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x, y, z, 20, 3, 3, 3, 0);
				for (int index3 = 0; index3 < Mth.nextInt(world.getRandom(), 5, 10); index3++) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = UnusualendModEntities.ENDER_BLOB.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
				}
				for (int index4 = 0; index4 < Mth.nextInt(world.getRandom(), 5, 10); index4++) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.ENDERMITE.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
				}
			}
			if (entity.getPersistentData().getBoolean("SecondPhase")) {
				ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 2));
			}
			if (entity.getPersistentData().getDouble("IA") > 500) {
				entity.getPersistentData().putDouble("IA", 0);
			}
		}
	}
}

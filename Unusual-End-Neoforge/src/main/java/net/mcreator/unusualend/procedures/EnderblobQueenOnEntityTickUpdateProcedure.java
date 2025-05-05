package net.mcreator.unusualend.procedures;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.unusualend.init.UnusualendModParticleTypes;
import net.mcreator.unusualend.init.UnusualendModMobEffects;
import net.mcreator.unusualend.init.UnusualendModEntities;
import net.mcreator.unusualend.entity.EnderblobQueenEntity;
import net.mcreator.unusualend.entity.EnderblobEntity;

import java.util.List;
import java.util.Comparator;

public class EnderblobQueenOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        double Chain = 0;
        double ChainWait = 0;
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
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.ENDERMITE_DEATH, SoundSource.HOSTILE, 2, (float) 0.5);
                    } else {
                        _level.playLocalSound(x, y, z, SoundEvents.ENDERMITE_DEATH, SoundSource.HOSTILE, 2, (float) 0.5, false);
                    }
                }
                dis = Math.sqrt(Math.pow((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX(), 2) + Math.pow((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - entity.getY(), 2)
                        + Math.pow((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ(), 2));
                if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
                    if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(UnusualendModMobEffects.CRYSTALLIZATION.get(), 100, 0, false, false));
                    for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 2, 3); index0++) {
                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.ENDERMITE_STEP, SoundSource.NEUTRAL, 1, (float) 0.75);
                            } else {
                                _level.playLocalSound(x, y, z, SoundEvents.ENDERMITE_STEP, SoundSource.NEUTRAL, 1, (float) 0.75, false);
                            }
                        }
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
                            Entity _ent = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null);
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
                            _level.sendParticles((SimpleParticleType) (UnusualendModParticleTypes.PINK_FLAME.get()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()),
                                    ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()), 20, 1, 1, 1, 0.1);
                        if (world instanceof ServerLevel _level)
                            _level.getServer().getCommands().performPrefixedCommand(
                                    new CommandSourceStack(CommandSource.NULL,
                                            new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + 0.5), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1),
                                                    ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + 0.5)),
                                            Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                                    "particle minecraft:block unusualend:void_particles_block ~ ~ ~ 0.5 0.5 0.5 0 5");
                        if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 9, false, false));
                        if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 9, false, false));
                    }
                }
            }
            if (entity.getPersistentData().getDouble("IA") == 300) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.ENDERMITE_HURT, SoundSource.HOSTILE, 2, (float) 0.5);
                    } else {
                        _level.playLocalSound(x, y, z, SoundEvents.ENDERMITE_HURT, SoundSource.HOSTILE, 2, (float) 0.5, false);
                    }
                }
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
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.RESPAWN_ANCHOR_SET_SPAWN, SoundSource.NEUTRAL, 3, 2);
                    } else {
                        _level.playLocalSound(x, y, z, SoundEvents.RESPAWN_ANCHOR_SET_SPAWN, SoundSource.NEUTRAL, 3, 2, false);
                    }
                }
                while (loop < particleAmount) {
                    if (world instanceof ServerLevel _level)
                        _level.getServer().getCommands().performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), (y + 0.5), (z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius)),
                                        Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                                "particle minecraft:block unusualend:void_particles_block ~ ~ ~ 0 0.05 0 0 5");
                    if (world instanceof ServerLevel _level)
                        _level.getServer().getCommands().performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), (y + 0.5), (z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius)),
                                        Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                                "particle minecraft:squid_ink ~ ~ ~ 0 0.05 0 0 1");
                    if (world instanceof ServerLevel _level)
                        _level.getServer().getCommands().performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), (y + 0.5), (z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius)),
                                        Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                                "particle minecraft:end_rod ~ ~ ~ 0 0.05 0 0 1");
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
                                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(UnusualendModMobEffects.ENDER_INFECTION.get(), 400, 0, false, false));
                                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(UnusualendModMobEffects.CRYSTALLIZATION.get(), 100, 0, false, false));
                            }
                            entityiterator.invulnerableTime = 0;
                            entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FELL_OUT_OF_WORLD)), 6);
                        }
                    }
                }
            }
            if (entity.getPersistentData().getDouble("IA") == 400) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.ENDERMITE_AMBIENT, SoundSource.HOSTILE, 2, (float) 0.7);
                    } else {
                        _level.playLocalSound(x, y, z, SoundEvents.ENDERMITE_AMBIENT, SoundSource.HOSTILE, 2, (float) 0.7, false);
                    }
                }
                loop = 1;
                particleAmount = 3;
                xRadius = 3;
                zRadius = 3;
                while (loop < particleAmount) {
                    if (world instanceof ServerLevel _level)
                        _level.getServer().getCommands().performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), (y + 0.5), (z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius)),
                                        Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                                "particle minecraft:block unusualend:void_particles_block ~ ~ ~ 0 0.05 0 0 5");
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
                        _level.sendParticles(ParticleTypes.SOUL, (((Entity) world.getEntitiesOfClass(EnderblobEntity.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(EnderblobEntity.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(EnderblobEntity.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), 5, 0.5, 0.5, 0.5, 0);
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1));
                }
            }
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 100 && !(entity.getPersistentData().getBoolean("SecondPhase") == true)) {
                QueenBreakSurroundingsProcedure.execute(world, x, y, z);
                entity.getPersistentData().putBoolean("SecondPhase", true);
                if (entity instanceof LivingEntity _entity)
                    _entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                if (world instanceof ServerLevel _level)
                    _level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x, y, z, 20, 3, 3, 3, 0);
                for (int index3 = 0; index3 < Mth.nextInt(RandomSource.create(), 5, 10); index3++) {
                    if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = UnusualendModEntities.ENDER_BLOB.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                        }
                    }
                }
                for (int index4 = 0; index4 < Mth.nextInt(RandomSource.create(), 5, 10); index4++) {
                    if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = EntityType.ENDERMITE.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                        }
                    }
                }
            }
            if (entity.getPersistentData().getBoolean("SecondPhase") == true) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 2));
            }
            if (entity.getPersistentData().getDouble("IA") > 500) {
                entity.getPersistentData().putDouble("IA", 0);
            }
        }
    }
}

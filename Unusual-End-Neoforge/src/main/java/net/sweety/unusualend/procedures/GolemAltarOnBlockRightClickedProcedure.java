package net.sweety.unusualend.procedures;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.entity.EndstoneGolemEntity;
import net.sweety.unusualend.init.UnusualEndEntities;

import java.util.Comparator;
import java.util.List;

public class GolemAltarOnBlockRightClickedProcedure {
    public static void execute(Level level, double x, double y, double z, Player player) {
        if (level.isClientSide()) return;
        if (player.getMainHandItem().is(Items.DRAGON_BREATH)) {
            if (!player.isCreative()) {
                player.getMainHandItem().shrink(1);
                ItemStack stack = new ItemStack(Items.GLASS_BOTTLE).copy();
                stack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, stack);
            }

            level.destroyBlock(BlockPos.containing(x, y, z), false);

            if (level instanceof ServerLevel serverLevel) {
                LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(serverLevel);
                if (entityToSpawn != null) {
                    entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 0.5, y, z + 0.5)));
                    entityToSpawn.setVisualOnly(true);
                    serverLevel.addFreshEntity(entityToSpawn);
                }
            }
            if (level instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.FIREWORK, (x + 0.5), (y + 1), (z + 0.5), 10, 0, 0, 0, 0.1);

            UnusualEnd.queueServerWork(10, () -> {
                if (level instanceof ServerLevel _level) {
                    LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
                    if (entityToSpawn != null) {
                        entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 0.5, y, z + 0.5)));
                        entityToSpawn.setVisualOnly(true);
                        _level.addFreshEntity(entityToSpawn);
                    }
                }
                UnusualEnd.queueServerWork(20, () -> {
                    if (level instanceof ServerLevel _level) {
                        LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
                        if (entityToSpawn != null) {
                            entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 0.5, y, z + 0.5)));
                            entityToSpawn.setVisualOnly(true);
                            _level.addFreshEntity(entityToSpawn);
                        }
                    }
                    if (level instanceof ServerLevel _level)
                        _level.sendParticles(ParticleTypes.FIREWORK, (x + 0.5), (y + 1), (z + 0.5), 5, 0, 0, 0, 0.1);

                    UnusualEnd.queueServerWork(5, () -> {
                        if (level instanceof ServerLevel _level) {
                            LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
                            if (entityToSpawn != null) {
                                entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 0.5, y, z + 0.5)));
                                entityToSpawn.setVisualOnly(true);
                                _level.addFreshEntity(entityToSpawn);
                            }
                        }

                        EndstoneGolemBreakSurroundingsProcedure.execute(level, x, (y - 1), z);

                        UnusualEnd.queueServerWork(10, () -> {
                            if (level instanceof ServerLevel _level) {
                                LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
                                if (entityToSpawn != null) {
                                    entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 0.5, y, z + 0.5)));
                                    entityToSpawn.setVisualOnly(true);
                                    _level.addFreshEntity(entityToSpawn);
                                }
                            }
                            if (level instanceof ServerLevel _level)
                                _level.sendParticles(ParticleTypes.EXPLOSION, (x + 0.5), y, (z + 0.5), 10, 0.5, 0.5, 0.5, 0);

                            UnusualEnd.queueServerWork(10, () -> {
                                if (level instanceof ServerLevel _level) {
                                    LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
                                    if (entityToSpawn != null) {
                                        entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 0.5, y, z + 0.5)));
                                        entityToSpawn.setVisualOnly(true);
                                        _level.addFreshEntity(entityToSpawn);
                                    }
                                }
                                final Vec3 _center = new Vec3(x, y, z);
                                List<Entity> list = level.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                        .toList();
                                for (Entity entityiterator : list) {
                                    if (entityiterator instanceof Player) {
                                        if (entityiterator instanceof ServerPlayer _player) {
                                            AdvancementHolder _adv = _player.server.getAdvancements().get(UnusualEnd.makeUEID("use_golem_altar"));
                                            if (_adv != null) {
                                                AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                                if (!_ap.isDone()) {
                                                    for (String criteria : _ap.getRemainingCriteria())
                                                        _player.getAdvancements().award(_adv, criteria);
                                                }
                                            }
                                        }
                                        if (entityiterator instanceof Player _player && !_player.level().isClientSide())
                                            _player.displayClientMessage(Component.literal((Component.translatable("text.unusualend.golem_theme").getString())), true);
                                    }
                                }
                                level.playSound(null, BlockPos.containing(x + 0.5, y, z + 0.5), SoundEvents.STONE_PLACE, SoundSource.NEUTRAL, 1, 1);

                                if (level instanceof ServerLevel serverLevel) {
                                    EndstoneGolemEntity golem = UnusualEndEntities.ENDSTONE_GOLEM.get().create(serverLevel);
                                    if (golem != null) {
                                        golem.setYRot(level.getRandom().nextFloat() * 360F);
                                        golem.moveTo(x, y + 1, z);
                                        golem.getPersistentData().putDouble("x", x);
                                        golem.getPersistentData().putDouble("y", y);
                                        golem.getPersistentData().putDouble("z", z);
                                        golem.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(golem.blockPosition()), MobSpawnType.MOB_SUMMONED, null);
                                        serverLevel.addFreshEntity(golem);
                                        Player closestPlayer = level.getNearestPlayer(golem, 16.0);
                                        if (closestPlayer != null) golem.lookAt(closestPlayer, 30.0F, 30.0F);
                                    }
                                }
                                if (level instanceof ServerLevel _level)
                                    _level.getServer().getCommands().performPrefixedCommand(
                                            new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                                            "particle minecraft:block unusualend:raw_purpur_block ~ ~ ~ 1 2 1 0.1 100 force");
                                if (level instanceof ServerLevel _level)
                                    _level.getServer().getCommands().performPrefixedCommand(
                                            new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                                            "particle minecraft:block end_stone_bricks ~ ~ ~ 1 2 1 0.1 100 force");
                                if (level instanceof ServerLevel _level)
                                    _level.sendParticles(ParticleTypes.EXPLOSION, (x + 0.5), (y + 1), (z + 0.5), 10, 0.5, 1, 0.5, 0);
                                if (level instanceof ServerLevel _level)
                                    _level.sendParticles(ParticleTypes.DRAGON_BREATH, (x + 0.5), y, (z + 0.5), 40, 0.8, 0.8, 0.8, 0.3);
                                if (level instanceof ServerLevel _level)
                                    _level.sendParticles(ParticleTypes.END_ROD, (x + 0.5), y, (z + 0.5), 40, 0.8, 0.8, 0.8, 0.3);
                            });
                        });
                    });
                });
            });
        }
    }
}
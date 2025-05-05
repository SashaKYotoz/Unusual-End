package net.mcreator.unusualend.procedures;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.unusualend.init.UnusualendModMobEffects;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.wrapper.InvWrapper;

import java.util.concurrent.atomic.AtomicReference;
import java.util.List;
import java.util.Comparator;

public class BuildingInhibitorOnTickUpdateProcedure {
    public static void execute(Level level, BlockPos pos) {
        boolean nearby;
        if ((new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent instanceof BaseContainerBlockEntity entity) {
                    IItemHandler handler = new InvWrapper(entity);
                    return handler.getStackInSlot(slotid).copy();
                }
                return _retval.get();
            }
        }.getItemStack(level, pos, 0)).is(Items.DRAGON_BREATH)) {
            if (new Object() {
                public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                    BlockEntity blockEntity = world.getBlockEntity(pos);
                    if (blockEntity != null)
                        return blockEntity.getPersistentData().getDouble(tag);
                    return 0;
                }
            }.getValue(level, pos, "Fuel") <= 16) {
                if (!level.isClientSide()) {
                    BlockEntity _blockEntity = level.getBlockEntity(pos);
                    BlockState state = level.getBlockState(pos);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putDouble("Fuel", (new Object() {
                            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                BlockEntity blockEntity = world.getBlockEntity(pos);
                                if (blockEntity != null)
                                    return blockEntity.getPersistentData().getDouble(tag);
                                return 0;
                            }
                        }.getValue(level, pos, "Fuel") + 16));
                    level.sendBlockUpdated(pos, state, state, 3);
                }
                BlockEntity _ent = level.getBlockEntity(pos);
                if (_ent instanceof BaseContainerBlockEntity entity) {
                    InvWrapper wrapper = new InvWrapper(entity);
                    wrapper.getStackInSlot(0).shrink(1);
                }
                if (level instanceof ServerLevel _level)
                    _level.sendParticles(ParticleTypes.DRAGON_BREATH, (pos.getX() + 0.5), (pos.getY() + 1), (pos.getZ() + 0.5), 10, 0.3, 0.3, 0.3, 0);
                if (!level.isClientSide()) {
                    level.playSound(null, pos, SoundEvents.BREWING_STAND_BREW, SoundSource.BLOCKS, 1, (float) 1.5);
                } else {
                    level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BREWING_STAND_BREW, SoundSource.BLOCKS, 1, (float) 1.5, false);
                }
            }
        }
        if (new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getDouble(tag);
                return 0;
            }
        }.getValue(level, pos, "isActive") >= 1) {
            if (!level.isClientSide()) {
                BlockEntity _blockEntity = level.getBlockEntity(pos);
                BlockState _bs = level.getBlockState(pos);
                if (_blockEntity != null)
                    _blockEntity.getPersistentData().putDouble("isActive", ((new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                            BlockEntity blockEntity = world.getBlockEntity(pos);
                            if (blockEntity != null)
                                return blockEntity.getPersistentData().getDouble(tag);
                            return 0;
                        }
                    }.getValue(level, pos, "isActive")) - 1));
                level.sendBlockUpdated(pos, _bs, _bs, 3);
            }
        }
        if (new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getDouble(tag);
                return 0;
            }
        }.getValue(level, pos, "isActive") >= 1 || new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getDouble(tag);
                return 0;
            }
        }.getValue(level, pos, "Fuel") >= 1) {
            nearby = false;
            if (!level.getEntitiesOfClass(Player.class, AABB.ofSize(pos.getCenter(), 64, 64, 64), e -> true).isEmpty()) {

                final Vec3 _center = pos.getCenter();
                List<Entity> _entfound = level.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                for (Entity entityiterator : _entfound) {
                    if (entityiterator instanceof Player player) {
                        if (!(player.isSpectator() || player.isCreative())) {
                            if (!(new Object() {
                                public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                    BlockEntity blockEntity = world.getBlockEntity(pos);
                                    if (blockEntity != null)
                                        return blockEntity.getPersistentData().getString(tag);
                                    return "";
                                }
                            }.getValue(level, pos, "Owner")).equals(entityiterator.getStringUUID())) {
                                nearby = true;
                                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(UnusualendModMobEffects.DISRUPTION.get(), 140, 0, true, true));
                            }
                        }
                    }
                }
                if (nearby) {
                    if (!(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                            BlockEntity blockEntity = world.getBlockEntity(pos);
                            if (blockEntity != null)
                                return blockEntity.getPersistentData().getDouble(tag);
                            return -1;
                        }
                    }.getValue(level, pos, "isActive") >= 1)) {
                        if (!level.isClientSide()) {
                            BlockEntity _blockEntity = level.getBlockEntity(pos);
                            BlockState _bs = level.getBlockState(pos);
                            if (_blockEntity != null)
                                _blockEntity.getPersistentData().putDouble("Fuel", ((new Object() {
                                    public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getDouble(tag);
                                        return 0;
                                    }
                                }.getValue(level, pos, "Fuel")) - 1));
                            level.sendBlockUpdated(pos, _bs, _bs, 3);
                        }
                        if (!level.isClientSide()) {
                            BlockEntity _blockEntity = level.getBlockEntity(pos);
                            BlockState _bs = level.getBlockState(pos);
                            if (_blockEntity != null)
                                _blockEntity.getPersistentData().putDouble("isActive", 6000);
                            level.sendBlockUpdated(pos, _bs, _bs, 3);
                        }
                        if (level instanceof ServerLevel _level)
                            _level.sendParticles(ParticleTypes.DRAGON_BREATH, (pos.getX() + 0.5), (pos.getY() + 1), (pos.getZ() + 0.5), 10, 0.3, 0.3, 0.3, 0);
                        if (!level.isClientSide()) {
                            level.playSound(null, pos, SoundEvents.BREWING_STAND_BREW, SoundSource.BLOCKS, 1, (float) 1.5);
                        } else {
                            level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BREWING_STAND_BREW, SoundSource.BLOCKS, 1, (float) 1.5, false);
                        }
                    }
                }
            }
        }
    }
}
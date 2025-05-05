package net.mcreator.unusualend.procedures;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModParticleTypes;
import net.mcreator.unusualend.init.UnusualendModItems;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.wrapper.InvWrapper;

import java.util.concurrent.atomic.AtomicReference;

public class PearlescentInfuserUpdateTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if ((new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent instanceof BaseContainerBlockEntity entity) {
                    InvWrapper wrapper = new InvWrapper(entity);
                    return wrapper.getStackInSlot(slotid);
                }
                return _retval.get();
            }
        }.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == UnusualendModItems.CITRINE_CHUNK.get()) {
            if (new Object() {
                public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                    BlockEntity blockEntity = world.getBlockEntity(pos);
                    if (blockEntity != null)
                        return blockEntity.getPersistentData().getDouble(tag);
                    return -1;
                }
            }.getValue(world, BlockPos.containing(x, y, z), "Citrine") <= 7) {
                {
                    BlockEntity entity = world.getBlockEntity(BlockPos.containing(x, y, z));
                    if (entity instanceof BaseContainerBlockEntity entity1) {
                        final int _slotid = 0;
                        InvWrapper wrapper = new InvWrapper(entity1);
                        wrapper.getStackInSlot(_slotid).shrink(1);
                    }
                }
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putDouble("Citrine", (new Object() {
                            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                BlockEntity blockEntity = world.getBlockEntity(pos);
                                if (blockEntity != null)
                                    return blockEntity.getPersistentData().getDouble(tag);
                                return -1;
                            }
                        }.getValue(world, BlockPos.containing(x, y, z), "Citrine") + 1));
                    if (world instanceof Level _level)
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
                if (world instanceof ServerLevel _level)
                    _level.sendParticles(ParticleTypes.FLAME, (x + 0.5), (y + 1.2), (z + 0.5), 6, 0.1, 0.1, 0.1, 0);
                if (world instanceof ServerLevel _level)
                    _level.sendParticles(ParticleTypes.SMOKE, (x + 0.5), (y + 1.2), (z + 0.5), 8, 0.1, 0.1, 0.1, 0);
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.CONDUIT_AMBIENT_SHORT, SoundSource.NEUTRAL, 2, (float) 1.8);
                    } else {
                        _level.playLocalSound(x, y, z, SoundEvents.CONDUIT_AMBIENT, SoundSource.NEUTRAL, 2, (float) 1.8, false);
                    }
                }
            }
        }
        if ((new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicReference<ItemStack> stack = new AtomicReference<>(ItemStack.EMPTY);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent instanceof BaseContainerBlockEntity entity) {
                    InvWrapper wrapper = new InvWrapper(entity);
                    return wrapper.getStackInSlot(slotid);
                }
                return stack.get();
            }
        }.getItemStack(world, BlockPos.containing(x, y, z), 1)).getItem() == UnusualendModItems.SHINY_CRYSTAL.get()) {
            if (new Object() {
                public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                    BlockEntity blockEntity = world.getBlockEntity(pos);
                    if (blockEntity != null)
                        return blockEntity.getPersistentData().getDouble(tag);
                    return -1;
                }
            }.getValue(world, BlockPos.containing(x, y, z), "Shiny") <= 7) {
                {
                    BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                    if (_ent instanceof BaseContainerBlockEntity entity) {
                        final int _slotid = 1;
                        InvWrapper wrapper = new InvWrapper(entity);
                        wrapper.getStackInSlot(_slotid).shrink(1);
                    }
                }
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putDouble("Shiny", (new Object() {
                            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                BlockEntity blockEntity = world.getBlockEntity(pos);
                                if (blockEntity != null)
                                    return blockEntity.getPersistentData().getDouble(tag);
                                return -1;
                            }
                        }.getValue(world, BlockPos.containing(x, y, z), "Shiny") + 1));
                    if (world instanceof Level _level)
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
                if (world instanceof ServerLevel _level)
                    _level.sendParticles(UnusualendModParticleTypes.PINK_FLAME.get(), (x + 0.5), (y + 1.2), (z + 0.5), 6, 0.1, 0.1, 0.1, 0);
                if (world instanceof ServerLevel _level)
                    _level.sendParticles(ParticleTypes.SMOKE, (x + 0.5), (y + 1.2), (z + 0.5), 8, 0.1, 0.1, 0.1, 0);
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.CONDUIT_AMBIENT_SHORT, SoundSource.NEUTRAL, 2, (float) 1.8);
                    } else {
                        _level.playLocalSound(x, y, z, SoundEvents.CONDUIT_AMBIENT_SHORT, SoundSource.NEUTRAL, 2, (float) 1.8, false);
                    }
                }
            }
        }
        if ((new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent instanceof BaseContainerBlockEntity entity) {
                    InvWrapper wrapper = new InvWrapper(entity);
                    return wrapper.getStackInSlot(slotid);
                }
                return _retval.get();
            }
        }.getItemStack(world, BlockPos.containing(x, y, z), 2)).getItem() == UnusualendModItems.PRISMALITE_GEM.get()) {
            if (new Object() {
                public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                    BlockEntity blockEntity = world.getBlockEntity(pos);
                    if (blockEntity != null)
                        return blockEntity.getPersistentData().getDouble(tag);
                    return -1;
                }
            }.getValue(world, BlockPos.containing(x, y, z), "Prismatic") <= 7) {
                {
                    BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                    if (_ent instanceof BaseContainerBlockEntity entity) {
                        InvWrapper wrapper = new InvWrapper(entity);
                        final int _slotid = 2;
                        final int _amount = 1;
                        wrapper.getStackInSlot(_slotid).shrink(1);
                    }
                }
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putDouble("Prismatic", (new Object() {
                            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                BlockEntity blockEntity = world.getBlockEntity(pos);
                                if (blockEntity != null)
                                    return blockEntity.getPersistentData().getDouble(tag);
                                return -1;
                            }
                        }.getValue(world, BlockPos.containing(x, y, z), "Prismatic") + 1));
                    if (world instanceof Level _level)
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
                if (world instanceof ServerLevel _level)
                    _level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (x + 0.5), (y + 1.2), (z + 0.5), 6, 0.1, 0.1, 0.1, 0);
                if (world instanceof ServerLevel _level)
                    _level.sendParticles(ParticleTypes.SMOKE, (x + 0.5), (y + 1.2), (z + 0.5), 8, 0.1, 0.1, 0.1, 0);
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.CONDUIT_AMBIENT_SHORT, SoundSource.NEUTRAL, 2, (float) 1.8);
                    } else {
                        _level.playLocalSound(x, y, z, SoundEvents.CONDUIT_AMBIENT_SHORT, SoundSource.NEUTRAL, 2, (float) 1.8, false);
                    }
                }
            }
        }
    }
}

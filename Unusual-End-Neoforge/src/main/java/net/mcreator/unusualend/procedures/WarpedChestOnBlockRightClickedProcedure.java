package net.mcreator.unusualend.procedures;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;

import net.mcreator.unusualend.init.UnusualendModParticleTypes;
import net.mcreator.unusualend.UnusualendMod;

public class WarpedChestOnBlockRightClickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Direction direction, Entity entity) {
        if (direction == null || entity == null)
            return;
        if (!(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getString(tag);
                return "";
            }
        }.getValue(world, BlockPos.containing(x, y, z), "UUID")).contains(entity.getStringUUID())) {
            if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip3 ? blockstate.getValue(_getip3) : -1) == 0) {
                {
                    int _value = 1;
                    BlockPos _pos = BlockPos.containing(x, y, z);
                    BlockState _bs = world.getBlockState(_pos);
                    if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
                        world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                }
                if (world.isClientSide()) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.CHEST_OPEN, SoundSource.BLOCKS, 1, (float) Mth.nextDouble(RandomSource.create(), 1.2, 1.4));
                        } else {
                            _level.playLocalSound(x, y, z, SoundEvents.CHEST_OPEN, SoundSource.BLOCKS, 1, (float) Mth.nextDouble(RandomSource.create(), 1.2, 1.4), false);
                        }
                    }
                }
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putString("UUID", ((new Object() {
                            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                BlockEntity blockEntity = world.getBlockEntity(pos);
                                if (blockEntity != null)
                                    return blockEntity.getPersistentData().getString(tag);
                                return "";
                            }
                        }.getValue(world, BlockPos.containing(x, y, z), "UUID")) + "." + entity.getStringUUID()));
                    if (world instanceof Level _level)
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
                if (world instanceof ServerLevel _level)
                    _level.sendParticles(ParticleTypes.CLOUD, (x + 0.5), (y + 0.8), (z + 0.5), 5, 0.4, 0.1, 0.4, 0);
                if (world instanceof ServerLevel _level)
                    _level.sendParticles(UnusualendModParticleTypes.WARPED_BUBBLES.get(), (x + 0.5), (y + Mth.nextDouble(RandomSource.create(), 0.6, 0.9)), (z + 0.5), 20, 0.3, 0.1, 0.3, 0.05);
                if (world instanceof ServerLevel _level)
                    _level.sendParticles(ParticleTypes.FISHING, (x + 0.5), (y + 0.8), (z + 0.5), 15, 0.4, 0.1, 0.4, 0);
                for (int index0 = 0; index0 < (int) Mth.nextDouble(RandomSource.create(), 4, 5); index0++) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().getLootData().getLootTable(new ResourceLocation("unusualend:chests/warped_ship"))
                                .getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY))) {
                            if (world instanceof ServerLevel _level) {
                                ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5 + direction.getStepX() * Mth.nextDouble(RandomSource.create(), 0.6, 0.6)), (y + 0.5 + direction.getStepY() * Mth.nextDouble(RandomSource.create(), 0.6, 0.6)),
                                        (z + 0.5 + direction.getStepZ() * Mth.nextDouble(RandomSource.create(), 0.6, 0.6)), itemstackiterator);
                                entityToSpawn.setPickUpDelay(10);
                                _level.addFreshEntity(entityToSpawn);
                            }
                        }
                    }
                }
                UnusualendMod.queueServerWork(5, () -> {
                    BlockPos _pos = BlockPos.containing(x, y, z);
                    BlockState _bs = world.getBlockState(_pos);
                    if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(0))
                        world.setBlock(_pos, _bs.setValue(_integerProp, 0), 3);
                    if (world.isClientSide()) {
                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.CHEST_LOCKED, SoundSource.BLOCKS, 1, (float) Mth.nextDouble(RandomSource.create(), 1.1, 1.2));
                            } else {
                                _level.playLocalSound(x, y, z, SoundEvents.CHEST_LOCKED, SoundSource.BLOCKS, 1, (float) Mth.nextDouble(RandomSource.create(), 1.1, 1.2), false);
                            }
                        }
                    }
                });
                if (!(entity instanceof ServerPlayer _plr30 && _plr30.level() instanceof ServerLevel
                        && _plr30.getAdvancements().getOrStartProgress(_plr30.server.getAdvancements().get(new ResourceLocation("unusualend:open_warped_chest"))).isDone())) {
                    if (entity instanceof ServerPlayer _player) {
                        AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("unusualend:open_warped_chest"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                            for (String criteria : _ap.getRemainingCriteria())
                                _player.getAdvancements().award(_adv, criteria);
                        }
                    }
                }
            }
        } else {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.SMOKE, (x + 0.5), (y + 0.8), (z + 0.5), 5, 0.4, 0.1, 0.4, 0);
            if (entity instanceof Player player && !player.level().isClientSide())
                player.displayClientMessage(Component.literal((Component.translatable("text.unusualend.alreay_opened").getString())), true);
            if (world.isClientSide()) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.CHEST_LOCKED, SoundSource.BLOCKS, 1, (float) 0.95);
                    } else {
                        _level.playLocalSound(x, y, z, SoundEvents.CHEST_LOCKED, SoundSource.BLOCKS, 1, (float) 0.95, false);
                    }
                }
            }
        }
    }
}
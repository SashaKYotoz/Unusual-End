package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.init.UnusualEndMiscRegister;
import net.sweety.unusualend.util.ProcedureHelper;

public class WarpedChestOnBlockRightClickedProcedure {
    public static void execute(LevelAccessor level, double x, double y, double z, BlockState blockstate, Direction direction, Entity entity) {
        if (direction == null || entity == null || level.isClientSide())
            return;
        if (!(ProcedureHelper.getBlockEntityString(level, BlockPos.containing(x, y, z), "UUID")).contains(entity.getStringUUID())) {
            if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip3 ? blockstate.getValue(_getip3) : -1) == 0) {
                {
                    int _value = 1;
                    BlockPos _pos = BlockPos.containing(x, y, z);
                    BlockState _bs = level.getBlockState(_pos);
                    if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
                        level.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                }
                if (level.isClientSide()) {
                    if (level instanceof Level _level)
                        _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.CHEST_OPEN, SoundSource.BLOCKS, 1, (float) Mth.nextDouble(level.getRandom(), 1.2, 1.4));
                }
                if (!level.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockEntity _blockEntity = level.getBlockEntity(_bp);
                    BlockState _bs = level.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putString("UUID", ((ProcedureHelper.getBlockEntityString(level, BlockPos.containing(x, y, z), "UUID")) + "." + entity.getStringUUID()));
                    if (level instanceof Level _level)
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
                if (level instanceof ServerLevel _level) {
                    _level.sendParticles(ParticleTypes.CLOUD, (x + 0.5), (y + 0.8), (z + 0.5), 5, 0.4, 0.1, 0.4, 0);
                    _level.sendParticles(UnusualEndMiscRegister.WARPED_BUBBLES.get(), (x + 0.5), (y + Mth.nextDouble(_level.getRandom(), 0.6, 0.9)), (z + 0.5), 20, 0.3, 0.1, 0.3, 0.05);
                    _level.sendParticles(ParticleTypes.FISHING, (x + 0.5), (y + 0.8), (z + 0.5), 15, 0.4, 0.1, 0.4, 0);
                }
                for (int index0 = 0; index0 < (int) Mth.nextDouble(level.getRandom(), 4, 5); index0++) {
                    if (!level.isClientSide() && level.getServer() != null) {
                        for (ItemStack itemstackiterator : level.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, UnusualEnd.makeUEID("chests/warped_ship")))
                                .getRandomItems(new LootParams.Builder((ServerLevel) level).create(LootContextParamSets.EMPTY))) {
                            ProcedureHelper.dropItem(level, (x + 0.5 + direction.getStepX() * Mth.nextDouble(level.getRandom(), 0.6, 0.6)), (y + 0.5 + direction.getStepY() * Mth.nextDouble(level.getRandom(), 0.6, 0.6)), (z + 0.5 + direction.getStepZ() * Mth.nextDouble(level.getRandom(), 0.6, 0.6)), itemstackiterator, 10);
                        }
                    }
                }
                UnusualEnd.queueServerWork(5, () -> {
                    BlockPos _pos = BlockPos.containing(x, y, z);
                    BlockState _bs = level.getBlockState(_pos);
                    if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(0))
                        level.setBlock(_pos, _bs.setValue(_integerProp, 0), 3);
                    if (level.isClientSide()) {
                        if (level instanceof Level _level) {
                            _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.CHEST_LOCKED, SoundSource.BLOCKS, 1, (float) Mth.nextDouble(_level.getRandom(), 1.1, 1.2));
                        }
                    }
                });
                ProcedureHelper.awardAdvancement(entity, "open_warped_chest");
            }
        } else {
            if (level instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.SMOKE, (x + 0.5), (y + 0.8), (z + 0.5), 5, 0.4, 0.1, 0.4, 0);
            if (entity instanceof Player player && !player.level().isClientSide())
                player.displayClientMessage(Component.translatable("text.unusualend.alreay_opened"), true);
            if (level instanceof Level _level) {
                if (!_level.isClientSide())
                    _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.CHEST_LOCKED, SoundSource.BLOCKS, 1, (float) 0.95);
            }
        }
    }
}
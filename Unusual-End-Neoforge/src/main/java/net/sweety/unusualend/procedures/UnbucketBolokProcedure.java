package net.sweety.unusualend.procedures;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.entity.BolokEntity;
import net.sweety.unusualend.init.UnusualEndEntities;

public class UnbucketBolokProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity, ItemStack stack) {
        if (direction == null || entity == null)
            return;
        if (!entity.isShiftKeyDown()) {
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == stack.getItem()) {
                if (!(new Object() {
                    public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                            return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                        } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                            return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                    && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
                        }
                        return false;
                    }
                }.checkGamemode(entity))) {
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player)
                            _player.getInventory().setChanged();
                    }
                }
                if (entity instanceof LivingEntity _entity)
                    _entity.swing(InteractionHand.MAIN_HAND, true);
            } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == stack.getItem()) {
                if (!(new Object() {
                    public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                            return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                        } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                            return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                    && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
                        }
                        return false;
                    }
                }.checkGamemode(entity))) {
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                        if (_entity instanceof Player _player)
                            _player.getInventory().setChanged();
                    }
                }
                if (entity instanceof LivingEntity _entity)
                    _entity.swing(InteractionHand.OFF_HAND, true);
            }
            if (world instanceof ServerLevel _level) {
                BolokEntity entityToSpawn = UnusualEndEntities.BOLOK.get().spawn(_level, BlockPos.containing(x + direction.getStepX(), y + direction.getStepY(), z + direction.getStepZ()), MobSpawnType.MOB_SUMMONED);
                if (entityToSpawn != null)
                    NBTProcessor.writeTagsIntoEntity(stack.getOrDefault(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY).copyTag(), entityToSpawn);
            }
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.BUCKET_FILL_FISH, SoundSource.NEUTRAL, 1, 1);
                } else {
                    _level.playLocalSound(x, y, z, SoundEvents.BUCKET_FILL_FISH, SoundSource.NEUTRAL, 1, 1, false);
                }
            }
        }
    }
}

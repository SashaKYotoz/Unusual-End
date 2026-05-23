package net.sweety.unusualend.procedures;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.entity.BlukEntity;
import net.sweety.unusualend.init.UnusualEndEntities;

import java.util.Comparator;

public class UnbucketBlukProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity, ItemStack stack) {
        if (direction == null || entity == null)
            return;
        String name = "";
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
                Entity entityToSpawn = UnusualEndEntities.BLUK.get().spawn(_level, BlockPos.containing(x + direction.getStepX(), y + direction.getStepY(), z + direction.getStepZ()), MobSpawnType.MOB_SUMMONED);
                if (entityToSpawn != null) {
                }
            }
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.BUCKET_FILL_FISH, SoundSource.NEUTRAL, 1, 1);
                } else {
                    _level.playLocalSound(x, y, z, SoundEvents.BUCKET_FILL_FISH, SoundSource.NEUTRAL, 1, 1, false);
                }
            }
            if (!world.getEntitiesOfClass(BlukEntity.class, AABB.ofSize(new Vec3((x + direction.getStepX()), (y + direction.getStepY()), (z + direction.getStepZ())), 1, 1, 1), e -> true).isEmpty()
                    && NBTProcessor.getNBTBoolean(stack, "isNamed")) {
                name = stack.getDisplayName().getString();
                name = name.substring(1, (name).length() - 1);
                world.getEntitiesOfClass(BlukEntity.class, AABB.ofSize(new Vec3((x + direction.getStepX()), (y + direction.getStepY()), (z + direction.getStepZ())), 1, 1, 1), e -> true).stream().sorted(new Object() {
                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                    }
                }.compareDistOf((x + direction.getStepX()), (y + direction.getStepY()), (z + direction.getStepZ()))).findFirst().orElse(null).setCustomName(Component.literal(name));
            }
            if (NBTProcessor.getNBTDouble(stack, "tagHealth") != 0) {
                if (((Entity) world.getEntitiesOfClass(BlukEntity.class, AABB.ofSize(new Vec3((x + direction.getStepX()), (y + direction.getStepY()), (z + direction.getStepZ())), 1, 1, 1), e -> true).stream().sorted(new Object() {
                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                    }
                }.compareDistOf((x + direction.getStepX()), (y + direction.getStepY()), (z + direction.getStepZ()))).findFirst().orElse(null)) instanceof LivingEntity _entity)
                    _entity.setHealth((float) NBTProcessor.getNBTDouble(stack, "tagHealth"));
            }
        }
    }
}

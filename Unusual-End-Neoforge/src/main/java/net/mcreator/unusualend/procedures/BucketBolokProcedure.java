package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.unusualend.init.UnusualendModItems;
import net.neoforged.neoforge.items.ItemHandlerHelper;

public class BucketBolokProcedure {
    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        ItemStack entity_bucket = new ItemStack(UnusualendModItems.BOLOK_BUCKET.get());
        if (!(new Object() {
            public String getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getString("CustomName");
            }
        }.getValue()).isEmpty()) {
            entity_bucket.setHoverName(Component.literal((entity.getDisplayName().getString())));
            entity_bucket.getOrCreateTag().putBoolean("isNamed", true);
        }
        entity_bucket.getOrCreateTag().putDouble("tagHealth", (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1));
        if (entity instanceof LivingEntity _livEnt6 && _livEnt6.isBaby()) {
            entity_bucket.getOrCreateTag().putBoolean("isBaby", true);
        } else {
            entity_bucket.getOrCreateTag().putBoolean("isBaby", false);
        }
        if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BUCKET) {
            if (!entity.level().isClientSide())
                entity.discard();
            if (sourceentity instanceof LivingEntity _entity)
                _entity.swing(InteractionHand.MAIN_HAND, true);
            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() == 1) {
                if (sourceentity instanceof LivingEntity _entity) {
                    ItemStack _setstack = entity_bucket.copy();
                    _setstack.setCount(1);
                    _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                    if (_entity instanceof Player _player)
                        _player.getInventory().setChanged();
                }
            } else {
                if (!world.isClientSide()) {
                    if (sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
                        _setstack.setCount((int) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1));
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player)
                            _player.getInventory().setChanged();
                    }
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = entity_bucket.copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                }
            }
        } else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.BUCKET && !(entity instanceof LivingEntity _livEnt23 && _livEnt23.isBaby())) {
            if (!entity.level().isClientSide())
                entity.discard();
            if (sourceentity instanceof LivingEntity _entity)
                _entity.swing(InteractionHand.OFF_HAND, true);
            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getCount() == 1) {
                if (sourceentity instanceof LivingEntity _entity) {
                    ItemStack _setstack = entity_bucket.copy();
                    _setstack.setCount(1);
                    _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                    if (_entity instanceof Player _player)
                        _player.getInventory().setChanged();
                }
            } else {
                if (!world.isClientSide()) {
                    if (sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
                        _setstack.setCount((int) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getCount() - 1));
                        _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                        if (_entity instanceof Player _player)
                            _player.getInventory().setChanged();
                    }
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = entity_bucket.copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                }
            }
        }
    }
}

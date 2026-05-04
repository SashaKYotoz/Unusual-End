package net.sweety.unusualend.procedures;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.sweety.unusualend.init.UnusualEndItems;

public class BucketFireflyProcedure {
    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        ItemStack entity_bucket;
        if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BUCKET
                || (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.BUCKET) {
            entity_bucket = new ItemStack(UnusualEndItems.ENDERFIREFLY_BUCKET.get());
            if (entity_bucket.has(DataComponents.BUCKET_ENTITY_DATA) && entity instanceof Mob living)
                entity_bucket.set(DataComponents.BUCKET_ENTITY_DATA, CustomData.of(NBTProcessor.formBabyTag(living)));
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
                            _setstack.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
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
            } else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.BUCKET) {
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
                            _setstack.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getCount() - 1);
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
        if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
            if (entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt && _tamIsTamedBy.isOwnedBy(_livEnt)) {
                entity.setDeltaMovement(new Vec3(0, 0, 0));
                if ((new Object() {
                    public boolean getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getBoolean("Sitting");
                    }
                }.getValue())) {
                    if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + Component.translatable("text.unusualend.follow").getString())), true);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        dataIndex.putBoolean("Sitting", false);
                        entity.load(dataIndex);
                    }
                } else {
                    if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + Component.translatable("text.unusualend.sit").getString())), true);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        dataIndex.putBoolean("Sitting", true);
                        entity.load(dataIndex);
                    }
                }
            }
        }
    }
}

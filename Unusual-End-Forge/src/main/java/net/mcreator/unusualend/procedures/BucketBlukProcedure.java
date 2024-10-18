package net.mcreator.unusualend.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModItems;

public class BucketBlukProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		ItemStack entity_bucket = ItemStack.EMPTY;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.BUCKET
				|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BUCKET) {
			entity_bucket = new ItemStack(UnusualendModItems.BLUK_BUCKET.get());
			if (!(new Object() {
				public String getValue() {
					CompoundTag dataIndex4 = new CompoundTag();
					entity.saveWithoutId(dataIndex4);
					return dataIndex4.getString("CustomName");
				}
			}.getValue()).isEmpty()) {
				entity_bucket.setHoverName(Component.literal((entity.getDisplayName().getString())));
				entity_bucket.getOrCreateTag().putBoolean("isNamed", true);
			}
			if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) {
				entity_bucket.getOrCreateTag().putString("Owner", ("" + ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getDisplayName().getString())));
				entity_bucket.getOrCreateTag().putBoolean("isTamed", true);
			} else {
				entity_bucket.getOrCreateTag().putBoolean("isTamed", false);
			}
			entity_bucket.getOrCreateTag().putDouble("tagHealth", (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1));
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
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.CARROT) {
			(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			if (sourceentity instanceof Player _player)
				_player.getCooldowns().addCooldown(Items.CARROT, 10);
			if (world.isClientSide()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.eat")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.eat")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:bluk_eat")), SoundSource.HOSTILE, (float) 0.7, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:bluk_eat")), SoundSource.HOSTILE, (float) 0.7, 1, false);
					}
				}
			}
		}
	}
}

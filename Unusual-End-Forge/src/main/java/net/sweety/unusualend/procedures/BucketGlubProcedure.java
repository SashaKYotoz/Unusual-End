package net.sweety.unusualend.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.items.ItemHandlerHelper;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.util.ProcedureHelper;

public class BucketGlubProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		ItemStack entity_bucket = ItemStack.EMPTY;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BUCKET
				|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.BUCKET) {
			entity_bucket = new ItemStack(UnusualendModItems.GLUB_BUCKET.get());
			if (entity.hasCustomName()) {
				entity_bucket.setHoverName(Component.literal((entity.getDisplayName().getString())));
				entity_bucket.getOrCreateTag().putBoolean("isNamed", true);
			}
			entity_bucket.getOrCreateTag().putDouble("tagHealth", (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1));
            entity_bucket.getOrCreateTag().putBoolean("isBaby", entity instanceof LivingEntity _livEnt10 && _livEnt10.isBaby());
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
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
			entity.startRiding(sourceentity);
			ProcedureHelper.awardAdvancement(sourceentity, "wear_glub");
		}
	}
}


package net.sweety.unusualend.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.sweety.unusualend.procedures.VoidTrackerHandTickUpdateProcedure;

import java.util.List;

public class VoidTrackerItem extends Item {
	public VoidTrackerItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("tooltip.unusualend.void_tracker.0"));
		list.add(Component.translatable("tooltip.unusualend.void_tracker.1"));
		list.add(Component.translatable("tooltip.unusualend.void_tracker.2"));
		list.add(Component.translatable("tooltip.unusualend.void_tracker.3"));
	}

	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return false;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected || slot == 0) {
			VoidTrackerHandTickUpdateProcedure.execute(world, world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
		} else if (!(itemstack.getOrCreateTag().getDouble("VoidState") == 10)) {
			itemstack.getOrCreateTag().putDouble("VoidState", 10);
		}
	}
}

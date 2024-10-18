
//render 3d model
package net.mcreator.unusualend.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.unusualend.procedures.PearlescentRingInventoryTickProcedure;

import java.util.List;

public class PearlescentRingItem extends Item {
	public PearlescentRingItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	public boolean isBarVisible(ItemStack stack) {
		if (stack.getOrCreateTag().getDouble("ringCooldown") < 400) {
			return true;
		}
		return false;
	}

	@Override
	public int getBarColor(ItemStack stack) {
		return 16400310;
	}

	@Override
	public int getBarWidth(ItemStack stack) {
		return (int) (stack.getOrCreateTag().getDouble("ringCooldown") * 0.0025f * 14f);
	}

	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return false;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77When equiped or held"));
		list.add(Component.literal("\u00A77in Off Hand on Hit:"));
		list.add(Component.literal("\u00A79Summon a Dragling minion"));
		list.add(Component.literal("\u00A77While wearing a Spirit Mask:"));
		list.add(Component.literal("\u00A79Summons a second Dragling"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		PearlescentRingInventoryTickProcedure.execute(itemstack);
	}
}

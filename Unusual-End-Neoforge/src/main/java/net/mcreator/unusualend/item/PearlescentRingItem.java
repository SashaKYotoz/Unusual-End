
package net.mcreator.unusualend.item;

import net.minecraft.ChatFormatting;
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
		if (stack.getOrCreateTag().getDouble("ringCooldown") < 400 && stack.getOrCreateTag().getDouble("ringCooldown") > 0) {
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
		list.add(Component.translatable("lore.unusualend.when_offhand").withStyle(ChatFormatting.GRAY));
		list.add(Component.translatable("lore.unusualend.spirit_ring_1").withStyle(ChatFormatting.BLUE));
		list.add(Component.translatable("lore.unusualend.spirit_ring_2").withStyle(ChatFormatting.BLUE));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		PearlescentRingInventoryTickProcedure.execute(itemstack);
	}
}


package net.mcreator.unusualend.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.unusualend.procedures.PearlescentRingInventoryTickProcedure;
import net.mcreator.unusualend.init.UnusualendModEnchantments;

import java.util.Set;
import java.util.List;

import com.google.common.collect.ImmutableSet;

public class PearlescentRingItem extends Item {
	public PearlescentRingItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		Set e = ImmutableSet.of(UnusualendModEnchantments.ARCANE_RECOVERY.get());
		return e.contains(enchantment);
	}

	@Override
	public int getEnchantmentValue() {
		return 8;
	}

	@Override
	public boolean isEnchantable(ItemStack stack) {
		return true;
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
		list.add(Component.literal("\u00A77" + Component.translatable("lore.unusualend.when_offhand").getString()));
		list.add(Component.literal("\u00A77 " + Component.translatable("lore.unusualend.on_hit").getString()));
		list.add(Component.literal("\u00A79 " + Component.translatable("lore.unusualend.spirit_ring_1").getString()));
		list.add(Component.literal("\u00A79 " + Component.translatable("lore.unusualend.spirit_ring_2").getString()));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		PearlescentRingInventoryTickProcedure.execute(itemstack);
	}
}

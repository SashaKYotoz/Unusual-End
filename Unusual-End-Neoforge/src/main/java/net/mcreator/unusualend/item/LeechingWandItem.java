
package net.mcreator.unusualend.item;

import net.minecraft.ChatFormatting;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import net.mcreator.unusualend.procedures.LeechingWandItemInInventoryTickProcedure;
import net.mcreator.unusualend.init.UnusualendModEnchantments;

import java.util.Set;
import java.util.List;

import com.google.common.collect.ImmutableSet;

public class LeechingWandItem extends Item {
	public LeechingWandItem() {
		super(new Item.Properties().durability(256).rarity(Rarity.COMMON));
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		Set e = ImmutableSet.of(UnusualendModEnchantments.BONDING.get(), UnusualendModEnchantments.BENEVOLENCE.get(), UnusualendModEnchantments.ARCANE_RECOVERY.get());
		return e.contains(enchantment);
	}

	@Override
	public int getEnchantmentValue() {
		return 16;
	}

	@Override
	public boolean isEnchantable(ItemStack stack) {
		return true;
	}

	@Override
	public boolean isBarVisible(ItemStack stack) {
        return stack.getDamageValue() > 0 || stack.getOrCreateTag().getDouble("rayCooldown") < 400 && stack.getOrCreateTag().getDouble("rayCooldown") > 0 || stack.getDamageValue() > 0 && stack.getOrCreateTag().getDouble("rayCooldown") < 400;
    }

	@Override
	public int getBarColor(ItemStack stack) {
		if (stack.getOrCreateTag().getDouble("rayCooldown") < 400) {
			return 16400310;
		}
		return Mth.hsvToRgb(Math.max(0.0F, 1.0F - (float) stack.getDamageValue() / stack.getMaxDamage()) / 3.0F, 1.0F, 1.0F);
	}

	@Override
	public int getBarWidth(ItemStack stack) {
		if (stack.getOrCreateTag().getDouble("rayCooldown") < 400) {
			return (int) (stack.getOrCreateTag().getDouble("rayCooldown") * 0.0025f * 14f);
		}
		return Math.round(13.0F - (float) stack.getDamageValue() / stack.getMaxDamage() * 13.0F);
	}

	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return false;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.translatable("lore.unusualend.hold_shooting").withStyle(ChatFormatting.DARK_GRAY));
		list.add(Component.translatable("lore.unusualend.on_hit").withStyle(ChatFormatting.GRAY));
		list.add(Component.literal("\u00A79Regeneration III (00:03)"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		LeechingWandItemInInventoryTickProcedure.execute(world, entity, itemstack);
	}
}

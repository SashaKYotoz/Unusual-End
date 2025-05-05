
package net.mcreator.unusualend.item;

import net.minecraft.ChatFormatting;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import net.mcreator.unusualend.init.UnusualendModBlocks;

import java.util.List;

public class EnderblobShieldItem extends ShieldItem {
	public EnderblobShieldItem() {
		super(new Item.Properties().durability(224));
	}

	@Override
	public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
		return Ingredient.of(new ItemStack(UnusualendModBlocks.ENDERBLOB_BLOCK.get())).test(repairitem);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("lore.unusualend.when_block").withStyle(ChatFormatting.GRAY));
		list.add(Component.translatable("lore.unusualend.blob_shield_1").withStyle(ChatFormatting.BLUE));
		list.add(Component.translatable("lore.unusualend.blob_shield_2").withStyle(ChatFormatting.BLUE));
	}
}
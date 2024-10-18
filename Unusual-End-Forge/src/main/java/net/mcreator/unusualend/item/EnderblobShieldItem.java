
package net.mcreator.unusualend.item;

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
		list.add(Component.literal("\u00A77When Blocking:"));
		list.add(Component.literal("\u00A79Push away opponents"));
		list.add(Component.literal("\u00A79trying to hurt you"));
	}
}

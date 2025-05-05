
package net.mcreator.unusualend.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class InfuserInfosItem extends Item {
	public InfuserInfosItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A7dx1 : 5 min"));
		list.add(Component.literal("\u00A7dx4 : 20 min"));
		list.add(Component.literal("\u00A7dx8 : 40 min"));
		list.add(Component.literal("\u00A75To consume a buff from a"));
		list.add(Component.literal("\u00A75mineral, the Infuser need to"));
		list.add(Component.literal("\u00A75be placed on at least 4 blocks"));
		list.add(Component.literal("\u00A75of this mineral. 1 Pearlescent"));
		list.add(Component.literal("\u00A75Alloy block is considered +1"));
		list.add(Component.literal("\u00A75for each mineral."));
	}
}

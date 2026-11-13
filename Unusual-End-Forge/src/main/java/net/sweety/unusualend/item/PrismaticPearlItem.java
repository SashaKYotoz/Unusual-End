
package net.sweety.unusualend.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class PrismaticPearlItem extends Item {
	public PrismaticPearlItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("tooltip.unusualend.prismatic_pearl.0"));
		list.add(Component.translatable("tooltip.unusualend.prismatic_pearl.1"));
		list.add(Component.translatable("tooltip.unusualend.prismatic_pearl.2"));
	}
}

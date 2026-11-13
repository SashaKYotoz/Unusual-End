package net.sweety.unusualend.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TooltipItem extends Item {
	private final List<Component> tooltip;

	public TooltipItem(Item.Properties properties, Component... tooltip) {
		super(properties);
		this.tooltip = List.of(tooltip);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(stack, level, list, flag);
		list.addAll(this.tooltip);
	}
}

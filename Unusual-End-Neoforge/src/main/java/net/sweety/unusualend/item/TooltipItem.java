package net.sweety.unusualend.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class TooltipItem extends Item {
    private final List<Component> tooltip;

    public TooltipItem(Item.Properties properties, Component... tooltip) {
        super(properties);
        this.tooltip = List.of(tooltip);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(stack, context, list, flag);
        list.addAll(this.tooltip);
    }
}


package net.mcreator.unusualend.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class CreativeSerenityItem extends Item {
	public CreativeSerenityItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
        if (net.minecraft.client.gui.screens.Screen.hasControlDown()) {
		list.add(Component.literal("\u00A771 Citrine Chunk : \u00A79Serenity (5:00)"));
		list.add(Component.literal("\u00A774 Citrine Chunks : \u00A79Serenity (20:00)"));
		list.add(Component.literal("\u00A778 Citrine Chunks : \u00A79Serenity (40:00)"));
    } else
            list.add(Component.translatable("item.unusual_end.short_description").withStyle(ChatFormatting.DARK_GRAY));
	}
}

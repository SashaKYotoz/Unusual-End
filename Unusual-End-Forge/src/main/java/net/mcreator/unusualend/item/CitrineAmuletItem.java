
//desc
package net.mcreator.unusualend.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class CitrineAmuletItem extends Item {
	public CitrineAmuletItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
        if (net.minecraft.client.gui.screens.Screen.hasControlDown()) {
		list.add(Component.literal("\u00A77" + Component.translatable("lore.unusualend.when_offhand").getString()));
		list.add(Component.literal("\u00A79" + Component.translatable("lore.unusualend.extra_xp").getString()));
        } else
            list.add(Component.translatable("item.unusual_end.short_description").withStyle(ChatFormatting.DARK_GRAY));
	}
}

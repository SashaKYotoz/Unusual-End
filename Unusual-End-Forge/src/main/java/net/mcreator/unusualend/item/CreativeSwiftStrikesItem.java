
package net.mcreator.unusualend.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class CreativeSwiftStrikesItem extends Item {
	public CreativeSwiftStrikesItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A771 Prismalite Gem : \u00A79Swift Strikes (5:00)"));
		list.add(Component.literal("\u00A774 Prismalite Gems : \u00A79Swift Strikes (20:00)"));
		list.add(Component.literal("\u00A778 Prismalite Gems : \u00A79Swift Strikes (40:00)"));
	}
}

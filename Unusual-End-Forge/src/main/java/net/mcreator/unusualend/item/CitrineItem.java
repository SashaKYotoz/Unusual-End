
package net.mcreator.unusualend.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class CitrineItem extends Item {
	public CitrineItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}

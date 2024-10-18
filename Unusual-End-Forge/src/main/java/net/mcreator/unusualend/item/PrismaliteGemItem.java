
package net.mcreator.unusualend.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class PrismaliteGemItem extends Item {
	public PrismaliteGemItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}

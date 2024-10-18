
package net.mcreator.unusualend.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class BlobLensItem extends Item {
	public BlobLensItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}

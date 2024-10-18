
package net.mcreator.unusualend.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HorseArmorItem;

public class ScaleHorseArmorItem extends HorseArmorItem {
	public ScaleHorseArmorItem() {
		super(16, "scale", new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}

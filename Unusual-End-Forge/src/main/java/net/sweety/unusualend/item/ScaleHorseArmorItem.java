
package net.sweety.unusualend.item;

import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.sweety.unusualend.init.UnusualendModTabs;

public class ScaleHorseArmorItem extends HorseArmorItem {
	public ScaleHorseArmorItem() {
		super(16, "scale", new Item.Properties().tab(UnusualendModTabs.UNUSUAL_END_WARPED_REEF).stacksTo(1).rarity(Rarity.COMMON));
	}
}

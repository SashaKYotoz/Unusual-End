
package net.sweety.unusualend.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.sweety.unusualend.init.UnusualendModSounds;

public class MusicDiscFlyingShipsItem extends RecordItem {
	public MusicDiscFlyingShipsItem() {
		super(3, () -> UnusualendModSounds.MUSIC_DISC_FLYING_SHIPS.get(), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 3900);
	}
}

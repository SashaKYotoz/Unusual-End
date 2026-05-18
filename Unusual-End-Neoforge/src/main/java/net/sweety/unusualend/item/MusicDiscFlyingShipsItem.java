
package net.sweety.unusualend.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.sweety.unusualend.init.UnusualEndSounds;

public class MusicDiscFlyingShipsItem extends Item {
	public MusicDiscFlyingShipsItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(UnusualEndSounds.FLYING_SHIPS));
	}
}

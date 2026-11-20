
package net.sweety.unusualend.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.sweety.unusualend.init.UnusualendModSounds;
import net.sweety.unusualend.init.UnusualendModTabs;

public class MusicDiscQueenItem extends RecordItem {
	public MusicDiscQueenItem() {
		super(0, () -> UnusualendModSounds.MUSIC_DISC_QUEEN.get(), new Item.Properties().tab(UnusualendModTabs.UNUSUAL_END_GLOOPSTONE_LANDS).stacksTo(1).rarity(Rarity.RARE), 3800);
	}
}

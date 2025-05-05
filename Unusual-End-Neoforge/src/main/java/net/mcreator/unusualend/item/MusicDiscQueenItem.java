
package net.mcreator.unusualend.item;

import net.mcreator.unusualend.init.UnusualendModSounds;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class MusicDiscQueenItem extends RecordItem {
	public MusicDiscQueenItem() {
		super(0, UnusualendModSounds.MUSIC_DISC_QUEEN, new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 3800);
	}
}
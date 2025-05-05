
package net.mcreator.unusualend.item;

import net.mcreator.unusualend.init.UnusualendModSounds;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class MusicDiscEndstoneGolemThemeItem extends RecordItem {
	public MusicDiscEndstoneGolemThemeItem() {
		super(15, UnusualendModSounds.ENDSTONE_GOLEM_THEME, new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 3600);
	}
}

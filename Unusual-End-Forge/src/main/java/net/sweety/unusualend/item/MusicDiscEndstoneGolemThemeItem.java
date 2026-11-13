
package net.sweety.unusualend.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.sweety.unusualend.init.UnusualendModSounds;

public class MusicDiscEndstoneGolemThemeItem extends RecordItem {
	public MusicDiscEndstoneGolemThemeItem() {
		super(15, () -> UnusualendModSounds.MUSIC_DISC_ENDSTONE_GOLEM_THEME.get(), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 3600);
	}
}

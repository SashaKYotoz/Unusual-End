
package net.mcreator.unusualend.item;

import net.mcreator.unusualend.init.UnusualendModSounds;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class MusicdiscflyingshipsItem extends RecordItem {
	public MusicdiscflyingshipsItem() {
		super(3, () -> UnusualendModSounds.MUSIC_DISC_FLYING_SHIPS.get(), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 3900);
	}
}

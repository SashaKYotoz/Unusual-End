
package net.sweety.unusualend.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.registries.ForgeRegistries;

public class MusicDiscEndstoneGolemThemeItem extends RecordItem {
	public MusicDiscEndstoneGolemThemeItem() {
		super(15, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:music_disc_endstone_golem_theme")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 3600);
	}
}


package net.mcreator.unusualend.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class MusicDiscQueenItem extends RecordItem {
	public MusicDiscQueenItem() {
		super(0, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:music_disc_queen")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 3800);
	}
}


package net.mcreator.unusualend.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.registries.ForgeRegistries;

public class MusicDiscFlyingShipsItem extends RecordItem {
	public MusicDiscFlyingShipsItem() {
		super(3, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:music_disc_flying_ships")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 3900);
	}
}

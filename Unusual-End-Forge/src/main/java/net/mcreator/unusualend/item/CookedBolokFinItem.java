
//desc
package net.mcreator.unusualend.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.network.chat.Component;

import net.mcreator.unusualend.configuration.ConfigurationFileConfiguration;

import java.util.List;

public class CookedBolokFinItem extends Item {
	public CookedBolokFinItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(9).saturationMod(1f).build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 128;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		double minute = (ConfigurationFileConfiguration.COOKED_BOLOK_FIN_TIME.get() / 60);
		double seconds = (ConfigurationFileConfiguration.COOKED_BOLOK_FIN_TIME.get() - (Math.floor(minute) * 60));
		String time = new java.text.DecimalFormat("00").format(minute) + ":" + new java.text.DecimalFormat("00").format(seconds);
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77" + Component.translatable("lore.unusualend.wolf_food").getString()));
		list.add(Component.literal("\u00A79" + Component.translatable("effect.minecraft.resistance").getString() + " II (" + time + ")"));
	}
}

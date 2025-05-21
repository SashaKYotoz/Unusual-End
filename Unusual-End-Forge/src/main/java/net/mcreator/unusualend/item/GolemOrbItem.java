
//desc
package net.mcreator.unusualend.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import net.mcreator.unusualend.configuration.ConfigurationFileConfiguration;

import java.util.List;

public class GolemOrbItem extends Item {
	public GolemOrbItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.UNCOMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		double raw_proba = ConfigurationFileConfiguration.ORB_TRIGGER.get();
		String proba = new java.text.DecimalFormat("0").format(raw_proba);
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77" + Component.translatable("lore.unusualend.when_hurt").getString() + " \u00A78(" + proba + "%)"));
		list.add(Component.literal("\u00A79" + Component.translatable("lore.unusualend.golem_orb").getString()));
	}
}

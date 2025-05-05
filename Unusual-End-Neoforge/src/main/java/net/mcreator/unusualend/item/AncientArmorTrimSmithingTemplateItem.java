
package net.mcreator.unusualend.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class AncientArmorTrimSmithingTemplateItem extends Item {
	public AncientArmorTrimSmithingTemplateItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77" + Component.translatable("trim_pattern.unusualend.ancient_armor_trim").getString()));
		list.add(Component.literal(""));
		list.add(Component.literal("\u00A77" + Component.translatable("item.minecraft.smithing_template.applies_to").getString()));
		list.add(Component.literal("\u00A79 " + Component.translatable("item.minecraft.smithing_template.armor_trim.applies_to").getString()));
		list.add(Component.literal("\u00A77" + Component.translatable("item.minecraft.smithing_template.ingredients").getString()));
		list.add(Component.literal("\u00A79 " + Component.translatable("item.minecraft.smithing_template.armor_trim.ingredients").getString()));
	}
}

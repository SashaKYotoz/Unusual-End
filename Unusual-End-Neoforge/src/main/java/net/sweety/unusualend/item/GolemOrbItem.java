
package net.sweety.unusualend.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.sweety.unusualend.configuration.UEConfig;

import java.util.List;

public class GolemOrbItem extends Item {
	public GolemOrbItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.UNCOMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, TooltipContext context, List<Component> list, TooltipFlag flag) {
        String proba = new java.text.DecimalFormat("0").format(UEConfig.ORB_TRIGGER.get());
		super.appendHoverText(itemstack, context, list, flag);
        list.add(Component.literal("\u00A77" + Component.translatable("lore.unusualend.when_hurt").getString() + " \u00A78(" + proba + "%)"));
        list.add(Component.literal("\u00A79" + Component.translatable("lore.unusualend.golem_orb").getString()));
	}
}

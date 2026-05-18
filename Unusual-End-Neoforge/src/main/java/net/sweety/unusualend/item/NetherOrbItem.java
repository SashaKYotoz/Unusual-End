
package net.sweety.unusualend.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.sweety.unusualend.configuration.UEConfig;

import java.util.List;

public class NetherOrbItem extends Item {
	public NetherOrbItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.UNCOMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
        String proba = new java.text.DecimalFormat("0").format(UEConfig.ORB_TRIGGER.get());
        super.appendHoverText(itemstack, context, list, flag);
        list.add(Component.literal("\u00A77" + Component.translatable("lore.unusualend.when_hurt").getString() + " \u00A78(" + proba + "%)"));
        list.add(Component.literal("\u00A79" + Component.translatable("lore.unusualend.nether_orb").getString()));
	}
}

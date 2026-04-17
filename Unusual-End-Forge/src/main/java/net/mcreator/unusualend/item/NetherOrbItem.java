
//desc
package net.mcreator.unusualend.item;

import net.mcreator.unusualend.configuration.Config;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

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
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		double raw_proba = Config.ORB_TRIGGER.get();
		String proba = new java.text.DecimalFormat("0").format(raw_proba);
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77" + Component.translatable("lore.unusualend.when_hurt").getString() + " \u00A78(" + proba + "%)"));
		list.add(Component.literal("\u00A79" + Component.translatable("lore.unusualend.nether_orb").getString()));
	}
}

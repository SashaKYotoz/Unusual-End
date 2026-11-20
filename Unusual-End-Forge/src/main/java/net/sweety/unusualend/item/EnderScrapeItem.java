
package net.sweety.unusualend.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import net.sweety.unusualend.init.UnusualendModTabs;

public class EnderScrapeItem extends Item {
	public EnderScrapeItem() {
		super(new Item.Properties().tab(UnusualendModTabs.UNUSUAL_END).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}
}

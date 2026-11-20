
package net.sweety.unusualend.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import net.sweety.unusualend.init.UnusualendModTabs;

public class EndermiteMoultItem extends Item {
	public EndermiteMoultItem() {
		super(new Item.Properties().tab(UnusualendModTabs.UNUSUAL_END_GLOOPSTONE_LANDS).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}
}

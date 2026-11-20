
package net.sweety.unusualend.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import net.sweety.unusualend.init.UnusualendModTabs;

public class AncientShardItem extends Item {
	public AncientShardItem() {
		super(new Item.Properties().tab(UnusualendModTabs.UNUSUAL_END).stacksTo(64).fireResistant().rarity(Rarity.UNCOMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}
}

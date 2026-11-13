
package net.sweety.unusualend.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.sweety.unusualend.procedures.BlukAuChocolatPlayerFinishesUsingItemProcedure;

public class BlukAuChocolatItem extends Item {
	public BlukAuChocolatItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(8).saturationMod(0.9f).meat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 80;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level level, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, level, entity);
		BlukAuChocolatPlayerFinishesUsingItemProcedure.execute(level, entity);
		return retval;
	}
}

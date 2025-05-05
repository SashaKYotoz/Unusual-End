
package net.mcreator.unusualend.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class CookedBlukItem extends Item {
	public CookedBlukItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 0), 1.0F).nutrition(6).saturationMod(0.5f).meat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 80;
	}
}

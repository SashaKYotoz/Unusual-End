
package net.mcreator.unusualend.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class CitrineGumItem extends Item {
	public CitrineGumItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)
				.food((new FoodProperties.Builder()).effect(new MobEffectInstance(MobEffects.LUCK, 300, 1), 1F).effect(new MobEffectInstance(MobEffects.ABSORPTION, 600, 1), 1F).nutrition(1).saturationMod(0.3f).alwaysEat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 48;
	}
}

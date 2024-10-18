
package net.mcreator.unusualend.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class PrismaticGumItem extends Item {
	public PrismaticGumItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)
				.food((new FoodProperties.Builder()).effect(new MobEffectInstance(MobEffects.DIG_SPEED, 300, 2), 1F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 2), 1F).nutrition(1).saturationMod(0.3f).alwaysEat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 48;
	}
}

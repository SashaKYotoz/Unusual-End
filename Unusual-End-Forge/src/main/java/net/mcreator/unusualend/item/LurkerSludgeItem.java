
package net.mcreator.unusualend.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class LurkerSludgeItem extends Item {
	public LurkerSludgeItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).effect(new MobEffectInstance(MobEffects.LEVITATION, 200, 0), 1.0F).nutrition(2).saturationMod(0.3f).alwaysEat().build()));
	}
}

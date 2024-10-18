
package net.mcreator.unusualend.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class WarpedSquashWedgeItem extends Item {
	public WarpedSquashWedgeItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 0), 1.0F).nutrition(4).saturationMod(0.4f).alwaysEat().build()));
	}
}

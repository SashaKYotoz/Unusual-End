
package net.mcreator.unusualend.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;

import net.mcreator.unusualend.init.UnusualendModItems;

public class SpectralHoeItem extends HoeItem {
	public SpectralHoeItem() {
		super(new Tier() {
			public int getUses() {
				return 1024;
			}

			public float getSpeed() {
				return 8f;
			}

			public float getAttackDamageBonus() {
				return 3f;
			}

			public int getLevel() {
				return 3;
			}

			public int getEnchantmentValue() {
				return 16;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(UnusualendModItems.PEARLESCENT_INGOT.get()));
			}
		}, 0, -3f, new Item.Properties().fireResistant());
	}
}

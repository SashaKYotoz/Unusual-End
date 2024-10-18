
package net.mcreator.unusualend.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.unusualend.init.UnusualendModItems;
import net.mcreator.unusualend.init.UnusualendModBlocks;

public class MoultDaggerItem extends SwordItem {
	public MoultDaggerItem() {
		super(new Tier() {
			public int getUses() {
				return 64;
			}

			public float getSpeed() {
				return 6f;
			}

			public float getAttackDamageBonus() {
				return -2f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 5;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(UnusualendModItems.END_BLOB.get()), new ItemStack(UnusualendModBlocks.ENDERBLOB_BLOCK.get()));
			}
		}, 3, -3f, new Item.Properties());
	}
}

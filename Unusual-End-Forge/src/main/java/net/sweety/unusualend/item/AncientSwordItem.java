
package net.sweety.unusualend.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.procedures.AncientSwordEntitySwingsItem2Procedure;

import java.util.List;

public class AncientSwordItem extends SwordItem {
	public AncientSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 1024;
			}

			public float getSpeed() {
				return 8f;
			}

			public float getAttackDamageBonus() {
				return 4f;
			}

			public int getLevel() {
				return 3;
			}

			public int getEnchantmentValue() {
				return 16;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(UnusualendModItems.ANCIENT_SHARD.get()));
			}
		}, 3, -2.1f, new Item.Properties().fireResistant());
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("tooltip.unusualend.ancient_sword.0"));
		list.add(Component.translatable("tooltip.unusualend.ancient_sword.1"));
		list.add(Component.translatable("tooltip.unusualend.ancient_sword.2"));
		list.add(Component.translatable("tooltip.unusualend.ancient_sword.3"));
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		AncientSwordEntitySwingsItem2Procedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
		return retval;
	}
}


//clear lev desc
package net.mcreator.unusualend.item;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.unusualend.procedures.WarpedAnchorToolInHandTickProcedure;
import net.mcreator.unusualend.procedures.WarpedAnchorLivingEntityIsHitWithToolProcedure;

import java.util.List;

public class WarpedAnchorItem extends PickaxeItem {
	public WarpedAnchorItem() {
		super(new Tier() {
			public int getUses() {
				return 1561;
			}

			public float getSpeed() {
				return 7.5f;
			}

			public float getAttackDamageBonus() {
				return 13f;
			}

			public int getLevel() {
				return 3;
			}

			public int getEnchantmentValue() {
				return 12;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Blocks.IRON_BLOCK));
			}
		}, 1, -3.3f, new Item.Properties());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		WarpedAnchorLivingEntityIsHitWithToolProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return retval;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77" + Component.translatable("lore.unusualend.on_hit").getString()));
		list.add(Component.literal("\u00A79" + Component.translatable("effect.unusualend.heaviness").getString() + " II (0:05)"));
		list.add(Component.literal("\u00A77" + Component.translatable("lore.unusualend.when_offhand").getString()));
		list.add(Component.literal("\u00A79" + Component.translatable("lore.unusualend.clear_levitation").getString()));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		WarpedAnchorToolInHandTickProcedure.execute(entity);
	}
}

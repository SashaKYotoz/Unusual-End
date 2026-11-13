
package net.sweety.unusualend.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.sweety.unusualend.entity.PhantomArrowProjectileEntity;
import net.sweety.unusualend.init.UnusualendModEntities;

public class PhantomArrowItem extends ArrowItem {
	public PhantomArrowItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public AbstractArrow createArrow(Level worldIn, ItemStack stack, LivingEntity shooter) {
		return new PhantomArrowProjectileEntity(UnusualendModEntities.PHANTOM_ARROW_PROJECTILE.get(), shooter, worldIn);
	}
}

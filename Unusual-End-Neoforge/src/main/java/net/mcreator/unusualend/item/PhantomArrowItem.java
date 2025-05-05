
package net.mcreator.unusualend.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.unusualend.init.UnusualendModEntities;
import net.mcreator.unusualend.entity.PhantomArrowProjectileEntity;

public class PhantomArrowItem extends ArrowItem {
	public PhantomArrowItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	//@Override
	//public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
	//	super.appendHoverText(itemstack, level, list, flag);
	//	list.add(Component.literal("\u00A77Not affected by Gravity"));
	//}
	@Override
	public AbstractArrow createArrow(Level worldIn, ItemStack stack, LivingEntity shooter) {
		return new PhantomArrowProjectileEntity(UnusualendModEntities.PHANTOM_ARROW_PROJECTILE.get(), shooter, worldIn);
	}
}

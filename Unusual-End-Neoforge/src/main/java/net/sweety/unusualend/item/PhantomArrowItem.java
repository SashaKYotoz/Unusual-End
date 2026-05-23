
package net.sweety.unusualend.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.sweety.unusualend.entity.PhantomArrowProjectileEntity;
import net.sweety.unusualend.init.UnusualEndEntities;
import org.jetbrains.annotations.Nullable;

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
	public AbstractArrow createArrow(Level level, ItemStack ammo, LivingEntity shooter, @Nullable ItemStack weapon) {
		return new PhantomArrowProjectileEntity(UnusualEndEntities.PHANTOM_ARROW_PROJECTILE.get(), shooter, level);
	}
}

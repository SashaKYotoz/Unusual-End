
package net.mcreator.unusualend.item;

import net.mcreator.unusualend.configuration.UEConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;

import net.mcreator.unusualend.procedures.WarpedInfusionPlayerFinishesUsingItemProcedure;

import java.util.List;

public class WarpedInfusionItem extends Item {
	public WarpedInfusionItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(0).saturationMod(0f).alwaysEat().build()));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.DRINK;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		double minute = (UEConfig.TENACITY_TIME.get() / 60);
		double seconds = (UEConfig.TENACITY_TIME.get() - (Math.floor(minute) * 60));
		String time = new java.text.DecimalFormat("00").format(minute) + ":" + new java.text.DecimalFormat("00").format(seconds);
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal(Component.translatable("effect.unusualend.warped_tenacity").getString() + " +1 (" + time + ")").withStyle(ChatFormatting.BLUE));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		WarpedInfusionPlayerFinishesUsingItemProcedure.execute(world, x, y, z, entity);
		return retval;
	}
}

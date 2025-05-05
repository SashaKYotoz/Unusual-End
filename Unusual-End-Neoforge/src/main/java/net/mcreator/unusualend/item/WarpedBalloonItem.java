
package net.mcreator.unusualend.item;

import net.minecraft.ChatFormatting;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.unusualend.procedures.WarpedBalloonRangedItemShootsProjectileProcedure;

import java.util.List;

public class WarpedBalloonItem extends Item {
	public WarpedBalloonItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.SPEAR;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 72000;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("lore.unusualend.when_valid_target").withStyle(ChatFormatting.GRAY));
		list.add(Component.translatable("lore.unusualend.ballon_capture_1").withStyle(ChatFormatting.BLUE));
		list.add(Component.translatable("lore.unusualend.ballon_capture_2").withStyle(ChatFormatting.BLUE));
		list.add(Component.translatable("lore.unusualend.can_leash").withStyle(ChatFormatting.DARK_GRAY));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(level, player, hand);
		WarpedBalloonRangedItemShootsProjectileProcedure.execute(level, player.getX(), player.getY(), player.getZ(), player, ar.getObject());
		return ar;
	}
}
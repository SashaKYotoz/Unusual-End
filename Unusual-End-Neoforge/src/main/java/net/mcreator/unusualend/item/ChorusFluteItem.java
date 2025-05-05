
package net.mcreator.unusualend.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.unusualend.procedures.ChorusFluteRightclickedProcedure;

import java.util.List;

public class ChorusFluteItem extends Item {
	public ChorusFluteItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.BOW;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 100;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		String track = "none";
		super.appendHoverText(itemstack, world, list, flag);
		track = (String) ((itemstack).getOrCreateTag().getString("track"));
		if ((itemstack.getOrCreateTag().getString("track")).equals("")) {
			itemstack.getOrCreateTag().putString("track", "All Tracks");
		}
		list.add(Component.literal("\u00A77" + ((track))));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		double x = player.getX();
		double y = player.getY();
		double z = player.getZ();
		if (!player.isUsingItem()) {
			ChorusFluteRightclickedProcedure.execute(world, player, itemstack);
		}
		if (getUseDuration(itemstack) <= 0) {
			finishUsingItem(itemstack, world, player);
		} else {
			player.startUsingItem(hand);
		}
		return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);
	}
}

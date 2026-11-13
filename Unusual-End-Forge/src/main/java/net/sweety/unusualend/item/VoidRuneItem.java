
package net.sweety.unusualend.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.sweety.unusualend.procedures.VoidRuneItemInHandTickProcedure;
import net.sweety.unusualend.procedures.VoidRuneMakeItemGlowProcedure;
import net.sweety.unusualend.procedures.VoidRuneRightclickedProcedure;

import java.util.List;

public class VoidRuneItem extends Item {
	public VoidRuneItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.BOW;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 32;
	}

	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return false;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return VoidRuneMakeItemGlowProcedure.execute(itemstack);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		double xp = 0;
		super.appendHoverText(itemstack, world, list, flag);
		xp = (itemstack).getOrCreateTag().getDouble("XP");
		list.add(Component.translatable("tooltip.unusualend.void_rune.0"));
		list.add(Component.translatable("tooltip.unusualend.void_rune.1"));
		list.add(Component.translatable("tooltip.unusualend.void_rune.2"));
		list.add(Component.translatable("tooltip.unusualend.void_rune.3"));
		list.add(Component.literal("\u00A79 - " + ((xp)) + " XP"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		VoidRuneRightclickedProcedure.execute(world, entity, itemstack);
		return ar;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			VoidRuneItemInHandTickProcedure.execute(world, entity, itemstack);
	}
}

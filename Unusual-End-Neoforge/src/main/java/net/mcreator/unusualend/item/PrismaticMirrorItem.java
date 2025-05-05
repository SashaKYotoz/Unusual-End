package net.mcreator.unusualend.item;

import net.minecraft.ChatFormatting;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.network.chat.Component;

import net.mcreator.unusualend.procedures.TPwithChorusProcedure;
import net.mcreator.unusualend.procedures.PrismaticPearlItemGlowProcedure;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

public class PrismaticMirrorItem extends Item {
	public PrismaticMirrorItem() {
		super(new Item.Properties().durability(32).rarity(Rarity.UNCOMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.BOW;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 48;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return PrismaticPearlItemGlowProcedure.execute(itemstack);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		double TpX;
		double TpY;
		double TpZ;
		super.appendHoverText(itemstack, world, list, flag);
		TpX = (itemstack).getOrCreateTag().getDouble("TpX");
		TpY = (itemstack).getOrCreateTag().getDouble("TpY");
		TpZ = (itemstack).getOrCreateTag().getDouble("TpZ");
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.translatable("lore.unusualend.when_rightclick").withStyle(ChatFormatting.GRAY));
		list.add(Component.translatable("lore.unusualend.warp_spawn").withStyle(ChatFormatting.BLUE));
		list.add(Component.translatable("lore.unusualend.when_linked").withStyle(ChatFormatting.GRAY));
		list.add(Component.translatable("lore.unusualend.warp_anchor").withStyle(ChatFormatting.BLUE));
		list.add(Component.literal("\u00A78● " + ((TpX)) + " " + ((TpY)) + " " + ((TpZ))));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		TPwithChorusProcedure.execute(world, entity, itemstack);
		return itemstack;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		ItemStack itemstack = entity.getItemInHand(hand);
		if (getUseDuration(itemstack) <= 0) {
			finishUsingItem(itemstack, world, entity);
		} else {
			entity.startUsingItem(hand);
		}
		if (!world.isClientSide) {
			world.playSound(null, entity, SoundEvents.BEACON_ACTIVATE, SoundSource.PLAYERS, 0.6f, 1.2f);
		}
		return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);
	}
	//@Override
	//public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
	//	super.inventoryTick(itemstack, world, entity, slot, selected);
	//	if (selected)
	//		TPConfirmProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
	//}
}

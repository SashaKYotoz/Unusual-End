
package net.sweety.unusualend.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.sweety.unusualend.procedures.VoidMirrorRightclickedProcedure;

import java.util.List;

public class VoidMirrorItem extends Item {
	public VoidMirrorItem() {
		super(new Item.Properties().durability(500).rarity(Rarity.UNCOMMON).component(DataComponents.CUSTOM_DATA, CustomData.EMPTY));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("tooltip.unusualend.void_mirror.0"));
		list.add(Component.translatable("tooltip.unusualend.void_mirror.1"));
		list.add(Component.translatable("tooltip.unusualend.void_mirror.2"));
		list.add(Component.translatable("tooltip.unusualend.void_mirror.3"));
		list.add(Component.translatable("tooltip.unusualend.void_mirror.4"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, player, hand);
		ItemStack itemstack = ar.getObject();
		double x = player.getX();
		double y = player.getY();
		double z = player.getZ();
		VoidMirrorRightclickedProcedure.execute(world, x, y, z, player, itemstack);
		return ar;
	}
}

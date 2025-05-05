
package net.mcreator.unusualend.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.unusualend.procedures.VoidMirrorRightclickedProcedure;

import java.util.List;

public class VoidMirrorItem extends Item {
	public VoidMirrorItem() {
		super(new Item.Properties().durability(500).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77When Right-Clicking:"));
		list.add(Component.literal("\u00A79Breach-Linked (5:00)"));
		list.add(Component.literal("\u00A77When the Effect expire:"));
		list.add(Component.literal("\u00A79Teleport back where"));
		list.add(Component.literal("\u00A79the item was used"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		VoidMirrorRightclickedProcedure.execute(world, x, y, z, entity, itemstack);
		return ar;
	}
}

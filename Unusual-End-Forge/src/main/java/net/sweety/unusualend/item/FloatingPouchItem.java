
//desc
package net.sweety.unusualend.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.sweety.unusualend.procedures.FloatingPouchRightclickedProcedure;

import java.util.List;

public class FloatingPouchItem extends Item {
	public FloatingPouchItem() {
		super(new Item.Properties().durability(384).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77" + Component.translatable("lore.unusualend.when_rightclick").getString()));
		list.add(Component.literal("\u00A79" + Component.translatable("lore.unusualend.floating_pouch_1").getString()));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		FloatingPouchRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}
}


package net.mcreator.unusualend.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class PrismaticPearlItem extends Item {
	public PrismaticPearlItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77When Used on"));
		list.add(Component.literal("\u00A77Gloopslate Pedestral:"));
		list.add(Component.literal("\u00A79Fill the Pedestral"));
	}
	//public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
	//	ItemStack itemStack = player.getItemInHand(hand);
	//	BlockHitResult hitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.NONE);
	//	player.startUsingItem(hand);
	//	if (level instanceof ServerLevel) {
	//		ServerLevel serverLevel = (ServerLevel) level;
	//		BlockPos nearestStructure = serverLevel.findNearestMapStructure((TagKey.create(Registries.STRUCTURE, UnusualEnd.makeUEID("prismatic_eye_located"))), player.blockPosition(), 100, false);
	//		if (nearestStructure != null) {
	//			EyeOfEnder eyeOfEnder = new EyeOfEnder(level, player.getX(), player.getY(0.5D), player.getZ());
	//			eyeOfEnder.setItem(itemStack);
	//			eyeOfEnder.signalTo(nearestStructure);
	//			level.gameEvent(GameEvent.PROJECTILE_SHOOT, eyeOfEnder.position(), GameEvent.Context.of(player));
	//			level.addFreshEntity(eyeOfEnder);
	//			if (player instanceof ServerPlayer) {
	//				CriteriaTriggers.USED_ENDER_EYE.trigger((ServerPlayer) player, nearestStructure);
	//			}
	//			level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDER_EYE_LAUNCH, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
	//			level.levelEvent(null, 1003, player.blockPosition(), 0);
	//			if (!player.getAbilities().instabuild) {
	//				itemStack.shrink(1);
	//			}
	//			player.awardStat(Stats.ITEM_USED.get(this));
	//			player.swing(hand, true);
	//			return InteractionResultHolder.success(itemStack);
	//		}
	//	}
	//	return InteractionResultHolder.consume(itemStack);
	//}
}

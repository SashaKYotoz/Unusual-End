
package net.sweety.unusualend.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.sweety.unusualend.procedures.ChorusFluteRightclickedProcedure;
import net.sweety.unusualend.procedures.NBTProcessor;

import java.util.List;

public class ChorusFluteItem extends Item {
    public ChorusFluteItem() {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).component(DataComponents.CUSTOM_DATA, CustomData.EMPTY));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemstack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack itemstack, LivingEntity entity) {
        return 100;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(stack, context, list, flag);

        String track = NBTProcessor.getNBTString(stack, "track");
        if (track.isEmpty() || track.equalsIgnoreCase("All Tracks"))
            list.add(Component.translatable("text.unusualend.all_tracks").withStyle(ChatFormatting.GRAY));
        else
            list.add(Component.literal(track).withStyle(ChatFormatting.GRAY));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (!player.isUsingItem())
            ChorusFluteRightclickedProcedure.execute(level, player, itemstack);
        if (getUseDuration(itemstack, player) <= 0)
            finishUsingItem(itemstack, level, player);
        else
            player.startUsingItem(hand);
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);
    }
}

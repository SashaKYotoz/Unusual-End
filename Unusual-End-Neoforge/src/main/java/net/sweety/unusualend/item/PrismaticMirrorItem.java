package net.sweety.unusualend.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.sweety.unusualend.procedures.NBTProcessor;
import net.sweety.unusualend.procedures.TPwithChorusProcedure;

import java.util.List;

public class PrismaticMirrorItem extends Item {
    public PrismaticMirrorItem() {
        super(new Item.Properties().durability(32).rarity(Rarity.UNCOMMON)
                .component(DataComponents.CUSTOM_DATA, CustomData.EMPTY));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemstack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack itemstack, LivingEntity entity) {
        return 48;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isFoil(ItemStack stack) {
        return NBTProcessor.getNBTBoolean(stack,"LinkedMirror") || NBTProcessor.getNBTBoolean(stack,"LinkedTotem");
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> list, TooltipFlag flag) {
        double TpX;
        double TpY;
        double TpZ;
        super.appendHoverText(stack, context, list, flag);
        TpX = NBTProcessor.getNBTDouble(stack, "TpX");
        TpY = NBTProcessor.getNBTDouble(stack, "TpY");
        TpZ = NBTProcessor.getNBTDouble(stack, "TpZ");
        super.appendHoverText(stack, context, list, flag);
        list.add(Component.translatable("lore.unusualend.when_rightclick").withStyle(ChatFormatting.GRAY));
        list.add(Component.translatable("lore.unusualend.warp_spawn").withStyle(ChatFormatting.BLUE));
        list.add(Component.translatable("lore.unusualend.when_linked").withStyle(ChatFormatting.GRAY));
        list.add(Component.translatable("lore.unusualend.warp_anchor").withStyle(ChatFormatting.BLUE));
        list.add(Component.literal("\u00A78● " + ((TpX)) + " " + ((TpY)) + " " + ((TpZ))));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemstack, Level level, LivingEntity entity) {
        TPwithChorusProcedure.execute(level, entity, itemstack);
        return itemstack;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (getUseDuration(itemstack, player) <= 0) {
            finishUsingItem(itemstack, level, player);
        } else
            player.startUsingItem(hand);
        if (!level.isClientSide()) {
            level.playSound(null, player, SoundEvents.BEACON_ACTIVATE, SoundSource.PLAYERS, 0.6f, 1.2f);
        }
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);
    }
}

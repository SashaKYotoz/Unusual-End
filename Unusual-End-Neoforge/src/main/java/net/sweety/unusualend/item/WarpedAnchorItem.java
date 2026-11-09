package net.sweety.unusualend.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.procedures.WarpedAnchorLivingEntityIsHitWithToolProcedure;

import java.util.List;

public class WarpedAnchorItem extends PickaxeItem {
    public WarpedAnchorItem() {
        super(ModTiers.ANCHOR, new Item.Properties().attributes(PickaxeItem.createAttributes(ModTiers.ANCHOR,14,-3.3f)));
    }

    @Override
    public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        WarpedAnchorLivingEntityIsHitWithToolProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
        return super.hurtEnemy(itemstack, entity, sourceentity);
    }

    @Override
    public void appendHoverText(ItemStack itemstack, TooltipContext context, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, context, list, flag);
        list.add(Component.translatable("lore.unusualend.on_hit").withStyle(ChatFormatting.GRAY));
        list.add(Component.translatable("tooltip.unusualend.warped_anchor.0").withStyle(ChatFormatting.BLUE));
        list.add(Component.translatable("lore.unusualend.when_offhand").withStyle(ChatFormatting.GRAY));
        list.add(Component.translatable("lore.unusualend.clear_levitation").withStyle(ChatFormatting.BLUE));
    }

    @Override
    public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemstack, world, entity, slot, selected);
        if (entity instanceof LivingEntity livingEntity && livingEntity.getOffhandItem().is(UnusualEndItems.WARPED_ANCHOR.get())) {
            if (livingEntity.hasEffect(MobEffects.LEVITATION))
                livingEntity.removeEffect(MobEffects.LEVITATION);

        }
    }
}

package net.sweety.unusualend.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.sweety.unusualend.procedures.LeechingWandItemInInventoryTickProcedure;
import net.sweety.unusualend.procedures.NBTProcessor;

import java.util.List;

public class LeechingWandItem extends Item {
    public LeechingWandItem() {
        super(new Item.Properties().durability(256).rarity(Rarity.COMMON).component(DataComponents.CUSTOM_DATA, CustomData.EMPTY));
    }

    @Override
    public int getEnchantmentValue() {
        return 16;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return stack.getDamageValue() > 0 || NBTProcessor.getNBTDouble(stack, "rayCooldown") < 400 && NBTProcessor.getNBTDouble(stack, "rayCooldown") > 0 || stack.getDamageValue() > 0 && NBTProcessor.getNBTDouble(stack, "rayCooldown") < 400;
    }

    @Override
    public int getBarColor(ItemStack stack) {
        if (NBTProcessor.getNBTDouble(stack, "rayCooldown") < 400) {
            return 16400310;
        }
        return Mth.hsvToRgb(Math.max(0.0F, 1.0F - (float) stack.getDamageValue() / stack.getMaxDamage()) / 3.0F, 1.0F, 1.0F);
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        if (NBTProcessor.getNBTDouble(stack, "rayCooldown") < 400) {
            return (int) (NBTProcessor.getNBTDouble(stack, "rayCooldown") * 0.0025f * 14f);
        }
        return Math.round(13.0F - (float) stack.getDamageValue() / stack.getMaxDamage() * 13.0F);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }

    @Override
    public void appendHoverText(ItemStack itemstack, TooltipContext context, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, context, list, flag);
        list.add(Component.translatable("lore.unusualend.hold_shooting").withStyle(ChatFormatting.DARK_GRAY));
        list.add(Component.translatable("lore.unusualend.on_hit").withStyle(ChatFormatting.GRAY));
        list.add(Component.translatable("tooltip.unusualend.leeching_wand.0"));
    }

    @Override
    public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemstack, world, entity, slot, selected);
        LeechingWandItemInInventoryTickProcedure.execute(world, entity, itemstack);
    }
}

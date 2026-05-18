
package net.sweety.unusualend.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.sweety.unusualend.procedures.NBTProcessor;
import net.sweety.unusualend.procedures.PearlescentRingInventoryTickProcedure;

import java.util.List;

public class PearlescentRingItem extends Item {
    public PearlescentRingItem() {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).component(DataComponents.CUSTOM_DATA, CustomData.EMPTY));
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return NBTProcessor.getNBTDouble(stack, "ringCooldown") < 400 && NBTProcessor.getNBTDouble(stack, "ringCooldown") > 0;
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return 16400310;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        return (int) (NBTProcessor.getNBTDouble(stack, "ringCooldown") * 0.0025f * 14f);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }

    @Override
    public void appendHoverText(ItemStack itemstack, TooltipContext context, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, context, list, flag);
        list.add(Component.translatable("lore.unusualend.when_offhand").withStyle(ChatFormatting.GRAY));
        list.add(Component.translatable("lore.unusualend.on_hit").withStyle(ChatFormatting.GRAY));
        list.add(Component.translatable("lore.unusualend.spirit_ring_1").withStyle(ChatFormatting.BLUE));
        list.add(Component.translatable("lore.unusualend.spirit_ring_2").withStyle(ChatFormatting.BLUE));
    }

    @Override
    public void inventoryTick(ItemStack itemstack, Level level, Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemstack, level, entity, slot, selected);
        PearlescentRingInventoryTickProcedure.execute(itemstack, level);
    }
}
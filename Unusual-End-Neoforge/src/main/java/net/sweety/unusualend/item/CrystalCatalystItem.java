package net.sweety.unusualend.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.sweety.unusualend.procedures.CrystalCatalystItemInInventoryTickProcedure;
import net.sweety.unusualend.procedures.CrystalCatalystRightclickedProcedure;
import net.sweety.unusualend.procedures.NBTProcessor;

import java.util.List;

public class CrystalCatalystItem extends Item {
    public CrystalCatalystItem() {
        super(new Item.Properties().durability(64).rarity(Rarity.UNCOMMON).component(DataComponents.CUSTOM_DATA, CustomData.EMPTY));
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {

        return stack.getDamageValue() > 0 || NBTProcessor.getNBTDouble(stack, "cataCooldown") < 400 && NBTProcessor.getNBTDouble(stack, "cataCooldown") > 0 || stack.getDamageValue() > 0 && NBTProcessor.getNBTDouble(stack, "cataCooldown") < 400;
    }

    @Override
    public int getBarColor(ItemStack stack) {
        if (NBTProcessor.getNBTDouble(stack, "cataCooldown") < 400)
            return 11050480;
        return Mth.hsvToRgb(Math.max(0.0F, 1.0F - (float) stack.getDamageValue() / stack.getMaxDamage()) / 3.0F, 1.0F, 1.0F);
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        if (NBTProcessor.getNBTDouble(stack, "cataCooldown") < 400)
            return (int) (NBTProcessor.getNBTDouble(stack, "cataCooldown") * 0.0025f * 14f);
        return Math.round(13.0F - (float) stack.getDamageValue() / stack.getMaxDamage() * 13.0F);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(stack, context, list, flag);
        String buff = NBTProcessor.getNBTString(stack, "buff");
        if (NBTProcessor.getNBTString(stack, "buff").isEmpty())
            NBTProcessor.setNBTString(stack, "track", "No Current Buff");
        list.add(Component.translatable("lore.unusualend.valid_blocs").withStyle(ChatFormatting.DARK_GRAY));
        list.add(Component.translatable("lore.unusualend.when_rightclick").withStyle(ChatFormatting.GRAY));
        list.add(Component.translatable("lore.unusualend.consume_effects").withStyle(ChatFormatting.BLUE));
        list.add(Component.translatable("lore.unusualend.current_buff").withStyle(ChatFormatting.BLUE));
        list.add(Component.literal("\u00A79 - " + ((buff))));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(level, entity, hand);
        ItemStack itemstack = ar.getObject();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        CrystalCatalystRightclickedProcedure.execute(level, x, y, z, entity, itemstack);
        return ar;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, level, entity, slot, selected);
        CrystalCatalystItemInInventoryTickProcedure.execute(stack, level);
    }
}

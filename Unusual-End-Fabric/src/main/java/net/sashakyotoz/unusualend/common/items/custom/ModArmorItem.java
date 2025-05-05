package net.sashakyotoz.unusualend.common.items.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.sashakyotoz.unusualend.common.effects.ModEffects;
import net.sashakyotoz.unusualend.common.items.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModArmorItem extends ArmorItem {
    public ModArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> list, TooltipContext context) {
        super.appendTooltip(stack, world, list, context);
        if (stack.isOf(ModItems.SPECTRAL_LEGGINGS)) {
            list.add(Text.translatable("lore.unusualend.when_sprint").formatted(Formatting.GRAY));
            list.add(Text.literal(Text.translatable("effect.unusualend.spectral_stride").getString() + " (0:03)").formatted(Formatting.BLUE));
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (stack.isOf(ModItems.SPECTRAL_LEGGINGS)) {
            if (entity instanceof LivingEntity entity1) {
                if (!entity1.hasStatusEffect(ModEffects.SPECTRAL_STRIDE) && entity1.getEquippedStack(EquipmentSlot.LEGS).equals(stack) && entity1.isSprinting())
                    entity1.addStatusEffect(new StatusEffectInstance(ModEffects.SPECTRAL_STRIDE, 30, 0));
            }
        }
    }
}
package net.sashakyotoz.unusualend.common.items.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CustomSmithingTemplateItem extends Item {
    public CustomSmithingTemplateItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.translatable("upgrade.unusualend.pearlescent_upgrade").formatted(Formatting.GRAY));
        tooltip.add(ScreenTexts.EMPTY);
        tooltip.add(Text.translatable("item.minecraft.smithing_template.applies_to").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("item.minecraft.smithing_template.netherite_upgrade.applies_to").formatted(Formatting.BLUE));
        tooltip.add(Text.translatable("item.minecraft.smithing_template.ingredients").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("item.unusualend.pearlescent_ingot").formatted(Formatting.BLUE));
    }
}
package net.sashakyotoz.unusualend.common.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractPlantBlock;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.FluidBlock;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.sashakyotoz.unusualend.UnusualEnd;
import net.sashakyotoz.unusualend.common.ModRegistry;
import net.sashakyotoz.unusualend.common.blocks.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup UNUSUAL_END_ITEMS = register("unusual_end_items",
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.unusualend.items"))
                    .icon(() -> new ItemStack(ModItems.PEARLESCENT_SWORD))
                    .entries((displayContext, entries) -> ModRegistry.ITEMS.forEach(item -> {
                        if (!(item instanceof BlockItem))
                            entries.add(item);
                    })).build());
    public static final ItemGroup UNUSUAL_END_BLOCKS = register("unusual_end_blocks",
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.unusualend.blocks"))
                    .icon(() -> new ItemStack(ModBlocks.PEARLESCENT_BLOCK))
                    .entries((displayContext, entries) -> ModRegistry.BLOCKS.forEach(block -> {
                        if (!block.getTranslationKey().contains("sign") && !(block instanceof FluidBlock) && (!(block instanceof AbstractPlantBlock) && (!(block instanceof AbstractPlantStemBlock))))
                            entries.add(block);
                    })).build());

    public static ItemGroup register(String id, ItemGroup tab) {
        return Registry.register(Registries.ITEM_GROUP, UnusualEnd.makeID(id), tab);
    }

    public static void register() {
        UnusualEnd.log("Registering ItemGroups for modid : " + UnusualEnd.MOD_ID);
    }
}
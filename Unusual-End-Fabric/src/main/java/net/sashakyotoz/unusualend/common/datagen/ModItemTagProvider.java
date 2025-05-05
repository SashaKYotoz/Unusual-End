package net.sashakyotoz.unusualend.common.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.sashakyotoz.unusualend.common.ModRegistry;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider{
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        for (TagKey<Item> tag : ModRegistry.ITEM_TAGS.keySet()) {
            FabricTagProvider<Item>.FabricTagBuilder builder = getOrCreateTagBuilder(tag);
            for (Item item : ModRegistry.ITEM_TAGS.get(tag)) {
                builder.add(item);
            }
        }
        for(Item item : ModRegistry.ITEMS){
            if (item instanceof ArmorItem armorItem)
                this.getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR).add(armorItem);
        }
    }
}
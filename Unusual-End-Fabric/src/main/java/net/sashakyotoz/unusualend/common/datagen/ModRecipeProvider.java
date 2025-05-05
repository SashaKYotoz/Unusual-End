package net.sashakyotoz.unusualend.common.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.sashakyotoz.unusualend.common.ModRegistry;
import net.sashakyotoz.unusualend.common.blocks.ModBlocks;
import net.sashakyotoz.unusualend.common.items.ModItems;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        for (Block parent : ModRegistry.BLOCK_SETS.keySet()) {
            for (Map.Entry<ModRegistry.Models, Block> entry : ModRegistry.BLOCK_SETS.get(parent).entrySet()) {
                if (entry.getKey() == ModRegistry.Models.STAIRS)
                    createStairsRecipe(entry.getValue(), Ingredient.ofItems(parent))
                            .criterion(hasItem(parent), conditionsFromItem(parent))
                            .offerTo(exporter);

                if (entry.getKey() == ModRegistry.Models.SLAB)
                    offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.getValue(), parent);

                if (entry.getKey() == ModRegistry.Models.PRESSURE_PLATE)
                    offerPressurePlateRecipe(exporter, entry.getValue(), parent);

                if (entry.getKey() == ModRegistry.Models.BUTTON)
                    offerSingleOutputShapelessRecipe(exporter, entry.getValue(), parent, "mod_buttons");

                if (entry.getKey() == ModRegistry.Models.FENCE)
                    createFenceRecipe(entry.getValue(), Ingredient.ofItems(parent))
                            .criterion(hasItem(parent), conditionsFromItem(parent))
                            .offerTo(exporter);

                if (entry.getKey() == ModRegistry.Models.FENCE_GATE)
                    createFenceGateRecipe(entry.getValue(), Ingredient.ofItems(parent))
                            .criterion(hasItem(parent), conditionsFromItem(parent))
                            .offerTo(exporter);

                if (entry.getKey() == ModRegistry.Models.TRAPDOOR)
                    createTrapdoorRecipe(entry.getValue(), Ingredient.ofItems(parent))
                            .criterion(hasItem(parent), conditionsFromItem(parent))
                            .offerTo(exporter);

                if (entry.getKey() == ModRegistry.Models.DOOR)
                    createDoorRecipe(entry.getValue(), Ingredient.ofItems(parent))
                            .criterion(hasItem(parent), conditionsFromItem(parent))
                            .offerTo(exporter);

                if (entry.getKey() == ModRegistry.Models.SIGN)
                    createSignRecipe(entry.getValue(), Ingredient.ofItems(parent))
                            .criterion(hasItem(parent), conditionsFromItem(parent))
                            .offerTo(exporter);

                if (entry.getKey() == ModRegistry.Models.PANE)
                    ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, entry.getValue(), 16)
                            .input('#', parent)
                            .pattern("###").pattern("###")
                            .group(Registries.ITEM.getId(entry.getValue().asItem()).getPath())
                            .criterion(hasItem(parent), conditionsFromItem(parent))
                            .offerTo(exporter);
            }
        }

        //ingots recipes
//        offerBlasting(exporter, List.of(ModBlocks.ABYSSAL_ORE_IN_DARK_CURRANTSLATE, ModBlocks.ABYSSAL_ORE_IN_GLACIEMITE),
//                RecipeCategory.TOOLS, ModItems.RAW_ABYSSAL_ORE, 10, 400, "abyssal_ore");
        offerReversibleCompactingRecipes(exporter,RecipeCategory.MISC, ModItems.PEARLESCENT_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PEARLESCENT_BLOCK);

        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_PURPUR, ModBlocks.RAW_PURPUR_BLOCK);

//        generateHelmetRecipe(exporter, ModItems.PEARLESCENT_INGOT, ModItems.UNSEENIUM_HELMET);
//        generateChestplateRecipe(exporter, ModItems.PEARLESCENT_INGOT, ModItems.UNSEENIUM_CHESTPLATE);
//        generateLeggingsRecipe(exporter, ModItems.PEARLESCENT_INGOT, ModItems.UNSEENIUM_LEGGINGS);
//        generateBootsRecipe(exporter, ModItems.PEARLESCENT_INGOT, ModItems.UNSEENIUM_BOOTS);
    }

    private void generateHelmetRecipe(Consumer<RecipeJsonProvider> exporter, Item ingredient, Item result) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, result)
                .input('X', ingredient)
                .pattern("XXX")
                .pattern("X X")
                .criterion("has_ingredient", conditionsFromItem(ingredient))
                .offerTo(exporter);
    }

    private void generateChestplateRecipe(Consumer<RecipeJsonProvider> exporter, Item ingredient, Item result) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, result)
                .input('X', ingredient)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .criterion("has_ingredient", conditionsFromItem(ingredient))
                .offerTo(exporter);
    }

    private void generateLeggingsRecipe(Consumer<RecipeJsonProvider> exporter, Item ingredient, Item result) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, result)
                .input('X', ingredient)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .criterion("has_ingredient", conditionsFromItem(ingredient))
                .offerTo(exporter);
    }

    private void generateBootsRecipe(Consumer<RecipeJsonProvider> exporter, Item ingredient, Item result) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, result)
                .input('X', ingredient)
                .pattern("X X")
                .pattern("X X")
                .criterion("has_ingredient", conditionsFromItem(ingredient))
                .offerTo(exporter);
    }
}
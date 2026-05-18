package net.sweety.unusualend.jei_recipes;

import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.crafting.SizedIngredient;

public class BolokTradingRecipe implements Recipe<CraftingInput> {
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public BolokTradingRecipe(ItemStack output, NonNullList<Ingredient> recipeItems) {
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public boolean matches(CraftingInput craftingInput, Level level) {
        return false;
    }

    @Override
    public ItemStack assemble(CraftingInput craftingInput, HolderLookup.Provider provider) {
        return output;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    public static class Type implements RecipeType<BolokTradingRecipe> {
        private Type() {
        }

        public static final Type INSTANCE = new Type();
    }

    public static class Serializer implements RecipeSerializer<BolokTradingRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        private static final MapCodec<BolokTradingRecipe> CODEC = RecordCodecBuilder.mapCodec(
                builder -> builder.group(
                                ItemStack.STRICT_CODEC.fieldOf("output").forGetter(recipe -> recipe.output),
                                Ingredient.CODEC_NONEMPTY
                                        .listOf()
                                        .fieldOf("ingredients")
                                        .flatXmap(
                                                ingredients -> {
                                                    Ingredient[] aingredient = ingredients
                                                            .toArray(Ingredient[]::new);
                                                    if (aingredient.length == 0) {
                                                        return DataResult.error(() -> "No ingredients found in custom recipe");
                                                    } else {
                                                        return DataResult.success(NonNullList.of(Ingredient.EMPTY, aingredient));
                                                    }
                                                },
                                                DataResult::success
                                        )
                                        .forGetter(recipe -> recipe.recipeItems)
                        )
                        .apply(builder, BolokTradingRecipe::new)
        );
        public static final StreamCodec<RegistryFriendlyByteBuf, BolokTradingRecipe> STREAM_CODEC = StreamCodec.of(BolokTradingRecipe.Serializer::toNetwork, BolokTradingRecipe.Serializer::fromNetwork);

        @Override
        public MapCodec<BolokTradingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, BolokTradingRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        private static BolokTradingRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            ItemStack output = ItemStack.STREAM_CODEC.decode(buffer);
            int count = buffer.readVarInt();
            NonNullList<Ingredient> inputs = NonNullList.withSize(count, Ingredient.EMPTY);

            for (int i = 0; i < count; i++) {
                SizedIngredient sized = SizedIngredient.STREAM_CODEC.decode(buffer);
                inputs.set(i, sized.ingredient());
            }
            return new BolokTradingRecipe(output, inputs);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buffer, BolokTradingRecipe recipe) {
            ItemStack.STREAM_CODEC.encode(buffer, recipe.output);
            buffer.writeVarInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.recipeItems) {
                SizedIngredient sized = new SizedIngredient(ing, 1);
                SizedIngredient.STREAM_CODEC.encode(buffer, sized);
            }
        }
    }
}

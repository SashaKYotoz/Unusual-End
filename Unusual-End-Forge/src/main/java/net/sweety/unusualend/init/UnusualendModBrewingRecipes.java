package net.sweety.unusualend.init;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.vanilla.IJeiBrewingRecipe;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.sweety.unusualend.recipes.brewing.UnusualEndBrewingRecipes;

import java.util.ArrayList;
import java.util.List;

@JeiPlugin
public class UnusualendModBrewingRecipes implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("unusualend:brewing_recipes");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		IVanillaRecipeFactory factory = registration.getVanillaRecipeFactory();
		List<IJeiBrewingRecipe> brewingRecipes = new ArrayList<>();
		for (UnusualEndBrewingRecipes.PotionMix mix : UnusualEndBrewingRecipes.POTION_MIXES)
			brewingRecipes.add(factory.createBrewingRecipe(List.of(new ItemStack(mix.ingredient().get())), UnusualEndBrewingRecipes.potion(mix.input().get()), UnusualEndBrewingRecipes.potion(mix.output().get())));
		for (UnusualEndBrewingRecipes.ItemMix mix : UnusualEndBrewingRecipes.ITEM_MIXES)
			brewingRecipes.add(factory.createBrewingRecipe(List.of(new ItemStack(mix.ingredient().get())), List.of(mix.displayInput()), mix.output().get()));
		registration.addRecipes(RecipeTypes.BREWING, brewingRecipes);
	}
}

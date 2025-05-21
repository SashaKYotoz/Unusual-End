
package net.mcreator.unusualend.init;

import net.mcreator.unusualend.UnusualEnd;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.unusualend.jei_recipes.InfuserRecipeCategory;
import net.mcreator.unusualend.jei_recipes.InfuserRecipe;
import net.mcreator.unusualend.jei_recipes.BolokTradingRecipeCategory;
import net.mcreator.unusualend.jei_recipes.BolokTradingRecipe;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.Objects;
import java.util.List;
import java.util.stream.Collectors;

@JeiPlugin
public class UnusualendModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<BolokTradingRecipe> BolokTrading_Type = new mezz.jei.api.recipe.RecipeType<>(BolokTradingRecipeCategory.UID, BolokTradingRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<InfuserRecipe> Infuser_Type = new mezz.jei.api.recipe.RecipeType<>(InfuserRecipeCategory.UID, InfuserRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return UnusualEnd.makeUEID("jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new BolokTradingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new InfuserRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<BolokTradingRecipe> BolokTradingRecipes = recipeManager.getAllRecipesFor(BolokTradingRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(BolokTrading_Type, BolokTradingRecipes);
		List<InfuserRecipe> InfuserRecipes = recipeManager.getAllRecipesFor(InfuserRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(Infuser_Type, InfuserRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(UnusualendModItems.BOLOK_SPAWN_EGG.get()), BolokTrading_Type);
		registration.addRecipeCatalyst(new ItemStack(UnusualendModBlocks.PEARLESCENT_INFUSER.get().asItem()), Infuser_Type);
	}
}

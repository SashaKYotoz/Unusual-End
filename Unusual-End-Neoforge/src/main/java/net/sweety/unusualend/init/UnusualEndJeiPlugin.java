
package net.sweety.unusualend.init;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.jei_recipes.BolokTradingRecipe;
import net.sweety.unusualend.jei_recipes.BolokTradingRecipeCategory;
import net.sweety.unusualend.jei_recipes.InfuserRecipe;
import net.sweety.unusualend.jei_recipes.InfuserRecipeCategory;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@JeiPlugin
public class UnusualEndJeiPlugin implements IModPlugin {
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
		registration.addRecipeCatalyst(new ItemStack(UnusualEndItems.BOLOK_SPAWN_EGG.get()), BolokTrading_Type);
		registration.addRecipeCatalyst(new ItemStack(UnusualEndBlocks.PEARLESCENT_INFUSER.get().asItem()), Infuser_Type);
	}
}

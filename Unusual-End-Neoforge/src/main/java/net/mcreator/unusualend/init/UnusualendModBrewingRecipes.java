
package net.mcreator.unusualend.init;

import net.mcreator.unusualend.UnusualEnd;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.recipe.vanilla.IJeiBrewingRecipe;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.List;
import java.util.ArrayList;

@JeiPlugin
public class UnusualendModBrewingRecipes implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return UnusualEnd.makeUEID("brewing_recipes");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		IVanillaRecipeFactory factory = registration.getVanillaRecipeFactory();
		List<IJeiBrewingRecipe> brewingRecipes = new ArrayList<>();
		ItemStack potion = new ItemStack(Items.POTION);
		ItemStack potion2 = new ItemStack(Items.POTION);
		List<ItemStack> ingredientStack = new ArrayList<>();
		List<ItemStack> inputStack = new ArrayList<>();
		ingredientStack.add(new ItemStack(UnusualendModItems.END_BLOB.get()));
		PotionUtils.setPotion(potion, Potions.AWKWARD);
		PotionUtils.setPotion(potion2, UnusualendModPotions.END_INFECTION.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(UnusualendModItems.LURKER_SLUDGE.get()));
		PotionUtils.setPotion(potion, Potions.AWKWARD);
		PotionUtils.setPotion(potion2, UnusualendModPotions.LEVITATION.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(UnusualendModItems.GOLEM_ORB.get()));
		PotionUtils.setPotion(potion, Potions.AWKWARD);
		PotionUtils.setPotion(potion2, UnusualendModPotions.BUILDING_POTION.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(UnusualendModItems.SHINY_CRYSTAL.get()));
		PotionUtils.setPotion(potion, Potions.LONG_REGENERATION);
		PotionUtils.setPotion(potion2, UnusualendModPotions.REGENERATION.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(UnusualendModItems.SHINY_CRYSTAL.get()));
		PotionUtils.setPotion(potion, Potions.STRONG_REGENERATION);
		PotionUtils.setPotion(potion2, UnusualendModPotions.REGENERATION_II.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(UnusualendModItems.WARPED_SPORES.get()));
		PotionUtils.setPotion(potion, Potions.WATER);
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), new ItemStack(UnusualendModItems.WARPED_POTION.get())));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(UnusualendModItems.BOLOK_SCALE.get()));
		PotionUtils.setPotion(potion, Potions.AWKWARD);
		PotionUtils.setPotion(potion2, UnusualendModPotions.HEAVINESS_POTION.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(UnusualendModItems.CITRINE_CHUNK.get()));
		PotionUtils.setPotion(potion, Potions.AWKWARD);
		PotionUtils.setPotion(potion2, UnusualendModPotions.SERENITY_POTION.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(UnusualendModItems.PRISMALITE_GEM.get()));
		PotionUtils.setPotion(potion, Potions.AWKWARD);
		PotionUtils.setPotion(potion2, UnusualendModPotions.SWIFT_STRIKES_POTION.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(UnusualendModItems.BOLOK_SCALE.get()));
		inputStack.add(new ItemStack(UnusualendModItems.WARPED_POTION.get()));
		PotionUtils.setPotion(potion, UnusualendModPotions.RESISTANCE.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), potion.copy()));
		ingredientStack.clear();
		inputStack.clear();
		ingredientStack.add(new ItemStack(UnusualendModItems.SHINY_CRYSTAL.get()));
		inputStack.add(new ItemStack(UnusualendModItems.WARPED_POTION.get()));
		PotionUtils.setPotion(potion, UnusualendModPotions.HEALTH_BOOST.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), potion.copy()));
		ingredientStack.clear();
		inputStack.clear();
		ingredientStack.add(new ItemStack(UnusualendModItems.ENDERBULB_LENS.get()));
		PotionUtils.setPotion(potion, Potions.AWKWARD);
		PotionUtils.setPotion(potion2, Potions.LONG_NIGHT_VISION);
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(UnusualendModItems.CHORUS_PETAL.get()));
		inputStack.add(new ItemStack(UnusualendModItems.CHORUS_JUICE.get()));
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), new ItemStack(UnusualendModItems.CHORUS_TEA.get())));
		inputStack.clear();
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(UnusualendModItems.COOKED_BLUK.get()));
		inputStack.add(new ItemStack(UnusualendModItems.WARPED_POTION.get()));
		PotionUtils.setPotion(potion, UnusualendModPotions.STRENGTH.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), potion.copy()));
		ingredientStack.clear();
		inputStack.clear();
		ingredientStack.add(new ItemStack(UnusualendModItems.GLOOPILON_SLICE.get()));
		PotionUtils.setPotion(potion, Potions.AWKWARD);
		PotionUtils.setPotion(potion2, UnusualendModPotions.HASTE.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(Items.REDSTONE));
		PotionUtils.setPotion(potion, UnusualendModPotions.HASTE.get());
		PotionUtils.setPotion(potion2, UnusualendModPotions.ADVANCED_HASTE.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		registration.addRecipes(RecipeTypes.BREWING, brewingRecipes);
	}
}


package net.mcreator.unusualend.jei_recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.unusualend.init.UnusualendModJeiPlugin;
import net.mcreator.unusualend.init.UnusualendModBlocks;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

public class InfuserRecipeCategory implements IRecipeCategory<InfuserRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("unusualend", "infuser");
	public final static ResourceLocation TEXTURE = new ResourceLocation("unusualend", "textures/screens/pearlescent_infuser_jei.png");
	private final IDrawable background;
	private final IDrawable icon;

	public InfuserRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 94, 43);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(UnusualendModBlocks.PEARLESCENT_INFUSER.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<InfuserRecipe> getRecipeType() {
		return UnusualendModJeiPlugin.Infuser_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Infusing");
	}

	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, InfuserRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 4, 4).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 49, 24).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 73, 4).addItemStack(recipe.getResultItem(null));
	}
}

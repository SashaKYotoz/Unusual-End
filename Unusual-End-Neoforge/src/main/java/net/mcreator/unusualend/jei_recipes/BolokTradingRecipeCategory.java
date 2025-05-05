
package net.mcreator.unusualend.jei_recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.unusualend.init.UnusualendModJeiPlugin;
import net.mcreator.unusualend.init.UnusualendModItems;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

public class BolokTradingRecipeCategory implements IRecipeCategory<BolokTradingRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("unusualend", "bolok_trading");
	public final static ResourceLocation TEXTURE = new ResourceLocation("unusualend", "textures/screens/bolok_trade_jei.png");
	private final IDrawable background;
	private final IDrawable icon;

	public BolokTradingRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 51);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(UnusualendModItems.BOLOK_BUCKET.get()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<BolokTradingRecipe> getRecipeType() {
		return UnusualendModJeiPlugin.BolokTrading_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Bolok Trading");
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
	public void setRecipe(IRecipeLayoutBuilder builder, BolokTradingRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 8, 19).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 152, 19).addItemStack(recipe.getResultItem(null));
	}
}

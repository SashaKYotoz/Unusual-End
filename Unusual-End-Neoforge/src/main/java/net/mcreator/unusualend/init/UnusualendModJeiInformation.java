
package net.mcreator.unusualend.init;

import net.mcreator.unusualend.UnusualEnd;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.List;

@JeiPlugin
public class UnusualendModJeiInformation implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return UnusualEnd.makeUEID("information");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addIngredientInfo(
				List.of(new ItemStack(UnusualendModItems.BLAZING_ORB.get()), new ItemStack(UnusualendModItems.GOLEM_ORB.get()), new ItemStack(UnusualendModItems.SHULKER_ORB.get()), new ItemStack(UnusualendModItems.WITHERING_ORB.get())),
				VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_1"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualendModBlocks.GOLEM_ALTAR.get()), new ItemStack(Items.DRAGON_BREATH)), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_2"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualendModItems.CHORUS_PETAL.get()), new ItemStack(Blocks.CHORUS_FLOWER), new ItemStack(UnusualendModBlocks.CHORUS_CANE_FLOWER.get())), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.unusualend.jei_desc_3"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualendModItems.ENDER_FIREFLY_EGG.get()), new ItemStack(UnusualendModBlocks.FIREFLY_BULB.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_4"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualendModItems.SPECTRAL_CLOTH.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_5"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualendModItems.SPECTRAL_LEGGINGS.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_6"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualendModBlocks.SPECTRAL_BLOCK.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_7"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualendModItems.WARPED_BERRIES.get()), new ItemStack(UnusualendModItems.GLUB_BUCKET.get()), new ItemStack(UnusualendModItems.GLUB_SPAWN_EGG.get())), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.unusualend.jei_desc_8"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualendModItems.END_BLOB.get()), new ItemStack(UnusualendModItems.ENDERFIREFLY_BUCKET.get()), new ItemStack(UnusualendModItems.ENDER_FIREFLY_EGG.get()),
				new ItemStack(UnusualendModItems.ENDER_FIREFLY_SPAWN_EGG.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_9"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualendModBlocks.WARPED_BUBBLE.get()), new ItemStack(UnusualendModItems.WARPED_BOOTS.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_10"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualendModItems.WARPED_POTION.get()), new ItemStack(UnusualendModBlocks.CARVED_WARPED_SQUASH.get()), new ItemStack(UnusualendModItems.GLUB_BUCKET.get()),
				new ItemStack(UnusualendModItems.GLUB_SPAWN_EGG.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_11"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualendModItems.CRYSTAL_CATALYST.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_12"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualendModItems.LEECHING_WAND.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_13"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualendModBlocks.BUILDING_INHIBITOR.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_15"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualendModBlocks.GLOOPILON_SEEDS.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_16"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualendModItems.ENDERBLOB_MOULT.get()), new ItemStack(Items.BRUSH)), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_18"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualendModItems.WANDERING_STEW.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_19"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualendModItems.VOID_TOTEM.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_14"));
		registration.addIngredientInfo(
				List.of(new ItemStack(UnusualendModBlocks.CHORUS_ROOTS.get()), new ItemStack(UnusualendModBlocks.PURPUR_GRASS.get()), new ItemStack(UnusualendModBlocks.ENDSTONE_SPROUTS.get()),
						new ItemStack(UnusualendModBlocks.SMALL_WARPED_ALGAE.get()), new ItemStack(UnusualendModBlocks.WARPED_BUSH.get()), new ItemStack(UnusualendModBlocks.SMALL_WARPED_SQUASH.get())),
				VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_20"));
		registration.addIngredientInfo(
				List.of(new ItemStack(UnusualendModItems.VOID_TOTEM.get()), new ItemStack(Items.TOTEM_OF_UNDYING), new ItemStack(UnusualendModItems.PRISMATIC_MIRROR.get()), new ItemStack(UnusualendModBlocks.TELEPORTATION_ANCHOR.get())),
				VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_21"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualendModBlocks.PHANTOM_MEMBRANE_BLOCK.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_22"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualendModItems.WARPED_INFUSION.get()), new ItemStack(UnusualendModItems.WARPED_ANCHOR.get()), new ItemStack(UnusualendModBlocks.WARPED_CHEST.get())), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.unusualend.jei_desc_23"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualendModItems.WARPED_BALLOON.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_24"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualendModItems.MUSIC_DISC_QUEEN.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_25"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualendModBlocks.CITRINE_CANDLE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_26"));
	}
}
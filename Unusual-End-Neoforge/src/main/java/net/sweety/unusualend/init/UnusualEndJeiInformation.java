
package net.sweety.unusualend.init;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.sweety.unusualend.UnusualEnd;

import java.util.List;

@JeiPlugin
public class UnusualEndJeiInformation implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return UnusualEnd.makeUEID("information");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addIngredientInfo(
				List.of(new ItemStack(UnusualEndItems.BLAZING_ORB.get()), new ItemStack(UnusualEndItems.GOLEM_ORB.get()), new ItemStack(UnusualEndItems.SHULKER_ORB.get()), new ItemStack(UnusualEndItems.WITHERING_ORB.get())),
				VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_1"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualEndBlocks.GOLEM_ALTAR.get()), new ItemStack(Items.DRAGON_BREATH)), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_2"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualEndItems.CHORUS_PETAL.get()), new ItemStack(Blocks.CHORUS_FLOWER), new ItemStack(UnusualEndBlocks.CHORUS_CANE_FLOWER.get())), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.unusualend.jei_desc_3"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualEndItems.ENDER_FIREFLY_EGG.get()), new ItemStack(UnusualEndBlocks.FIREFLY_BULB.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_4"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualEndItems.SPECTRAL_CLOTH.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_5"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualEndItems.SPECTRAL_LEGGINGS.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_6"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualEndBlocks.SPECTRAL_BLOCK.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_7"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualEndItems.WARPED_BERRIES.get()), new ItemStack(UnusualEndItems.GLUB_BUCKET.get()), new ItemStack(UnusualEndItems.GLUB_SPAWN_EGG.get())), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.unusualend.jei_desc_8"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualEndItems.END_BLOB.get()), new ItemStack(UnusualEndItems.ENDERFIREFLY_BUCKET.get()), new ItemStack(UnusualEndItems.ENDER_FIREFLY_EGG.get()),
				new ItemStack(UnusualEndItems.ENDER_FIREFLY_SPAWN_EGG.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_9"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualEndBlocks.WARPED_BUBBLE.get()), new ItemStack(UnusualEndItems.WARPED_BOOTS.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_10"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualEndItems.WARPED_POTION.get()), new ItemStack(UnusualEndBlocks.CARVED_WARPED_SQUASH.get()), new ItemStack(UnusualEndItems.GLUB_BUCKET.get()),
				new ItemStack(UnusualEndItems.GLUB_SPAWN_EGG.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_11"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualEndItems.CRYSTAL_CATALYST.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_12"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualEndItems.LEECHING_WAND.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_13"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualEndBlocks.BUILDING_INHIBITOR.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_15"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualEndBlocks.GLOOPILON_SEEDS.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_16"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualEndItems.ENDERBLOB_MOULT.get()), new ItemStack(Items.BRUSH)), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_18"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualEndItems.WANDERING_STEW.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_19"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualEndItems.VOID_TOTEM.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_14"));
		registration.addIngredientInfo(
				List.of(new ItemStack(UnusualEndBlocks.CHORUS_ROOTS.get()), new ItemStack(UnusualEndBlocks.PURPUR_GRASS.get()), new ItemStack(UnusualEndBlocks.ENDSTONE_SPROUTS.get()),
						new ItemStack(UnusualEndBlocks.SMALL_WARPED_ALGAE.get()), new ItemStack(UnusualEndBlocks.WARPED_BUSH.get()), new ItemStack(UnusualEndBlocks.SMALL_WARPED_SQUASH.get())),
				VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_20"));
		registration.addIngredientInfo(
				List.of(new ItemStack(UnusualEndItems.VOID_TOTEM.get()), new ItemStack(Items.TOTEM_OF_UNDYING), new ItemStack(UnusualEndItems.PRISMATIC_MIRROR.get()), new ItemStack(UnusualEndBlocks.TELEPORTATION_ANCHOR.get())),
				VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_21"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualEndBlocks.PHANTOM_MEMBRANE_BLOCK.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_22"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualEndItems.WARPED_INFUSION.get()), new ItemStack(UnusualEndItems.WARPED_ANCHOR.get()), new ItemStack(UnusualEndBlocks.WARPED_CHEST.get())), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.unusualend.jei_desc_23"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualEndItems.WARPED_BALLOON.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_24"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualEndItems.MUSIC_DISC_QUEEN.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_25"));
		registration.addIngredientInfo(List.of(new ItemStack(UnusualEndBlocks.CITRINE_CANDLE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.unusualend.jei_desc_26"));
	}
}
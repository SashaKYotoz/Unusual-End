package net.sweety.unusualend.recipes.brewing;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.sweety.unusualend.init.UnusualendModBlocks;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.init.UnusualendModPotions;

import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public final class UnusualEndBrewingRecipes {
	public static final List<PotionMix> POTION_MIXES = List.of(
			new PotionMix(() -> Potions.AWKWARD, UnusualendModItems.END_BLOB, UnusualendModPotions.END_INFECTION),
			new PotionMix(() -> Potions.AWKWARD, UnusualendModItems.LURKER_SLUDGE, UnusualendModPotions.LEVITATION),
			new PotionMix(() -> Potions.AWKWARD, UnusualendModItems.GOLEM_ORB, UnusualendModPotions.BUILDING_POTION),
			new PotionMix(() -> Potions.LONG_REGENERATION, UnusualendModItems.SHINY_CRYSTAL, UnusualendModPotions.REGENERATION),
			new PotionMix(() -> Potions.STRONG_REGENERATION, UnusualendModItems.SHINY_CRYSTAL, UnusualendModPotions.REGENERATION_II),
			new PotionMix(() -> Potions.AWKWARD, UnusualendModItems.BOLOK_SCALE, UnusualendModPotions.HEAVINESS_POTION),
			new PotionMix(() -> Potions.AWKWARD, UnusualendModItems.CITRINE_CHUNK, UnusualendModPotions.SERENITY_POTION),
			new PotionMix(() -> Potions.AWKWARD, UnusualendModItems.PRISMALITE_GEM, UnusualendModPotions.SWIFT_STRIKES_POTION),
			new PotionMix(() -> Potions.AWKWARD, UnusualendModItems.ENDERBULB_LENS, () -> Potions.LONG_NIGHT_VISION),
			new PotionMix(() -> Potions.AWKWARD, UnusualendModItems.GLOOPILON_SLICE, UnusualendModPotions.HASTE),
			new PotionMix(UnusualendModPotions.HASTE, () -> Items.REDSTONE, UnusualendModPotions.ADVANCED_HASTE)
	);

	public static final List<ItemMix> ITEM_MIXES = List.of(
			new ItemMix(() -> Items.POTION, UnusualendModItems.WARPED_SPORES, () -> new ItemStack(UnusualendModItems.WARPED_POTION.get()), () -> Potions.WATER),
			new ItemMix(UnusualendModItems.WARPED_POTION, UnusualendModItems.BOLOK_SCALE, () -> potion(UnusualendModPotions.RESISTANCE.get()), null),
			new ItemMix(UnusualendModItems.WARPED_POTION, UnusualendModItems.SHINY_CRYSTAL, () -> potion(UnusualendModPotions.HEALTH_BOOST.get()), null),
			new ItemMix(UnusualendModItems.WARPED_POTION, UnusualendModItems.COOKED_BLUK, () -> potion(UnusualendModPotions.STRENGTH.get()), null),
			new ItemMix(UnusualendModItems.CHORUS_JUICE, UnusualendModItems.CHORUS_PETAL, () -> new ItemStack(UnusualendModItems.CHORUS_TEA.get()), null)
	);

	private UnusualEndBrewingRecipes() {
	}

	public static ItemStack potion(Potion potion) {
		return PotionUtils.setPotion(new ItemStack(Items.POTION), potion);
	}

	private static boolean isPotionItem(ItemStack stack) {
		return stack.is(Items.POTION) || stack.is(Items.SPLASH_POTION) || stack.is(Items.LINGERING_POTION);
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			POTION_MIXES.forEach(BrewingRecipeRegistry::addRecipe);
			ITEM_MIXES.forEach(BrewingRecipeRegistry::addRecipe);
			UnusualendModBlocks.registerPottedPlants();
		});
	}

	public record PotionMix(Supplier<Potion> input, Supplier<? extends Item> ingredient, Supplier<Potion> output) implements IBrewingRecipe {
		@Override
		public boolean isInput(ItemStack stack) {
			return isPotionItem(stack) && PotionUtils.getPotion(stack) == this.input.get();
		}

		@Override
		public boolean isIngredient(ItemStack stack) {
			return stack.is(this.ingredient.get());
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient))
				return PotionUtils.setPotion(new ItemStack(input.getItem()), this.output.get());
			return ItemStack.EMPTY;
		}
	}

	public record ItemMix(Supplier<? extends Item> input, Supplier<? extends Item> ingredient, Supplier<ItemStack> output, Supplier<Potion> requiredPotion) implements IBrewingRecipe {
		@Override
		public boolean isInput(ItemStack stack) {
			if (this.requiredPotion != null)
				return isPotionItem(stack) && PotionUtils.getPotion(stack) == this.requiredPotion.get();
			return stack.is(this.input.get());
		}

		@Override
		public boolean isIngredient(ItemStack stack) {
			return stack.is(this.ingredient.get());
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient))
				return this.output.get();
			return ItemStack.EMPTY;
		}

		public ItemStack displayInput() {
			return this.requiredPotion != null ? potion(this.requiredPotion.get()) : new ItemStack(this.input.get());
		}
	}
}
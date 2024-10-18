package net.mcreator.unusualend.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeSerializer;

import net.mcreator.unusualend.jei_recipes.InfuserRecipe;
import net.mcreator.unusualend.jei_recipes.BolokTradingRecipe;
import net.mcreator.unusualend.UnusualendMod;

@Mod.EventBusSubscriber(modid = UnusualendMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusualendModRecipeTypes {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, "unusualend");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		event.enqueueWork(() -> {
			SERIALIZERS.register(bus);
			SERIALIZERS.register("bolok_trading", () -> BolokTradingRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("infuser", () -> InfuserRecipe.Serializer.INSTANCE);
		});
	}
}

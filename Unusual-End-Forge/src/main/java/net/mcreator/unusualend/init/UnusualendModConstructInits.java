package net.mcreator.unusualend.init;

import net.mcreator.unusualend.UnusualEnd;
import net.mcreator.unusualend.configuration.Config;
import net.mcreator.unusualend.jei_recipes.BolokTradingRecipe;
import net.mcreator.unusualend.jei_recipes.InfuserRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = UnusualEnd.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusualendModConstructInits {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, "unusualend");

    @SubscribeEvent
    public static void register(FMLConstructModEvent event) {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        event.enqueueWork(() -> {
            ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC, "unusualend-common.toml");

            SERIALIZERS.register(bus);
            SERIALIZERS.register("bolok_trading", () -> BolokTradingRecipe.Serializer.INSTANCE);
            SERIALIZERS.register("infuser", () -> InfuserRecipe.Serializer.INSTANCE);
        });
    }
}
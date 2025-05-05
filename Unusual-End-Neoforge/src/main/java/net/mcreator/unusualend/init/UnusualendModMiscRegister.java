package net.mcreator.unusualend.init;

import net.mcreator.unusualend.configuration.ConfigurationFileConfiguration;
import net.mcreator.unusualend.UnusualendMod;
import net.mcreator.unusualend.jei_recipes.BolokTradingRecipe;
import net.mcreator.unusualend.jei_recipes.InfuserRecipe;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod.EventBusSubscriber(modid = UnusualendMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusualendModMiscRegister {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, "unusualend");
    public static final DeferredRegister<PaintingVariant> PAINTINGS = DeferredRegister.create(BuiltInRegistries.PAINTING_VARIANT, UnusualendMod.MODID);
    public static final DeferredHolder<PaintingVariant, PaintingVariant> END_LANDSCAPE = PAINTINGS.register("end_landscape", () -> new PaintingVariant(16, 16));
    public static final DeferredHolder<PaintingVariant, PaintingVariant> GLOOP = PAINTINGS.register("gloop", () -> new PaintingVariant(32, 16));
    public static final DeferredHolder<PaintingVariant, PaintingVariant> STARRY_VOID = PAINTINGS.register("starry_void", () -> new PaintingVariant(48, 16));

    @SubscribeEvent
    public static void register(FMLConstructModEvent event) {
        event.enqueueWork(() -> ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigurationFileConfiguration.SPEC, "unusualend-common.toml"));
        SERIALIZERS.register("bolok_trading", () -> BolokTradingRecipe.Serializer.INSTANCE);
        SERIALIZERS.register("infuser", () -> InfuserRecipe.Serializer.INSTANCE);
    }
}
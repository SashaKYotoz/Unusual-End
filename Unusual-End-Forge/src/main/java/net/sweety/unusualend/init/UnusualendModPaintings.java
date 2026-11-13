package net.sweety.unusualend.init;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sweety.unusualend.UnusualEnd;

public class UnusualendModPaintings {
	public static final DeferredRegister<PaintingVariant> REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, UnusualEnd.MODID);
	public static final RegistryObject<PaintingVariant> END_LANDSCAPE = REGISTRY.register("end_landscape", () -> new PaintingVariant(16, 16));
	public static final RegistryObject<PaintingVariant> GLOOP = REGISTRY.register("gloop", () -> new PaintingVariant(32, 16));
	public static final RegistryObject<PaintingVariant> STARRY_VOID = REGISTRY.register("starry_void", () -> new PaintingVariant(48, 16));
}

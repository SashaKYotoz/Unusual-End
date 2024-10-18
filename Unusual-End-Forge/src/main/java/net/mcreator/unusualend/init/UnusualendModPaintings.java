
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.unusualend.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.entity.decoration.PaintingVariant;

import net.mcreator.unusualend.UnusualendMod;

public class UnusualendModPaintings {
	public static final DeferredRegister<PaintingVariant> REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, UnusualendMod.MODID);
	public static final RegistryObject<PaintingVariant> END_LANDSCAPE = REGISTRY.register("end_landscape", () -> new PaintingVariant(16, 16));
	public static final RegistryObject<PaintingVariant> GLOOP = REGISTRY.register("gloop", () -> new PaintingVariant(32, 16));
	public static final RegistryObject<PaintingVariant> STARRY_VOID = REGISTRY.register("starry_void", () -> new PaintingVariant(48, 16));
}

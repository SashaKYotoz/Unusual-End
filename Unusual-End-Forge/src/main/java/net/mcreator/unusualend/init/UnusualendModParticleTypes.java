
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.unusualend.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.unusualend.UnusualendMod;

public class UnusualendModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, UnusualendMod.MODID);
	public static final RegistryObject<SimpleParticleType> BOLOK_PARTICLE = REGISTRY.register("bolok_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> PINK_FLAME = REGISTRY.register("pink_flame", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> WARPED_BUBBLES = REGISTRY.register("warped_bubbles", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> CITRINE_SHINE = REGISTRY.register("citrine_shine", () -> new SimpleParticleType(false));
}

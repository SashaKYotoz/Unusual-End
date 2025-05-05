package net.mcreator.unusualend.init;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.unusualend.UnusualendMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class UnusualendModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, UnusualendMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BOLOK_PARTICLE = REGISTRY.register("bolok_particle", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PINK_FLAME = REGISTRY.register("pink_flame", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> WARPED_BUBBLES = REGISTRY.register("warped_bubbles", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CITRINE_SHINE = REGISTRY.register("citrine_shine", () -> new SimpleParticleType(false));
}

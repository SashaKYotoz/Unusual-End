package net.mcreator.unusualend.init;

import net.mcreator.unusualend.UnusualEnd;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class UnusualendModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, UnusualEnd.MODID);
	public static final RegistryObject<SimpleParticleType> BOLOK_PARTICLE = REGISTRY.register("bolok_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> PINK_FLAME = REGISTRY.register("pink_flame", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> WARPED_BUBBLES = REGISTRY.register("warped_bubbles", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> CITRINE_SHINE = REGISTRY.register("citrine_shine", () -> new SimpleParticleType(false));
}

package net.mcreator.unusualend.init;

import net.mcreator.unusualend.UnusualEnd;
import net.mcreator.unusualend.potion.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class UnusualendModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, UnusualEnd.MODID);
	public static final RegistryObject<MobEffect> ENDER_INFECTION = REGISTRY.register("ender_infection", () -> new EnderInfectionMobEffect());
	public static final RegistryObject<MobEffect> DISRUPTION = REGISTRY.register("disruption", () -> new BuildingFatigueMobEffect());
	public static final RegistryObject<MobEffect> HEAVINESS = REGISTRY.register("heaviness", () -> new HeavinessMobEffect());
	public static final RegistryObject<MobEffect> SPECTRAL_STRIDE = REGISTRY.register("spectral_stride", () -> new SpectralStrideMobEffect());
	public static final RegistryObject<MobEffect> CRYSTALLIZATION = REGISTRY.register("crystallization", () -> new CrystallizationMobEffect());
	public static final RegistryObject<MobEffect> WARPED_TENACITY = REGISTRY.register("warped_tenacity", () -> new WarpedTenacityMobEffect());
	public static final RegistryObject<MobEffect> SWIFT_STRIKES = REGISTRY.register("swift_strikes", () -> new SwiftStrikesMobEffect());
	public static final RegistryObject<MobEffect> SERENITY = REGISTRY.register("serenity", () -> new SerenityMobEffect());
	public static final RegistryObject<MobEffect> BREACH_LINKED = REGISTRY.register("breach_linked", () -> new BreachLinkedMobEffect());
}

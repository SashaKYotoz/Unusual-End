package net.mcreator.unusualend.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.unusualend.potion.WarpedTenacityMobEffect;
import net.mcreator.unusualend.potion.SwiftStrikesMobEffect;
import net.mcreator.unusualend.potion.SpectralStrideMobEffect;
import net.mcreator.unusualend.potion.SerenityMobEffect;
import net.mcreator.unusualend.potion.HeavinessMobEffect;
import net.mcreator.unusualend.potion.EnderInfectionMobEffect;
import net.mcreator.unusualend.potion.CrystallizationMobEffect;
import net.mcreator.unusualend.potion.BuildingFatigueMobEffect;
import net.mcreator.unusualend.potion.BreachLinkedMobEffect;
import net.mcreator.unusualend.UnusualendMod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class UnusualendModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, UnusualendMod.MODID);
	public static final DeferredHolder<MobEffect, EnderInfectionMobEffect> ENDER_INFECTION = REGISTRY.register("ender_infection", () -> new EnderInfectionMobEffect());
	public static final DeferredHolder<MobEffect, BuildingFatigueMobEffect> DISRUPTION = REGISTRY.register("disruption", () -> new BuildingFatigueMobEffect());
	public static final DeferredHolder<MobEffect, HeavinessMobEffect> HEAVINESS = REGISTRY.register("heaviness", () -> new HeavinessMobEffect());
	public static final DeferredHolder<MobEffect, SpectralStrideMobEffect> SPECTRAL_STRIDE = REGISTRY.register("spectral_stride", () -> new SpectralStrideMobEffect());
	public static final DeferredHolder<MobEffect, CrystallizationMobEffect> CRYSTALLIZATION = REGISTRY.register("crystallization", () -> new CrystallizationMobEffect());
	public static final DeferredHolder<MobEffect, WarpedTenacityMobEffect> WARPED_TENACITY = REGISTRY.register("warped_tenacity", () -> new WarpedTenacityMobEffect());
	public static final DeferredHolder<MobEffect, SwiftStrikesMobEffect> SWIFT_STRIKES = REGISTRY.register("swift_strikes", () -> new SwiftStrikesMobEffect());
	public static final DeferredHolder<MobEffect, SerenityMobEffect> SERENITY = REGISTRY.register("serenity", () -> new SerenityMobEffect());
	public static final DeferredHolder<MobEffect, BreachLinkedMobEffect> BREACH_LINKED = REGISTRY.register("breach_linked", () -> new BreachLinkedMobEffect());
}

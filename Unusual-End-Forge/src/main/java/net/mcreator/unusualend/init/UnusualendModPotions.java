
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.unusualend.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.unusualend.UnusualendMod;

public class UnusualendModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, UnusualendMod.MODID);
	public static final RegistryObject<Potion> END_INFECTION = REGISTRY.register("end_infection", () -> new Potion(new MobEffectInstance(UnusualendModMobEffects.ENDER_INFECTION.get(), 3600, 0, false, true)));
	public static final RegistryObject<Potion> LEVITATION = REGISTRY.register("levitation", () -> new Potion(new MobEffectInstance(MobEffects.LEVITATION, 400, 0, false, true)));
	public static final RegistryObject<Potion> BUILDING_POTION = REGISTRY.register("building_potion", () -> new Potion(new MobEffectInstance(UnusualendModMobEffects.DISRUPTION.get(), 9600, 0, false, true)));
	public static final RegistryObject<Potion> RESISTANCE = REGISTRY.register("resistance",
			() -> new Potion(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2400, 0, false, true), new MobEffectInstance(UnusualendModMobEffects.HEAVINESS.get(), 1200, 0, false, true)));
	public static final RegistryObject<Potion> REGENERATION = REGISTRY.register("regeneration", () -> new Potion(new MobEffectInstance(MobEffects.REGENERATION, 6000, 0, false, true)));
	public static final RegistryObject<Potion> REGENERATION_II = REGISTRY.register("regeneration_ii", () -> new Potion(new MobEffectInstance(MobEffects.REGENERATION, 1200, 1, false, true)));
	public static final RegistryObject<Potion> HEALTH_BOOST = REGISTRY.register("health_boost", () -> new Potion(new MobEffectInstance(MobEffects.HEALTH_BOOST, 6000, 1, false, true), new MobEffectInstance(MobEffects.WEAKNESS, 3600, 0, false, true)));
	public static final RegistryObject<Potion> HEAVINESS_POTION = REGISTRY.register("heaviness_potion", () -> new Potion(new MobEffectInstance(UnusualendModMobEffects.HEAVINESS.get(), 3600, 1, false, true)));
	public static final RegistryObject<Potion> SERENITY_POTION = REGISTRY.register("serenity_potion", () -> new Potion(new MobEffectInstance(UnusualendModMobEffects.SERENITY.get(), 3600, 0, false, true)));
	public static final RegistryObject<Potion> SWIFT_STRIKES_POTION = REGISTRY.register("swift_strikes_potion", () -> new Potion(new MobEffectInstance(UnusualendModMobEffects.SWIFT_STRIKES.get(), 3600, 0, false, true)));
	public static final RegistryObject<Potion> STRENGTH = REGISTRY.register("strength",
			() -> new Potion(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600, 1, false, true), new MobEffectInstance(MobEffects.BLINDNESS, 1200, 0, false, true), new MobEffectInstance(MobEffects.CONFUSION, 2400, 0, false, true)));
	public static final RegistryObject<Potion> HASTE = REGISTRY.register("haste", () -> new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 0, false, true)));
	public static final RegistryObject<Potion> ADVANCED_HASTE = REGISTRY.register("advanced_haste", () -> new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 9600, 0, false, true)));
}

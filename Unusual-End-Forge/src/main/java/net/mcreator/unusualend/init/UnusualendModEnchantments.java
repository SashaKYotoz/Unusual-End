
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.unusualend.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.unusualend.enchantment.RecoveryEnchantment;
import net.mcreator.unusualend.enchantment.JoustEnchantment;
import net.mcreator.unusualend.enchantment.EverlastingEnchantment;
import net.mcreator.unusualend.enchantment.BondingEnchantment;
import net.mcreator.unusualend.enchantment.BoloksWingsEnchantment;
import net.mcreator.unusualend.enchantment.BoloksHeadEnchantment;
import net.mcreator.unusualend.enchantment.BoloksFuryEnchantment;
import net.mcreator.unusualend.enchantment.BenevolenceEnchantment;
import net.mcreator.unusualend.UnusualendMod;

public class UnusualendModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, UnusualendMod.MODID);
	public static final RegistryObject<Enchantment> EVERLASTING = REGISTRY.register("everlasting", () -> new EverlastingEnchantment());
	public static final RegistryObject<Enchantment> BOLOKS_FURY = REGISTRY.register("boloks_fury", () -> new BoloksFuryEnchantment());
	public static final RegistryObject<Enchantment> BOLOKS_WINGS = REGISTRY.register("boloks_wings", () -> new BoloksWingsEnchantment());
	public static final RegistryObject<Enchantment> BOLOKS_HEAD = REGISTRY.register("boloks_head", () -> new BoloksHeadEnchantment());
	public static final RegistryObject<Enchantment> JOUST = REGISTRY.register("joust", () -> new JoustEnchantment());
	public static final RegistryObject<Enchantment> ARCANE_RECOVERY = REGISTRY.register("arcane_recovery", () -> new RecoveryEnchantment());
	public static final RegistryObject<Enchantment> BONDING = REGISTRY.register("bonding", () -> new BondingEnchantment());
	public static final RegistryObject<Enchantment> BENEVOLENCE = REGISTRY.register("benevolence", () -> new BenevolenceEnchantment());
}

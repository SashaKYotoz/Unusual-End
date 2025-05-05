package net.mcreator.unusualend.init;

import net.minecraft.core.registries.BuiltInRegistries;
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
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class UnusualendModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(BuiltInRegistries.ENCHANTMENT, UnusualendMod.MODID);
	public static final DeferredHolder<Enchantment, EverlastingEnchantment> EVERLASTING = REGISTRY.register("everlasting", () -> new EverlastingEnchantment());
	public static final DeferredHolder<Enchantment, BoloksFuryEnchantment> BOLOKS_FURY = REGISTRY.register("boloks_fury", () -> new BoloksFuryEnchantment());
	public static final DeferredHolder<Enchantment, BoloksWingsEnchantment> BOLOKS_WINGS = REGISTRY.register("boloks_wings", () -> new BoloksWingsEnchantment());
	public static final DeferredHolder<Enchantment, BoloksHeadEnchantment> BOLOKS_HEAD = REGISTRY.register("boloks_head", () -> new BoloksHeadEnchantment());
	public static final DeferredHolder<Enchantment, JoustEnchantment> JOUST = REGISTRY.register("joust", () -> new JoustEnchantment());
	public static final DeferredHolder<Enchantment, RecoveryEnchantment> ARCANE_RECOVERY = REGISTRY.register("arcane_recovery", () -> new RecoveryEnchantment());
	public static final DeferredHolder<Enchantment, BondingEnchantment> BONDING = REGISTRY.register("bonding", () -> new BondingEnchantment());
	public static final DeferredHolder<Enchantment, BenevolenceEnchantment> BENEVOLENCE = REGISTRY.register("benevolence", () -> new BenevolenceEnchantment());
}
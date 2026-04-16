package net.mcreator.unusualend.init;

import net.mcreator.unusualend.UnusualEnd;
import net.mcreator.unusualend.enchantment.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class UnusualendModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, UnusualEnd.MODID);
	public static final RegistryObject<Enchantment> EVERLASTING = REGISTRY.register("everlasting", () -> new EverlastingEnchantment());
	public static final RegistryObject<Enchantment> BOLOKS_FURY = REGISTRY.register("boloks_fury", () -> new BoloksFuryEnchantment());
	public static final RegistryObject<Enchantment> BOLOKS_WINGS = REGISTRY.register("boloks_wings", () -> new BoloksWingsEnchantment());
	public static final RegistryObject<Enchantment> BOLOKS_HEAD = REGISTRY.register("boloks_head", () -> new BoloksHeadEnchantment());
	public static final RegistryObject<Enchantment> JOUST = REGISTRY.register("joust", () -> new JoustEnchantment());
	public static final RegistryObject<Enchantment> ARCANE_RECOVERY = REGISTRY.register("arcane_recovery", () -> new RecoveryEnchantment());
	public static final RegistryObject<Enchantment> BONDING = REGISTRY.register("bonding", () -> new BondingEnchantment());
	public static final RegistryObject<Enchantment> BENEVOLENCE = REGISTRY.register("benevolence", () -> new BenevolenceEnchantment());
}

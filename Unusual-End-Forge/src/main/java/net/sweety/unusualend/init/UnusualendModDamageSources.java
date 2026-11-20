package net.sweety.unusualend.init;

import net.minecraft.world.damagesource.DamageSource;

public class UnusualendModDamageSources {
	public static final DamageSource TRAPPER = new DamageSource("trapper_damages").bypassArmor().bypassEnchantments().setScalesWithDifficulty();
	public static final DamageSource SPUNKLER = new DamageSource("spunkler_damages").setScalesWithDifficulty();
	public static final DamageSource INFECTION = new DamageSource("infection_damages").bypassArmor().setScalesWithDifficulty();
	public static final DamageSource JOUST = new DamageSource("joust");
}

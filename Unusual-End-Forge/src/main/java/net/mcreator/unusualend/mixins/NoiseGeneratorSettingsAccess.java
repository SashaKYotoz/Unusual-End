package net.mcreator.unusualend.mixins;

import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

@Mixin(NoiseGeneratorSettings.class)
public interface NoiseGeneratorSettingsAccess {
	@Accessor("surfaceRule")
	@Mutable
	void addSurfaceRule(SurfaceRules.RuleSource ruleSource);
}

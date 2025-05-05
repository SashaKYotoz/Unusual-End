package net.sashakyotoz.unusualend.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.sashakyotoz.unusualend.common.effects.ModEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = LivingEntity.class,priority = 900)
public class LivingEntityMixin {
    @Redirect(
            method = "travel",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;hasStatusEffect(Lnet/minecraft/entity/effect/StatusEffect;)Z"
            )
    )
    private boolean modifySlowFallingCondition(LivingEntity instance, StatusEffect effect) {
        if (effect == StatusEffects.SLOW_FALLING)
            return instance.hasStatusEffect(StatusEffects.SLOW_FALLING) || instance.hasStatusEffect(ModEffects.SPECTRAL_STRIDE);
        return instance.hasStatusEffect(effect);
    }
}
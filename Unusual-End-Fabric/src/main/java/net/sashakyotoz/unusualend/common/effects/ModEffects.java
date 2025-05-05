package net.sashakyotoz.unusualend.common.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.sashakyotoz.unusualend.UnusualEnd;
import net.sashakyotoz.unusualend.common.effects.custom.SpectralStrideEffect;

public class ModEffects {
    //SPECTRAL_STRIDE spectral_stride
    public static final StatusEffect SPECTRAL_STRIDE = register(UnusualEnd.MOD_ID +":spectral_stride",new SpectralStrideEffect(StatusEffectCategory.BENEFICIAL,-4121136));

    private static StatusEffect register(String id, StatusEffect entry) {
        return Registry.register(Registries.STATUS_EFFECT, id, entry);
    }
    public static void register(){
        UnusualEnd.log("Registering Effects for modid : " + UnusualEnd.MOD_ID);
    }
}
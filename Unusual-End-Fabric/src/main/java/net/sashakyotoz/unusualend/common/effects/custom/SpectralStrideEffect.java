package net.sashakyotoz.unusualend.common.effects.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.sashakyotoz.unusualend.common.networking.IEntityDataSaver;
import net.sashakyotoz.unusualend.common.networking.data.ClothOverlayValuesHandler;

public class SpectralStrideEffect extends StatusEffect {
    public SpectralStrideEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
        this.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "9ed92810-4b50-11ee-be56-0242ac120002", 0.09F, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof ServerPlayerEntity player && !(ClothOverlayValuesHandler.get((IEntityDataSaver) player) > 0))
            player.getServerWorld().spawnParticles(ParticleTypes.REVERSE_PORTAL, player.getX(), player.getY() + 0.1f, player.getZ(), 1, 0.2, 0.2, 0.2, 0);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);
        if (entity instanceof ServerPlayerEntity player)
            ClothOverlayValuesHandler.remove((IEntityDataSaver) player, ClothOverlayValuesHandler.get((IEntityDataSaver) player));
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
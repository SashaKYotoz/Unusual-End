
package net.mcreator.unusualend.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.unusualend.procedures.SpectralStrideOnEffectActiveTickProcedure;
import net.neoforged.neoforge.common.NeoForgeMod;

public class SpectralStrideMobEffect extends MobEffect {
	public SpectralStrideMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -4121136);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "9ed92810-4b50-11ee-be56-0242ac120002", 0.08F, AttributeModifier.Operation.MULTIPLY_TOTAL);
		this.addAttributeModifier(NeoForgeMod.ENTITY_GRAVITY.value(), "82fce226-4b50-11ee-be56-0242ac120002", -0.35F, AttributeModifier.Operation.MULTIPLY_TOTAL);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		SpectralStrideOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
		return true;
	}
}

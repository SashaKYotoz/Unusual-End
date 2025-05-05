
package net.mcreator.unusualend.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.unusualend.procedures.HeavinessOnEffectActiveTickProcedure;
import net.neoforged.neoforge.common.NeoForgeMod;

public class HeavinessMobEffect extends MobEffect {
	public HeavinessMobEffect() {
		super(MobEffectCategory.HARMFUL, -16751002);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "1311a77c-53fc-4f39-b6e4-e39364233123", -0.10F, AttributeModifier.Operation.MULTIPLY_TOTAL);
		this.addAttributeModifier(NeoForgeMod.ENTITY_GRAVITY.value(), "86fe2657-05ca-4b13-9e17-2ceb225def27", 0.25F, AttributeModifier.Operation.MULTIPLY_TOTAL);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		HeavinessOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
		return true;
	}
}

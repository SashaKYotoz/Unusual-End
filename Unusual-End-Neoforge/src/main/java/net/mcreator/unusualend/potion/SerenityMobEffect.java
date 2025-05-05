
package net.mcreator.unusualend.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.unusualend.procedures.SerenityOnEffectActiveTickProcedure;

public class SerenityMobEffect extends MobEffect {
	public SerenityMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16026);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		SerenityOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
		return true;
	}
}

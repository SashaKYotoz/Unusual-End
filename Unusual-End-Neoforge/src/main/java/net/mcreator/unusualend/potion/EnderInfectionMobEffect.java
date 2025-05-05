
package net.mcreator.unusualend.potion;

import net.mcreator.unusualend.procedures.EnderInfectionEffectExpiresProcedure;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.unusualend.procedures.EnderInfectionOnEffectActiveTickProcedure;

public class EnderInfectionMobEffect extends MobEffect {
    private LivingEntity entity;

    public EnderInfectionMobEffect() {
        super(MobEffectCategory.HARMFUL, -15704495);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (this.entity == null)
            this.entity = entity;
        EnderInfectionOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        return true;
    }

    @Override
    public void removeAttributeModifiers(AttributeMap pAttributeMap) {
        super.removeAttributeModifiers(pAttributeMap);
        if (this.entity != null)
            EnderInfectionEffectExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
    }
}

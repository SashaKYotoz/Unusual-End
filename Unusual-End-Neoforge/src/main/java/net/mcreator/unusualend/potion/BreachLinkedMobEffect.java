
package net.mcreator.unusualend.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.unusualend.procedures.BreachLinkedEffectStartedappliedProcedure;
import net.mcreator.unusualend.procedures.BreachLinkedEffectExpiresProcedure;

public class BreachLinkedMobEffect extends MobEffect {
    private LivingEntity entity;

    public BreachLinkedMobEffect() {
        super(MobEffectCategory.BENEFICIAL, -16764109);
    }

    @Override
    public void removeAttributeModifiers(AttributeMap pAttributeMap) {
        super.removeAttributeModifiers(pAttributeMap);
        if (entity != null)
            BreachLinkedEffectExpiresProcedure.execute(entity.level(), entity);
    }

    @Override
    public void onEffectStarted(LivingEntity pLivingEntity, int pAmplifier) {
        this.entity = pLivingEntity;
        BreachLinkedEffectStartedappliedProcedure.execute(pLivingEntity.level(), pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(), pLivingEntity);
    }
}
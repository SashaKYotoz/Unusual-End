
package net.sweety.unusualend.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.sweety.unusualend.procedures.BreachLinkedEffectExpiresProcedure;
import net.sweety.unusualend.procedures.BreachLinkedEffectStartedappliedProcedure;

public class BreachLinkedMobEffect extends MobEffect {
	public BreachLinkedMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16764109);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		BreachLinkedEffectStartedappliedProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		BreachLinkedEffectExpiresProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}


package net.mcreator.unusualend.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class SwiftStrikesMobEffect extends MobEffect {
	public SwiftStrikesMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -4468228);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, "5911a33c-47fc-4f39-b5e4-e39365234145", 0.25F, AttributeModifier.Operation.MULTIPLY_TOTAL);
	}

	@Override
	public String getDescriptionId() {
		return "effect.unusualend.swift_strikes";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

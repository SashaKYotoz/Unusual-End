
package net.mcreator.unusualend.potion;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.unusualend.procedures.WarpedTenacityOnEffectActiveTickProcedure;

public class WarpedTenacityMobEffect extends MobEffect {
	public WarpedTenacityMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -14376058);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "2871a77c-53fc-4f39-b6e4-e39364233124", -0.03F, AttributeModifier.Operation.MULTIPLY_TOTAL);
		this.addAttributeModifier(ForgeMod.ENTITY_GRAVITY.get(), "84fce326-4b50-11ee-be56-0242ac123301", 0.1F, AttributeModifier.Operation.MULTIPLY_TOTAL);
		this.addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE, "2511a77c-53fc-4f39-b6e4-e39364233119", 0.15F, AttributeModifier.Operation.MULTIPLY_TOTAL);
		this.addAttributeModifier(Attributes.ARMOR, "4411a77c-53fc-4f39-b6e4-e39364233154", 3.0F, AttributeModifier.Operation.ADDITION);
		this.addAttributeModifier(Attributes.ARMOR_TOUGHNESS, "2311a77c-53fc-4f39-b6e4-e39364233175", 2.0F, AttributeModifier.Operation.ADDITION);
	}

	@Override
	public String getDescriptionId() {
		return "effect.unusualend.warped_tenacity";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		WarpedTenacityOnEffectActiveTickProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

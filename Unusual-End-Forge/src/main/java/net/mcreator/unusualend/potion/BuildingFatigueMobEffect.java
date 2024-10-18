
package net.mcreator.unusualend.potion;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import java.util.List;
import java.util.ArrayList;

public class BuildingFatigueMobEffect extends MobEffect {
	public BuildingFatigueMobEffect() {
		super(MobEffectCategory.HARMFUL, -13487566);
		this.addAttributeModifier(ForgeMod.BLOCK_REACH.get(), "5671a87c-50fc-4f29-b6e4-e39364233137", -100F, AttributeModifier.Operation.ADDITION);
	}

	@Override
	public List<ItemStack> getCurativeItems() {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		return ret;
	}

	@Override
	public String getDescriptionId() {
		return "effect.unusualend.disruption";
	}

	//@Override
	//public void applyEffectTick(LivingEntity entity, int amplifier) {
	//	BuildingFatigueOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	//}
	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

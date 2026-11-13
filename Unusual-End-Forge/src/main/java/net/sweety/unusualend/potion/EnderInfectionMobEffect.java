
package net.sweety.unusualend.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.procedures.EnderInfectionEffectExpiresProcedure;
import net.sweety.unusualend.procedures.EnderInfectionOnEffectActiveTickProcedure;

import java.util.ArrayList;
import java.util.List;

public class EnderInfectionMobEffect extends MobEffect {
	public EnderInfectionMobEffect() {
		super(MobEffectCategory.HARMFUL, -15704495);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		EnderInfectionOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		EnderInfectionEffectExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public List<ItemStack> getCurativeItems() {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(UnusualendModItems.CHORUS_JUICE.get()));
		ret.add(new ItemStack(Items.MILK_BUCKET));
		return ret;
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

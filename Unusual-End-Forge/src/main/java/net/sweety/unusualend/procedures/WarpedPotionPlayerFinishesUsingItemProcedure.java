package net.sweety.unusualend.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.sweety.unusualend.util.ProcedureHelper;

public class WarpedPotionPlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.CONFUSION, 200, 0));
	}
}

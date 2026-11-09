package net.sweety.unusualend.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.sweety.unusualend.init.UnusualEndMiscRegister;
import net.sweety.unusualend.util.ProcedureHelper;

public class EnderlingScrapLeggingsTickEventProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isSprinting()) {
			ProcedureHelper.addEffect(entity, new MobEffectInstance(UnusualEndMiscRegister.SPECTRAL_STRIDE, 2, 0, false, false));
		}
	}
}

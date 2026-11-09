package net.sweety.unusualend.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.sweety.unusualend.init.UnusualEndMiscRegister;
import net.sweety.unusualend.util.ProcedureHelper;

public class IsCristallizedProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(UnusualEndMiscRegister.CRYSTALLIZATION) && !(ProcedureHelper.isCreative(entity)) && !(ProcedureHelper.isSpectator(entity));
	}
}

package net.sweety.unusualend.procedures;

import net.minecraft.world.entity.Entity;
import net.sweety.unusualend.util.ProcedureHelper;

public class IsNotRidingProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !entity.isPassenger() && !((ProcedureHelper.isOrderedToSit(entity)) == true);
	}
}

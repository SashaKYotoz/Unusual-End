package net.sweety.unusualend.procedures;

import net.minecraft.world.entity.Entity;
import net.sweety.unusualend.util.ProcedureHelper;

public class ReturnNotSneakingProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !((ProcedureHelper.isOrderedToSit(entity)) == true);
	}
}

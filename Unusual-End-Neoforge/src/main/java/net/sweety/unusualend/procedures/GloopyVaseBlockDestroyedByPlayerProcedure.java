package net.sweety.unusualend.procedures;

import net.minecraft.world.entity.Entity;
import net.sweety.unusualend.util.ProcedureHelper;

public class GloopyVaseBlockDestroyedByPlayerProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ProcedureHelper.awardAdvancement(entity, "break_gloopy_urn");
	}
}

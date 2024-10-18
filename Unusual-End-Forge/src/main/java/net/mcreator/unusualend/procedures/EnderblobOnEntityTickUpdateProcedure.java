package net.mcreator.unusualend.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.unusualend.entity.EnderblobEntity;

public class EnderblobOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof EnderblobEntity _datEntI ? _datEntI.getEntityData().get(EnderblobEntity.DATA_BrushTimer) : 0) > 0) {
			if (entity instanceof EnderblobEntity _datEntSetI)
				_datEntSetI.getEntityData().set(EnderblobEntity.DATA_BrushTimer, (int) ((entity instanceof EnderblobEntity _datEntI ? _datEntI.getEntityData().get(EnderblobEntity.DATA_BrushTimer) : 0) - 1));
		}
	}
}

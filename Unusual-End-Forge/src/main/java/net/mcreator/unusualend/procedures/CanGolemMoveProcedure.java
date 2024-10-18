package net.mcreator.unusualend.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.unusualend.entity.EndstoneGolemEntity;

public class CanGolemMoveProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof EndstoneGolemEntity _datEntI ? _datEntI.getEntityData().get(EndstoneGolemEntity.DATA_aoe_animtime) : 0) == 0) {
			return true;
		}
		return false;
	}
}

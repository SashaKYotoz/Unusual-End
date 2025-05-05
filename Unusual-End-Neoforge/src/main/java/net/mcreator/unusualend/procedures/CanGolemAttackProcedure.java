package net.mcreator.unusualend.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.unusualend.entity.EndstoneGolemEntity;

public class CanGolemAttackProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof EndstoneGolemEntity _datEntI ? _datEntI.getEntityData().get(EndstoneGolemEntity.DATA_aoe_animtime) : 0) == 0
				&& (entity instanceof EndstoneGolemEntity _datEntI ? _datEntI.getEntityData().get(EndstoneGolemEntity.DATA_push) : 0) == 0
				&& (entity instanceof EndstoneGolemEntity _datEntI ? _datEntI.getEntityData().get(EndstoneGolemEntity.DATA_aoe_cooldown) : 0) < 110) {
			return true;
		}
		return false;
	}
}

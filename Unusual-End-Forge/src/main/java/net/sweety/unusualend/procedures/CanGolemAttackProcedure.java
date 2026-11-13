package net.sweety.unusualend.procedures;

import net.sweety.unusualend.entity.EndstoneGolemEntity;

public class CanGolemAttackProcedure {
	public static boolean execute(EndstoneGolemEntity entity) {
		if (entity == null)
			return false;
        return entity.getEntityData().get(EndstoneGolemEntity.DATA_aoe_animtime) == 0
                && entity.getEntityData().get(EndstoneGolemEntity.DATA_push) == 0
                && entity.getEntityData().get(EndstoneGolemEntity.DATA_aoe_cooldown) < 110;
    }
}

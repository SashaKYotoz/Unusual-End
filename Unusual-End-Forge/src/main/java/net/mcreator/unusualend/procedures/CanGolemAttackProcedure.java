package net.mcreator.unusualend.procedures;

import net.mcreator.unusualend.entity.EndstoneGolemEntity;
import net.minecraft.world.entity.Entity;

public class CanGolemAttackProcedure {
	public static boolean execute(EndstoneGolemEntity entity) {
		if (entity == null)
			return false;
        return entity.getEntityData().get(EndstoneGolemEntity.DATA_aoe_animtime) == 0
                && entity.getEntityData().get(EndstoneGolemEntity.DATA_push) == 0
                && entity.getEntityData().get(EndstoneGolemEntity.DATA_aoe_cooldown) < 110;
    }
}

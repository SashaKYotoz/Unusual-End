package net.mcreator.unusualend.procedures;

import net.minecraft.world.entity.Entity;

public class VoidArrowProjectileProjectileHitsLivingEntityProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.invulnerableTime = 5;
	}
}

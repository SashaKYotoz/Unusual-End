package net.mcreator.unusualend.procedures;

import net.minecraft.world.entity.Entity;

public class EnderBlobBlockEntityCollidesInTheBlockProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.fallDistance = 0;
	}
}

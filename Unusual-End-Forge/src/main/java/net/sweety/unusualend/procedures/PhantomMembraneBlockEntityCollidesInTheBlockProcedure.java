package net.sweety.unusualend.procedures;

import net.minecraft.world.entity.Entity;

public class PhantomMembraneBlockEntityCollidesInTheBlockProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.fallDistance = 0;
	}
}

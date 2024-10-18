package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class EnderFireflyTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean lcl = false;
		if (Math.random() < 0.05) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.END_ROD, x, y, z, 1, 0.35, 0.35, 0.35, 0);
		}
		if (!(entity.getPersistentData().getBoolean("coords") == true)) {
			entity.getPersistentData().putBoolean("coords", true);
			entity.getPersistentData().putDouble("x", x);
			entity.getPersistentData().putDouble("y", y);
			entity.getPersistentData().putDouble("z", z);
		}
		if (!(entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false)) {
			if (Math.random() < 0.005) {
				if (entity instanceof Mob _entity)
					_entity.getNavigation().moveTo((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z")), 0.8);
			}
		}
	}
}

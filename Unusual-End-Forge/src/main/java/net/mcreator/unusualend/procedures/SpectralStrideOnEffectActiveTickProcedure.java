package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class SpectralStrideOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getPersistentData().getDouble("ScrapClothOverlay") > 0)) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.REVERSE_PORTAL, x, (y + 0.1), z, 1, 0.2, 0.2, 0.2, 0);
		}
	}
}

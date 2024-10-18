package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class CitrineTalismanTriggerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double proba = 0;
		if (entity instanceof LivingEntity) {
			if (!(entity instanceof ArmorStand)) {
				if (!world.isClientSide()) {
					proba = Math.random();
					if (proba < 0.2) {
						for (int index0 = 0; index0 < 10; index0++) {
							if (world instanceof ServerLevel _level)
								_level.addFreshEntity(new ExperienceOrb(_level, (x + Mth.nextDouble(RandomSource.create(), -0.3, 0.3)), (y + Mth.nextDouble(RandomSource.create(), -0.3, 0.3) + entity.getBbHeight() / 2),
										(z + Mth.nextDouble(RandomSource.create(), -0.3, 0.3)), 1));
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.TOTEM_OF_UNDYING, x, (y + entity.getBbHeight() / 2), z, 15, 0.3, 0.3, 0.3, 0.4);
					}
				}
			}
		}
	}
}

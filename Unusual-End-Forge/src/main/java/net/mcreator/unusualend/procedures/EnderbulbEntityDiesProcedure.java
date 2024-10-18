package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModEntities;

public class EnderbulbEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.POOF, x, y, z, 10, 0.5, 0.5, 0.5, 0);
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, 0, Level.ExplosionInteraction.MOB);
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 2, 4); index0++) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = UnusualendModEntities.SMALL_ENDERBULB.get().spawn(_level, BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -0.15, 0.15), y, z + Mth.nextDouble(RandomSource.create(), -0.15, 0.15)),
						MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
	}
}

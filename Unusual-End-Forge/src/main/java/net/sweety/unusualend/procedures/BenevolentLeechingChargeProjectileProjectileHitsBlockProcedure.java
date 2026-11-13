package net.sweety.unusualend.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.util.ParticleHelper;

public class BenevolentLeechingChargeProjectileProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
		if (world instanceof ServerLevel _level) {
			AreaEffectCloud cloud = new AreaEffectCloud(_level, x, y + 1, z);
			cloud.setParticle(ParticleHelper.dust(0.94f, 0.3f, 0.88f, 1f));
			cloud.setPotion(Potions.STRONG_REGENERATION);
			cloud.setRadius(2);
			cloud.setRadiusPerTick(-0.01f);
			cloud.setDuration(100);
			_level.addFreshEntity(cloud);
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.POOF, x, (y + 1.2), z, 3, 0.5, 0.2, 0.5, 0.1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.HEART, x, (y + 1.2), z, 5, 1.2, 0.2, 1.2, 0.1);
	}
}

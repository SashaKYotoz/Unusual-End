package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModParticleTypes;

public class WarpedChestOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!("" + (new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, BlockPos.containing(x, y, z), "UUID"))).contains(entity.getStringUUID())) {
			world.addParticle(ParticleTypes.DRIPPING_WATER, (x + Mth.nextDouble(RandomSource.create(), -0.1, 1.1)), (y + Mth.nextDouble(RandomSource.create(), 0.4, 0.85)), (z + Mth.nextDouble(RandomSource.create(), -0.1, 1.1)), 0, 0, 0);
			world.addParticle((SimpleParticleType) (UnusualendModParticleTypes.BOLOK_PARTICLE.get()), (x + Mth.nextDouble(RandomSource.create(), -0.1, 1.1)), (y + Mth.nextDouble(RandomSource.create(), 0.4, 0.85)),
					(z + Mth.nextDouble(RandomSource.create(), -0.1, 1.1)), 0, 0, 0);
			if (Math.random() < 0.3) {
				world.addParticle((SimpleParticleType) (UnusualendModParticleTypes.WARPED_BUBBLES.get()), (x + Mth.nextDouble(RandomSource.create(), 0.2, 0.8)), (y + Mth.nextDouble(RandomSource.create(), 0.7, 0.85)),
						(z + Mth.nextDouble(RandomSource.create(), 0.2, 0.8)), 0, 0, 0);
			}
		} else {
			if (Math.random() < 0.3) {
				world.addParticle(ParticleTypes.SMOKE, (x + Mth.nextDouble(RandomSource.create(), -0.1, 1.1)), (y + Mth.nextDouble(RandomSource.create(), 0.4, 0.85)), (z + Mth.nextDouble(RandomSource.create(), -0.1, 1.1)), 0, 0, 0);
			}
		}
	}
}

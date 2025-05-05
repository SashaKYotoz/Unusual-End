package net.mcreator.unusualend.procedures;

import net.minecraft.sounds.SoundEvents;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;

public class CrystallizationEffectExpiresProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("CrystalDamages") > 0) {
		}
		entity.getPersistentData().putDouble("CrystalDamages", 0);
		for (int index0 = 0; index0 < 3; index0++) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.GLASS_BREAK, SoundSource.PLAYERS, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1),
							(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.2));
				} else {
					_level.playLocalSound(x, y, z, SoundEvents.GLASS_BREAK, SoundSource.PLAYERS, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1),
							(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.2), false);
				}
			}
		}
	}
}

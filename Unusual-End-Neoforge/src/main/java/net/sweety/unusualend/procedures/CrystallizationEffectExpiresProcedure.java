package net.sweety.unusualend.procedures;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.util.ProcedureHelper;

public class CrystallizationEffectExpiresProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("CrystalDamages") > 0) {
		}
		entity.getPersistentData().putDouble("CrystalDamages", 0);
		for (int index0 = 0; index0 < 3; index0++) {
			ProcedureHelper.playSound(world, x, y, z, SoundEvents.GLASS_BREAK, SoundSource.PLAYERS, (float) Mth.nextDouble(world.getRandom(), 0.9, 1.1), (float) Mth.nextDouble(world.getRandom(), 0.9, 1.2));
		}
	}
}

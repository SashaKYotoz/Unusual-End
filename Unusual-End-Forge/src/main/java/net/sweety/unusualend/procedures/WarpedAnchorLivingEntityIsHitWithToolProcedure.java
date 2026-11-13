package net.sweety.unusualend.procedures;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.init.UnusualendModMobEffects;
import net.sweety.unusualend.util.ProcedureHelper;

public class WarpedAnchorLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ProcedureHelper.playSound(world, x, y, z, SoundEvents.ANVIL_PLACE, SoundSource.NEUTRAL, (float) 0.1, (float) Mth.nextDouble(world.getRandom(), 0.5, 0.8));
		ProcedureHelper.addEffect(entity, new MobEffectInstance(UnusualendModMobEffects.HEAVINESS.get(), 100, 1));
	}
}

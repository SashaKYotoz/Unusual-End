package net.sweety.unusualend.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.init.UnusualendModMobEffects;
import net.sweety.unusualend.util.ParticleHelper;
import net.sweety.unusualend.util.ProcedureHelper;

public class BolokEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		ProcedureHelper.addEffect(sourceentity, new MobEffectInstance(UnusualendModMobEffects.HEAVINESS.get(), 100, 0));
		ParticleHelper.spawn(world, ParticleHelper.dustTransition(0.165f, 1.0f, 0.753f, 2.0f, 0.137f, 0.506f, 0.533f), (entity.getX()), (entity.getY()), (entity.getZ()), 10, 0.4, 0.4, 0.4, 0);
	}
}

package net.sweety.unusualend.procedures;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.init.UnusualendModDamageSources;
import net.sweety.unusualend.init.UnusualendModMobEffects;
import net.sweety.unusualend.util.ProcedureHelper;
public class SpunklerPlayerCollidesWithThisEntityProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double dis = 0;
		if (!(ProcedureHelper.isSpectator(entity) || ProcedureHelper.isCreative(entity))) {
			entity.hurt(DamageSource.GENERIC, (float) 0.01);
			sourceentity.hurt(UnusualendModDamageSources.SPUNKLER, 4);
			dis = Math.sqrt(Math.pow(sourceentity.getX() - entity.getX(), 2) + Math.pow(sourceentity.getY() - entity.getY(), 2) + Math.pow(sourceentity.getZ() - entity.getZ(), 2));
			ProcedureHelper.addEffect(sourceentity, new MobEffectInstance(MobEffects.LEVITATION, 10, 0));
			ProcedureHelper.addEffect(sourceentity, new MobEffectInstance(UnusualendModMobEffects.HEAVINESS.get(), 10, 0));
			sourceentity.setDeltaMovement(new Vec3((((sourceentity.getX() - entity.getX()) / dis) * 1.6), (((sourceentity.getY() - entity.getY()) / dis) * 1.6), (((sourceentity.getZ() - entity.getZ()) / dis) * 1.6)));
		}
	}
}

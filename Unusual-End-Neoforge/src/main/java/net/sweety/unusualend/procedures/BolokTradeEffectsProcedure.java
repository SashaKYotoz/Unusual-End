package net.sweety.unusualend.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.util.ParticleHelper;
import net.sweety.unusualend.util.ProcedureHelper;

public class BolokTradeEffectsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		ParticleHelper.spawn(world, ParticleTypes.GLOW_SQUID_INK, ParticleHelper.localToEyes(entity, 0, 0, 0.6), 10, 0.1, 0.1, 0.1, 0.01, true);
		if (world.isClientSide()) {
			ProcedureHelper.playSound(world, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.GENERIC_EAT, SoundSource.HOSTILE, 1, (float) 0.75);
		}
		((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
		ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 2, false, false));
		ProcedureHelper.awardAdvancement(sourceentity, "trade_with_bolok");
	}
}

package net.sweety.unusualend.procedures;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.configuration.UEConfig;
import net.sweety.unusualend.init.UnusualEndMiscRegister;
import net.sweety.unusualend.util.ProcedureHelper;

public class WarpedInfusionPlayerFinishesUsingItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(UnusualEndMiscRegister.WARPED_TENACITY)) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(UnusualEndMiscRegister.WARPED_TENACITY) ? _livEnt.getEffect(UnusualEndMiscRegister.WARPED_TENACITY).getAmplifier() : 0) == 1) {
				ProcedureHelper.awardAdvancement(entity, "drink_max_warped_infusion");
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(UnusualEndMiscRegister.WARPED_TENACITY)
					? _livEnt.getEffect(UnusualEndMiscRegister.WARPED_TENACITY).getAmplifier()
					: 0) >= UEConfig.MAX_WARPED_INFUSION.get() - 1) {
				ProcedureHelper.addEffect(entity, new MobEffectInstance(UnusualEndMiscRegister.WARPED_TENACITY,
                            (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(UnusualEndMiscRegister.WARPED_TENACITY) ? _livEnt.getEffect(UnusualEndMiscRegister.WARPED_TENACITY).getDuration() : 0) + 1200,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(UnusualEndMiscRegister.WARPED_TENACITY) ? _livEnt.getEffect(UnusualEndMiscRegister.WARPED_TENACITY).getAmplifier() : 0));
			} else {
				ProcedureHelper.addEffect(entity, new MobEffectInstance(UnusualEndMiscRegister.WARPED_TENACITY, 1200,
                            (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(UnusualEndMiscRegister.WARPED_TENACITY) ? _livEnt.getEffect(UnusualEndMiscRegister.WARPED_TENACITY).getAmplifier() : 0) + 1));
			}
		} else {
			ProcedureHelper.addEffect(entity, new MobEffectInstance(UnusualEndMiscRegister.WARPED_TENACITY, 1200, 0));
		}
		if (world.isClientSide()) {
			ProcedureHelper.playSound(world, x, y, z, SoundEvents.GLASS_BREAK, SoundSource.PLAYERS, (float) 0.9, (float) 1.5);
		}
	}
}

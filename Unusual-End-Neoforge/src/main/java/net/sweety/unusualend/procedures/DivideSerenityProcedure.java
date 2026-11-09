package net.sweety.unusualend.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.sweety.unusualend.init.UnusualEndMiscRegister;
import net.sweety.unusualend.util.ProcedureHelper;

public class DivideSerenityProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
        double level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(UnusualEndMiscRegister.SERENITY) ? _livEnt.getEffect(UnusualEndMiscRegister.SERENITY).getAmplifier() : 0;
		double ticks = (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(UnusualEndMiscRegister.SERENITY) ? _livEnt.getEffect(UnusualEndMiscRegister.SERENITY).getDuration() : 0) / 2d - 20;
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(UnusualEndMiscRegister.SERENITY);
		ProcedureHelper.addEffect(entity, new MobEffectInstance(UnusualEndMiscRegister.SERENITY, (int) ticks, (int) level, false, false));
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.translatable("text.unusualend.used_serenity"), true);
	}
}
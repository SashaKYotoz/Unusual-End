package net.mcreator.unusualend.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;

import net.mcreator.unusualend.init.UnusualendModMobEffects;

public class DivideSerenityProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double level = 0;
		double ticks = 0;
		level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(UnusualendModMobEffects.SERENITY.get()) ? _livEnt.getEffect(UnusualendModMobEffects.SERENITY.get()).getAmplifier() : 0;
		ticks = (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(UnusualendModMobEffects.SERENITY.get()) ? _livEnt.getEffect(UnusualendModMobEffects.SERENITY.get()).getDuration() : 0) / 2 - 20;
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(UnusualendModMobEffects.SERENITY.get());
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(UnusualendModMobEffects.SERENITY.get(), (int) ticks, (int) level, false, false));
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal((Component.translatable("text.unusualend.used_serenity").getString())), true);
	}
}

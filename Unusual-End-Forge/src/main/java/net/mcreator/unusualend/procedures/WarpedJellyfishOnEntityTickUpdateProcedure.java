package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.unusualend.init.UnusualendModParticleTypes;
import net.mcreator.unusualend.entity.LargeBubbleEntity;

public class WarpedJellyfishOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (y < 30 && (entity.level().dimension()) == Level.END) {
			if (entity instanceof Mob _entity)
				_entity.getNavigation().moveTo(x, 45, z, 0.8);
			if (y < 10) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 60, 0));
			}
		}
		if (!((entity.getVehicle()) == null) && !((entity.getVehicle()) instanceof LargeBubbleEntity)) {
			if ((entity.getVehicle()) instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 15, 2, false, false));
			if ((entity.getVehicle()) instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 15, 0, false, false));
			if ((entity.getVehicle()) instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A77" + Component.translatable("text.unusualend.unequip_glub").getString())), true);
		} else {
			if (Math.random() < 0.3) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (UnusualendModParticleTypes.BOLOK_PARTICLE.get()), x, y, z, 1, 0.1, 0.1, 0.1, 0.1);
			}
		}
	}
}

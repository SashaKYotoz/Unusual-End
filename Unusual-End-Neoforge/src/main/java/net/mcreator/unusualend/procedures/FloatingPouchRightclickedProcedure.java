package net.mcreator.unusualend.procedures;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModItems;
import net.mcreator.unusualend.configuration.UEConfig;
import net.mcreator.unusualend.UnusualEnd;

public class FloatingPouchRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualendModItems.FLOATING_POUCH.get()) {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.OFF_HAND, true);
		}
		if (world.isClientSide()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.FIRE_EXTINGUISH, SoundSource.PLAYERS, (float) 0.5, 1);
				} else {
					_level.playLocalSound(x, y, z, SoundEvents.FIRE_EXTINGUISH, SoundSource.PLAYERS, (float) 0.5, 1, false);
				}
			}
		}
		{
			ItemStack _ist = itemstack;
			if (_ist.hurt(1, RandomSource.create(), null)) {
				_ist.shrink(1);
				_ist.setDamageValue(0);
			}
		}
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), (int) (double) UEConfig.POUCH.get());
		entity.fallDistance = 0;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.POOF, x, y, z, 20, 0.3, 0.3, 0.3, 0.1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.END_ROD, x, y, z, 5, 0.3, 0.3, 0.3, 0.1);
		if (entity instanceof LivingEntity _livEnt14 && _livEnt14.isFallFlying()) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() * 1.3), 0.8, (entity.getDeltaMovement().z() * 1.3)));
		} else {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 1, (entity.getDeltaMovement().z())));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 40, 0));
			UnusualEnd.queueServerWork(60, () -> {
				entity.fallDistance = 0;
				UnusualEnd.queueServerWork(20, () -> {
					entity.fallDistance = 0;
				});
			});
		}
	}
}

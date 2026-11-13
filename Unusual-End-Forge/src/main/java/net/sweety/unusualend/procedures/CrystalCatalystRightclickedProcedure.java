package net.sweety.unusualend.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.init.UnusualendModMobEffects;
import net.sweety.unusualend.util.ProcedureHelper;

public class CrystalCatalystRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("Catalyser") >= 1) {
			if (itemstack.getOrCreateTag().getDouble("cataCooldown") >= 400) {
				if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= 1) {
					itemstack.getOrCreateTag().putDouble("cataCooldown", 0);
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(-(7));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualendModItems.CRYSTAL_CATALYST.get()) {
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
					} else {
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.OFF_HAND, true);
					}
					{
						ItemStack _ist = itemstack;
						if (_ist.hurt(1, world.getRandom(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), 10);
					if (itemstack.getOrCreateTag().getDouble("Catalyser") == 1) {
						ProcedureHelper.playSound(world, x, y, z, SoundEvents.BEACON_ACTIVATE, SoundSource.PLAYERS, (float) 0.5, 2);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.END_ROD, x, (y + 1.5), z, 30, 0.9, 0.9, 0.9, 0);
						if (Math.random() < 0.5) {
							ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0, true, false));
							ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.JUMP, 400, 0, true, false));
							ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.DIG_SPEED, 400, 0, false, false));
						} else {
							ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 0, false, false));
							ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 0, false, false));
							ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.REGENERATION, 400, 0, false, false));
						}
					} else if (itemstack.getOrCreateTag().getDouble("Catalyser") == 2) {
						ProcedureHelper.playSound(world, x, y, z, SoundEvents.CONDUIT_ACTIVATE, SoundSource.PLAYERS, (float) 0.5, 2);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SPLASH, x, (y + 1.5), z, 30, 0.9, 0.9, 0.9, 0);
						ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.CONDUIT_POWER, 400, 0, false, false));
					} else if (itemstack.getOrCreateTag().getDouble("Catalyser") == 3) {
						ProcedureHelper.playSound(world, x, y, z, SoundEvents.GENERIC_BURN, SoundSource.PLAYERS, (float) 0.5, 2);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.WITCH, x, (y + 1.5), z, 30, 0.9, 0.9, 0.9, 0);
						if (Math.random() < 0.3) {
							ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.HEALTH_BOOST, 400, 0, true, false));
							ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.REGENERATION, 200, 0, false, false));
						} else if (Math.random() < 0.3) {
							ProcedureHelper.addEffect(entity, new MobEffectInstance(UnusualendModMobEffects.SWIFT_STRIKES.get(), 400, 0, true, false));
						} else {
							ProcedureHelper.addEffect(entity, new MobEffectInstance(UnusualendModMobEffects.SERENITY.get(), 400, 0, true, false));
						}
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.translatable("text.unusualend.no_xp"), true);
				}
			}
		}
	}
}

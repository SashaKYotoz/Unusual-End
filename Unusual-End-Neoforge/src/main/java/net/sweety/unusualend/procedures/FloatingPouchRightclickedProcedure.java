package net.sweety.unusualend.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.configuration.UEConfig;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.util.ProcedureHelper;

public class FloatingPouchRightclickedProcedure {
    public static void execute(LevelAccessor level, double x, double y, double z, LivingEntity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        if (entity.getMainHandItem().getItem() == UnusualEndItems.FLOATING_POUCH.get()) {
            entity.swing(InteractionHand.MAIN_HAND, true);
        } else {
            entity.swing(InteractionHand.OFF_HAND, true);
        }
        if (level.isClientSide()) {
            ProcedureHelper.playSound(level, x, y, z, SoundEvents.FIRE_EXTINGUISH, SoundSource.PLAYERS, (float) 0.5, 1);
        }
        itemstack.hurtAndBreak(1, entity, entity.getEquipmentSlotForItem(itemstack));
        if (entity instanceof Player _player)
            _player.getCooldowns().addCooldown(itemstack.getItem(), (int) (double) UEConfig.POUCH.get());
        entity.fallDistance = 0;
        if (level instanceof ServerLevel _level)
            _level.sendParticles(ParticleTypes.POOF, x, y, z, 20, 0.3, 0.3, 0.3, 0.1);
        if (level instanceof ServerLevel _level)
            _level.sendParticles(ParticleTypes.END_ROD, x, y, z, 5, 0.3, 0.3, 0.3, 0.1);
        if (entity instanceof LivingEntity _livEnt14 && _livEnt14.isFallFlying()) {
            entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() * 1.3), 0.8, (entity.getDeltaMovement().z() * 1.3)));
        } else {
            entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 1, (entity.getDeltaMovement().z())));
            ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.SLOW_FALLING, 40, 0));
            UnusualEnd.queueServerWork(60, () -> {
                entity.fallDistance = 0;
                UnusualEnd.queueServerWork(20, () -> {
                    entity.fallDistance = 0;
                });
            });
        }
    }
}

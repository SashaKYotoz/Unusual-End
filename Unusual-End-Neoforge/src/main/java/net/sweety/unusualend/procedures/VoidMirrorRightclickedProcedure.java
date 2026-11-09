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
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.init.UnusualEndMiscRegister;
import net.sweety.unusualend.util.ParticleHelper;
import net.sweety.unusualend.util.ProcedureHelper;

public class VoidMirrorRightclickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, LivingEntity entity, ItemStack stack) {
        if (entity == null)
            return;
        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualEndItems.VOID_MIRROR.get()) {
            if (entity instanceof LivingEntity _entity)
                _entity.swing(InteractionHand.MAIN_HAND, true);
        } else {
            if (entity instanceof LivingEntity _entity)
                _entity.swing(InteractionHand.OFF_HAND, true);
        }
        ParticleHelper.spawn(world, ParticleHelper.voidParticles(), new Vec3(x, y, z).add(0, 1, 0), 3, 1.5, 1, 1.5, 0);
        if (world instanceof ServerLevel _level)
            _level.sendParticles(ParticleTypes.END_ROD, x, y, z, 10, 1, 1, 1, 0.1);
        ProcedureHelper.addEffect(entity, new MobEffectInstance(UnusualEndMiscRegister.BREACH_LINKED, 6000, 0, false, false));
        ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.BLINDNESS, 20, 0, false, false));
        if (entity instanceof Player _player)
            _player.getCooldowns().addCooldown(stack.getItem(), 6000);
        stack.hurtAndBreak(1,entity,entity.getEquipmentSlotForItem(stack));
        ProcedureHelper.playSound(world, x, y, z, SoundEvents.RESPAWN_ANCHOR_SET_SPAWN, SoundSource.NEUTRAL, 1, 2);
    }
}

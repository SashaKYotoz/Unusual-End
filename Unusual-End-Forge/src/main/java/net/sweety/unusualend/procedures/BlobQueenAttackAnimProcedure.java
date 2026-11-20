package net.sweety.unusualend.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.entity.EnderblobQueenEntity;
import net.sweety.unusualend.util.ParticleHelper;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BlobQueenAttackAnimProcedure {
    @SubscribeEvent
    public static void onEntityAttacked(LivingAttackEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity().level, event.getSource().getEntity());
        }
    }

    public static void execute(LevelAccessor world, Entity sourceentity) {
        execute(null, world, sourceentity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Entity sourceentity) {
        if (sourceentity == null)
            return;
        double swing_curve = 0;
        double swing_offset = 0;
        double original_curve = 0;
        if (sourceentity instanceof EnderblobQueenEntity) {
            sourceentity.setSprinting(true);
            swing_offset = 2;
            swing_curve = 1;
            original_curve = swing_curve;
            for (int i = 0; i < 30; i++) {
                {
                    if (!sourceentity.level.isClientSide() && sourceentity.getServer() != null) {
                        ParticleHelper.spawn(sourceentity.level, ParticleHelper.voidParticles(), ParticleHelper.localToEyes(sourceentity, swing_offset, swing_curve + 0.6, 2), 3, 0.1, 0.1, 0.1, 0);
                    }
                }
                if (Math.random() < 0.1) {
                    if (!sourceentity.level.isClientSide() && sourceentity.getServer() != null) {
                        ParticleHelper.spawn(sourceentity.level, ParticleTypes.END_ROD, ParticleHelper.localToEyes(sourceentity, swing_offset, swing_curve + 0.6, 2), 0, 0, 0, 0, 0);
                    }
                }
                if (Math.random() < 0.3) {
                    if (!sourceentity.level.isClientSide() && sourceentity.getServer() != null) {
                        ParticleHelper.spawn(sourceentity.level, ParticleTypes.SQUID_INK, ParticleHelper.localToEyes(sourceentity, swing_offset, swing_curve + 0.6, 2), 0, 0, 0, 0, 0);
                    }
                }
                swing_offset = swing_offset - 0.1;
                swing_curve = swing_curve - original_curve / 10;
            }
            UnusualEnd.queueServerWork(11, () -> {
                sourceentity.setSprinting(false);
            });
        }
    }
}

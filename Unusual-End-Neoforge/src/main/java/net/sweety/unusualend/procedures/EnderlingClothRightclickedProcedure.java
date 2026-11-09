package net.sweety.unusualend.procedures;

import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.PlayerTeam;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.init.UnusualEndMiscRegister;
import net.sweety.unusualend.network.UnusualEndVariables;
import net.sweety.unusualend.util.ParticleHelper;
import net.sweety.unusualend.util.ProcedureHelper;

public class EnderlingClothRightclickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        itemstack.shrink(1);
        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
            if (entity instanceof LivingEntity _entity)
                _entity.swing(InteractionHand.MAIN_HAND, true);
        } else {
            if (entity instanceof LivingEntity _entity)
                _entity.swing(InteractionHand.OFF_HAND, true);
        }
        UnusualEndVariables.PlayerVariables variables = entity.getData(UnusualEndVariables.PLAYER_VARIABLES.get());
        variables.scrapeOverlay = 1200;
        variables.syncPlayerVariables(entity);
        ParticleHelper.spawn(world, ParticleHelper.enderClothDust(), new Vec3(x, y, z).add(0, 1, 0), 40, 0.4, 0.5, 0.4, 0);
        if (world instanceof ServerLevel _level)
            _level.sendParticles(ParticleTypes.POOF, x, (y + 1), z, 10, 0.5, 0.5, 0.5, 0);
        ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.INVISIBILITY, 1200, 1, false, false));
        ProcedureHelper.addEffect(entity, new MobEffectInstance(UnusualEndMiscRegister.SPECTRAL_STRIDE, 1200, 0, false, false));
        if (entity instanceof Player _player)
            _player.getCooldowns().addCooldown(UnusualEndItems.SPECTRAL_CLOTH.get(), 100);
        if (world instanceof Level _level)
            _level.getScoreboard().addPlayerTeam((entity.getStringUUID()));
        {
            Entity _entityTeam = entity;
            PlayerTeam _pt = _entityTeam.level().getScoreboard().getPlayerTeam((entity.getStringUUID()));
            if (_pt != null) {
                if (_entityTeam instanceof Player _player)
                    _entityTeam.level().getScoreboard().addPlayerToTeam(_player.getGameProfile().getName(), _pt);
                else
                    _entityTeam.level().getScoreboard().addPlayerToTeam(_entityTeam.getStringUUID(), _pt);
            }
        }
        if (world.isClientSide()) {
            ProcedureHelper.playSound(world, x, y, z, SoundEvents.GENERIC_BURN, SoundSource.PLAYERS, (float) 0.3, 1);
        }
    }
}

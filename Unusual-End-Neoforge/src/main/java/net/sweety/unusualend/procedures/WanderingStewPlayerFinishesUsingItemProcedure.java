package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.sweety.unusualend.util.ProcedureHelper;

public class WanderingStewPlayerFinishesUsingItemProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (!((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD)) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.PORTAL, x, (y + 1), z, 60, 0.5, 1, 0.5, 0);
            ProcedureHelper.playSound(world, x, y, z, SoundEvents.PORTAL_TRAVEL, SoundSource.PLAYERS, (float) 0.1, 1);
            if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
                ResourceKey<Level> destinationType = Level.OVERWORLD;
                if (_player.level().dimension() == destinationType)
                    return;
                ServerLevel nextLevel = _player.server.getLevel(destinationType);
                if (nextLevel != null) {
                    _player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
                    _player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
                    _player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
                    for (MobEffectInstance _effectinstance : _player.getActiveEffects())
                        _player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, true));
                    _player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
                }
            }
            entity.teleportTo((world.getLevelData().getSpawnPos().getX()), (world.getLevelData().getSpawnPos().getY()), (world.getLevelData().getSpawnPos().getZ()));
            if (entity instanceof ServerPlayer _serverPlayer)
                _serverPlayer.connection.teleport((world.getLevelData().getSpawnPos().getX()), (world.getLevelData().getSpawnPos().getY()), (world.getLevelData().getSpawnPos().getZ()), entity.getYRot(), entity.getXRot());
            entity.fallDistance = 0;
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.PORTAL, (world.getLevelData().getSpawnPos().getX()), (world.getLevelData().getSpawnPos().getY() + 1), (world.getLevelData().getSpawnPos().getZ()), 60, 0.5, 1, 0.5, 0);
        }
        if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD) {
            ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.INVISIBILITY, 12000, 0, false, true));
        }
    }
}

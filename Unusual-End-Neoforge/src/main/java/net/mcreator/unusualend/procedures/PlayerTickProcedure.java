package net.mcreator.unusualend.procedures;

import net.mcreator.unusualend.entity.EnderblobQueenEntity;
import net.mcreator.unusualend.entity.EndstoneGolemEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.unusualend.network.UnusualendModVariables;
import net.mcreator.unusualend.BiomeMusicLibrary;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.TickEvent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerTickProcedure {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            playMusic(event.player.level(), event.player);
            updateMusic(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
            overlayUpdate(event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
            onReturnMusic(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
        }
    }

    private static void playMusic(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        double MusicID;
        if (world.isClientSide()) {
            UnusualendModVariables.PlayerVariables variables = entity.getData(UnusualendModVariables.PLAYER_VARIABLES.get());
            MusicID = variables.PlayerMusic;
            BiomeMusicLibrary.PlayTrack((int) MusicID);
        }
    }

    private static void updateMusic(Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (!world.isClientSide()) {
            if (!onReturnMusic(null, world, x, y, z, entity)) {
                UnusualendModVariables.PlayerVariables variables = entity.getData(UnusualendModVariables.PLAYER_VARIABLES.get());
                variables.PlayerMusic = -1;
                variables.syncPlayerVariables(entity);
            }
        }
    }

    private static void overlayUpdate(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        UnusualendModVariables.PlayerVariables variables = entity.getData(UnusualendModVariables.PLAYER_VARIABLES.get());
        if (variables.ScrapeOverlay == 1) {
            variables.ScrapeOverlay = 0;
            variables.syncPlayerVariables(entity);
            if (world instanceof ServerLevel _level)
                _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                        ("team remove " + entity.getStringUUID()));
            if (world instanceof ServerLevel _level)
                _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                        "particle dust_color_transition 0.827 0.216 0.741 1.5 0.047 0.047 0.047 ~ ~1 ~ 0.4 0.5 0.4 0 40 normal");
            if (world.isClientSide()) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.GENERIC_BURN, SoundSource.PLAYERS, (float) 0.3, 1);
                    } else {
                        _level.playLocalSound(x, y, z, SoundEvents.GENERIC_BURN, SoundSource.PLAYERS, (float) 0.3, 1, false);
                    }
                }
            }
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.POOF, x, (y + 1), z, 10, 0.5, 0.5, 0.5, 0);
        } else if (variables.ScrapeOverlay > 0) {
            variables.ScrapeOverlay = variables.ScrapeOverlay - 1;
            variables.syncPlayerVariables(entity);
            if (!(entity instanceof LivingEntity living && living.hasEffect(MobEffects.INVISIBILITY))) {
                variables.ScrapeOverlay = 1;
                variables.syncPlayerVariables(entity);
            }
        }
    }

    private static boolean onReturnMusic(@Nullable TickEvent.PlayerTickEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return false;
        boolean music = false;
        UnusualendModVariables.PlayerVariables variables = entity.getData(UnusualendModVariables.PLAYER_VARIABLES.get());
        if (!world.getEntitiesOfClass(EndstoneGolemEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
            variables.PlayerMusic = 0;
            variables.syncPlayerVariables(entity);
            music = true;
        } else if (!world.getEntitiesOfClass(EnderblobQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
            variables.PlayerMusic = 1;
            variables.syncPlayerVariables(entity);
            music = true;
        } else {
            variables.PlayerMusic = -1;
            variables.syncPlayerVariables(entity);
        }
        return music;
    }
}
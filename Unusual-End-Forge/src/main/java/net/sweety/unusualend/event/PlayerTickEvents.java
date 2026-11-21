package net.sweety.unusualend.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sweety.unusualend.BiomeMusicLibrary;
import net.sweety.unusualend.entity.EnderblobQueenEntity;
import net.sweety.unusualend.entity.EndstoneGolemEntity;
import net.sweety.unusualend.init.UnusualendModBlocks;
import net.sweety.unusualend.init.UnusualendModEnchantments;
import net.sweety.unusualend.item.PearlescentRingItem;
import net.sweety.unusualend.network.UnusualendModVariables;
import net.sweety.unusualend.util.ParticleHelper;
import net.sweety.unusualend.util.ProcedureHelper;
import net.sweety.unusualend.util.TeleportHelper;

@Mod.EventBusSubscriber
public class PlayerTickEvents {
    private static final int NO_TRACK = -1;
    private static final int GOLEM_TRACK = 0;
    private static final int BLOB_QUEEN_TRACK = 1;
    private static final int BOSS_MUSIC_INTERVAL = 20;
    private static final double BOSS_MUSIC_RANGE = 100;
    private static final double WINGS_MIN_SPEED = 1.8;

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END)
            return;
        Player player = event.player;
        Level level = player.level();
        boloksWings(player, level);
        draglingPlushCooldown(player);
        player.getCapability(UnusualendModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> {
            scrapeOverlay(player, level, variables);
            if (level.isClientSide()) {
                if (player.isLocalPlayer())
                    BiomeMusicLibrary.PlayTrack((int) variables.PlayerMusic);
                return;
            }
            teleportAnchorCheck(player, level, variables);
            updateBossMusic(player, level, variables);
        });
        if (!level.isClientSide())
            PearlescentRingItem.rechargeCurios(player);
    }

    private static double speed(Entity entity) {
        Vec3 motion = entity.getDeltaMovement();
        return Math.abs(motion.x()) + Math.abs(motion.y()) + Math.abs(motion.z());
    }

    private static void boloksWings(Player player, Level level) {
        if (!player.isFallFlying())
            return;
        int wings = player.getItemBySlot(EquipmentSlot.CHEST).getEnchantmentLevel(UnusualendModEnchantments.BOLOKS_WINGS.get());
        if (wings == 0 || speed(player) <= WINGS_MIN_SPEED)
            return;
        DamageSource ram = new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FLY_INTO_WALL));
        float damage = (float) ((speed(player) + 1) * wings);
        for (Entity hit : level.getEntities(player, new AABB(player.position(), player.position()).inflate(1.25), entity -> !(entity instanceof FireworkRocketEntity))) {
            hit.invulnerableTime = 0;
            hit.hurt(ram, damage);
        }
        Vec3 trail = player.position().add(0, 0.1, 0);
        ParticleHelper.spawn(level, ParticleHelper.dustTransition(0.067f, 0.608f, 0.522f, 1.0f, 0.737f, 0.902f, 0.922f), trail, 1, 0.4, 0.2, 0.4, 0);
        ParticleHelper.spawn(level, ParticleHelper.dustTransition(0.094f, 0.851f, 0.729f, 1.2f, 0.98f, 0.988f, 1.0f), trail, 1, 0.4, 0.2, 0.4, 0);
    }

    private static void draglingPlushCooldown(Player player) {
        Item plush = UnusualendModBlocks.DRAGLING_PLUSH.get().asItem();
        if (player.getOffhandItem().is(plush) && !player.getMainHandItem().is(plush))
            player.getCooldowns().addCooldown(plush, 20);
    }

    private static void scrapeOverlay(Player player, Level level, UnusualendModVariables.PlayerVariables variables) {
        double overlay = variables.ScrapeOverlay;
        if (overlay <= 0)
            return;
        if (overlay == 1) {
            variables.ScrapeOverlay = 0;
            variables.syncPlayerVariables(player);
            if (level instanceof ServerLevel serverLevel) {
                PlayerTeam team = serverLevel.getScoreboard().getPlayerTeam(player.getStringUUID());
                if (team != null)
                    serverLevel.getScoreboard().removePlayerTeam(team);
                serverLevel.sendParticles(ParticleTypes.POOF, player.getX(), player.getY() + 1, player.getZ(), 10, 0.5, 0.5, 0.5, 0);
            }
            ParticleHelper.spawn(level, ParticleHelper.enderClothDust(), player.position().add(0, 1, 0), 40, 0.4, 0.5, 0.4, 0);
            if (level.isClientSide())
                ProcedureHelper.playSound(level, player.getX(), player.getY(), player.getZ(), SoundEvents.GENERIC_BURN, SoundSource.PLAYERS, 0.3f, 1);
            return;
        }
        variables.ScrapeOverlay = player.hasEffect(MobEffects.INVISIBILITY) ? overlay - 1 : 1;
        variables.syncPlayerVariables(player);
    }

    private static void teleportAnchorCheck(Player player, Level level, UnusualendModVariables.PlayerVariables variables) {
        if (!variables.isTeleporting || !player.getPersistentData().getString("TargetDimension").equals(String.valueOf(level.dimension())))
            return;
        BlockPos anchor = BlockPos.containing(player.getPersistentData().getDouble("TargetX"), player.getPersistentData().getDouble("TargetY") - 1, player.getPersistentData().getDouble("TargetZ"));
        if (!level.getBlockState(anchor).is(UnusualendModBlocks.TELEPORTATION_ANCHOR.get())) {
            TeleportHelper.teleport(player, Mth.nextDouble(level.getRandom(), -1000, 1000), Mth.nextDouble(level.getRandom(), 100, 120), Mth.nextDouble(level.getRandom(), -1000, 1000));
            ProcedureHelper.addEffect(player, new MobEffectInstance(MobEffects.SLOW_FALLING, 300, 1));
            ProcedureHelper.addEffect(player, new MobEffectInstance(MobEffects.DARKNESS, 80, 0));
            player.displayClientMessage(Component.translatable("text.unusualend.tp_error"), true);
            if (level instanceof ServerLevel serverLevel)
                serverLevel.sendParticles(ParticleTypes.PORTAL, player.getX(), player.getY(), player.getZ(), 50, 0.5, 1.5, 0.5, 0);
            ProcedureHelper.playSound(level, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDER_EYE_DEATH, SoundSource.PLAYERS, 1, 1);
        }
        variables.isTeleporting = false;
        variables.syncPlayerVariables(player);
    }

    private static void updateBossMusic(Player player, Level level, UnusualendModVariables.PlayerVariables variables) {
        if (!(player instanceof ServerPlayer) || player.tickCount % BOSS_MUSIC_INTERVAL != 0)
            return;
        int track = bossTrack(player, level);
        if (variables.PlayerMusic == track)
            return;
        variables.PlayerMusic = track;
        variables.syncPlayerVariables(player);
    }

    private static int bossTrack(Player player, Level level) {
        AABB area = AABB.ofSize(player.position(), BOSS_MUSIC_RANGE, BOSS_MUSIC_RANGE, BOSS_MUSIC_RANGE);
        if (!level.getEntitiesOfClass(EndstoneGolemEntity.class, area).isEmpty())
            return GOLEM_TRACK;
        if (!level.getEntitiesOfClass(EnderblobQueenEntity.class, area).isEmpty())
            return BLOB_QUEEN_TRACK;
        return NO_TRACK;
    }
}
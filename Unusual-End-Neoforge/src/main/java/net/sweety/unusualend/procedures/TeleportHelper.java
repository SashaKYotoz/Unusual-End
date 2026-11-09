package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.network.UnusualEndVariables;
import net.sweety.unusualend.util.ProcedureHelper;

import java.util.Optional;

public final class TeleportHelper {
    private TeleportHelper() {
    }

    public static Optional<ResourceKey<Level>> parseDimension(String raw) {
        if (raw == null || raw.isBlank())
            return Optional.empty();
        String id = raw.trim();
        int separator = id.lastIndexOf(" / ");
        if (id.startsWith("ResourceKey[") && id.endsWith("]") && separator >= 0)
            id = id.substring(separator + 3, id.length() - 1);
        ResourceLocation location = ResourceLocation.tryParse(id);
        return location == null ? Optional.empty() : Optional.of(ResourceKey.create(Registries.DIMENSION, location));
    }

    public static ServerLevel linkedLevel(ServerPlayer player, ItemStack stack) {
        return parseDimension(NBTProcessor.getNBTString(stack, "TpW"))
                .map(player.server::getLevel)
                .orElse(player.serverLevel());
    }

    public static Vec3 linkedPosition(ItemStack stack) {
        return new Vec3(NBTProcessor.getNBTDouble(stack, "TpX"), NBTProcessor.getNBTDouble(stack, "TpY"), NBTProcessor.getNBTDouble(stack, "TpZ"));
    }

    public static boolean isSafeDestination(ServerLevel level, Vec3 position) {
        BlockPos pos = BlockPos.containing(position);
        return Level.isInSpawnableBounds(pos) && level.getWorldBorder().isWithinBounds(pos)
                && pos.getY() >= level.getMinBuildHeight() && pos.getY() < level.getMaxBuildHeight() + 64;
    }

    public static boolean teleport(ServerPlayer player, ServerLevel level, Vec3 position) {
        if (!isSafeDestination(level, position))
            return false;
        player.resetFallDistance();
        player.setDeltaMovement(Vec3.ZERO);
        player.teleportTo(level, position.x, position.y, position.z, player.getYRot(), player.getXRot());
        player.resetFallDistance();
        return true;
    }

    public static void rememberAnchorTarget(ServerPlayer player, ItemStack stack) {
        player.getPersistentData().putString("TargetDimension", NBTProcessor.getNBTString(stack, "TpW"));
        player.getPersistentData().putDouble("TargetX", NBTProcessor.getNBTDouble(stack, "TpX") - 0.5);
        player.getPersistentData().putDouble("TargetY", NBTProcessor.getNBTDouble(stack, "TpY"));
        player.getPersistentData().putDouble("TargetZ", NBTProcessor.getNBTDouble(stack, "TpZ") - 0.5);
        UnusualEndVariables.PlayerVariables variables = player.getData(UnusualEndVariables.PLAYER_VARIABLES.get());
        variables.teleporting = true;
        variables.syncPlayerVariables(player);
    }

    public static void playArrivalEffects(ServerLevel level, Player player, SoundSource source) {
        level.sendParticles(ParticleTypes.PORTAL, player.getX(), player.getY(), player.getZ(), 50, 0.5, 1.5, 0.5, 0);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.CHORUS_FRUIT_TELEPORT, source, 1, 1);
    }

    public static Vec3 voidRescuePosition(ServerLevel level, double x, double z) {
        BlockPos column = BlockPos.containing(x, level.getMinBuildHeight(), z);
        if (!level.dimensionType().hasCeiling()) {
            int surface = level.getHeight(Heightmap.Types.MOTION_BLOCKING, column.getX(), column.getZ());
            if (surface > level.getMinBuildHeight())
                return new Vec3(x, surface, z);
            return new Vec3(x, level.getMaxBuildHeight() + 4, z);
        }
        int top = Math.min(level.getMaxBuildHeight(), level.getMinBuildHeight() + level.dimensionType().logicalHeight()) - 2;
        BlockPos.MutableBlockPos cursor = column.mutable();
        for (int y = top; y > level.getMinBuildHeight(); y--) {
            cursor.setY(y);
            if (level.getBlockState(cursor).isAir() && level.getBlockState(cursor.above()).isAir()
                    && level.getBlockState(cursor.below()).isFaceSturdy(level, cursor.below(), Direction.UP))
                return new Vec3(x, y, z);
        }
        return new Vec3(x, top, z);
    }

    public static void awardAdvancement(ServerPlayer player, String path) {
        ProcedureHelper.awardAdvancement(player, path);
    }
}
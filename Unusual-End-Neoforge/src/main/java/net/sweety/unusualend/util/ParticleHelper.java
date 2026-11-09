package net.sweety.unusualend.util;

import net.minecraft.core.particles.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.init.UnusualEndBlocks;
import org.joml.Vector3f;

public final class ParticleHelper {

    public static ParticleOptions block(Block block) {
        return new BlockParticleOption(ParticleTypes.BLOCK, block.defaultBlockState());
    }

    public static ParticleOptions voidParticles() {
        return block(UnusualEndBlocks.VOID_PARTICLES_BLOCK.get());
    }

    public static ParticleOptions item(ItemLike item) {
        return new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(item));
    }

    public static ParticleOptions dust(float red, float green, float blue, float scale) {
        return new DustParticleOptions(new Vector3f(red, green, blue), scale);
    }

    public static ParticleOptions dustTransition(float fromRed, float fromGreen, float fromBlue, float scale, float toRed, float toGreen, float toBlue) {
        return new DustColorTransitionOptions(new Vector3f(fromRed, fromGreen, fromBlue), new Vector3f(toRed, toGreen, toBlue), scale);
    }

    public static ParticleOptions enderClothDust() {
        return dustTransition(0.827f, 0.216f, 0.741f, 1.5f, 0.047f, 0.047f, 0.047f);
    }

    public static Vec3 localToEyes(Entity entity, double left, double up, double forwards) {
        float yaw = entity.getYRot();
        float pitch = entity.getXRot();
        float cosYaw = Mth.cos((yaw + 90.0F) * Mth.DEG_TO_RAD);
        float sinYaw = Mth.sin((yaw + 90.0F) * Mth.DEG_TO_RAD);
        float cosPitch = Mth.cos(-pitch * Mth.DEG_TO_RAD);
        float sinPitch = Mth.sin(-pitch * Mth.DEG_TO_RAD);
        float cosPitchUp = Mth.cos((-pitch + 90.0F) * Mth.DEG_TO_RAD);
        float sinPitchUp = Mth.sin((-pitch + 90.0F) * Mth.DEG_TO_RAD);
        Vec3 forward = new Vec3(cosYaw * cosPitch, sinPitch, sinYaw * cosPitch);
        Vec3 upward = new Vec3(cosYaw * cosPitchUp, sinPitchUp, sinYaw * cosPitchUp);
        Vec3 leftward = forward.cross(upward).scale(-1.0);
        return entity.getEyePosition().add(forward.scale(forwards)).add(upward.scale(up)).add(leftward.scale(left));
    }

    public static void spawn(LevelAccessor level, ParticleOptions particle, double x, double y, double z, int count, double dx, double dy, double dz, double speed) {
        spawn(level, particle, x, y, z, count, dx, dy, dz, speed, false);
    }

    public static void spawn(LevelAccessor level, ParticleOptions particle, Vec3 pos, int count, double dx, double dy, double dz, double speed) {
        spawn(level, particle, pos.x, pos.y, pos.z, count, dx, dy, dz, speed, false);
    }

    public static void spawn(LevelAccessor level, ParticleOptions particle, Vec3 pos, int count, double dx, double dy, double dz, double speed, boolean force) {
        spawn(level, particle, pos.x, pos.y, pos.z, count, dx, dy, dz, speed, force);
    }

    public static void spawn(LevelAccessor level, ParticleOptions particle, double x, double y, double z, int count, double dx, double dy, double dz, double speed, boolean force) {
        if (level instanceof ServerLevel serverLevel) {
            if (force) {
                for (ServerPlayer player : serverLevel.players())
                    serverLevel.sendParticles(player, particle, true, x, y, z, count, dx, dy, dz, speed);
            } else {
                serverLevel.sendParticles(particle, x, y, z, count, dx, dy, dz, speed);
            }
        } else if (level instanceof Level clientLevel) {
            RandomSource random = clientLevel.getRandom();
            if (count == 0) {
                clientLevel.addParticle(particle, force, x, y, z, dx * speed, dy * speed, dz * speed);
                return;
            }
            for (int i = 0; i < count; i++) {
                clientLevel.addParticle(particle, force, x + random.nextGaussian() * dx, y + random.nextGaussian() * dy, z + random.nextGaussian() * dz,
                        random.nextGaussian() * speed, random.nextGaussian() * speed, random.nextGaussian() * speed);
            }
        }
    }
}
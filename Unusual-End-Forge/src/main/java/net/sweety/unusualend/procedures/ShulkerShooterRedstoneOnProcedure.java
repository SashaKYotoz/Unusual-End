package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ShulkerBullet;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.util.ProcedureHelper;

public class ShulkerShooterRedstoneOnProcedure {
    private static final double DETECTION_RANGE = 16;
    private static final double BULLET_SPEED = 0.5;

    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (!(world instanceof ServerLevel level))
            return;
        BlockPos pos = BlockPos.containing(x, y, z);
        if (level.hasNeighborSignal(pos))
            return;
        Player target = level.getEntitiesOfClass(Player.class, AABB.ofSize(Vec3.atCenterOf(pos), DETECTION_RANGE, DETECTION_RANGE, DETECTION_RANGE), player -> !player.isCreative() && !player.isSpectator())
                .stream().min(ProcedureHelper.byDistanceTo(x, y, z)).orElse(null);
        if (target == null)
            return;
        Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(level.getRandom());
        if (!level.isEmptyBlock(pos.relative(direction)))
            return;
        ShulkerBullet bullet = EntityType.SHULKER_BULLET.create(level);
        if (bullet == null)
            return;
        double halfWidth = bullet.getBbWidth() / 2;
        double offset = 0.5 + halfWidth;
        Vec3 center = Vec3.atCenterOf(pos);
        double spawnX = center.x + direction.getStepX() * offset;
        double spawnY = center.y - bullet.getBbHeight() / 2;
        double spawnZ = center.z + direction.getStepZ() * offset;
        double velocityX = direction.getStepX() * BULLET_SPEED;
        double velocityZ = direction.getStepZ() * BULLET_SPEED;
        bullet.moveTo(spawnX, spawnY, spawnZ, level.getRandom().nextFloat() * 360.0F, 0);
        bullet.setDeltaMovement(velocityX, 0, velocityZ);
        CompoundTag data = bullet.saveWithoutId(new CompoundTag());
        data.putUUID("Target", target.getUUID());
        data.putInt("Steps", 3);
        data.putInt("Dir", direction.get3DDataValue());
        data.putDouble("TXD", velocityX);
        data.putDouble("TYD", 0);
        data.putDouble("TZD", velocityZ);
        bullet.load(data);
        level.addFreshEntity(bullet);
        level.sendParticles(ParticleTypes.POOF, spawnX, center.y, spawnZ, 3, 0.2, 0.2, 0.2, 0.1);
        ProcedureHelper.playSound(level, x, y, z, SoundEvents.SHULKER_SHOOT, SoundSource.BLOCKS, 1, 0.6f);
    }
}
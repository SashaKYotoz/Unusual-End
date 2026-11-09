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
    private static final Direction[] FIRING_SIDES = {Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST};

    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (!(world instanceof ServerLevel level))
            return;
        BlockPos pos = BlockPos.containing(x, y, z);
        if (level.hasNeighborSignal(pos))
            return;
        Player target = level.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16, 16, 16), player -> true).stream()
                .min(ProcedureHelper.byDistanceTo(x, y, z)).orElse(null);
        if (target == null || target.isCreative() || target.isSpectator())
            return;
        Direction side = FIRING_SIDES[level.getRandom().nextInt(FIRING_SIDES.length)];
        if (!level.isEmptyBlock(pos.relative(side)))
            return;
        double spawnX = x + 0.5 + side.getStepX() * 0.6;
        double spawnY = y + 0.5;
        double spawnZ = z + 0.5 + side.getStepZ() * 0.6;
        ProcedureHelper.playSound(level, x, y, z, SoundEvents.SHULKER_SHOOT, SoundSource.BLOCKS, 1, 0.6f);
        level.sendParticles(ParticleTypes.POOF, spawnX, spawnY, spawnZ, 3, 0.2, 0.2, 0.2, 0.1);
        ShulkerBullet bullet = EntityType.SHULKER_BULLET.create(level);
        if (bullet == null)
            return;
        bullet.moveTo(spawnX, spawnY, spawnZ, level.getRandom().nextFloat() * 360.0F, 0);
        bullet.setDeltaMovement(side.getStepX() * 0.5, 0, side.getStepZ() * 0.5);
        CompoundTag data = bullet.saveWithoutId(new CompoundTag());
        data.putUUID("Target", target.getUUID());
        data.putInt("Steps", 1);
        bullet.load(data);
        level.addFreshEntity(bullet);
    }
}

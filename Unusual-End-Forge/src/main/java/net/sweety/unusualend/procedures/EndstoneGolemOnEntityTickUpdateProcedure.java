package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.entity.EndstoneGolemEntity;
import net.sweety.unusualend.init.UnusualendModBlocks;

public class EndstoneGolemOnEntityTickUpdateProcedure {
    private static final double TARGET_SEARCH_RADIUS = 16;

    public static void execute(double x, double y, double z, Entity entity) {
        if (!(entity instanceof EndstoneGolemEntity golem))
            return;
        int animTime = golem.getEntityData().get(EndstoneGolemEntity.DATA_aoe_animtime);
        if (golem.level.isClientSide()) {
            if (animTime > 18)
                pullLocalEntities(golem);
            return;
        }
        if (!(golem.level instanceof ServerLevel level))
            return;
        tickPush(golem);
        if (animTime > 0) {
            animTime--;
            golem.getEntityData().set(EndstoneGolemEntity.DATA_aoe_animtime, animTime);
            if (animTime == 18)
                slam(level, golem, x, y, z);
            else if (animTime > 18)
                pullServerEntities(golem);
        }
        tickSlamCharge(level, golem);
        if (y <= -10)
            returnToAltar(level, golem, x, y, z);
    }

    private static void tickPush(EndstoneGolemEntity golem) {
        int push = golem.getEntityData().get(EndstoneGolemEntity.DATA_push);
        if (push >= 1)
            push++;
        if (push >= 9)
            push = 0;
        golem.getEntityData().set(EndstoneGolemEntity.DATA_push, push);
    }

    private static void slam(ServerLevel level, EndstoneGolemEntity golem, double x, double y, double z) {
        for (int i = 0; i < 20; i++) {
            double angle = (Math.PI * 2 / 20) * i;
            double px = x + 0.5 + Math.cos(angle) * 3;
            double pz = z + 0.5 + Math.sin(angle) * 3;
            BlockState ground = level.getBlockState(new BlockPos(px, y - 1, pz));
            if (!ground.isAir())
                level.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, ground), px, y + 0.1, pz, 8, 0.4, 0.1, 0.4, 0.15);
        }
        for (Entity target : level.getEntitiesOfClass(Entity.class, area(golem, 6), e -> e != golem && e.isOnGround() && !isOwnedBy(e, golem))) {
            double distance = golem.distanceTo(target);
            if (distance > 0) {
                Vec3 away = new Vec3(target.getX() - golem.getX(), 0, target.getZ() - golem.getZ()).normalize().scale(2.5);
                target.setDeltaMovement(target.getDeltaMovement().add(away));
            }
            target.invulnerableTime = 0;
            target.hurt(new EntityDamageSource("cramming", golem).bypassArmor(), (float) Math.max(0, 20 - distance));
        }
        level.playSound(null, x, y, z, SoundEvents.ZOMBIE_BREAK_WOODEN_DOOR, SoundSource.HOSTILE, 3, 1);
        EndstoneGolemBreakSurroundingsProcedure.execute(level, x, y, z);
    }

    private static void pullServerEntities(EndstoneGolemEntity golem) {
        for (Entity target : golem.level.getEntitiesOfClass(Entity.class, area(golem, 8), e -> e != golem && !(e instanceof Player)))
            pull(golem, target);
    }

    private static void pullLocalEntities(EndstoneGolemEntity golem) {
        for (Entity target : golem.level.getEntitiesOfClass(Entity.class, area(golem, 8), e -> e != golem && e.isControlledByLocalInstance()))
            pull(golem, target);
    }

    private static void pull(EndstoneGolemEntity golem, Entity target) {
        Vec3 toward = new Vec3(golem.getX() - target.getX(), 0, golem.getZ() - target.getZ());
        if (toward.lengthSqr() > 1.0E-4)
            target.setDeltaMovement(target.getDeltaMovement().add(toward.normalize().scale(0.025)));
    }

    private static void tickSlamCharge(ServerLevel level, EndstoneGolemEntity golem) {
        int cooldown = golem.getEntityData().get(EndstoneGolemEntity.DATA_aoe_cooldown);
        if (cooldown >= 120) {
            if (golem.getEntityData().get(EndstoneGolemEntity.DATA_push) == 0) {
                golem.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 2, false, false));
                golem.getEntityData().set(EndstoneGolemEntity.DATA_aoe_cooldown, 0);
                if (golem.getEntityData().get(EndstoneGolemEntity.DATA_aoe_animtime) == 0) {
                    golem.getEntityData().set(EndstoneGolemEntity.DATA_aoe_animtime, 35);
                    level.playSound(null, golem.getX(), golem.getY(), golem.getZ(), SoundEvents.ELDER_GUARDIAN_AMBIENT, SoundSource.HOSTILE, 3, 1);
                }
            }
            return;
        }
        LivingEntity target = golem.getTarget();
        if (target == null || !target.isAlive() || golem.distanceToSqr(target) > TARGET_SEARCH_RADIUS * TARGET_SEARCH_RADIUS)
            return;
        cooldown++;
        golem.getEntityData().set(EndstoneGolemEntity.DATA_aoe_cooldown, cooldown);
        if (cooldown == 110)
            level.playSound(null, golem.getX(), golem.getY(), golem.getZ(), SoundEvents.EVOKER_PREPARE_ATTACK, SoundSource.HOSTILE, 3, 0.6f);
        if (cooldown >= 115) {
            double angle = 0;
            for (int i = 0; i < 15; i++) {
                level.sendParticles(ParticleTypes.REVERSE_PORTAL, golem.getX() + Math.sin(angle) * 1.5, golem.getY() + 0.1, golem.getZ() + Math.cos(angle) * 1.5, 1, 0.1, 0, 0.1, 0.1);
                angle += 0.4;
            }
        }
    }

    private static void returnToAltar(ServerLevel level, EndstoneGolemEntity golem, double x, double y, double z) {
        if (level.dimension() != Level.END)
            return;
        BlockPos altar = new BlockPos(golem.getPersistentData().getDouble("x"), golem.getPersistentData().getDouble("y"), golem.getPersistentData().getDouble("z"));
        if (!level.isEmptyBlock(altar))
            return;
        level.setBlock(altar, UnusualendModBlocks.GOLEM_ALTAR.get().defaultBlockState(), 3);
        level.levelEvent(2001, altar, Block.getId(UnusualendModBlocks.ANCIENT_ENCASED_END_STONE.get().defaultBlockState()));
        level.sendParticles(ParticleTypes.REVERSE_PORTAL, x, y, z, 20, 2, 2, 2, 0.1);
        level.sendParticles(ParticleTypes.ENCHANT, x, y, z, 20, 1, 1, 1, 0);
        level.playSound(null, x, y, z, SoundEvents.ELDER_GUARDIAN_CURSE, SoundSource.HOSTILE, 2, 0.5f);
        golem.discard();
    }

    private static AABB area(Entity center, double radius) {
        return new AABB(center.position(), center.position()).inflate(radius);
    }

    private static boolean isOwnedBy(Entity entity, EndstoneGolemEntity golem) {
        return entity instanceof TamableAnimal tamable && tamable.isTame() && tamable.getOwner() == golem;
    }
}
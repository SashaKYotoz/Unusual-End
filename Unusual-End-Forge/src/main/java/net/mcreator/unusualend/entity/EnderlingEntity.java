//attribute + spawn in dark
package net.mcreator.unusualend.entity;

import net.mcreator.unusualend.init.UnusualendModEntities;
import net.mcreator.unusualend.procedures.EnderlingOnInitialEntitySpawnProcedure;
import net.mcreator.unusualend.procedures.HasInvisibilityProcedure;
import net.mcreator.unusualend.procedures.ReturnIsWearingMaskProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;

import javax.annotation.Nullable;

public class EnderlingEntity extends Monster {
    public EnderlingEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(UnusualendModEntities.UNDEAD_ENDERLING.get(), world);
    }

    public EnderlingEntity(EntityType<EnderlingEntity> type, Level world) {
        super(type, world);
        setMaxUpStep(0.6f);
        xpReward = 1;
        setNoAi(false);
        this.moveControl = new FlyingMoveControl(this, 10, true);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected PathNavigation createNavigation(Level world) {
        return new FlyingPathNavigation(this, world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 12.25;
            }

            @Override
            public boolean canUse() {
                return super.canUse() && HasInvisibilityProcedure.execute(EnderlingEntity.this);
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && HasInvisibilityProcedure.execute(EnderlingEntity.this);
            }
        });
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 3.24;
            }
        });
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, false, false) {
            @Override
            public boolean canUse() {
                return super.canUse() && ReturnIsWearingMaskProcedure.execute(EnderlingEntity.this);
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && ReturnIsWearingMaskProcedure.execute(EnderlingEntity.this);
            }
        });
        this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1, 20) {
            @Override
            protected Vec3 getPosition() {
                RandomSource random = EnderlingEntity.this.getRandom();
                double dir_x = EnderlingEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
                double dir_y = EnderlingEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
                double dir_z = EnderlingEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
                return new Vec3(dir_x, dir_y, dir_z);
            }
        });
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEAD;
    }

    @Override
    public SoundEvent getAmbientSound() {
        return SoundEvents.ENDERMAN_AMBIENT;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return SoundEvents.ENDERMAN_HURT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.ENDERMAN_DEATH;
    }

    @Override
    public float getVoicePitch() {
        return Math.max(0.1f, super.getVoicePitch() - 0.5f);
    }

    @Override
    public boolean causeFallDamage(float l, float d, DamageSource source) {
        return false;
    }

    @Override
    public boolean hurt(DamageSource damagesource, float amount) {
        if (damagesource.is(DamageTypes.FALL))
            return false;
        if (damagesource.is(DamageTypes.DRAGON_BREATH))
            return false;
        return super.hurt(damagesource, amount);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
        SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
        EnderlingOnInitialEntitySpawnProcedure.execute(world, this);
        return retval;
    }

    @Override
    public void baseTick() {
        super.baseTick();
        if (this.level() instanceof ServerLevel level && (this.tickCount & 1) == 0)
            level.sendParticles(ParticleTypes.REVERSE_PORTAL, (this.getX() + 0.1), (this.getY() + 0.3), (this.getZ() + 0.1), 1, 0.3, 0.3, 0.3, 0.01);
    }

    @Override
    protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    }

    @Override
    public void setNoGravity(boolean ignored) {
        super.setNoGravity(true);
    }

    public void aiStep() {
        super.aiStep();
        this.setNoGravity(true);
    }

    public static void init() {
        SpawnPlacements.register(UnusualendModEntities.UNDEAD_ENDERLING.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) -> (world.getDifficulty() != Difficulty.PEACEFUL && Mob.checkMobSpawnRules(entityType, world, reason, pos, random)));
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0);
        builder = builder.add(Attributes.MAX_HEALTH, 30);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 4);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16);
        builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.5);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.1);
        builder = builder.add(Attributes.FLYING_SPEED, 0.3);
        return builder;
    }
}

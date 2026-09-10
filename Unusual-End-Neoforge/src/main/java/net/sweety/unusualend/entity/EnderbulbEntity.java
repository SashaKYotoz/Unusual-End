
package net.sweety.unusualend.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.init.UnusualEndEntities;
import net.sweety.unusualend.procedures.EnderbulbOnEntityTickUpdateProcedure;

public class EnderbulbEntity extends Monster {

    public EnderbulbEntity(EntityType<EnderbulbEntity> type, Level world) {
        super(type, world);
        xpReward = 3;
        setNoAi(false);
        this.moveControl = new FlyingMoveControl(this, 10, true);
    }

    @Override
    public float getVoicePitch() {
        return 0.5f;
    }

    @Override
    protected PathNavigation createNavigation(Level world) {
        return new FlyingPathNavigation(this, world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.8, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, true, false));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this).setAlertOthers());
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 0.6, false));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, (float) 12));
        this.goalSelector.addGoal(7, new AvoidEntityGoal<>(this, Player.class, (float) 3, 1.3, 1.5));
        this.goalSelector.addGoal(8, new RandomStrollGoal(this, 0.9, 20) {
            @Override
            protected Vec3 getPosition() {
                RandomSource random = EnderbulbEntity.this.getRandom();
                double dir_x = EnderbulbEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
                double dir_y = EnderbulbEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
                double dir_z = EnderbulbEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
                return new Vec3(dir_x, dir_y, dir_z);
            }
        });
    }

    @Override
    public SoundEvent getAmbientSound() {
        return SoundEvents.ENDERMITE_AMBIENT;
    }

    @Override
    public void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENDERMITE_STEP, 0.15f, 1);
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return SoundEvents.ENDERMITE_HURT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.ENDERMITE_DEATH;
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
    public void die(DamageSource source) {
        super.die(source);
        if (this.level() instanceof ServerLevel _level)
            _level.sendParticles(ParticleTypes.POOF, this.getX(), this.getY(), this.getZ(), 10, 0.5, 0.5, 0.5, 0);
        if (this.level() instanceof Level _level && !_level.isClientSide())
            _level.explode(null, this.getX(), this.getY(), this.getZ(), 0, Level.ExplosionInteraction.MOB);
        for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 2, 4); index0++) {
            if (this.level() instanceof ServerLevel _level) {
                Entity entityToSpawn = UnusualEndEntities.SMALL_ENDERBULB.get().spawn(_level, BlockPos.containing(
                                this.getX() + Mth.nextDouble(RandomSource.create(), -0.15, 0.15),
                                this.getY(),
                                this.getZ() + Mth.nextDouble(RandomSource.create(), -0.15, 0.15)),
                        MobSpawnType.MOB_SUMMONED);
                if (entityToSpawn != null) {
                    entityToSpawn.setYRot(this.level().getRandom().nextFloat() * 360F);
                }
            }
        }
    }

    @Override
    public void baseTick() {
        super.baseTick();
        EnderbulbOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
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

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 48);
        builder = builder.add(Attributes.ARMOR, 4);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 4);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16);
        builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.4);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.2);
        builder = builder.add(Attributes.FLYING_SPEED, 0.3);
        builder = builder.add(Attributes.STEP_HEIGHT, 1.5f);
        return builder;
    }
}

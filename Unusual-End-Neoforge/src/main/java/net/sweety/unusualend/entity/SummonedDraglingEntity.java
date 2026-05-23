
package net.sweety.unusualend.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.init.UnusualEndEntities;
import net.sweety.unusualend.procedures.SummonedDraglingOnEntityTickUpdateProcedure;

import java.util.EnumSet;

public class SummonedDraglingEntity extends TamableAnimal {
    public final AnimationState attackAnimationState = new AnimationState();
    public final AnimationState idleAnimationState = new AnimationState();
    public static final EntityDataAccessor<Integer> DATA_despawn = SynchedEntityData.defineId(SummonedDraglingEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Boolean> DATA_atk = SynchedEntityData.defineId(SummonedDraglingEntity.class, EntityDataSerializers.BOOLEAN);

    public SummonedDraglingEntity(EntityType<SummonedDraglingEntity> type, Level world) {
        super(type, world);
        xpReward = 0;
        setNoAi(false);
        setPersistenceRequired();
        this.moveControl = new FlyingMoveControl(this, 10, true);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_despawn, 1200);
        builder.define(DATA_atk, false);
    }

    @Override
    protected PathNavigation createNavigation(Level world) {
        return new FlyingPathNavigation(this, world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.8, false));
        this.goalSelector.addGoal(2, new Goal() {
            {
                this.setFlags(EnumSet.of(Goal.Flag.MOVE));
            }

            public boolean canUse() {
                return SummonedDraglingEntity.this.getTarget() != null && !SummonedDraglingEntity.this.getMoveControl().hasWanted();
            }

            @Override
            public boolean canContinueToUse() {
                return SummonedDraglingEntity.this.getMoveControl().hasWanted() && SummonedDraglingEntity.this.getTarget() != null && SummonedDraglingEntity.this.getTarget().isAlive();
            }

            @Override
            public void start() {
                LivingEntity livingentity = SummonedDraglingEntity.this.getTarget();
                Vec3 vec3d = livingentity.getEyePosition(1);
                SummonedDraglingEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1.8);
            }

            @Override
            public void tick() {
                LivingEntity livingentity = SummonedDraglingEntity.this.getTarget();
                if (SummonedDraglingEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
                    SummonedDraglingEntity.this.doHurtTarget(livingentity);
                } else {
                    double d0 = SummonedDraglingEntity.this.distanceToSqr(livingentity);
                    if (d0 < 16) {
                        Vec3 vec3d = livingentity.getEyePosition(1);
                        SummonedDraglingEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1.8);
                    }
                }
            }
        });
        this.goalSelector.addGoal(3, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(4, new OwnerHurtTargetGoal(this));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.8, 20) {
            @Override
            protected Vec3 getPosition() {
                RandomSource random = SummonedDraglingEntity.this.getRandom();
                double dir_x = SummonedDraglingEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
                double dir_y = SummonedDraglingEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
                double dir_z = SummonedDraglingEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
                return new Vec3(dir_x, dir_y, dir_z);
            }
        });
        this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1, 10, 2));
        this.targetSelector.addGoal(7, new HurtByTargetGoal(this).setAlertOthers());
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

    @Override
    public void tick() {
        if (level().isClientSide) {
            this.attackAnimationState.animateWhen((this.getEntityData().get(SummonedDraglingEntity.DATA_atk) == true), this.tickCount);
            this.idleAnimationState.animateWhen(!this.walkAnimation.isMoving() && !this.getEntityData().get(SummonedDraglingEntity.DATA_atk) == true, this.tickCount);
        }
        super.tick();
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
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
        return SoundEvents.ENDERMAN_TELEPORT;
    }

    @Override
    public boolean causeFallDamage(float l, float d, DamageSource source) {
        return false;
    }

    @Override
    public boolean hurt(DamageSource damagesource, float amount) {
        if (damagesource.is(DamageTypes.IN_FIRE))
            return false;
        if (damagesource.getDirectEntity() instanceof ThrownPotion || damagesource.getDirectEntity() instanceof AreaEffectCloud)
            return false;
        if (damagesource.is(DamageTypes.FALL))
            return false;
        if (damagesource.is(DamageTypes.LIGHTNING_BOLT))
            return false;
        if (damagesource.is(DamageTypes.DRAGON_BREATH))
            return false;
        return super.hurt(damagesource, amount);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Datadespawn", this.entityData.get(DATA_despawn));
        compound.putBoolean("Dataatk", this.entityData.get(DATA_atk));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Datadespawn"))
            this.entityData.set(DATA_despawn, compound.getInt("Datadespawn"));
        if (compound.contains("Dataatk"))
            this.entityData.set(DATA_atk, compound.getBoolean("Dataatk"));
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
        Item item = itemstack.getItem();
        if (itemstack.getItem() instanceof SpawnEggItem) {
            retval = super.mobInteract(player, hand);
        } else if (this.level().isClientSide()) {
            retval = (this.isTame() && this.isOwnedBy(player) || this.isFood(itemstack)) ? InteractionResult.sidedSuccess(this.level().isClientSide()) : InteractionResult.PASS;
        } else {
            if (this.isTame()) {
                if (this.isOwnedBy(player)) {
                    if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                        this.usePlayerItem(player, hand, itemstack);
                        this.heal((float) item.getFoodProperties(itemstack, player).nutrition());
                        retval = InteractionResult.sidedSuccess(this.level().isClientSide());
                    } else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                        this.usePlayerItem(player, hand, itemstack);
                        this.heal(4);
                        retval = InteractionResult.sidedSuccess(this.level().isClientSide());
                    } else {
                        retval = super.mobInteract(player, hand);
                    }
                }
            } else if (this.isFood(itemstack)) {
                this.usePlayerItem(player, hand, itemstack);
                if (this.random.nextInt(3) == 0) {
                    this.tame(player);
                    this.level().broadcastEntityEvent(this, (byte) 7);
                } else {
                    this.level().broadcastEntityEvent(this, (byte) 6);
                }
                this.setPersistenceRequired();
                retval = InteractionResult.sidedSuccess(this.level().isClientSide());
            } else {
                retval = super.mobInteract(player, hand);
                if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME)
                    this.setPersistenceRequired();
            }
        }
        return retval;
    }

    @Override
    public void baseTick() {
        super.baseTick();
        SummonedDraglingOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
        SummonedDraglingEntity retval = UnusualEndEntities.SUMMONED_DRAGLING.get().create(serverWorld);
        retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null);
        return retval;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return Ingredient.of().test(stack);
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
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.27);
        builder = builder.add(Attributes.MAX_HEALTH, 20);
        builder = builder.add(Attributes.ARMOR, 1);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16);
        builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.3);
        builder = builder.add(Attributes.FLYING_SPEED, 0.27);
        return builder;
    }
}

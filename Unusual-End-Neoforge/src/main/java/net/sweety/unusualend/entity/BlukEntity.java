package net.sweety.unusualend.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.procedures.BlukOnEntityTickUpdateProcedure;
import net.sweety.unusualend.procedures.BucketBlukProcedure;

public class BlukEntity extends Monster {
    public BlukEntity(EntityType<BlukEntity> type, Level world) {
        super(type, world);
        xpReward = 1;
        setNoAi(false);
        this.moveControl = new FlyingMoveControl(this, 10, true);
    }

    @Override
    protected PathNavigation createNavigation(Level world) {
        return new FlyingPathNavigation(this, world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.4));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1, false));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this).setAlertOthers());
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 1.2, 20) {
            @Override
            protected Vec3 getPosition() {
                RandomSource random = BlukEntity.this.getRandom();
                double dir_x = BlukEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
                double dir_y = BlukEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
                double dir_z = BlukEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
                return new Vec3(dir_x, dir_y, dir_z);
            }
        });
        this.goalSelector.addGoal(5, new RandomSwimmingGoal(this, 1, 40));
        this.goalSelector.addGoal(6, new FollowMobGoal(this, 1.2, (float) 10, (float) 6));
        this.goalSelector.addGoal(7, new TemptGoal(this, 1.3, Ingredient.of(UnusualEndItems.WARPED_BERRIES.get()), true));
        this.goalSelector.addGoal(8, new TemptGoal(this, 1.3, Ingredient.of(Items.CARROT), true));
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, BolokEntity.class, (float) 6));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, BlukEntity.class, (float) 6));
        this.goalSelector.addGoal(11, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(12, new AvoidEntityGoal<>(this, Cat.class, (float) 12, 1, 1.2));
        this.goalSelector.addGoal(13, new AvoidEntityGoal<>(this, Ocelot.class, (float) 12, 1, 1.2));
        this.goalSelector.addGoal(14, new AvoidEntityGoal<>(this, Endermite.class, (float) 6, 1, 1.2));
        this.goalSelector.addGoal(15, new AvoidEntityGoal<>(this, SpunklerEntity.class, (float) 6, 1, 1.2));
        this.goalSelector.addGoal(16, new AvoidEntityGoal<>(this, EnderblobEntity.class, (float) 6, 1, 1.2));
        this.goalSelector.addGoal(17, new AvoidEntityGoal<>(this, EnderbulbEntity.class, (float) 6, 1, 1.2));
        this.goalSelector.addGoal(18, new FloatGoal(this));
    }

    protected void dropCustomDeathLoot(ServerLevel level, DamageSource damageSource, boolean recentlyHitIn) {
        super.dropCustomDeathLoot(level, damageSource, recentlyHitIn);
        this.spawnAtLocation(new ItemStack(UnusualEndItems.RAW_BLUK.get()));
    }

    @Override
    public SoundEvent getAmbientSound() {
        return SoundEvents.DROWNED_AMBIENT;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return SoundEvents.DROWNED_HURT_WATER;
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.DROWNED_DEATH;
    }

    @Override
    public boolean causeFallDamage(float l, float d, DamageSource source) {
        return false;
    }

    @Override
    public boolean hurt(DamageSource damagesource, float amount) {
        if (!this.level().isClientSide()) {
            this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 0));
            this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 0));
        }
        if (damagesource.is(DamageTypes.DROWN))
            return false;
        return super.hurt(damagesource, amount);
    }

    @Override
    public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
        ItemStack itemstack = sourceentity.getItemInHand(hand);
        InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
        super.mobInteract(sourceentity, hand);
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        Entity entity = this;
        Level world = this.level();
        BucketBlukProcedure.execute(world, x, y, z, entity, sourceentity);
        return retval;
    }

    @Override
    public void baseTick() {
        super.baseTick();
        BlukOnEntityTickUpdateProcedure.execute(this.getX(), this.getY(), this.getZ(), this);
    }

    @Override
    public float getVoicePitch() {
        return super.getVoicePitch() + 0.7f;
    }

    @Override
    public int getAirSupply() {
        return 100;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    protected void doPush(Entity entityIn) {
    }

    @Override
    protected void pushEntities() {
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
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.4);
        builder = builder.add(Attributes.MAX_HEALTH, 4);
        builder = builder.add(Attributes.ARMOR, 10);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 1);
        builder = builder.add(Attributes.FOLLOW_RANGE, 8);
        builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.1);
        builder = builder.add(Attributes.FLYING_SPEED, 0.4);
        return builder;
    }
}

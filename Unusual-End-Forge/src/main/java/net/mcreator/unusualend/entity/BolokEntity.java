package net.mcreator.unusualend.entity;

import net.mcreator.unusualend.init.UnusualendModEntities;
import net.mcreator.unusualend.procedures.BolokEntityIsHurtProcedure;
import net.mcreator.unusualend.procedures.BolokOnEntityTickUpdateProcedure;
import net.mcreator.unusualend.procedures.BucketBolokProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
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
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

public class BolokEntity extends Monster {
    private static final EntityDataAccessor<Boolean> IS_BABY = SynchedEntityData.defineId(BolokEntity.class, EntityDataSerializers.BOOLEAN);

    public BolokEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(UnusualendModEntities.BOLOK.get(), world);
    }

    public BolokEntity(EntityType<BolokEntity> type, Level world) {
        super(type, world);
        setMaxUpStep(0.6f);
        xpReward = 1;
        setNoAi(false);
        this.moveControl = new FlyingMoveControl(this, 10, true);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_BABY, false);
    }

    @Override
    public void setBaby(boolean isBaby) {
        this.entityData.set(IS_BABY, isBaby);
    }

    @Override
    public boolean isBaby() {
        return this.entityData.get(IS_BABY);
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("IsBaby", this.isBaby());
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setBaby(tag.getBoolean("IsBaby"));
    }

    protected float getStandingEyeHeight(Pose pose, EntityDimensions dimensions) {
        return this.isBaby() ? dimensions.height * 0.75f : dimensions.height;
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
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
            }
        });
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this).setAlertOthers());
        this.goalSelector.addGoal(3, new PanicGoal(this, 1.2));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Shulker.class, false, false));
        this.goalSelector.addGoal(5, new TemptGoal(this, 1.3, Ingredient.of(Blocks.WARPED_FUNGUS.asItem()), false));
        this.goalSelector.addGoal(6, new TemptGoal(this, 1.3, Ingredient.of(Items.WARPED_FUNGUS_ON_A_STICK), false));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.1, 20) {
            @Override
            protected Vec3 getPosition() {
                RandomSource random = BolokEntity.this.getRandom();
                double dir_x = BolokEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
                double dir_y = BolokEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
                double dir_z = BolokEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
                return new Vec3(dir_x, dir_y, dir_z);
            }
        });
        this.goalSelector.addGoal(8, new AvoidEntityGoal<>(this, Endermite.class, (float) 6, 1, 1.2));
        this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, SpunklerEntity.class, (float) 6, 1, 1.2));
        this.goalSelector.addGoal(10, new AvoidEntityGoal<>(this, EnderblobEntity.class, (float) 6, 1, 1.2));
        this.goalSelector.addGoal(11, new FollowMobGoal(this, 1.1, (float) 10, (float) 5));
        this.goalSelector.addGoal(12, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(13, new FloatGoal(this));
    }

    @Override
    public MobType getMobType() {
        return MobType.WATER;
    }

    @Override
    public double getPassengersRidingOffset() {
        return super.getPassengersRidingOffset() + -0.2;
    }

    @Override
    public SoundEvent getAmbientSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:bolok_ambient"));
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:bolok_hurts"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:bolok_dies"));
    }

    @Override
    public boolean causeFallDamage(float l, float d, DamageSource source) {
        return false;
    }

    @Override
    public boolean hurt(DamageSource damagesource, float amount) {
        Level world = this.level();
        Entity entity = this;
        Entity sourceentity = damagesource.getEntity();
        BolokEntityIsHurtProcedure.execute(world, entity, sourceentity);
        if (damagesource.is(DamageTypes.DROWN))
            return false;
        if (damagesource.is(DamageTypes.IN_WALL))
            return false;
        return super.hurt(damagesource, amount);
    }

    @Override
    public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
        super.mobInteract(sourceentity, hand);
        BucketBolokProcedure.execute(this.level(), this, sourceentity);
        return InteractionResult.sidedSuccess(this.level().isClientSide());
    }

    @Override
    public void baseTick() {
        super.baseTick();
        BolokOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> accessor) {
        if (IS_BABY.equals(accessor)) {
            this.refreshDimensions();
        }

        super.onSyncedDataUpdated(accessor);
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
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

    public static void init() {
        SpawnPlacements.register(UnusualendModEntities.BOLOK.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) -> (world.getDifficulty() != Difficulty.PEACEFUL && Mob.checkMobSpawnRules(entityType, world, reason, pos, random)));
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 6);
        builder = builder.add(Attributes.ARMOR, 20);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 1);
        builder = builder.add(Attributes.FOLLOW_RANGE, 64);
        builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1);
        builder = builder.add(Attributes.FLYING_SPEED, 0.3);
        return builder;
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor accessor, DifficultyInstance instance, MobSpawnType type, @Nullable SpawnGroupData data, @Nullable CompoundTag tag) {
        this.setBaby(random.nextFloat() < 0.1f);
        return super.finalizeSpawn(accessor, instance, type, data, tag);
    }
}
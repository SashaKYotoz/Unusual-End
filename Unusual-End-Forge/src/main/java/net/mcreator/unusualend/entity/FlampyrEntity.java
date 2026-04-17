package net.mcreator.unusualend.entity;

import net.mcreator.unusualend.init.UnusualendModEntities;
import net.mcreator.unusualend.init.UnusualendModItems;
import net.mcreator.unusualend.procedures.BucketFireflyProcedure;
import net.mcreator.unusualend.procedures.EnderFireflyTickUpdateProcedure;
import net.mcreator.unusualend.procedures.FireflyIsHurtProcedure;
import net.mcreator.unusualend.procedures.ReturnNotSneakingProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
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
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.EnumSet;

public class FlampyrEntity extends TamableAnimal {
    public FlampyrEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(UnusualendModEntities.ENDER_FIREFLY.get(), world);
    }

    public FlampyrEntity(EntityType<FlampyrEntity> type, Level world) {
        super(type, world);
        setMaxUpStep(0.6f);
        xpReward = 1;
        setNoAi(false);
        setPersistenceRequired();
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
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.2) {
            @Override
            public boolean canUse() {
                return super.canUse() && ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
            }
        });
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.2, Ingredient.of(UnusualendModItems.END_BLOB.get()), false) {
            @Override
            public boolean canUse() {
                return super.canUse() && ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
            }
        });
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 2.25;
            }

            @Override
            public boolean canUse() {
                return super.canUse() && ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
            }
        });
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, EnderblobEntity.class, false, false) {
            @Override
            public boolean canUse() {
                return super.canUse() && ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
            }
        });
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Endermite.class, false, false) {
            @Override
            public boolean canUse() {
                return super.canUse() && ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
            }
        });
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, SmallEnderbulbEntity.class, false, false) {
            @Override
            public boolean canUse() {
                return super.canUse() && ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
            }
        });
        this.goalSelector.addGoal(6, new Goal() {
            {
                this.setFlags(EnumSet.of(Goal.Flag.MOVE));
            }

            public boolean canUse() {
                if (FlampyrEntity.this.getTarget() != null && !FlampyrEntity.this.getMoveControl().hasWanted()) {
                    return ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
                } else {
                    return false;
                }
            }

            @Override
            public boolean canContinueToUse() {
                return ReturnNotSneakingProcedure.execute(FlampyrEntity.this) && FlampyrEntity.this.getMoveControl().hasWanted() && FlampyrEntity.this.getTarget() != null && FlampyrEntity.this.getTarget().isAlive();
            }

            @Override
            public void start() {
                LivingEntity livingentity = FlampyrEntity.this.getTarget();
                Vec3 vec3d = livingentity.getEyePosition(1);
                FlampyrEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1.2);
            }

            @Override
            public void tick() {
                LivingEntity livingentity = FlampyrEntity.this.getTarget();
                if (FlampyrEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
                    FlampyrEntity.this.doHurtTarget(livingentity);
                } else {
                    double d0 = FlampyrEntity.this.distanceToSqr(livingentity);
                    if (d0 < 16) {
                        Vec3 vec3d = livingentity.getEyePosition(1);
                        FlampyrEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1.2);
                    }
                }
            }
        });
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, EnderblobEntity.class, (float) 64) {
            @Override
            public boolean canUse() {
                return super.canUse() && ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
            }
        });
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Endermite.class, (float) 64) {
            @Override
            public boolean canUse() {
                return super.canUse() && ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
            }
        });
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, SmallEnderbulbEntity.class, (float) 64) {
            @Override
            public boolean canUse() {
                return super.canUse() && ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
            }
        });
        this.goalSelector.addGoal(10, new FollowOwnerGoal(this, 1.2, (float) 8, (float) 4, false) {
            @Override
            public boolean canUse() {
                return super.canUse() && ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
            }
        });
        this.goalSelector.addGoal(11, new RandomStrollGoal(this, 1.2, 20) {
            @Override
            protected Vec3 getPosition() {
                RandomSource random = FlampyrEntity.this.getRandom();
                double dir_x = FlampyrEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
                double dir_y = FlampyrEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
                double dir_z = FlampyrEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
                return new Vec3(dir_x, dir_y, dir_z);
            }

            @Override
            public boolean canUse() {
                return super.canUse() && ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
            }
        });
        this.goalSelector.addGoal(12, new LeapAtTargetGoal(this, (float) 1.2) {
            @Override
            public boolean canUse() {
                return super.canUse() && ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && ReturnNotSneakingProcedure.execute(FlampyrEntity.this);
            }
        });
        this.goalSelector.addGoal(13, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(14, new FloatGoal(this));
    }

    @Override
    public MobType getMobType() {
        return MobType.ARTHROPOD;
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.endermite.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.endermite.death"));
    }

    @Override
    public boolean causeFallDamage(float l, float d, DamageSource source) {
        return false;
    }

    @Override
    public boolean hurt(DamageSource damagesource, float amount) {
        FireflyIsHurtProcedure.execute(this);
        if (damagesource.is(DamageTypes.FALL))
            return false;
        if (damagesource.is(DamageTypes.DRAGON_BREATH))
            return false;
        return super.hurt(damagesource, amount);
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
                    if (item.isEdible() && this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                        this.usePlayerItem(player, hand, itemstack);
                        this.heal((float) item.getFoodProperties().getNutrition());
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
                if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
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
        Entity entity = this;
        Level world = this.level();
        BucketFireflyProcedure.execute(world, entity, player);
        return retval;
    }

    @Override
    public void baseTick() {
        super.baseTick();
        EnderFireflyTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
        FlampyrEntity retval = UnusualendModEntities.ENDER_FIREFLY.get().create(serverWorld);
        retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
        return retval;
    }

    private void resetAmbientSoundTime() {
        this.ambientSoundTime = -this.getAmbientSoundInterval();
    }

    @Override
    protected void playHurtSound(DamageSource source) {
        this.resetAmbientSoundTime();
        SoundEvent soundevent = this.getHurtSound(source);
        if (soundevent != null) {
            this.playSound(soundevent, this.getSoundVolume(), this.getVoicePitch() + 0.6f);
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.PARROT_FLY;
    }

    @Override
    public void playAmbientSound() {
        SoundEvent soundevent = this.getAmbientSound();
        if (soundevent != null) {
            this.playSound(soundevent, this.getSoundVolume(), 0.6f);
        }
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return Ingredient.of(new ItemStack(UnusualendModItems.END_BLOB.get()), new ItemStack(UnusualendModItems.BLOB_STEW.get())).test(stack);
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
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.2);
        builder = builder.add(Attributes.MAX_HEALTH, 40);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16);
        builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.2);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.1);
        builder = builder.add(Attributes.FLYING_SPEED, 0.4);
        return builder;
    }
}

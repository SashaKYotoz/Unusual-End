
//fireflyhurt
package net.mcreator.unusualend.entity;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.procedures.ReturnNotSneakingProcedure;
import net.mcreator.unusualend.procedures.FireflyIsHurtProcedure;
import net.mcreator.unusualend.procedures.EnderFireflyTickUpdateProcedure;
import net.mcreator.unusualend.procedures.BucketFireflyProcedure;
import net.mcreator.unusualend.init.UnusualendModItems;
import net.mcreator.unusualend.init.UnusualendModEntities;

import java.util.EnumSet;

public class EnderBugEntity extends TamableAnimal {

	public EnderBugEntity(EntityType<EnderBugEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.6f);
		xpReward = 1;
		setNoAi(false);
		setPersistenceRequired();
		this.moveControl = new FlyingMoveControl(this, 10, true);
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
				double x = EnderBugEntity.this.getX();
				double y = EnderBugEntity.this.getY();
				double z = EnderBugEntity.this.getZ();
				Entity entity = EnderBugEntity.this;
				Level world = EnderBugEntity.this.level();
				return super.canUse() && ReturnNotSneakingProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = EnderBugEntity.this.getX();
				double y = EnderBugEntity.this.getY();
				double z = EnderBugEntity.this.getZ();
				Entity entity = EnderBugEntity.this;
				Level world = EnderBugEntity.this.level();
				return super.canContinueToUse() && ReturnNotSneakingProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(2, new TemptGoal(this, 1.2, Ingredient.of(UnusualendModItems.END_BLOB.get()), false) {
			@Override
			public boolean canUse() {
				double x = EnderBugEntity.this.getX();
				double y = EnderBugEntity.this.getY();
				double z = EnderBugEntity.this.getZ();
				Entity entity = EnderBugEntity.this;
				Level world = EnderBugEntity.this.level();
				return super.canUse() && ReturnNotSneakingProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = EnderBugEntity.this.getX();
				double y = EnderBugEntity.this.getY();
				double z = EnderBugEntity.this.getZ();
				Entity entity = EnderBugEntity.this;
				Level world = EnderBugEntity.this.level();
				return super.canContinueToUse() && ReturnNotSneakingProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false) {

			@Override
			public boolean canUse() {
				Entity entity = EnderBugEntity.this;
				return super.canUse() && ReturnNotSneakingProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				Entity entity = EnderBugEntity.this;
				return super.canContinueToUse() && ReturnNotSneakingProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, EnderblobEntity.class, false, false) {
			@Override
			public boolean canUse() {
				double x = EnderBugEntity.this.getX();
				double y = EnderBugEntity.this.getY();
				double z = EnderBugEntity.this.getZ();
				Entity entity = EnderBugEntity.this;
				Level world = EnderBugEntity.this.level();
				return super.canUse() && ReturnNotSneakingProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = EnderBugEntity.this.getX();
				double y = EnderBugEntity.this.getY();
				double z = EnderBugEntity.this.getZ();
				Entity entity = EnderBugEntity.this;
				Level world = EnderBugEntity.this.level();
				return super.canContinueToUse() && ReturnNotSneakingProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Endermite.class, false, false) {
			@Override
			public boolean canUse() {
				double x = EnderBugEntity.this.getX();
				double y = EnderBugEntity.this.getY();
				double z = EnderBugEntity.this.getZ();
				Entity entity = EnderBugEntity.this;
				Level world = EnderBugEntity.this.level();
				return super.canUse() && ReturnNotSneakingProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = EnderBugEntity.this.getX();
				double y = EnderBugEntity.this.getY();
				double z = EnderBugEntity.this.getZ();
				Entity entity = EnderBugEntity.this;
				Level world = EnderBugEntity.this.level();
				return super.canContinueToUse() && ReturnNotSneakingProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, SmallEnderbulbEntity.class, false, false) {
			@Override
			public boolean canUse() {
				double x = EnderBugEntity.this.getX();
				double y = EnderBugEntity.this.getY();
				double z = EnderBugEntity.this.getZ();
				Entity entity = EnderBugEntity.this;
				Level world = EnderBugEntity.this.level();
				return super.canUse() && ReturnNotSneakingProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = EnderBugEntity.this.getX();
				double y = EnderBugEntity.this.getY();
				double z = EnderBugEntity.this.getZ();
				Entity entity = EnderBugEntity.this;
				Level world = EnderBugEntity.this.level();
				return super.canContinueToUse() && ReturnNotSneakingProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(6, new Goal() {
			{
				this.setFlags(EnumSet.of(Goal.Flag.MOVE));
			}

			public boolean canUse() {
				if (EnderBugEntity.this.getTarget() != null && !EnderBugEntity.this.getMoveControl().hasWanted()) {
					double x = EnderBugEntity.this.getX();
					double y = EnderBugEntity.this.getY();
					double z = EnderBugEntity.this.getZ();
					Entity entity = EnderBugEntity.this;
					Level world = EnderBugEntity.this.level();
					return ReturnNotSneakingProcedure.execute(entity);
				} else {
					return false;
				}
			}

			@Override
			public boolean canContinueToUse() {
				double x = EnderBugEntity.this.getX();
				double y = EnderBugEntity.this.getY();
				double z = EnderBugEntity.this.getZ();
				Entity entity = EnderBugEntity.this;
				Level world = EnderBugEntity.this.level();
				return ReturnNotSneakingProcedure.execute(entity) && EnderBugEntity.this.getMoveControl().hasWanted() && EnderBugEntity.this.getTarget() != null && EnderBugEntity.this.getTarget().isAlive();
			}

			@Override
			public void start() {
				LivingEntity livingentity = EnderBugEntity.this.getTarget();
				Vec3 vec3d = livingentity.getEyePosition(1);
				EnderBugEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1.2);
			}

			@Override
			public void tick() {
				LivingEntity livingentity = EnderBugEntity.this.getTarget();
				if (EnderBugEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
					EnderBugEntity.this.doHurtTarget(livingentity);
				} else {
					double d0 = EnderBugEntity.this.distanceToSqr(livingentity);
					if (d0 < 16) {
						Vec3 vec3d = livingentity.getEyePosition(1);
						EnderBugEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1.2);
					}
				}
			}
		});
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, EnderblobEntity.class, (float) 64) {
			@Override
			public boolean canUse() {
				double x = EnderBugEntity.this.getX();
				double y = EnderBugEntity.this.getY();
				double z = EnderBugEntity.this.getZ();
				Entity entity = EnderBugEntity.this;
				Level world = EnderBugEntity.this.level();
				return super.canUse() && ReturnNotSneakingProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = EnderBugEntity.this.getX();
				double y = EnderBugEntity.this.getY();
				double z = EnderBugEntity.this.getZ();
				Entity entity = EnderBugEntity.this;
				Level world = EnderBugEntity.this.level();
				return super.canContinueToUse() && ReturnNotSneakingProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Endermite.class, (float) 64) {
			@Override
			public boolean canUse() {
				double x = EnderBugEntity.this.getX();
				double y = EnderBugEntity.this.getY();
				double z = EnderBugEntity.this.getZ();
				Entity entity = EnderBugEntity.this;
				Level world = EnderBugEntity.this.level();
				return super.canUse() && ReturnNotSneakingProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = EnderBugEntity.this.getX();
				double y = EnderBugEntity.this.getY();
				double z = EnderBugEntity.this.getZ();
				Entity entity = EnderBugEntity.this;
				Level world = EnderBugEntity.this.level();
				return super.canContinueToUse() && ReturnNotSneakingProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, SmallEnderbulbEntity.class, (float) 64) {
			@Override
			public boolean canUse() {
				double x = EnderBugEntity.this.getX();
				double y = EnderBugEntity.this.getY();
				double z = EnderBugEntity.this.getZ();
				Entity entity = EnderBugEntity.this;
				Level world = EnderBugEntity.this.level();
				return super.canUse() && ReturnNotSneakingProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = EnderBugEntity.this.getX();
				double y = EnderBugEntity.this.getY();
				double z = EnderBugEntity.this.getZ();
				Entity entity = EnderBugEntity.this;
				Level world = EnderBugEntity.this.level();
				return super.canContinueToUse() && ReturnNotSneakingProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(10, new FollowOwnerGoal(this, 1.2, (float) 8, (float) 4, false) {
			@Override
			public boolean canUse() {
				double x = EnderBugEntity.this.getX();
				double y = EnderBugEntity.this.getY();
				double z = EnderBugEntity.this.getZ();
				Entity entity = EnderBugEntity.this;
				Level world = EnderBugEntity.this.level();
				return super.canUse() && ReturnNotSneakingProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = EnderBugEntity.this.getX();
				double y = EnderBugEntity.this.getY();
				double z = EnderBugEntity.this.getZ();
				Entity entity = EnderBugEntity.this;
				Level world = EnderBugEntity.this.level();
				return super.canContinueToUse() && ReturnNotSneakingProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(11, new RandomStrollGoal(this, 1.2, 20) {
			@Override
			protected Vec3 getPosition() {
				RandomSource random = EnderBugEntity.this.getRandom();
				double dir_x = EnderBugEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_y = EnderBugEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_z = EnderBugEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
				return new Vec3(dir_x, dir_y, dir_z);
			}

			@Override
			public boolean canUse() {
				double x = EnderBugEntity.this.getX();
				double y = EnderBugEntity.this.getY();
				double z = EnderBugEntity.this.getZ();
				Entity entity = EnderBugEntity.this;
				Level world = EnderBugEntity.this.level();
				return super.canUse() && ReturnNotSneakingProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = EnderBugEntity.this.getX();
				double y = EnderBugEntity.this.getY();
				double z = EnderBugEntity.this.getZ();
				Entity entity = EnderBugEntity.this;
				Level world = EnderBugEntity.this.level();
				return super.canContinueToUse() && ReturnNotSneakingProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(12, new LeapAtTargetGoal(this, (float) 1.2) {
			@Override
			public boolean canUse() {
				double x = EnderBugEntity.this.getX();
				double y = EnderBugEntity.this.getY();
				double z = EnderBugEntity.this.getZ();
				Entity entity = EnderBugEntity.this;
				Level world = EnderBugEntity.this.level();
				return super.canUse() && ReturnNotSneakingProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = EnderBugEntity.this.getX();
				double y = EnderBugEntity.this.getY();
				double z = EnderBugEntity.this.getZ();
				Entity entity = EnderBugEntity.this;
				Level world = EnderBugEntity.this.level();
				return super.canContinueToUse() && ReturnNotSneakingProcedure.execute(entity);
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
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		Entity sourceentity = damagesource.getEntity();
		Entity immediatesourceentity = damagesource.getDirectEntity();
		FireflyIsHurtProcedure.execute(entity);
		if (damagesource.is(DamageTypes.FALL))
			return false;
		if (damagesource.is(DamageTypes.DRAGON_BREATH))
			return false;
		return super.hurt(damagesource, amount);
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
		Item item = itemstack.getItem();
		if (itemstack.getItem() instanceof SpawnEggItem) {
			retval = super.mobInteract(sourceentity, hand);
		} else if (this.level().isClientSide()) {
			retval = (this.isTame() && this.isOwnedBy(sourceentity) || this.isFood(itemstack)) ? InteractionResult.sidedSuccess(this.level().isClientSide()) : InteractionResult.PASS;
		} else {
			if (this.isTame()) {
				if (this.isOwnedBy(sourceentity)) {
					if (item.isEdible() && this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
						this.usePlayerItem(sourceentity, hand, itemstack);
						this.heal((float) item.getFoodProperties().getNutrition());
						retval = InteractionResult.sidedSuccess(this.level().isClientSide());
					} else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
						this.usePlayerItem(sourceentity, hand, itemstack);
						this.heal(4);
						retval = InteractionResult.sidedSuccess(this.level().isClientSide());
					} else {
						retval = super.mobInteract(sourceentity, hand);
					}
				}
			} else if (this.isFood(itemstack)) {
				this.usePlayerItem(sourceentity, hand, itemstack);
				if (this.random.nextInt(3) == 0) {
					this.tame(sourceentity);
					this.level().broadcastEntityEvent(this, (byte) 7);
				} else {
					this.level().broadcastEntityEvent(this, (byte) 6);
				}
				this.setPersistenceRequired();
				retval = InteractionResult.sidedSuccess(this.level().isClientSide());
			} else {
				retval = super.mobInteract(sourceentity, hand);
				if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME)
					this.setPersistenceRequired();
			}
		}
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();
		BucketFireflyProcedure.execute(world, entity, sourceentity);
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		EnderFireflyTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		EnderBugEntity retval = UnusualendModEntities.ENDER_FIREFLY.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
		return retval;
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

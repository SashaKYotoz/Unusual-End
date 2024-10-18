
package net.mcreator.unusualend.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.procedures.EndstoneGolemOnEntityTickUpdateProcedure;
import net.mcreator.unusualend.procedures.EndstoneGolemEntityIsHurtProcedure;
import net.mcreator.unusualend.procedures.EndstoneGolemEntityDiesProcedure;
import net.mcreator.unusualend.procedures.CanGolemAttackProcedure;
import net.mcreator.unusualend.init.UnusualendModEntities;

public class EndstoneGolemEntity extends Monster {
	public final AnimationState attackAnimationState = new AnimationState();
	public final AnimationState pushAnimationState = new AnimationState();
	public final AnimationState idleAnimationState = new AnimationState();
	public static final EntityDataAccessor<Integer> DATA_aoe_cooldown = SynchedEntityData.defineId(EndstoneGolemEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_aoe_animtime = SynchedEntityData.defineId(EndstoneGolemEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_texture = SynchedEntityData.defineId(EndstoneGolemEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_push = SynchedEntityData.defineId(EndstoneGolemEntity.class, EntityDataSerializers.INT);
	private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.PURPLE, ServerBossEvent.BossBarOverlay.PROGRESS);

	public EndstoneGolemEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(UnusualendModEntities.ENDSTONE_GOLEM.get(), world);
	}

	public EndstoneGolemEntity(EntityType<EndstoneGolemEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.6f);
		xpReward = 500;
		setNoAi(false);
		setPersistenceRequired();
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_aoe_cooldown, 0);
		this.entityData.define(DATA_aoe_animtime, 0);
		this.entityData.define(DATA_texture, 0);
		this.entityData.define(DATA_push, 0);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return 6;
			}

			@Override
			protected int getAttackInterval() {
				return 120;
			}

			@Override
			public boolean canUse() {
				double x = EndstoneGolemEntity.this.getX();
				double y = EndstoneGolemEntity.this.getY();
				double z = EndstoneGolemEntity.this.getZ();
				Entity entity = EndstoneGolemEntity.this;
				Level world = EndstoneGolemEntity.this.level();
				return super.canUse() && CanGolemAttackProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = EndstoneGolemEntity.this.getX();
				double y = EndstoneGolemEntity.this.getY();
				double z = EndstoneGolemEntity.this.getZ();
				Entity entity = EndstoneGolemEntity.this;
				Level world = EndstoneGolemEntity.this.level();
				return super.canContinueToUse() && CanGolemAttackProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
	}

	@Override
	public void tick() {
		if (level().isClientSide) {
			this.pushAnimationState.animateWhen((this.getEntityData().get(EndstoneGolemEntity.DATA_push) > 0 && !(this.getEntityData().get(EndstoneGolemEntity.DATA_aoe_animtime) > 0)), this.tickCount);
			this.attackAnimationState.animateWhen((this.getEntityData().get(EndstoneGolemEntity.DATA_aoe_animtime) > 0), this.tickCount);
			this.idleAnimationState.animateWhen(!this.walkAnimation.isMoving() && !isInWaterOrBubble(), this.tickCount);
		}
		super.tick();
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.elder_guardian.ambient"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.place")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.elder_guardian.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport"));
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
		EndstoneGolemEntityIsHurtProcedure.execute(world, x, y, z, entity, sourceentity);
		if (damagesource.is(DamageTypes.IN_FIRE))
			return false;
		if (damagesource.getDirectEntity() instanceof AbstractArrow)
			//return super.hurt(damagesource, 1);
			return false;
		if (damagesource.getDirectEntity() instanceof ThrownPotion || damagesource.getDirectEntity() instanceof AreaEffectCloud)
			return false;
		if (damagesource.is(DamageTypes.FALL))
			return false;
		if (damagesource.is(DamageTypes.CACTUS))
			return false;
		if (damagesource.is(DamageTypes.DROWN))
			return false;
		if (damagesource.is(DamageTypes.LIGHTNING_BOLT))
			return false;
		if (damagesource.is(DamageTypes.EXPLOSION) || damagesource.is(DamageTypes.PLAYER_EXPLOSION))
			return false;
		if (damagesource.is(DamageTypes.TRIDENT))
			return false;
		if (damagesource.is(DamageTypes.FALLING_ANVIL))
			return false;
		if (damagesource.is(DamageTypes.DRAGON_BREATH))
			return false;
		if (damagesource.is(DamageTypes.WITHER))
			return false;
		return super.hurt(damagesource, amount);
	}

	@Override
	public boolean ignoreExplosion() {
		return true;
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		EndstoneGolemEntityDiesProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("Dataaoe_cooldown", this.entityData.get(DATA_aoe_cooldown));
		compound.putInt("Dataaoe_animtime", this.entityData.get(DATA_aoe_animtime));
		compound.putInt("Datatexture", this.entityData.get(DATA_texture));
		compound.putInt("Datapush", this.entityData.get(DATA_push));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Dataaoe_cooldown"))
			this.entityData.set(DATA_aoe_cooldown, compound.getInt("Dataaoe_cooldown"));
		if (compound.contains("Dataaoe_animtime"))
			this.entityData.set(DATA_aoe_animtime, compound.getInt("Dataaoe_animtime"));
		if (compound.contains("Datatexture"))
			this.entityData.set(DATA_texture, compound.getInt("Datatexture"));
		if (compound.contains("Datapush"))
			this.entityData.set(DATA_push, compound.getInt("Datapush"));
	}

	@Override
	public void baseTick() {
		super.baseTick();
		EndstoneGolemOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	public boolean canBreatheUnderwater() {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		return true;
	}

	@Override
	public boolean isPushedByFluid() {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		return false;
	}

	@Override
	public boolean canChangeDimensions() {
		return false;
	}

	@Override
	public void startSeenByPlayer(ServerPlayer player) {
		super.startSeenByPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	@Override
	public void stopSeenByPlayer(ServerPlayer player) {
		super.stopSeenByPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	@Override
	public void customServerAiStep() {
		super.customServerAiStep();
		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.2);
		builder = builder.add(Attributes.MAX_HEALTH, 500);
		builder = builder.add(Attributes.ARMOR, 20);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 8);
		builder = builder.add(Attributes.FOLLOW_RANGE, 64);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 3);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 2);
		return builder;
	}
}

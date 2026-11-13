
package net.sweety.unusualend.entity;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.sweety.unusualend.init.UnusualendModEntities;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.util.TeleportHelper;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class WanderingPearlProjectileEntity extends AbstractArrow implements ItemSupplier {
	public static final ItemStack PROJECTILE_ITEM = new ItemStack(UnusualendModItems.WANDERING_PEARL.get());

	public WanderingPearlProjectileEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(UnusualendModEntities.WANDERING_PEARL_PROJECTILE.get(), world);
	}

	public WanderingPearlProjectileEntity(EntityType<? extends WanderingPearlProjectileEntity> type, Level world) {
		super(type, world);
	}

	public WanderingPearlProjectileEntity(EntityType<? extends WanderingPearlProjectileEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public WanderingPearlProjectileEntity(EntityType<? extends WanderingPearlProjectileEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected ItemStack getPickupItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void onHitEntity(EntityHitResult entityHitResult) {
		super.onHitEntity(entityHitResult);
		if (this.getOwner() != null && entityHitResult.getEntity() != this.getOwner())
			TeleportHelper.scatter(this.level(), entityHitResult.getEntity(), this.getX(), this.getY(), this.getZ(), 5, 5);
	}

	@Override
	public void onHitBlock(BlockHitResult blockHitResult) {
		super.onHitBlock(blockHitResult);
		if (this.getOwner() != null)
			TeleportHelper.scatter(this.level(), this.getOwner(), blockHitResult.getBlockPos().getX(), blockHitResult.getBlockPos().getY(), blockHitResult.getBlockPos().getZ(), 2, 4);
	}

	@Override
	public void tick() {
		super.tick();
		if (this.inGround)
			this.discard();
	}

	public static WanderingPearlProjectileEntity shoot(Level world, LivingEntity entity, RandomSource source) {
		return shoot(world, entity, source, 1.2f, 0, 0);
	}

	public static WanderingPearlProjectileEntity shoot(Level world, LivingEntity entity, RandomSource source, float pullingPower) {
		return shoot(world, entity, source, pullingPower * 1.2f, 0, 0);
	}

	public static WanderingPearlProjectileEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		WanderingPearlProjectileEntity entityarrow = new WanderingPearlProjectileEntity(UnusualendModEntities.WANDERING_PEARL_PROJECTILE.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ENDER_PEARL_THROW, SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static WanderingPearlProjectileEntity shoot(LivingEntity entity, LivingEntity target) {
		WanderingPearlProjectileEntity entityarrow = new WanderingPearlProjectileEntity(UnusualendModEntities.WANDERING_PEARL_PROJECTILE.get(), entity, entity.level());
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 1.2f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(0);
		entityarrow.setKnockback(0);
		entityarrow.setCritArrow(false);
		entity.level().addFreshEntity(entityarrow);
		entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ENDER_PEARL_THROW, SoundSource.PLAYERS, 1, 1f / (entity.getRandom().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}

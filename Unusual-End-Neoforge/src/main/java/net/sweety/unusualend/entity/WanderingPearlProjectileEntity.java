
package net.sweety.unusualend.entity;

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
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.init.UnusualEndEntities;
import net.sweety.unusualend.procedures.WanderingPearlProjectileHitsLivingEntityProcedure;
import net.sweety.unusualend.procedures.WanderingPearlProjectileHitsProcedure;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class WanderingPearlProjectileEntity extends AbstractArrow implements ItemSupplier {
    public static final ItemStack PROJECTILE_ITEM = new ItemStack(UnusualEndItems.WANDERING_PEARL.get());

    public WanderingPearlProjectileEntity(EntityType<? extends WanderingPearlProjectileEntity> type, Level level) {
        super(type, level);
    }

    public WanderingPearlProjectileEntity(EntityType<? extends WanderingPearlProjectileEntity> type, LivingEntity entity, Level level) {
        super(type, entity, level, PROJECTILE_ITEM, null);
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
    protected ItemStack getDefaultPickupItem() {
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
        WanderingPearlProjectileHitsLivingEntityProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), entityHitResult.getEntity(), this.getOwner());
    }

    @Override
    public void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        WanderingPearlProjectileHitsProcedure.execute(this.level(), blockHitResult.getBlockPos().getX(), blockHitResult.getBlockPos().getY(), blockHitResult.getBlockPos().getZ(), this.getOwner());
    }

    @Override
    public void tick() {
        super.tick();
        if (this.inGround)
            this.discard();
    }

    public static WanderingPearlProjectileEntity shoot(Level world, LivingEntity entity, RandomSource source) {
        return shoot(world, entity, source, 1.2f, 0);
    }

    public static WanderingPearlProjectileEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage) {
        WanderingPearlProjectileEntity entityarrow = new WanderingPearlProjectileEntity(UnusualEndEntities.WANDERING_PEARL_PROJECTILE.get(), entity, world);
        entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
        entityarrow.setSilent(true);
        entityarrow.setCritArrow(false);
        entityarrow.setBaseDamage(damage);
        world.addFreshEntity(entityarrow);
        world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ENDER_PEARL_THROW, SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
        return entityarrow;
    }

    public static WanderingPearlProjectileEntity shoot(LivingEntity entity, LivingEntity target) {
        WanderingPearlProjectileEntity entityarrow = new WanderingPearlProjectileEntity(UnusualEndEntities.WANDERING_PEARL_PROJECTILE.get(), entity, entity.level());
        double dx = target.getX() - entity.getX();
        double dy = target.getY() + target.getEyeHeight() - 1.1;
        double dz = target.getZ() - entity.getZ();
        entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 1.2f * 2, 12.0F);
        entityarrow.setSilent(true);
        entityarrow.setBaseDamage(0);
        entityarrow.setCritArrow(false);
        entity.level().addFreshEntity(entityarrow);
        entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ENDER_PEARL_THROW, SoundSource.PLAYERS, 1, 1f / (RandomSource.create().nextFloat() * 0.5f + 1));
        return entityarrow;
    }
}

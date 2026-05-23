
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
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.init.UnusualEndEntities;
import net.sweety.unusualend.procedures.PhantomArrowWhileProjectileFlyingTickProcedure;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class PhantomArrowProjectileEntity extends AbstractArrow implements ItemSupplier {
    public static final ItemStack PROJECTILE_ITEM = new ItemStack(UnusualEndItems.PHANTOM_ARROW.get());

    public PhantomArrowProjectileEntity(EntityType<? extends PhantomArrowProjectileEntity> type, Level level) {
        super(type, level);
    }

    public PhantomArrowProjectileEntity(EntityType<? extends PhantomArrowProjectileEntity> type, LivingEntity entity, Level level) {
        super(type, entity, level, ItemStack.EMPTY, null);
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
    public void tick() {
        super.tick();
        if (!this.inGround)
            PhantomArrowWhileProjectileFlyingTickProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
    }

    public static PhantomArrowProjectileEntity shoot(Level world, LivingEntity entity, RandomSource source) {
        return shoot(world, entity, source, 1f, 5);
    }

    public static PhantomArrowProjectileEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage) {
        PhantomArrowProjectileEntity entityarrow = new PhantomArrowProjectileEntity(UnusualEndEntities.PHANTOM_ARROW_PROJECTILE.get(), entity, world);
        entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
        entityarrow.setSilent(true);
        entityarrow.setCritArrow(false);
        entityarrow.setBaseDamage(damage);
        world.addFreshEntity(entityarrow);
        world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
        return entityarrow;
    }

    public static PhantomArrowProjectileEntity shoot(LivingEntity entity, LivingEntity target) {
        PhantomArrowProjectileEntity entityarrow = new PhantomArrowProjectileEntity(UnusualEndEntities.PHANTOM_ARROW_PROJECTILE.get(), entity, entity.level());
        double dx = target.getX() - entity.getX();
        double dy = target.getY() + target.getEyeHeight() - 1.1;
        double dz = target.getZ() - entity.getZ();
        entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 1f * 2, 12.0F);
        entityarrow.setSilent(true);
        entityarrow.setBaseDamage(5);
        entityarrow.setCritArrow(false);
        entity.level().addFreshEntity(entityarrow);
        entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1, 1f / (RandomSource.create().nextFloat() * 0.5f + 1));
        return entityarrow;
    }
}

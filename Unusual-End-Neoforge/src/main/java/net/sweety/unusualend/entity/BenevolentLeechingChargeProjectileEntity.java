
package net.sweety.unusualend.entity;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.sweety.unusualend.init.UnusualEndEntities;
import net.sweety.unusualend.procedures.LeechingChargeWhileProjectileFlyingTickProcedure;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class BenevolentLeechingChargeProjectileEntity extends AbstractArrow implements ItemSupplier {
    public static final ItemStack PROJECTILE_ITEM = ItemStack.EMPTY;

    public BenevolentLeechingChargeProjectileEntity(EntityType<? extends BenevolentLeechingChargeProjectileEntity> type, Level level) {
        super(type, level);
    }

    public BenevolentLeechingChargeProjectileEntity(EntityType<? extends BenevolentLeechingChargeProjectileEntity> type, LivingEntity entity, Level level) {
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
    public void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        if (entityHitResult.getEntity() instanceof LivingEntity entity && !entity.level().isClientSide())
            entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 2));
    }

    @Override
    public void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        double x = blockHitResult.getBlockPos().getX();
        double y = blockHitResult.getBlockPos().getY();
        double z = blockHitResult.getBlockPos().getZ();
        if (!this.level().isClientSide())
            this.discard();
        if (this.level() instanceof ServerLevel level) {
            level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 1), z), Vec2.ZERO, level, 4, "", Component.literal(""), level.getServer(), null).withSuppressedOutput(),
                    "summon area_effect_cloud ~ ~ ~ {Particle:\"dust 0.94 0.3 0.88 1\",Potion:strong_regeneration,Radius:2,RadiusPerTick:-0.01,Duration:100}");
            level.sendParticles(ParticleTypes.POOF, x, (y + 1.2), z, 3, 0.5, 0.2, 0.5, 0.1);
            level.sendParticles(ParticleTypes.HEART, x, (y + 1.2), z, 5, 1.2, 0.2, 1.2, 0.1);
        }
    }

    @Override
    public void tick() {
        super.tick();
        LeechingChargeWhileProjectileFlyingTickProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
        if (this.inGround)
            this.discard();
    }

    public static BenevolentLeechingChargeProjectileEntity shoot(Level world, LivingEntity entity, RandomSource source) {
        return shoot(world, entity, source, 1f, 5);
    }

    public static BenevolentLeechingChargeProjectileEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage) {
        BenevolentLeechingChargeProjectileEntity entityarrow = new BenevolentLeechingChargeProjectileEntity(UnusualEndEntities.BENEVOLENT_LEECHING_CHARGE_PROJECTILE.get(), entity, world);
        entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
        entityarrow.setSilent(true);
        entityarrow.setCritArrow(false);
        entityarrow.setBaseDamage(damage);
        world.addFreshEntity(entityarrow);
        world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.FIREWORK_ROCKET_SHOOT, SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
        return entityarrow;
    }

    public static BenevolentLeechingChargeProjectileEntity shoot(LivingEntity entity, LivingEntity target) {
        BenevolentLeechingChargeProjectileEntity entityarrow = new BenevolentLeechingChargeProjectileEntity(UnusualEndEntities.BENEVOLENT_LEECHING_CHARGE_PROJECTILE.get(), entity, entity.level());
        double dx = target.getX() - entity.getX();
        double dy = target.getY() + target.getEyeHeight() - 1.1;
        double dz = target.getZ() - entity.getZ();
        entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 1f * 2, 12.0F);
        entityarrow.setSilent(true);
        entityarrow.setBaseDamage(5);
        entityarrow.setCritArrow(false);
        entity.level().addFreshEntity(entityarrow);
        entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.FIREWORK_ROCKET_SHOOT, SoundSource.PLAYERS, 1,
                1f / (RandomSource.create().nextFloat() * 0.5f + 1));
        return entityarrow;
    }
}

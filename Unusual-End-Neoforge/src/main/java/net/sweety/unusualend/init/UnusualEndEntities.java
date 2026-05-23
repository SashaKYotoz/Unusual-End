package net.sweety.unusualend.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.entity.*;

public class UnusualEndEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, UnusualEnd.MODID);
    public static final DeferredHolder<EntityType<?>, EntityType<EnderblobEntity>> ENDER_BLOB = register("ender_blob",
            EntityType.Builder.of(EnderblobEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

                    .sized(0.8f, 0.4f));
    public static final DeferredHolder<EntityType<?>, EntityType<EnderlingEntity>> UNDEAD_ENDERLING = register("undead_enderling",
            EntityType.Builder.of(EnderlingEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

                    .sized(0.6f, 1.45f));
    public static final DeferredHolder<EntityType<?>, EntityType<EnderTrapperEntity>> ENDSTONE_TRAPPER = register("endstone_trapper", EntityType.Builder.of(EnderTrapperEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.05f));
    public static final DeferredHolder<EntityType<?>, EntityType<FlampyrEntity>> FLAMPYR = register("ender_firefly",
            EntityType.Builder.of(FlampyrEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

                    .sized(0.7f, 0.5f));
    public static final DeferredHolder<EntityType<?>, EntityType<EndstoneGolemEntity>> ENDSTONE_GOLEM = register("endstone_golem", EntityType.Builder.of(EndstoneGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(128).setUpdateInterval(3).fireImmune().sized(1.8f, 2.95f));
    public static final DeferredHolder<EntityType<?>, EntityType<DraglingEntity>> DRAGLING = register("dragling",
            EntityType.Builder.of(DraglingEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.5f, 0.7f));
    public static final DeferredHolder<EntityType<?>, EntityType<BolokEntity>> BOLOK = register("bolok",
            EntityType.Builder.of(BolokEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

                    .sized(0.8f, 0.6f));
    public static final DeferredHolder<EntityType<?>, EntityType<EnderblobQueenEntity>> ENDERBLOB_QUEEN = register("enderblob_queen", EntityType.Builder.of(EnderblobQueenEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(1.9f, 3f));
    public static final DeferredHolder<EntityType<?>, EntityType<BlockUpdaterEntity>> BLOCK_UPDATER = register("block_updater", EntityType.Builder.of(BlockUpdaterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.2f, 0.2f));
    public static final DeferredHolder<EntityType<?>, EntityType<SpunklerEntity>> SPUNKLER = register("spunkler",
            EntityType.Builder.of(SpunklerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

                    .sized(0.8f, 0.8f));
    public static final DeferredHolder<EntityType<?>, EntityType<VoidCrackEntity>> VOID_CRACK = register("void_crack", EntityType.Builder.of(VoidCrackEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
            .setUpdateInterval(3).fireImmune().sized(0.2f, 0.2f));
    public static final DeferredHolder<EntityType<?>, EntityType<LargeBubbleEntity>> WARPED_BALLOON = register("warped_balloon",
            EntityType.Builder.of(LargeBubbleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(16).setUpdateInterval(3)

                    .sized(1.4f, 1.6f));
    public static final DeferredHolder<EntityType<?>, EntityType<GlubEntity>> GLUB = register("glub",
            EntityType.Builder.of(GlubEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

                    .sized(0.75f, 1f));
    public static final DeferredHolder<EntityType<?>, EntityType<VoidBombEntity>> VOID_BOMB = register("void_bomb",
            EntityType.Builder.of(VoidBombEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(1f, 1f));
    public static final DeferredHolder<EntityType<?>, EntityType<EnderbulbEntity>> ENDERBULB = register("enderbulb",
            EntityType.Builder.of(EnderbulbEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

                    .sized(0.8f, 1.2f));
    public static final DeferredHolder<EntityType<?>, EntityType<SmallEnderbulbEntity>> SMALL_ENDERBULB = register("small_enderbulb",
            EntityType.Builder.of(SmallEnderbulbEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

                    .sized(0.4f, 0.4f));
    public static final DeferredHolder<EntityType<?>, EntityType<BlukEntity>> BLUK = register("bluk",
            EntityType.Builder.of(BlukEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(16).setUpdateInterval(3)

                    .sized(0.6f, 0.5f));
    public static final DeferredHolder<EntityType<?>, EntityType<PhantomArrowProjectileEntity>> PHANTOM_ARROW_PROJECTILE = register("phantom_arrow_projectile", EntityType.Builder.<PhantomArrowProjectileEntity>of(PhantomArrowProjectileEntity::new, MobCategory.MISC)
            .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
    public static final DeferredHolder<EntityType<?>, EntityType<WanderingPearlProjectileEntity>> WANDERING_PEARL_PROJECTILE = register("wandering_pearl_projectile",
            EntityType.Builder.<WanderingPearlProjectileEntity>of(WanderingPearlProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
                    .setUpdateInterval(1).sized(0.5f, 0.5f));
    public static final DeferredHolder<EntityType<?>, EntityType<ShinyGrenadeProjectileEntity>> SHINY_GRENADE_PROJECTILE = register("shiny_grenade_projectile", EntityType.Builder.<ShinyGrenadeProjectileEntity>of(ShinyGrenadeProjectileEntity::new, MobCategory.MISC)
            .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
    public static final DeferredHolder<EntityType<?>, EntityType<LeechingChargeProjectileEntity>> LEECHING_CHARGE_PROJECTILE = register("leeching_charge_projectile",
            EntityType.Builder.<LeechingChargeProjectileEntity>of(LeechingChargeProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
                    .setUpdateInterval(1).sized(0.5f, 0.5f));
    public static final DeferredHolder<EntityType<?>, EntityType<VoidArrowProjectileEntity>> VOID_ARROW_PROJECTILE = register("void_arrow_projectile", EntityType.Builder.<VoidArrowProjectileEntity>of(VoidArrowProjectileEntity::new, MobCategory.MISC)
            .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
    public static final DeferredHolder<EntityType<?>, EntityType<SummonedDraglingEntity>> SUMMONED_DRAGLING = register("summoned_dragling", EntityType.Builder.of(SummonedDraglingEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
    public static final DeferredHolder<EntityType<?>, EntityType<BondLeechingChargeProjectileEntity>> BOND_LEECHING_CHARGE_PROJECTILE = register("bond_leeching_charge_projectile",
            EntityType.Builder.<BondLeechingChargeProjectileEntity>of(BondLeechingChargeProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
    public static final DeferredHolder<EntityType<?>, EntityType<BenevolentLeechingChargeProjectileEntity>> BENEVOLENT_LEECHING_CHARGE_PROJECTILE = register("benevolent_leeching_charge_projectile",
            EntityType.Builder.<BenevolentLeechingChargeProjectileEntity>of(BenevolentLeechingChargeProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
    public static final DeferredHolder<EntityType<?>, EntityType<WarpedBalloonProjEntity>> WARPED_BALLOON_PROJ = register("warped_balloon_proj", EntityType.Builder.<WarpedBalloonProjEntity>of(WarpedBalloonProjEntity::new, MobCategory.MISC)
            .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        return REGISTRY.register(registryname, () -> entityTypeBuilder.build(registryname));
    }
}
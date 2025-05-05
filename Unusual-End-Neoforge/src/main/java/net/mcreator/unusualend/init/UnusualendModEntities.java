package net.mcreator.unusualend.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.unusualend.entity.WarpedJellyfishEntity;
import net.mcreator.unusualend.entity.WarpedBalloonProjEntity;
import net.mcreator.unusualend.entity.WanderingPearlProjectileEntity;
import net.mcreator.unusualend.entity.VoidCrackEntity;
import net.mcreator.unusualend.entity.VoidBombEntity;
import net.mcreator.unusualend.entity.VoidArrowProjectileEntity;
import net.mcreator.unusualend.entity.SummonedDraglingEntity;
import net.mcreator.unusualend.entity.SpunklerEntity;
import net.mcreator.unusualend.entity.SmallEnderbulbEntity;
import net.mcreator.unusualend.entity.ShinyGrenadeProjectileEntity;
import net.mcreator.unusualend.entity.PhantomArrowProjectileEntity;
import net.mcreator.unusualend.entity.LeechingChargeProjectileEntity;
import net.mcreator.unusualend.entity.LargeBubbleEntity;
import net.mcreator.unusualend.entity.EndstoneGolemEntity;
import net.mcreator.unusualend.entity.EnderlingEntity;
import net.mcreator.unusualend.entity.EnderbulbEntity;
import net.mcreator.unusualend.entity.EnderblobQueenEntity;
import net.mcreator.unusualend.entity.EnderblobEntity;
import net.mcreator.unusualend.entity.EnderTrapperEntity;
import net.mcreator.unusualend.entity.EnderBugEntity;
import net.mcreator.unusualend.entity.DraglingEntity;
import net.mcreator.unusualend.entity.BondLeechingChargeProjectileEntity;
import net.mcreator.unusualend.entity.BolokEntity;
import net.mcreator.unusualend.entity.BlukEntity;
import net.mcreator.unusualend.entity.BlockUpdaterEntity;
import net.mcreator.unusualend.entity.BenevolentLeechingChargeProjectileEntity;
import net.mcreator.unusualend.UnusualendMod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusualendModEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, UnusualendMod.MODID);
    public static final DeferredHolder<EntityType<?>, EntityType<EnderblobEntity>> ENDER_BLOB = register("ender_blob",
            EntityType.Builder.<EnderblobEntity>of(EnderblobEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

                    .sized(0.8f, 0.4f));
    public static final DeferredHolder<EntityType<?>, EntityType<EnderlingEntity>> UNDEAD_ENDERLING = register("undead_enderling",
            EntityType.Builder.<EnderlingEntity>of(EnderlingEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

                    .sized(0.6f, 1.45f));
    public static final DeferredHolder<EntityType<?>, EntityType<EnderTrapperEntity>> ENDSTONE_TRAPPER = register("endstone_trapper", EntityType.Builder.<EnderTrapperEntity>of(EnderTrapperEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.05f));
    public static final DeferredHolder<EntityType<?>, EntityType<EnderBugEntity>> ENDER_FIREFLY = register("ender_firefly",
            EntityType.Builder.<EnderBugEntity>of(EnderBugEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

                    .sized(0.7f, 0.5f));
    public static final DeferredHolder<EntityType<?>, EntityType<EndstoneGolemEntity>> ENDSTONE_GOLEM = register("endstone_golem", EntityType.Builder.<EndstoneGolemEntity>of(EndstoneGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(128).setUpdateInterval(3).fireImmune().sized(1.8f, 2.95f));
    public static final DeferredHolder<EntityType<?>, EntityType<DraglingEntity>> DRAGLING = register("dragling",
            EntityType.Builder.<DraglingEntity>of(DraglingEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.5f, 0.7f));
    public static final DeferredHolder<EntityType<?>, EntityType<BolokEntity>> BOLOK = register("bolok",
            EntityType.Builder.<BolokEntity>of(BolokEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

                    .sized(0.8f, 0.6f));
    public static final DeferredHolder<EntityType<?>, EntityType<EnderblobQueenEntity>> ENDERBLOB_QUEEN = register("enderblob_queen", EntityType.Builder.<EnderblobQueenEntity>of(EnderblobQueenEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(1.9f, 3f));
    public static final DeferredHolder<EntityType<?>, EntityType<BlockUpdaterEntity>> BLOCK_UPDATER = register("block_updater", EntityType.Builder.<BlockUpdaterEntity>of(BlockUpdaterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.2f, 0.2f));
    public static final DeferredHolder<EntityType<?>, EntityType<SpunklerEntity>> SPUNKLER = register("spunkler",
            EntityType.Builder.<SpunklerEntity>of(SpunklerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

                    .sized(0.8f, 0.8f));
    public static final DeferredHolder<EntityType<?>, EntityType<VoidCrackEntity>> VOID_CRACK = register("void_crack", EntityType.Builder.<VoidCrackEntity>of(VoidCrackEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
            .setUpdateInterval(3).fireImmune().sized(0.2f, 0.2f));
    public static final DeferredHolder<EntityType<?>, EntityType<LargeBubbleEntity>> WARPED_BALLOON = register("warped_balloon",
            EntityType.Builder.<LargeBubbleEntity>of(LargeBubbleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(16).setUpdateInterval(3)

                    .sized(1.4f, 1.6f));
    public static final DeferredHolder<EntityType<?>, EntityType<WarpedJellyfishEntity>> GLUB = register("glub",
            EntityType.Builder.<WarpedJellyfishEntity>of(WarpedJellyfishEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

                    .sized(0.75f, 1f));
    public static final DeferredHolder<EntityType<?>, EntityType<VoidBombEntity>> VOID_BOMB = register("void_bomb",
            EntityType.Builder.<VoidBombEntity>of(VoidBombEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(1f, 1f));
    public static final DeferredHolder<EntityType<?>, EntityType<EnderbulbEntity>> ENDERBULB = register("enderbulb",
            EntityType.Builder.<EnderbulbEntity>of(EnderbulbEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

                    .sized(0.8f, 1.2f));
    public static final DeferredHolder<EntityType<?>, EntityType<SmallEnderbulbEntity>> SMALL_ENDERBULB = register("small_enderbulb",
            EntityType.Builder.<SmallEnderbulbEntity>of(SmallEnderbulbEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

                    .sized(0.4f, 0.4f));
    public static final DeferredHolder<EntityType<?>, EntityType<BlukEntity>> BLUK = register("bluk",
            EntityType.Builder.<BlukEntity>of(BlukEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(16).setUpdateInterval(3)

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
    public static final DeferredHolder<EntityType<?>, EntityType<SummonedDraglingEntity>> SUMMONED_DRAGLING = register("summoned_dragling", EntityType.Builder.<SummonedDraglingEntity>of(SummonedDraglingEntity::new, MobCategory.MONSTER)
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

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            EnderblobEntity.init();
            EnderlingEntity.init();
            EnderTrapperEntity.init();
            EnderBugEntity.init();
            EndstoneGolemEntity.init();
            DraglingEntity.init();
            BolokEntity.init();
            EnderblobQueenEntity.init();
            BlockUpdaterEntity.init();
            SpunklerEntity.init();
            VoidCrackEntity.init();
            LargeBubbleEntity.init();
            WarpedJellyfishEntity.init();
            VoidBombEntity.init();
            EnderbulbEntity.init();
            SmallEnderbulbEntity.init();
            BlukEntity.init();
            SummonedDraglingEntity.init();
        });
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ENDER_BLOB.get(), EnderblobEntity.createAttributes().build());
        event.put(UNDEAD_ENDERLING.get(), EnderlingEntity.createAttributes().build());
        event.put(ENDSTONE_TRAPPER.get(), EnderTrapperEntity.createAttributes().build());
        event.put(ENDER_FIREFLY.get(), EnderBugEntity.createAttributes().build());
        event.put(ENDSTONE_GOLEM.get(), EndstoneGolemEntity.createAttributes().build());
        event.put(DRAGLING.get(), DraglingEntity.createAttributes().build());
        event.put(BOLOK.get(), BolokEntity.createAttributes().build());
        event.put(ENDERBLOB_QUEEN.get(), EnderblobQueenEntity.createAttributes().build());
        event.put(BLOCK_UPDATER.get(), BlockUpdaterEntity.createAttributes().build());
        event.put(SPUNKLER.get(), SpunklerEntity.createAttributes().build());
        event.put(VOID_CRACK.get(), VoidCrackEntity.createAttributes().build());
        event.put(WARPED_BALLOON.get(), LargeBubbleEntity.createAttributes().build());
        event.put(GLUB.get(), WarpedJellyfishEntity.createAttributes().build());
        event.put(VOID_BOMB.get(), VoidBombEntity.createAttributes().build());
        event.put(ENDERBULB.get(), EnderbulbEntity.createAttributes().build());
        event.put(SMALL_ENDERBULB.get(), SmallEnderbulbEntity.createAttributes().build());
        event.put(BLUK.get(), BlukEntity.createAttributes().build());
        event.put(SUMMONED_DRAGLING.get(), SummonedDraglingEntity.createAttributes().build());
    }
}

package net.sweety.unusualend.event;

import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.sweety.unusualend.block.entity.*;
import net.sweety.unusualend.entity.*;
import net.sweety.unusualend.init.*;
import net.sweety.unusualend.item.BolokResearchNotesItem;
import net.sweety.unusualend.jei_recipes.BolokTradingRecipe;
import net.sweety.unusualend.jei_recipes.InfuserRecipe;
import net.sweety.unusualend.network.BolokNotesPacket;
import net.sweety.unusualend.network.InfuserGUIPacket;
import net.sweety.unusualend.network.UnusualEndVariables;
import net.sweety.unusualend.procedures.SpunklerNaturalEntitySpawningConditionProcedure;


@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class UnusualEndEvents {
    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerItem(Capabilities.ItemHandler.ITEM, (stack, content) -> stack.getCapability(BolokResearchNotesItem.NOTES_ITEM_HANDLER), UnusualEndItems.BOLOK_RESEARCH_NOTES.get());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UnusualEndBlockEntities.ANCIENT_PODIUM.get(), (block, side) -> ((AncientPodiumBlockEntity) block).getHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UnusualEndBlockEntities.PURPUR_TANK.get(), (block, side) -> ((PurpurTankBlockEntity) block).getHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UnusualEndBlockEntities.GLOOPSLATE_PEDESTRAL.get(), (block, side) -> ((GloopslatePedestralBlockEntity) block).getHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UnusualEndBlockEntities.BUILDING_INHIBITOR.get(), (block, side) -> ((BuildingInhibitorBlockEntity) block).getHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UnusualEndBlockEntities.FADING_BLOCK.get(), (block, side) -> ((FadingBlockEntity) block).getHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UnusualEndBlockEntities.PEARLESCENT_INFUSER.get(), (block, side) -> ((PearlescentInfuserBlockEntity) block).getHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UnusualEndBlockEntities.WARPED_CHEST.get(), (block, side) -> ((WarpedChestBlockEntity) block).getHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UnusualEndBlockEntities.WARPING_WAYSTONE.get(), (block, side) -> ((WarpingWaystoneBlockEntity) block).getHandler());
    }

    @SubscribeEvent
    public static void registerSpawnConditions(RegisterSpawnPlacementsEvent event) {
        event.register(UnusualEndEntities.BLUK.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, level, reason, pos, random) -> (level.getDifficulty() != Difficulty.PEACEFUL && Mob.checkMobSpawnRules(entityType, level, reason, pos, random)), RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(UnusualEndEntities.BOLOK.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, level, reason, pos, random) -> (level.getDifficulty() != Difficulty.PEACEFUL && Mob.checkMobSpawnRules(entityType, level, reason, pos, random)), RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(UnusualEndEntities.UNDEAD_ENDERLING.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, level, reason, pos, random) -> (level.getDifficulty() != Difficulty.PEACEFUL && Mob.checkMobSpawnRules(entityType, level, reason, pos, random)), RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(UnusualEndEntities.ENDER_BLOB.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, level, reason, pos, random) -> (level.getDifficulty() != Difficulty.PEACEFUL && Mob.checkMobSpawnRules(entityType, level, reason, pos, random)), RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(UnusualEndEntities.SMALL_ENDERBULB.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, level, reason, pos, random) -> (level.getDifficulty() != Difficulty.PEACEFUL && Mob.checkMobSpawnRules(entityType, level, reason, pos, random)), RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(UnusualEndEntities.ENDERBULB.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, level, reason, pos, random) -> (level.getDifficulty() != Difficulty.PEACEFUL && Mob.checkMobSpawnRules(entityType, level, reason, pos, random)), RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(UnusualEndEntities.GLUB.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, level, reason, pos, random) -> {
                    int x = pos.getX();
                    int y = pos.getY();
                    int z = pos.getZ();
                    return SpunklerNaturalEntitySpawningConditionProcedure.execute(level, x, y, z);
                }, RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(UnusualEndEntities.SPUNKLER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, level, reason, pos, random) -> {
                    int x = pos.getX();
                    int y = pos.getY();
                    int z = pos.getZ();
                    return SpunklerNaturalEntitySpawningConditionProcedure.execute(level, x, y, z);
                }, RegisterSpawnPlacementsEvent.Operation.AND);

    }

    @SubscribeEvent
    public static void register(FMLConstructModEvent event) {
        UnusualEndMiscRegister.SERIALIZERS.register("bolok_trading", () -> BolokTradingRecipe.Serializer.INSTANCE);
        UnusualEndMiscRegister.SERIALIZERS.register("infuser", () -> InfuserRecipe.Serializer.INSTANCE);
    }

    @SubscribeEvent
    public static void registerPayloads(final RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar("1.0");
        registrar.playToServer(BolokNotesPacket.TYPE, BolokNotesPacket.STREAM_CODEC, BolokNotesPacket::handle);
        registrar.playToServer(InfuserGUIPacket.TYPE, InfuserGUIPacket.STREAM_CODEC, InfuserGUIPacket::handle);
        registrar.playBidirectional(UnusualEndVariables.PlayerVariablesSyncPacket.TYPE, UnusualEndVariables.PlayerVariablesSyncPacket.STREAM_CODEC, UnusualEndVariables.PlayerVariablesSyncPacket::handle);
    }

    @SubscribeEvent
    public static void addComposterItems(FMLCommonSetupEvent event) {
        ComposterBlock.COMPOSTABLES.put(UnusualEndBlocks.CHORUS_CANE_FLOWER.get().asItem(), 0.85f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndBlocks.CHORUS_CANE.get().asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndBlocks.BLOOMING_CHORUS_CANE.get().asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndBlocks.CHORUS_FUNGUS.get().asItem(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndBlocks.CHORUS_ROOTS.get().asItem(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndBlocks.ENDSTONE_SPROUTS.get().asItem(), 0.5f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndBlocks.PURPUR_GRASS.get().asItem(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndBlocks.FLOWERING_PURPUR_GRASS.get().asItem(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndBlocks.WARPED_MOSS.get().asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndItems.CHORUS_PIE.get(), 1f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndItems.CHORUS_PETAL.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndBlocks.DRIPPING_GLOOPSTONE.get().asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndBlocks.GLOOPY_BUSH.get().asItem(), 0.5f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndBlocks.SHINY_SPIREA.get().asItem(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndItems.WARPED_SPORES.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndBlocks.WARPED_ALGAE.get().asItem(), 0.5f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndBlocks.SMALL_WARPED_ALGAE.get().asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndBlocks.WARPED_SPROUTS.get().asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndBlocks.CRYSTAL_FLOWER.get().asItem(), 1f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndItems.WARPED_BERRIES.get(), 0.85f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndBlocks.GLOOPY_TENDRILS.get().asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndBlocks.WARPED_BUSH.get().asItem(), 0.5f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndBlocks.WARPED_SQUASH.get().asItem(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndItems.WARPED_SQUASH_WEDGE.get(), 0.5f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndBlocks.SMALL_WARPED_SQUASH.get().asItem(), 0.5f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndItems.GLOOPILON_SLICE.get(), 0.85f);
        ComposterBlock.COMPOSTABLES.put(UnusualEndBlocks.GLOOPILON_SEEDS.get().asItem(), 0.85f);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(UnusualEndEntities.ENDER_BLOB.get(), EnderblobEntity.createAttributes().build());
        event.put(UnusualEndEntities.UNDEAD_ENDERLING.get(), EnderlingEntity.createAttributes().build());
        event.put(UnusualEndEntities.ENDSTONE_TRAPPER.get(), EnderTrapperEntity.createAttributes().build());
        event.put(UnusualEndEntities.FLAMPYR.get(), FlampyrEntity.createAttributes().build());
        event.put(UnusualEndEntities.ENDSTONE_GOLEM.get(), EndstoneGolemEntity.createAttributes().build());
        event.put(UnusualEndEntities.DRAGLING.get(), DraglingEntity.createAttributes().build());
        event.put(UnusualEndEntities.BOLOK.get(), BolokEntity.createAttributes().build());
        event.put(UnusualEndEntities.ENDERBLOB_QUEEN.get(), EnderblobQueenEntity.createAttributes().build());
        event.put(UnusualEndEntities.BLOCK_UPDATER.get(), BlockUpdaterEntity.createAttributes().build());
        event.put(UnusualEndEntities.SPUNKLER.get(), SpunklerEntity.createAttributes().build());
        event.put(UnusualEndEntities.VOID_CRACK.get(), VoidCrackEntity.createAttributes().build());
        event.put(UnusualEndEntities.WARPED_BALLOON.get(), LargeBubbleEntity.createAttributes().build());
        event.put(UnusualEndEntities.GLUB.get(), GlubEntity.createAttributes().build());
        event.put(UnusualEndEntities.VOID_BOMB.get(), VoidBombEntity.createAttributes().build());
        event.put(UnusualEndEntities.ENDERBULB.get(), EnderbulbEntity.createAttributes().build());
        event.put(UnusualEndEntities.SMALL_ENDERBULB.get(), SmallEnderbulbEntity.createAttributes().build());
        event.put(UnusualEndEntities.BLUK.get(), BlukEntity.createAttributes().build());
        event.put(UnusualEndEntities.SUMMONED_DRAGLING.get(), SummonedDraglingEntity.createAttributes().build());
    }
}
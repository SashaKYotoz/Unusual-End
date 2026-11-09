package net.sweety.unusualend.init;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.block.*;

public class UnusualEndBlocks {
    public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(UnusualEnd.MODID);
    public static final DeferredBlock<Block> RAW_PURPUR_BLOCK = block("raw_purpur_block", stone(MapColor.COLOR_MAGENTA, 1.5f, 6f));
    public static final DeferredBlock<InfectedEndstoneBlock> INFESTED_END_STONE = REGISTRY.register("infested_end_stone", () -> new InfectedEndstoneBlock());
    public static final DeferredBlock<Block> POLISHED_PURPUR = block("polished_purpur", stone(MapColor.COLOR_MAGENTA, 1.5f, 6f));
    public static final DeferredBlock<StairBlock> POLISHED_PURPUR_STAIRS = stairs("polished_purpur_stairs", POLISHED_PURPUR, 0, stone(MapColor.COLOR_MAGENTA, 1.5f, 6f));
    public static final DeferredBlock<SlabBlock> POLISHED_PURPUR_SLAB = slab("polished_purpur_slab", 0, stone(MapColor.COLOR_MAGENTA, 1.5f, 6f));
    public static final DeferredBlock<ChorusRootsBlock> CHORUS_ROOTS = REGISTRY.register("chorus_roots", () -> new ChorusRootsBlock());
    public static final DeferredBlock<ChorusFungusBlock> CHORUS_FUNGUS = REGISTRY.register("chorus_fungus", () -> new ChorusFungusBlock());
    public static final DeferredBlock<FlowerPotBlock> FLOWER_POT_CHORUS_FUNGUS = flowerPot("flower_pot_chorus_fungus", CHORUS_FUNGUS, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));
    public static final DeferredBlock<ChiseledEndstone1Block> CHISELED_ENDSTONE_BUILDER = REGISTRY.register("chiseled_endstone_builder", () -> new ChiseledEndstone1Block());
    public static final DeferredBlock<ChiseledEndstone2Block> CHISELED_ENDSTONE_US = REGISTRY.register("chiseled_endstone_us", () -> new ChiseledEndstone2Block());
    public static final DeferredBlock<ChiseledEndstone3Block> CHISELED_ENDSTONE_DRAGON = REGISTRY.register("chiseled_endstone_dragon", () -> new ChiseledEndstone3Block());
    public static final DeferredBlock<ChiseledEndstone4Block> CHISELED_ENDSTONE_SCARED = REGISTRY.register("chiseled_endstone_scared", () -> new ChiseledEndstone4Block());
    public static final DeferredBlock<ChiseledEndstone5Block> CHISELED_ENDSTONE_WORK = REGISTRY.register("chiseled_endstone_work", () -> new ChiseledEndstone5Block());
    public static final DeferredBlock<ChiseledEndstone6Block> CHISELED_ENDSTONE_FRIENDSHIP = REGISTRY.register("chiseled_endstone_friendship", () -> new ChiseledEndstone6Block());
    public static final DeferredBlock<FireflyBulbBlock> FIREFLY_BULB = REGISTRY.register("firefly_bulb", () -> new FireflyBulbBlock());
    public static final DeferredBlock<EnderBlobBlock> ENDERBLOB_BLOCK = REGISTRY.register("enderblob_block", () -> new EnderBlobBlock());
    public static final DeferredBlock<TeleportationAnchorBlock> TELEPORTATION_ANCHOR = REGISTRY.register("teleportation_anchor", () -> new TeleportationAnchorBlock());
    public static final DeferredBlock<WeakEndStoneBricksBlock> WEAK_END_STONE_BRICKS = REGISTRY.register("weak_end_stone_bricks", () -> new WeakEndStoneBricksBlock());
    public static final DeferredBlock<ShulkerShooterBlock> SHULKER_SHOOTER = REGISTRY.register("shulker_shooter", () -> new ShulkerShooterBlock());
    public static final DeferredBlock<GolemAltarBlock> GOLEM_ALTAR = REGISTRY.register("golem_altar", () -> new GolemAltarBlock());
    public static final DeferredBlock<Block> SPECTRAL_BLOCK = REGISTRY.register("spectral_block", () -> new PhantomBlock());
    public static final DeferredBlock<DragonLampBlock> DRAGON_LAMP = REGISTRY.register("dragon_lamp", () -> new DragonLampBlock());
    public static final DeferredBlock<PurpurTankBlock> PURPUR_TANK = REGISTRY.register("purpur_tank", () -> new PurpurTankBlock());
    public static final DeferredBlock<Block> PURPUR_EMBEDDED_END_STONE = block("purpur_embedded_end_stone", stone(MapColor.COLOR_MAGENTA, 3f, 9.5f));
    public static final DeferredBlock<ChorusNestPlanksBlock> CHORUS_NEST_PLANKS = REGISTRY.register("chorus_nest_planks", () -> new ChorusNestPlanksBlock());
    public static final DeferredBlock<StrippedChorusNestPlanksBlock> STRIPPED_CHORUS_NEST_PLANKS = REGISTRY.register("stripped_chorus_nest_planks", () -> new StrippedChorusNestPlanksBlock());
    public static final DeferredBlock<ChorusNestStairsBlock> CHORUS_NEST_STAIRS = REGISTRY.register("chorus_nest_stairs", () -> new ChorusNestStairsBlock());
    public static final DeferredBlock<StrippedChorusNestStairsBlock> STRIPPED_CHORUS_NEST_STAIRS = REGISTRY.register("stripped_chorus_nest_stairs", () -> new StrippedChorusNestStairsBlock());
    public static final DeferredBlock<ChorusNestSlabBlock> CHORUS_NEST_SLAB = REGISTRY.register("chorus_nest_slab", () -> new ChorusNestSlabBlock());
    public static final DeferredBlock<StrippedChorusNestSlabBlock> STRIPPED_CHORUS_NEST_SLAB = REGISTRY.register("stripped_chorus_nest_slab", () -> new StrippedChorusNestSlabBlock());
    public static final DeferredBlock<FadingBlockBlock> FADING_BLOCK = REGISTRY.register("fading_block", () -> new FadingBlockBlock());
    public static final DeferredBlock<Block> ENDSTONE_TILES = block("endstone_tiles", stone(MapColor.SAND, 3f, 9.5f));
    public static final DeferredBlock<EndermitemoultblockBlock> ENDERBLOB_MOULT_BLOCK = REGISTRY.register("enderblob_moult_block", () -> new EndermitemoultblockBlock());
    public static final DeferredBlock<PhantomMembraneBlock> PHANTOM_MEMBRANE_BLOCK = REGISTRY.register("phantom_membrane_block", () -> new PhantomMembraneBlock());
    public static final DeferredBlock<Block> POLISHED_PURPUR_TILES = block("polished_purpur_tiles", stone(MapColor.COLOR_MAGENTA, 1.5f, 6f));
    public static final DeferredBlock<StairBlock> POLISHED_PURPUR_TILES_STAIRS = stairs("polished_purpur_tiles_stairs", POLISHED_PURPUR_TILES, stone(MapColor.COLOR_MAGENTA, 1.5f, 6f));
    public static final DeferredBlock<SlabBlock> POLISHED_PURPUR_TILES_SLAB = slab("polished_purpur_tiles_slab", stone(MapColor.COLOR_MAGENTA, 1.5f, 6f));
    public static final DeferredBlock<StairBlock> RAW_PURPUR_BLOCK_STAIRS = stairs("raw_purpur_block_stairs", RAW_PURPUR_BLOCK, stone(MapColor.COLOR_MAGENTA, 1.5f, 6f));
    public static final DeferredBlock<SlabBlock> RAW_PURPUR_BLOCK_SLAB = slab("raw_purpur_block_slab", stone(MapColor.COLOR_MAGENTA, 1.5f, 6f));
    public static final DeferredBlock<Block> POLISHED_PURPUR_BRICKS = block("polished_purpur_bricks", stone(MapColor.COLOR_MAGENTA, 1.5f, 6f));
    public static final DeferredBlock<StairBlock> POLISHED_PURPUR_BRICK_STAIRS = stairs("polished_purpur_brick_stairs", POLISHED_PURPUR_BRICKS, stone(MapColor.COLOR_MAGENTA, 1.5f, 6f));
    public static final DeferredBlock<SlabBlock> POLISHED_PURPUR_BRICK_SLAB = slab("polished_purpur_brick_slab", stone(MapColor.COLOR_MAGENTA, 1.5f, 6f));
    public static final DeferredBlock<Block> POLISHED_PURPUR_TILES_LANTERN = block("polished_purpur_tiles_lantern", stone(MapColor.COLOR_MAGENTA, 1.5f, 6f).lightLevel(s -> 15));
    public static final DeferredBlock<ChorusnestplanksdoorBlock> CHORUS_NEST_PLANKS_DOOR = REGISTRY.register("chorus_nest_planks_door", () -> new ChorusnestplanksdoorBlock());
    public static final DeferredBlock<ChorusNestTrapdoorBlock> CHORUS_NEST_TRAPDOOR = REGISTRY.register("chorus_nest_trapdoor", () -> new ChorusNestTrapdoorBlock());
    public static final DeferredBlock<ChorusnestmosaicBlock> CHORUS_NEST_MOSAIC = REGISTRY.register("chorus_nest_mosaic", () -> new ChorusnestmosaicBlock());
    public static final DeferredBlock<ChorusnestmosaicslabBlock> CHORUS_NEST_MOSAIC_SLAB = REGISTRY.register("chorus_nest_mosaic_slab", () -> new ChorusnestmosaicslabBlock());
    public static final DeferredBlock<ChorusnestmosaicstairsBlock> CHORUS_NEST_MOSAIC_STAIRS = REGISTRY.register("chorus_nest_mosaic_stairs", () -> new ChorusnestmosaicstairsBlock());
    public static final DeferredBlock<Block> CHISELED_POLISHED_PURPUR_TILES = block("chiseled_polished_purpur_tiles", stone(MapColor.COLOR_MAGENTA, 1.5f, 6f));
    public static final DeferredBlock<ChorusNestFencesBlock> CHORUS_NEST_MOSAIC_FENCE = REGISTRY.register("chorus_nest_mosaic_fence", () -> new ChorusNestFencesBlock());
    public static final DeferredBlock<ChorusNestFenceGateBlock> CHORUS_NEST_FENCE_GATE = REGISTRY.register("chorus_nest_fence_gate", () -> new ChorusNestFenceGateBlock());
    public static final DeferredBlock<ChorusGrassBlock> PURPUR_GRASS = REGISTRY.register("purpur_grass", () -> new ChorusGrassBlock());
    public static final DeferredBlock<FloweringChorusGrassBlock> FLOWERING_PURPUR_GRASS = REGISTRY.register("flowering_purpur_grass", () -> new FloweringChorusGrassBlock());
    public static final DeferredBlock<EndstoneSproutsBlock> ENDSTONE_SPROUTS = REGISTRY.register("endstone_sprouts", () -> new EndstoneSproutsBlock());
    public static final DeferredBlock<Block> CHISELED_GLASS = REGISTRY.register("chiseled_glass", () -> new ChiseledGlassBlock());
    public static final DeferredBlock<ChiseledGlassPaneBlock> CHISELED_GLASS_PANE = REGISTRY.register("chiseled_glass_pane", () -> new ChiseledGlassPaneBlock());
    public static final DeferredBlock<EndermitemoultbricksBlock> ENDERBLOB_MOULT_BRICKS = REGISTRY.register("enderblob_moult_bricks", () -> new EndermitemoultbricksBlock());
    public static final DeferredBlock<WallBlock> RAW_PURPUR_WALL = wall("raw_purpur_wall", stone(MapColor.COLOR_MAGENTA, 1.5f, 6f).forceSolidOn());
    public static final DeferredBlock<WallBlock> POLISHED_RAW_PURPUR_BRICK_WALL = wall("polished_raw_purpur_brick_wall", stone(MapColor.COLOR_MAGENTA, 1.5f, 6f).forceSolidOn());
    public static final DeferredBlock<Block> GNEISS = block("gneiss", stone(MapColor.COLOR_BLUE, 15f, 15f));
    public static final DeferredBlock<WarpedEndStoneBlock> WARPED_END_STONE = REGISTRY.register("warped_end_stone", () -> new WarpedEndStoneBlock());
    public static final DeferredBlock<Block> GLOOPSTONE = block("gloopstone", gloop(0.95f));
    public static final DeferredBlock<Block> GNEISS_BRICKS = block("gneiss_bricks", stone(MapColor.COLOR_BLUE, 14f, 15f));
    public static final DeferredBlock<Block> POLISHED_GNEISS = block("polished_gneiss", stone(MapColor.COLOR_BLUE, 14f, 15f));
    public static final DeferredBlock<Block> CHISELED_GNEISS_BRICK = block("chiseled_gneiss_brick", stone(MapColor.COLOR_BLUE, 14f, 15f));
    public static final DeferredBlock<EndermiteEggBlock> ENDERMITE_EGGS = REGISTRY.register("endermite_eggs", () -> new EndermiteEggBlock());
    public static final DeferredBlock<WeakEndermiteEggBlock> CRACKED_ENDERMITE_EGGS = REGISTRY.register("cracked_endermite_eggs", () -> new WeakEndermiteEggBlock());
    public static final DeferredBlock<ShinyGloopstoneBlock> SHINY_GLOOPSTONE = REGISTRY.register("shiny_gloopstone", () -> new ShinyGloopstoneBlock());
    public static final DeferredBlock<GloopstoneLampBlock> GLOOPSTONE_LAMP = REGISTRY.register("gloopstone_lamp", () -> new GloopstoneLampBlock());
    public static final DeferredBlock<Block> POLISHED_GLOOPSTONE = block("polished_gloopstone", 13, gloop(0.95f));
    public static final DeferredBlock<Block> GLOOPSTONE_BRICKS = block("gloopstone_bricks", 13, gloop(0.95f));
    public static final DeferredBlock<StairBlock> POLISHED_GNEISS_STAIRS = stairs("polished_gneiss_stairs", POLISHED_GNEISS, stone(MapColor.COLOR_BLUE, 14f, 15f));
    public static final DeferredBlock<SlabBlock> POLISHED_GNEISS_SLAB = slab("polished_gneiss_slab", stone(MapColor.COLOR_BLUE, 14f, 15f));
    public static final DeferredBlock<StairBlock> GNEISS_BRICK_STAIRS = stairs("gneiss_brick_stairs", GNEISS_BRICKS, stone(MapColor.COLOR_BLUE, 14f, 15f));
    public static final DeferredBlock<SlabBlock> GNEISS_BRICK_SLAB = slab("gneiss_brick_slab", stone(MapColor.COLOR_BLUE, 14f, 15f));
    public static final DeferredBlock<StairBlock> POLISHED_GLOOPSTONE_STAIRS = stairs("polished_gloopstone_stairs", POLISHED_GLOOPSTONE, gloop(0.95f));
    public static final DeferredBlock<SlabBlock> POLISHED_GLOOPSTONE_SLAB = slab("polished_gloopstone_slab", gloop(0.95f));
    public static final DeferredBlock<StairBlock> GLOOPSTONE_BRICK_STAIRS = stairs("gloopstone_brick_stairs", GLOOPSTONE_BRICKS, gloop(0.95f));
    public static final DeferredBlock<SlabBlock> GLOOPSTONE_BRICK_SLAB = slab("gloopstone_brick_slab", gloop(0.95f));
    public static final DeferredBlock<WallBlock> GNEISS_BRICK_WALL = wall("gneiss_brick_wall", stone(MapColor.COLOR_BLUE, 14f, 15f).forceSolidOn());
    public static final DeferredBlock<WallBlock> GLOOPSTONE_BRICK_WALL = wall("gloopstone_brick_wall", gloop(0.95f).forceSolidOn());
    public static final DeferredBlock<Block> SHINY_CRYSTAL_BLOCK = block("shiny_crystal_block", 10, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.AMETHYST).strength(0.85f, 5f).lightLevel(s -> 10).requiresCorrectToolForDrops());
    public static final DeferredBlock<BolokScaleBlock> BOLOK_SCALE_BLOCK = REGISTRY.register("bolok_scale_block", () -> new BolokScaleBlock());
    public static final DeferredBlock<Block> SHINY_CRYSTAL_TILES = block("shiny_crystal_tiles", 10, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.AMETHYST).strength(0.85f, 4f).lightLevel(s -> 5).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> CHISELED_GLOOPSTONE_BRICKS = block("chiseled_gloopstone_bricks", 13, gloop(0.95f));
    public static final DeferredBlock<WarpedMossBlock> WARPED_MOSS = REGISTRY.register("warped_moss", () -> new WarpedMossBlock());
    public static final DeferredBlock<Block> SHINY_CRYSTAL_BRICKS = block("shiny_crystal_bricks", 10, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.AMETHYST).strength(0.85f, 4f).lightLevel(s -> 5).requiresCorrectToolForDrops());
    public static final DeferredBlock<ChorusPetalsBlock> CHORUS_PETALS_BLOCK = REGISTRY.register("chorus_petals_block", () -> new ChorusPetalsBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.RAW_IRON).sound(SoundType.MOSS).strength(0.05f, 1f).jumpFactor(0.9f)));
    public static final DeferredBlock<DrippingGloopstoneBlock> DRIPPING_GLOOPSTONE = REGISTRY.register("dripping_gloopstone", () -> new DrippingGloopstoneBlock());
    public static final DeferredBlock<Block> GLOOPSLATE = block("gloopslate", gloop(0.85f));
    public static final DeferredBlock<GloopyBushBlock> GLOOPY_BUSH = REGISTRY.register("gloopy_bush", () -> new GloopyBushBlock());
    public static final DeferredBlock<ShinySpireaBlock> SHINY_SPIREA = REGISTRY.register("shiny_spirea", () -> new ShinySpireaBlock());
    public static final DeferredBlock<BouncyGloopslateBlock> BOUNCY_GLOOPSLATE = REGISTRY.register("bouncy_gloopslate", () -> new BouncyGloopslateBlock());
    public static final DeferredBlock<Block> GLOOPSTONE_LANTERN = block("gloopstone_lantern", 1, gloop(0.85f).lightLevel(s -> 15));
    public static final DeferredBlock<FlowerPotBlock> FLOWER_POT_CHORUS_ROOTS = flowerPot("flower_pot_chorus_roots", CHORUS_ROOTS, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));
    public static final DeferredBlock<FlowerPotBlock> FLOWER_POT_SHINY_SPIREA = flowerPot("flower_pot_shiny_spirea", SHINY_SPIREA, BlockBehaviour.Properties.of().instabreak().lightLevel(s -> 8).noOcclusion().pushReaction(PushReaction.DESTROY));
    public static final DeferredBlock<HealingLanternBlock> HEALING_LANTERN = REGISTRY.register("healing_lantern", () -> new HealingLanternBlock());
    public static final DeferredBlock<Block> POLISHED_GLOOPSLATE = block("polished_gloopslate", gloop(0.85f));
    public static final DeferredBlock<Block> GLOOPSLATE_BRICKS = block("gloopslate_bricks", gloop(0.85f));
    public static final DeferredBlock<SlabBlock> POLISHED_GLOOPSLATE_SLAB = slab("polished_gloopslate_slab", gloop(0.85f));
    public static final DeferredBlock<StairBlock> POLISHED_GLOOPSLATE_STAIRS = stairs("polished_gloopslate_stairs", POLISHED_GLOOPSLATE, gloop(0.85f));
    public static final DeferredBlock<SlabBlock> GLOOPSLATE_BRICKS_SLAB = slab("gloopslate_bricks_slab", gloop(0.85f));
    public static final DeferredBlock<StairBlock> GLOOPSLATE_BRICKS_STAIRS = stairs("gloopslate_bricks_stairs", GLOOPSLATE_BRICKS, gloop(0.85f));
    public static final DeferredBlock<Block> CHISELED_POLISHED_GLOOPSLATE = block("chiseled_polished_gloopslate", 13, gloop(0.85f));
    public static final DeferredBlock<GneissPileBlock> GNEISS_PILE = REGISTRY.register("gneiss_pile", () -> new GneissPileBlock());
    public static final DeferredBlock<WarpedAlgaeBlock> WARPED_ALGAE = REGISTRY.register("warped_algae", () -> new WarpedAlgaeBlock());
    public static final DeferredBlock<Block> ANCIENT_ENCASED_END_STONE = block("ancient_encased_end_stone", stone(MapColor.SAND, 3.5f, 13f).pushReaction(PushReaction.BLOCK));
    public static final DeferredBlock<Block> PEARLESCENT_BLOCK = block("pearlescent_block", 5, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.COPPER).strength(2f, 15f).lightLevel(s -> 5).requiresCorrectToolForDrops().speedFactor(1.1f).jumpFactor(1.1f));
    public static final DeferredBlock<WarpedSquashBlock> WARPED_SQUASH = REGISTRY.register("warped_squash", () -> new WarpedSquashBlock());
    public static final DeferredBlock<GneissPillarBlock> GNEISS_PILLAR = REGISTRY.register("gneiss_pillar", () -> new GneissPillarBlock());
    public static final DeferredBlock<CarvedWarpedSquashBlock> CARVED_WARPED_SQUASH = REGISTRY.register("carved_warped_squash", () -> new CarvedWarpedSquashBlock());
    public static final DeferredBlock<VoidParticlesBlockBlock> VOID_PARTICLES_BLOCK = REGISTRY.register("void_particles_block", () -> new VoidParticlesBlockBlock());
    public static final DeferredBlock<WarpedBubbleBlock> WARPED_BUBBLE = REGISTRY.register("warped_bubble", () -> new WarpedBubbleBlock());
    public static final DeferredBlock<WarpingWaystoneBlock> WARPING_WAYSTONE = REGISTRY.register("warping_waystone", () -> new WarpingWaystoneBlock());
    public static final DeferredBlock<PrismaliticGloopslateBlock> PRISMALITIC_GLOOPSLATE = REGISTRY.register("prismalitic_gloopslate", () -> new PrismaliticGloopslateBlock());
    public static final DeferredBlock<Block> PRISMALITE_BLOCK = block("prismalite_block", BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.COLOR_PURPLE).sound(SoundType.AMETHYST).strength(2f, 10f).lightLevel(s -> 8).speedFactor(1.3f));
    public static final DeferredBlock<GloopslatePedestralBlock> GLOOPSLATE_PEDESTRAL = REGISTRY.register("gloopslate_pedestral", () -> new GloopslatePedestralBlock());
    public static final DeferredBlock<FilledGloopslatePedestralBlock> PRISMATIC_PEARL_DISPLAY = REGISTRY.register("prismatic_pearl_display", () -> new FilledGloopslatePedestralBlock());
    public static final DeferredBlock<CentralPedestralBlock> CENTRAL_PEDESTAL = REGISTRY.register("central_pedestal", () -> new CentralPedestralBlock());
    public static final DeferredBlock<Block> CITRINE_BLOCK = block("citrine_block", BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.COLOR_ORANGE).sound(SoundType.AMETHYST).strength(1.5f).requiresCorrectToolForDrops());
    public static final DeferredBlock<CitrineClusterBlock> CITRINE_CLUSTER = REGISTRY.register("citrine_cluster", () -> new CitrineClusterBlock());
    public static final DeferredBlock<CitrineBudBlock> CITRINE_BUD = REGISTRY.register("citrine_bud", () -> new CitrineBudBlock());
    public static final DeferredBlock<BuddingCitrineBlock> BUDDING_CITRINE = REGISTRY.register("budding_citrine", () -> new BuddingCitrineBlock());
    public static final DeferredBlock<LargeCitrineBudBlock> LARGE_CITRINE_BUD = REGISTRY.register("large_citrine_bud", () -> new LargeCitrineBudBlock());
    public static final DeferredBlock<CondensedCitrineBlockBlock> CONDENSED_CITRINE_BLOCK = REGISTRY.register("condensed_citrine_block", () -> new CondensedCitrineBlockBlock());
    public static final DeferredBlock<PearlescentInfuserBlock> PEARLESCENT_INFUSER = REGISTRY.register("pearlescent_infuser", () -> new PearlescentInfuserBlock());
    public static final DeferredBlock<CrystalFlowerBlock> CRYSTAL_FLOWER = REGISTRY.register("crystal_flower", () -> new CrystalFlowerBlock());
    public static final DeferredBlock<SmallWarpedAlgaeBlock> SMALL_WARPED_ALGAE = REGISTRY.register("small_warped_algae", () -> new SmallWarpedAlgaeBlock());
    public static final DeferredBlock<WarpedSproutsBlock> WARPED_SPROUTS = REGISTRY.register("warped_sprouts", () -> new WarpedSproutsBlock());
    public static final DeferredBlock<Block> WARPED_STONE = block("warped_stone", stone(MapColor.COLOR_CYAN, 9f, 11f));
    public static final DeferredBlock<GloopyTendrilsBlock> GLOOPY_TENDRILS = REGISTRY.register("gloopy_tendrils", () -> new GloopyTendrilsBlock());
    public static final DeferredBlock<WarpedBushBlock> WARPED_BUSH = REGISTRY.register("warped_bush", () -> new WarpedBushBlock());
    public static final DeferredBlock<GrownWarpedBushBlock> GROWN_WARPED_BUSH = REGISTRY.register("grown_warped_bush", () -> new GrownWarpedBushBlock());
    public static final DeferredBlock<FloweringGloopyPileBlock> FLOWERING_GLOOPY_PILE = REGISTRY.register("flowering_gloopy_pile", () -> new FloweringGloopyPileBlock());
    public static final DeferredBlock<Block> POLISHED_WARPED_STONE = block("polished_warped_stone", stone(MapColor.COLOR_CYAN, 9f, 11f));
    public static final DeferredBlock<Block> CHISELED_POLISHED_WARPED_STONE = block("chiseled_polished_warped_stone", stone(MapColor.COLOR_CYAN, 9f, 11f));
    public static final DeferredBlock<Block> WARPED_STONE_BRICKS = block("warped_stone_bricks", stone(MapColor.COLOR_CYAN, 9f, 11f));
    public static final DeferredBlock<SlabBlock> POLISHED_WARPED_STONE_SLAB = slab("polished_warped_stone_slab", stone(MapColor.COLOR_CYAN, 9f, 11f));
    public static final DeferredBlock<StairBlock> POLISHED_WARPED_STONE_STAIRS = stairs("polished_warped_stone_stairs", POLISHED_WARPED_STONE, stone(MapColor.COLOR_CYAN, 9f, 11f));
    public static final DeferredBlock<SlabBlock> WARPED_STONE_BRICKS_SLAB = slab("warped_stone_bricks_slab", stone(MapColor.COLOR_CYAN, 9f, 11f));
    public static final DeferredBlock<StairBlock> WARPED_STONE_BRICKS_STAIRS = stairs("warped_stone_bricks_stairs", WARPED_STONE_BRICKS, stone(MapColor.COLOR_CYAN, 9f, 11f));
    public static final DeferredBlock<Block> WARPED_STONE_TILES = block("warped_stone_tiles", stone(MapColor.COLOR_CYAN, 9f, 11f));
    public static final DeferredBlock<SlabBlock> WARPED_STONE_TILES_SLAB = slab("warped_stone_tiles_slab", stone(MapColor.COLOR_CYAN, 9f, 11f));
    public static final DeferredBlock<StairBlock> WARPED_STONE_TILES_STAIRS = stairs("warped_stone_tiles_stairs", WARPED_STONE_TILES, stone(MapColor.COLOR_CYAN, 9f, 11f));
    public static final DeferredBlock<Block> ROOTED_RAW_PURPUR = block("rooted_raw_purpur", stone(MapColor.TERRACOTTA_MAGENTA, 1.4f, 6f));
    public static final DeferredBlock<ChorusCaneBlock> CHORUS_CANE = REGISTRY.register("chorus_cane", () -> new ChorusCaneBlock());
    public static final DeferredBlock<BloomingChorusCaneBlock> BLOOMING_CHORUS_CANE = REGISTRY.register("blooming_chorus_cane", () -> new BloomingChorusCaneBlock());
    public static final DeferredBlock<ChorusCaneBlockBlock> CHORUS_CANE_BLOCK = REGISTRY.register("chorus_cane_block", () -> new ChorusCaneBlockBlock());
    public static final DeferredBlock<StrippedChorusCaneBlockBlock> STRIPPED_CHORUS_CANE_BLOCK = REGISTRY.register("stripped_chorus_cane_block", () -> new StrippedChorusCaneBlockBlock());
    public static final DeferredBlock<ChorusCaneFlowerBlock> CHORUS_CANE_FLOWER = REGISTRY.register("chorus_cane_flower", () -> new ChorusCaneFlowerBlock());
    public static final DeferredBlock<Block> WARPED_LAMP = block("warped_lamp", stone(MapColor.COLOR_ORANGE, 9f, 11f).lightLevel(s -> 13));
    public static final DeferredBlock<Block> POLISHED_CITRINE = block("polished_citrine", BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.COLOR_ORANGE).sound(SoundType.AMETHYST).strength(1.5f).lightLevel(s -> 1).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> POLISHED_CITRINE_TILES = block("polished_citrine_tiles", BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.COLOR_ORANGE).sound(SoundType.AMETHYST).strength(1.5f).lightLevel(s -> 1).requiresCorrectToolForDrops());
    public static final DeferredBlock<WallBlock> WARPED_STONE_BRICK_WALL = wall("warped_stone_brick_wall", stone(MapColor.COLOR_CYAN, 9f, 11f).forceSolidOn());
    public static final DeferredBlock<VoidExplosiveBlock> VOID_EXPLOSIVE = REGISTRY.register("void_explosive", () -> new VoidExplosiveBlock());
    public static final DeferredBlock<BuildingInhibitorBlock> BUILDING_INHIBITOR = REGISTRY.register("building_inhibitor", () -> new BuildingInhibitorBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.COLOR_PURPLE).sound(SoundType.STONE).strength(4f, 300f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<WarpedLanternBlock> WARPED_LANTERN = REGISTRY.register("warped_lantern", () -> new WarpedLanternBlock());
    public static final DeferredBlock<DraglingPlushBlock> DRAGLING_PLUSH = REGISTRY.register("dragling_plush", () -> new DraglingPlushBlock());
    public static final DeferredBlock<CitrinePillarBlock> CITRINE_PILLAR = REGISTRY.register("citrine_pillar", () -> new CitrinePillarBlock());
    public static final DeferredBlock<LensHardglassBlock> LENS_HARDGLASS = REGISTRY.register("lens_hardglass", () -> new LensHardglassBlock());
    public static final DeferredBlock<SquashOLanternBlock> SQUASH_O_LANTERN = REGISTRY.register("squash_o_lantern", () -> new SquashOLanternBlock());
    public static final DeferredBlock<WarpedStonePillarBlock> WARPED_STONE_PILLAR = REGISTRY.register("warped_stone_pillar", () -> new WarpedStonePillarBlock());
    public static final DeferredBlock<Block> WARPED_STONE_EMBEDDED_CITRINE = block("warped_stone_embedded_citrine", stone(MapColor.COLOR_ORANGE, 9f, 11f).lightLevel(s -> 3));
    public static final DeferredBlock<CrackedLensHardglassBlock> CRACKED_LENS_HARDGLASS = REGISTRY.register("cracked_lens_hardglass", () -> new CrackedLensHardglassBlock());
    public static final DeferredBlock<SmallWarpedSquashBlock> SMALL_WARPED_SQUASH = REGISTRY.register("small_warped_squash", () -> new SmallWarpedSquashBlock());
    public static final DeferredBlock<CitrineTotemBlock> CITRINE_TOTEM = REGISTRY.register("citrine_totem", () -> new CitrineTotemBlock());
    public static final DeferredBlock<GloopilonSproutBlock> GLOOPILON_SEEDS = REGISTRY.register("gloopilon_seeds", () -> new GloopilonSproutBlock());
    public static final DeferredBlock<GloopilonStemBlock> GLOOPILON_STEM = REGISTRY.register("gloopilon_stem", () -> new GloopilonStemBlock());
    public static final DeferredBlock<ChargedGloopstoneBlock> CHARGED_GLOOPSTONE = REGISTRY.register("charged_gloopstone", () -> new ChargedGloopstoneBlock());
    public static final DeferredBlock<SlabBlock> SHINY_CRYSTAL_TILES_SLAB = slab("shiny_crystal_tiles_slab", 0, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.AMETHYST).strength(0.85f, 4f).lightLevel(s -> 5).requiresCorrectToolForDrops());
    public static final DeferredBlock<StairBlock> SHINY_CRYSTAL_TILE_STAIRS = stairs("shiny_crystal_tile_stairs", SHINY_CRYSTAL_TILES, 0, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.AMETHYST).strength(0.85f, 4f).lightLevel(s -> 5).requiresCorrectToolForDrops());
    public static final DeferredBlock<EnderblobMoultBrickStairsBlock> ENDERBLOB_MOULT_BRICK_STAIRS = REGISTRY.register("enderblob_moult_brick_stairs", () -> new EnderblobMoultBrickStairsBlock());
    public static final DeferredBlock<EnderblobMoultBrickSlabBlock> ENDERBLOB_MOULT_BRICK_SLAB = REGISTRY.register("enderblob_moult_brick_slab", () -> new EnderblobMoultBrickSlabBlock());
    public static final DeferredBlock<Block> GLOOPSTONE_TILES = block("gloopstone_tiles", 13, gloop(0.95f));
    public static final DeferredBlock<EnderblobMoultWallBlock> ENDERBLOB_MOULT_WALL = REGISTRY.register("enderblob_moult_wall", () -> new EnderblobMoultWallBlock());
    public static final DeferredBlock<GloopyUrnBlock> GLOOPY_URN = REGISTRY.register("gloopy_urn", () -> new GloopyUrnBlock());
    public static final DeferredBlock<FlowerPotBlock> FLOWER_POT_WARPED_BUSH = flowerPot("flower_pot_warped_bush", WARPED_BUSH, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));
    public static final DeferredBlock<FlowerPotBlock> FLOWER_POT_CANE = flowerPot("flower_pot_cane", BLOOMING_CHORUS_CANE, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));
    public static final DeferredBlock<CitrineCandleBlock> CITRINE_CANDLE = REGISTRY.register("citrine_candle", () -> new CitrineCandleBlock());
    public static final DeferredBlock<AncientPodiumBlock> ANCIENT_PODIUM = REGISTRY.register("ancient_podium", () -> new AncientPodiumBlock());
    public static final DeferredBlock<Block> ANCIENT_ENCASED_PURPUR = block("ancient_encased_purpur", stone(MapColor.COLOR_MAGENTA, 3.5f, 13f).pushReaction(PushReaction.BLOCK));
    public static final DeferredBlock<EndstonePillarBlock> ENDSTONE_PILLAR = REGISTRY.register("endstone_pillar", () -> new EndstonePillarBlock());
    public static final DeferredBlock<InfusedEndStoneTilesBlock> INFUSED_END_STONE_TILES = REGISTRY.register("infused_end_stone_tiles", () -> new InfusedEndStoneTilesBlock());
    public static final DeferredBlock<BouncyGloopstoneBlock> BOUNCY_GLOOPSTONE = REGISTRY.register("bouncy_gloopstone", () -> new BouncyGloopstoneBlock());
    public static final DeferredBlock<WarpedChestBlock> WARPED_CHEST = REGISTRY.register("warped_chest", () -> new WarpedChestBlock());
    public static final DeferredBlock<GloopilonBulbBlock> GLOOPILON_BULB = REGISTRY.register("gloopilon_bulb", () -> new GloopilonBulbBlock());
    public static final DeferredBlock<ShinyCrystalTorchBlock> CRYSTAL_TORCH = REGISTRY.register("crystal_torch", () -> new ShinyCrystalTorchBlock());
    public static final DeferredBlock<FlowerPotBlock> FLOWER_POT_CRYSTAL_FLOWER = flowerPot("flower_pot_crystal_flower", CRYSTAL_FLOWER, BlockBehaviour.Properties.of().instabreak().lightLevel(s -> 10).noOcclusion().pushReaction(PushReaction.DESTROY));
    public static final DeferredBlock<FlowerPotBlock> FLOWER_POT_GLOOPY_TENDRILS = flowerPot("flower_pot_gloopy_tendrils", GLOOPY_TENDRILS, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));
    public static final DeferredBlock<FlowerPotBlock> FLOWER_POT_GLOOPY_BUSH = flowerPot("flower_pot_gloopy_bush", GLOOPY_BUSH, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));
    public static final DeferredBlock<FlowerPotBlock> FLOWER_POT_PURPUR_GRASS = flowerPot("flower_pot_purpur_grass", FLOWERING_PURPUR_GRASS, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));
    public static final DeferredBlock<Block> GLOOPY_ENDSTONE = REGISTRY.register("gloopy_endstone", () -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.COLOR_PURPLE).sound(SoundType.CORAL_BLOCK)
            .strength(0.95f, 5f).requiresCorrectToolForDrops()));

    private static BlockBehaviour.Properties stone(MapColor color, float hardness, float resistance) {
        return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(color).sound(SoundType.STONE).strength(hardness, resistance).requiresCorrectToolForDrops();
    }

    private static BlockBehaviour.Properties gloop(float hardness) {
        return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.COLOR_PURPLE).sound(SoundType.CORAL_BLOCK).strength(hardness, 5f);
    }

    private static DeferredBlock<Block> block(String name, BlockBehaviour.Properties properties) {
        return REGISTRY.register(name, () -> new Block(properties));
    }

    private static DeferredBlock<Block> block(String name, int lightBlock, BlockBehaviour.Properties properties) {
        return REGISTRY.register(name, () -> new Block(properties) {
            @Override
            public int getLightBlock(BlockState state, BlockGetter level, BlockPos pos) {
                return lightBlock;
            }
        });
    }

    private static DeferredBlock<StairBlock> stairs(String name, DeferredBlock<? extends Block> base, BlockBehaviour.Properties properties) {
        return REGISTRY.register(name, () -> new StairBlock(base.get().defaultBlockState(), properties));
    }

    private static DeferredBlock<StairBlock> stairs(String name, DeferredBlock<? extends Block> base, int lightBlock, BlockBehaviour.Properties properties) {
        return REGISTRY.register(name, () -> new StairBlock(base.get().defaultBlockState(), properties) {
            @Override
            public int getLightBlock(BlockState state, BlockGetter level, BlockPos pos) {
                return lightBlock;
            }
        });
    }

    private static DeferredBlock<SlabBlock> slab(String name, BlockBehaviour.Properties properties) {
        return REGISTRY.register(name, () -> new SlabBlock(properties));
    }

    private static DeferredBlock<SlabBlock> slab(String name, int lightBlock, BlockBehaviour.Properties properties) {
        return REGISTRY.register(name, () -> new SlabBlock(properties) {
            @Override
            public int getLightBlock(BlockState state, BlockGetter level, BlockPos pos) {
                return lightBlock;
            }
        });
    }

    private static DeferredBlock<WallBlock> wall(String name, BlockBehaviour.Properties properties) {
        return REGISTRY.register(name, () -> new WallBlock(properties));
    }

    private static DeferredBlock<FlowerPotBlock> flowerPot(String name, DeferredBlock<? extends Block> plant, BlockBehaviour.Properties properties) {
        return REGISTRY.register(name, () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, plant, properties));
    }

    public static void registerPottedPlants() {
        FlowerPotBlock emptyPot = (FlowerPotBlock) Blocks.FLOWER_POT;
        emptyPot.addPlant(CHORUS_FUNGUS.getId(), FLOWER_POT_CHORUS_FUNGUS);
        emptyPot.addPlant(CHORUS_ROOTS.getId(), FLOWER_POT_CHORUS_ROOTS);
        emptyPot.addPlant(SHINY_SPIREA.getId(), FLOWER_POT_SHINY_SPIREA);
        emptyPot.addPlant(WARPED_BUSH.getId(), FLOWER_POT_WARPED_BUSH);
        emptyPot.addPlant(BLOOMING_CHORUS_CANE.getId(), FLOWER_POT_CANE);
        emptyPot.addPlant(FLOWERING_PURPUR_GRASS.getId(), FLOWER_POT_PURPUR_GRASS);
        emptyPot.addPlant(CRYSTAL_FLOWER.getId(), FLOWER_POT_CRYSTAL_FLOWER);
        emptyPot.addPlant(GLOOPY_BUSH.getId(), FLOWER_POT_GLOOPY_BUSH);
        emptyPot.addPlant(GLOOPY_TENDRILS.getId(), FLOWER_POT_GLOOPY_TENDRILS);
    }
}

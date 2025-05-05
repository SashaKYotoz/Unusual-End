package net.sashakyotoz.unusualend.common.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.gen.feature.EndConfiguredFeatures;
import net.sashakyotoz.unusualend.UnusualEnd;
import net.sashakyotoz.unusualend.common.ModRegistry;
import net.sashakyotoz.unusualend.common.blocks.custom.CustomCollisionBlock;
import net.sashakyotoz.unusualend.common.blocks.custom.CustomPlantBlock;

public class ModBlocks {
    public static void register() {
        UnusualEnd.log("Registering Blocks for modid : " + UnusualEnd.MOD_ID);
        ModRegistry.BlockBuilder.registerBricksSet(RAW_PURPUR_BLOCK, RAW_PURPUR_BLOCK_STAIRS, RAW_PURPUR_BLOCK_SLAB, RAW_PURPUR_WALL);
        ModRegistry.BlockBuilder.registerPolishedSet(POLISHED_PURPUR, POLISHED_PURPUR_STAIRS, POLISHED_PURPUR_SLAB);
        ModRegistry.BlockBuilder.registerPolishedSet(POLISHED_PURPUR_TILES, POLISHED_PURPUR_TILES_STAIRS, POLISHED_PURPUR_TILES_SLAB);
        ModRegistry.BlockBuilder.registerPolishedSet(POLISHED_GLOOPSLATE, POLISHED_GLOOPSLATE_STAIRS, POLISHED_GLOOPSLATE_SLAB);
        ModRegistry.BlockBuilder.registerPolishedSet(GLOOPSLATE_BRICKS, GLOOPSLATE_BRICKS_STAIRS, GLOOPSLATE_BRICKS_SLAB);
    }

    public static final Block PEARLESCENT_BLOCK = ModRegistry.ofBlock("pearlescent_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.PINK).sounds(BlockSoundGroup.COPPER).hardness(2).resistance(15f).luminance(5).slipperiness(1.1f).jumpVelocityMultiplier(1.1f).requiresTool())).model().tool("_pickaxe").build();
    public static final Block SPECTRAL_BLOCK = ModRegistry.ofBlock("spectral_block",
            new CustomCollisionBlock(FabricBlockSettings.create().mapColor(MapColor.BLACK).sounds(BlockSoundGroup.WOOL).hardness(0.2f).resistance(10f))).tool("_pickaxe").model().build();
    public static final Block PHANTOM_MEMBRANE_BLOCK = ModRegistry.ofBlock("phantom_membrane_block",
            new CustomCollisionBlock(FabricBlockSettings.create().mapColor(MapColor.WHITE).slipperiness(0.85f).jumpVelocityMultiplier(0.9f).hardness(0.2f).resistance(3f).pistonBehavior(PistonBehavior.DESTROY))).tool("_pickaxe").model().build();
    public static final Block FADING_BLOCK = ModRegistry.ofBlock("fading_block",
            new CustomCollisionBlock(FabricBlockSettings.create().mapColor(MapColor.YELLOW).hardness(-1))).tool("_pickaxe").build();
    public static final Block RAW_PURPUR_BLOCK = ModRegistry.ofBlock("raw_purpur_block",
            new Block(FabricBlockSettings.create().instrument(Instrument.BASEDRUM).mapColor(MapColor.MAGENTA).sounds(BlockSoundGroup.STONE).strength(1.5f, 6f).requiresTool())).tool("_pickaxe").build();
    public static final Block RAW_PURPUR_BLOCK_STAIRS = ModRegistry.ofBlock("raw_purpur_block_stairs",
            new StairsBlock(RAW_PURPUR_BLOCK.getDefaultState(), FabricBlockSettings.create().instrument(Instrument.BASEDRUM).mapColor(MapColor.MAGENTA).sounds(BlockSoundGroup.STONE).strength(1.5f, 6f).requiresTool())).tool("_pickaxe").build();
    public static final Block RAW_PURPUR_BLOCK_SLAB = ModRegistry.ofBlock("raw_purpur_block_slab",
            new SlabBlock(FabricBlockSettings.create().instrument(Instrument.BASEDRUM).mapColor(MapColor.MAGENTA).sounds(BlockSoundGroup.STONE).strength(1.5f, 6f).requiresTool())).tool("_pickaxe").build();
    public static final Block RAW_PURPUR_WALL = ModRegistry.ofBlock("raw_purpur_wall",
            new WallBlock(FabricBlockSettings.create().instrument(Instrument.BASEDRUM).mapColor(MapColor.MAGENTA).sounds(BlockSoundGroup.STONE).strength(1.5f, 6f).requiresTool())).tool("_pickaxe").build();
    public static final Block POLISHED_PURPUR = ModRegistry.ofBlock("polished_purpur",
            new Block(FabricBlockSettings.create().instrument(Instrument.BASEDRUM).mapColor(MapColor.MAGENTA).sounds(BlockSoundGroup.STONE).strength(1.5f, 6f).requiresTool())).tool("_pickaxe").build();
    public static final Block POLISHED_PURPUR_STAIRS = ModRegistry.ofBlock("polished_purpur_stairs",
            new StairsBlock(POLISHED_PURPUR.getDefaultState(), FabricBlockSettings.create().instrument(Instrument.BASEDRUM).mapColor(MapColor.MAGENTA).sounds(BlockSoundGroup.STONE).strength(1.5f, 6f).requiresTool())).tool("_pickaxe").build();
    public static final Block POLISHED_PURPUR_SLAB = ModRegistry.ofBlock("polished_purpur_slab",
            new SlabBlock(FabricBlockSettings.create().instrument(Instrument.BASEDRUM).mapColor(MapColor.MAGENTA).sounds(BlockSoundGroup.STONE).strength(1.5f, 6f).requiresTool())).tool("_pickaxe").build();
    public static final Block POLISHED_PURPUR_TILES = ModRegistry.ofBlock("polished_purpur_tiles",
            new Block(FabricBlockSettings.create().instrument(Instrument.BASEDRUM).mapColor(MapColor.MAGENTA).sounds(BlockSoundGroup.STONE).strength(1.5f, 6f).requiresTool())).tool("_pickaxe").build();
    public static final Block POLISHED_PURPUR_TILES_STAIRS = ModRegistry.ofBlock("polished_purpur_tiles_stairs",
            new StairsBlock(POLISHED_PURPUR_TILES.getDefaultState(), FabricBlockSettings.create().instrument(Instrument.BASEDRUM).mapColor(MapColor.MAGENTA).sounds(BlockSoundGroup.STONE).strength(1.5f, 6f).requiresTool())).tool("_pickaxe").build();
    public static final Block POLISHED_PURPUR_TILES_SLAB = ModRegistry.ofBlock("polished_purpur_tiles_slab",
            new SlabBlock(FabricBlockSettings.create().instrument(Instrument.BASEDRUM).mapColor(MapColor.MAGENTA).sounds(BlockSoundGroup.STONE).strength(1.5f, 6f).requiresTool())).tool("_pickaxe").build();
    public static final Block GLOOPSLATE = ModRegistry.ofBlock("gloopslate",
            new Block(FabricBlockSettings.create().instrument(Instrument.BASEDRUM).mapColor(MapColor.DARK_DULL_PINK).sounds(BlockSoundGroup.CORAL).strength(0.85f, 5f).requiresTool())).model().tool("_pickaxe").build();
    public static final Block GLOOPSLATE_BRICKS = ModRegistry.ofBlock("gloopslate_bricks",
            new Block(FabricBlockSettings.create().instrument(Instrument.BASEDRUM).mapColor(MapColor.DARK_DULL_PINK).sounds(BlockSoundGroup.CORAL).strength(0.85f, 5f).requiresTool())).tool("_pickaxe").build();
    public static final Block GLOOPSLATE_BRICKS_SLAB = ModRegistry.ofBlock("gloopslate_bricks_slab",
            new SlabBlock(FabricBlockSettings.create().instrument(Instrument.BASEDRUM).mapColor(MapColor.DARK_DULL_PINK).sounds(BlockSoundGroup.CORAL).strength(0.85f, 5f).requiresTool())).tool("_pickaxe").build();
    public static final Block GLOOPSLATE_BRICKS_STAIRS = ModRegistry.ofBlock("gloopslate_bricks_stairs",
            new StairsBlock(GLOOPSLATE_BRICKS.getDefaultState(), FabricBlockSettings.create().instrument(Instrument.BASEDRUM).mapColor(MapColor.DARK_DULL_PINK).sounds(BlockSoundGroup.CORAL).strength(0.85f, 5f).requiresTool())).tool("_pickaxe").build();
    public static final Block POLISHED_GLOOPSLATE = ModRegistry.ofBlock("polished_gloopslate",
            new Block(FabricBlockSettings.create().instrument(Instrument.BASEDRUM).mapColor(MapColor.DARK_DULL_PINK).sounds(BlockSoundGroup.CORAL).strength(0.85f, 5f).requiresTool())).tool("_pickaxe").build();
    public static final Block POLISHED_GLOOPSLATE_SLAB = ModRegistry.ofBlock("polished_gloopslate_slab",
            new SlabBlock(FabricBlockSettings.create().instrument(Instrument.BASEDRUM).mapColor(MapColor.DARK_DULL_PINK).sounds(BlockSoundGroup.CORAL).strength(0.85f, 5f).requiresTool())).tool("_pickaxe").build();
    public static final Block POLISHED_GLOOPSLATE_STAIRS = ModRegistry.ofBlock("polished_gloopslate_stairs",
            new StairsBlock(POLISHED_GLOOPSLATE.getDefaultState(), FabricBlockSettings.create().instrument(Instrument.BASEDRUM).mapColor(MapColor.DARK_DULL_PINK).sounds(BlockSoundGroup.CORAL).strength(0.85f, 5f).requiresTool())).tool("_pickaxe").build();

    //plants
    public static final Block WARPED_END_STONE = ModRegistry.ofBlock("warped_end_stone",
            new GrassBlock(FabricBlockSettings.copy(Blocks.END_STONE).mapColor(MapColor.PALE_GREEN).requiresTool())).tool("_pickaxe").model(ModRegistry.Models.GRASS).build();
    public static final Block CHORUS_FUNGUS = ModRegistry.ofBlock("chorus_fungus",
            new MushroomPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_FUNGUS).mapColor(MapColor.DULL_PINK).requiresTool(), EndConfiguredFeatures.CHORUS_PLANT)).tool("_pickaxe").model(ModRegistry.Models.CROSS).build();
    public static final Block ENDSTONE_SPROUTS = ModRegistry.ofBlock("endstone_sprouts",
            new CustomPlantBlock(FabricBlockSettings.copy(Blocks.GRASS).mapColor(MapColor.PINK).requiresTool())).tool("_pickaxe").model(ModRegistry.Models.CROSS).build();
    public static final Block PURPUR_GRASS = ModRegistry.ofBlock("purpur_grass",
            new CustomPlantBlock(FabricBlockSettings.copy(Blocks.GRASS).mapColor(MapColor.PINK).requiresTool())).tool("_pickaxe").model(ModRegistry.Models.CROSS).build();
    public static final Block FLOWERING_PURPUR_GRASS = ModRegistry.ofBlock("flowering_purpur_grass",
            new CustomPlantBlock(FabricBlockSettings.copy(Blocks.GRASS).mapColor(MapColor.PINK).requiresTool())).tool("_pickaxe").model(ModRegistry.Models.CROSS).build();
}
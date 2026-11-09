package net.sweety.unusualend.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.init.UnusualEndBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, UnusualEnd.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(UnusualEndTags.Blocks.CHORUS_FUNGUS_MAY_PLACE_ON).add(UnusualEndBlocks.INFESTED_END_STONE.get()).add(net.minecraft.world.level.block.Blocks.END_STONE).add(net.minecraft.world.level.block.Blocks.GRASS_BLOCK).add(net.minecraft.world.level.block.Blocks.MYCELIUM).add(net.minecraft.world.level.block.Blocks.DIRT).add(net.minecraft.world.level.block.Blocks.COARSE_DIRT).add(net.minecraft.world.level.block.Blocks.PODZOL).add(UnusualEndBlocks.RAW_PURPUR_BLOCK.get()).add(UnusualEndBlocks.GNEISS.get()).add(UnusualEndBlocks.WARPED_END_STONE.get()).add(UnusualEndBlocks.ROOTED_RAW_PURPUR.get()).add(UnusualEndBlocks.PURPUR_EMBEDDED_END_STONE.get()).addTag(BlockTags.NYLIUM);
        tag(UnusualEndTags.Blocks.CHORUS_GRASS_MAY_PLACE_ON).add(UnusualEndBlocks.INFESTED_END_STONE.get()).add(net.minecraft.world.level.block.Blocks.END_STONE).add(net.minecraft.world.level.block.Blocks.GRASS_BLOCK).add(net.minecraft.world.level.block.Blocks.DIRT).add(net.minecraft.world.level.block.Blocks.COARSE_DIRT).add(net.minecraft.world.level.block.Blocks.PODZOL).add(net.minecraft.world.level.block.Blocks.MYCELIUM).add(UnusualEndBlocks.RAW_PURPUR_BLOCK.get()).add(UnusualEndBlocks.ROOTED_RAW_PURPUR.get()).addTag(BlockTags.NYLIUM);
        tag(UnusualEndTags.Blocks.CHORUS_ROOTS_MAY_PLACE_ON).add(UnusualEndBlocks.INFESTED_END_STONE.get()).add(net.minecraft.world.level.block.Blocks.END_STONE).add(net.minecraft.world.level.block.Blocks.GRASS_BLOCK).add(net.minecraft.world.level.block.Blocks.DIRT).add(net.minecraft.world.level.block.Blocks.COARSE_DIRT).add(net.minecraft.world.level.block.Blocks.PODZOL).add(net.minecraft.world.level.block.Blocks.MYCELIUM).add(UnusualEndBlocks.RAW_PURPUR_BLOCK.get()).add(UnusualEndBlocks.GNEISS.get()).add(UnusualEndBlocks.WARPED_END_STONE.get()).add(UnusualEndBlocks.ROOTED_RAW_PURPUR.get()).add(UnusualEndBlocks.GLOOPSLATE.get()).addTag(BlockTags.NYLIUM);
        tag(UnusualEndTags.Blocks.CRYSTAL_FLOWER_MAY_PLACE_ON).add(net.minecraft.world.level.block.Blocks.GRASS_BLOCK).add(net.minecraft.world.level.block.Blocks.MYCELIUM).add(UnusualEndBlocks.GLOOPSLATE.get()).add(UnusualEndBlocks.SHINY_GLOOPSTONE.get()).add(UnusualEndBlocks.GLOOPSTONE.get()).add(UnusualEndBlocks.BOUNCY_GLOOPSLATE.get()).add(net.minecraft.world.level.block.Blocks.DIRT).add(net.minecraft.world.level.block.Blocks.COARSE_DIRT).add(net.minecraft.world.level.block.Blocks.PODZOL).add(net.minecraft.world.level.block.Blocks.ROOTED_DIRT).addTag(BlockTags.NYLIUM);
        tag(UnusualEndTags.Blocks.GLOOPY_PILE_MAY_PLACE_ON).add(net.minecraft.world.level.block.Blocks.GRASS_BLOCK).add(net.minecraft.world.level.block.Blocks.DIRT).add(net.minecraft.world.level.block.Blocks.COARSE_DIRT).add(net.minecraft.world.level.block.Blocks.PODZOL).add(net.minecraft.world.level.block.Blocks.MYCELIUM).add(UnusualEndBlocks.GLOOPSTONE.get()).add(UnusualEndBlocks.GLOOPSLATE.get()).addTag(BlockTags.NYLIUM);
        tag(UnusualEndTags.Blocks.GLOOPY_BUSH_MAY_PLACE_ON).add(net.minecraft.world.level.block.Blocks.GRASS_BLOCK).add(net.minecraft.world.level.block.Blocks.DIRT).add(net.minecraft.world.level.block.Blocks.COARSE_DIRT).add(net.minecraft.world.level.block.Blocks.PODZOL).add(net.minecraft.world.level.block.Blocks.MYCELIUM).add(UnusualEndBlocks.GLOOPSTONE.get()).add(UnusualEndBlocks.GLOOPSLATE.get()).add(UnusualEndBlocks.SHINY_GLOOPSTONE.get()).add(net.minecraft.world.level.block.Blocks.BARREL).addTag(BlockTags.NYLIUM);
        tag(UnusualEndTags.Blocks.GLOOPY_TENDRILS_MAY_PLACE_ON).add(net.minecraft.world.level.block.Blocks.GRASS_BLOCK).add(net.minecraft.world.level.block.Blocks.DIRT).add(net.minecraft.world.level.block.Blocks.COARSE_DIRT).add(net.minecraft.world.level.block.Blocks.PODZOL).add(net.minecraft.world.level.block.Blocks.MYCELIUM).add(UnusualEndBlocks.GLOOPSTONE.get()).add(UnusualEndBlocks.GLOOPSLATE.get()).add(UnusualEndBlocks.SHINY_GLOOPSTONE.get()).add(UnusualEndBlocks.BOUNCY_GLOOPSLATE.get()).add(UnusualEndBlocks.RAW_PURPUR_BLOCK.get()).add(UnusualEndBlocks.ROOTED_RAW_PURPUR.get()).add(net.minecraft.world.level.block.Blocks.END_STONE).add(UnusualEndBlocks.GLOOPSTONE_BRICKS.get()).add(UnusualEndBlocks.POLISHED_GLOOPSTONE.get()).addTag(BlockTags.NYLIUM);
        tag(UnusualEndTags.Blocks.WARPED_BUSH_MAY_PLACE_ON).add(UnusualEndBlocks.WARPED_END_STONE.get()).add(UnusualEndBlocks.WARPED_STONE.get()).add(net.minecraft.world.level.block.Blocks.WARPED_NYLIUM).add(UnusualEndBlocks.GNEISS.get()).add(net.minecraft.world.level.block.Blocks.END_STONE);
        tag(UnusualEndTags.Blocks.SHINY_SPIREA_MAY_PLACE_ON).add(net.minecraft.world.level.block.Blocks.GRASS_BLOCK).add(net.minecraft.world.level.block.Blocks.DIRT).add(net.minecraft.world.level.block.Blocks.COARSE_DIRT).add(net.minecraft.world.level.block.Blocks.PODZOL).add(net.minecraft.world.level.block.Blocks.MYCELIUM).add(UnusualEndBlocks.GLOOPSTONE.get()).add(UnusualEndBlocks.GLOOPSLATE.get()).add(UnusualEndBlocks.SHINY_GLOOPSTONE.get()).add(net.minecraft.world.level.block.Blocks.ROOTED_DIRT).addTag(BlockTags.NYLIUM);
        tag(UnusualEndTags.Blocks.WARPED_ALGAE_MAY_PLACE_ON).add(UnusualEndBlocks.INFESTED_END_STONE.get()).add(net.minecraft.world.level.block.Blocks.END_STONE).add(net.minecraft.world.level.block.Blocks.GRASS_BLOCK).add(net.minecraft.world.level.block.Blocks.DIRT).add(net.minecraft.world.level.block.Blocks.COARSE_DIRT).add(net.minecraft.world.level.block.Blocks.PODZOL).add(net.minecraft.world.level.block.Blocks.MYCELIUM).add(UnusualEndBlocks.GNEISS.get()).add(UnusualEndBlocks.WARPED_END_STONE.get()).add(UnusualEndBlocks.GNEISS_BRICKS.get()).add(UnusualEndBlocks.POLISHED_GNEISS.get()).add(UnusualEndBlocks.CHISELED_GNEISS_BRICK.get()).add(UnusualEndBlocks.BOLOK_SCALE_BLOCK.get()).add(UnusualEndBlocks.WARPED_STONE.get()).add(UnusualEndBlocks.POLISHED_WARPED_STONE.get()).add(UnusualEndBlocks.CHISELED_POLISHED_WARPED_STONE.get()).add(UnusualEndBlocks.WARPED_STONE_BRICKS.get()).add(UnusualEndBlocks.WARPED_STONE_TILES.get()).add(UnusualEndBlocks.WARPED_STONE_PILLAR.get()).addTag(BlockTags.NYLIUM);
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(UnusualEndBlocks.ANCIENT_ENCASED_END_STONE.get())
                .add(UnusualEndBlocks.ANCIENT_ENCASED_PURPUR.get())
                .add(UnusualEndBlocks.BUDDING_CITRINE.get())
                .add(UnusualEndBlocks.BUILDING_INHIBITOR.get())
                .add(UnusualEndBlocks.CENTRAL_PEDESTAL.get())
                .add(UnusualEndBlocks.BOLOK_SCALE_BLOCK.get())
                .add(UnusualEndBlocks.CHISELED_ENDSTONE_BUILDER.get())
                .add(UnusualEndBlocks.CHISELED_ENDSTONE_DRAGON.get())
                .add(UnusualEndBlocks.CHISELED_ENDSTONE_FRIENDSHIP.get())
                .add(UnusualEndBlocks.CHISELED_ENDSTONE_SCARED.get())
                .add(UnusualEndBlocks.CHISELED_ENDSTONE_US.get())
                .add(UnusualEndBlocks.CHISELED_ENDSTONE_WORK.get())
                .add(UnusualEndBlocks.CHISELED_POLISHED_PURPUR_TILES.get())
                .add(UnusualEndBlocks.CITRINE_BLOCK.get())
                .add(UnusualEndBlocks.ENDSTONE_TILES.get())
                .add(UnusualEndBlocks.ENDSTONE_PILLAR.get())
                .add(UnusualEndBlocks.CONDENSED_CITRINE_BLOCK.get())
                .add(UnusualEndBlocks.CITRINE_TOTEM.get())
                .add(UnusualEndBlocks.CITRINE_PILLAR.get())
                .add(UnusualEndBlocks.CITRINE_CLUSTER.get())
                .add(UnusualEndBlocks.CITRINE_BUD.get())
                .add(UnusualEndBlocks.CHISELED_POLISHED_WARPED_STONE.get())
                .add(UnusualEndBlocks.POLISHED_PURPUR.get())
                .add(UnusualEndBlocks.POLISHED_PURPUR_SLAB.get())
                .add(UnusualEndBlocks.POLISHED_PURPUR_STAIRS.get())
                .add(UnusualEndBlocks.POLISHED_GNEISS_STAIRS.get())
                .add(UnusualEndBlocks.POLISHED_GNEISS_SLAB.get())
                .add(UnusualEndBlocks.POLISHED_GNEISS.get())
                .add(UnusualEndBlocks.POLISHED_GLOOPSLATE_STAIRS.get())
                .add(UnusualEndBlocks.POLISHED_GLOOPSLATE_SLAB.get())
                .add(UnusualEndBlocks.POLISHED_GLOOPSLATE.get())
                .add(UnusualEndBlocks.POLISHED_CITRINE_TILES.get())
                .add(UnusualEndBlocks.SHINY_CRYSTAL_TILES.get())
                .add(UnusualEndBlocks.SHINY_CRYSTAL_TILES_SLAB.get())
                .add(UnusualEndBlocks.SHINY_CRYSTAL_TILE_STAIRS.get())
                .add(UnusualEndBlocks.SHINY_CRYSTAL_BRICKS.get())
                .add(UnusualEndBlocks.SHINY_CRYSTAL_BLOCK.get())
                .add(UnusualEndBlocks.ROOTED_RAW_PURPUR.get())
                .add(UnusualEndBlocks.RAW_PURPUR_BLOCK.get())
                .add(UnusualEndBlocks.RAW_PURPUR_BLOCK_SLAB.get())
                .add(UnusualEndBlocks.RAW_PURPUR_BLOCK_STAIRS.get())
                .add(UnusualEndBlocks.RAW_PURPUR_WALL.get())
                .add(UnusualEndBlocks.TELEPORTATION_ANCHOR.get())
                .add(UnusualEndBlocks.WARPED_STONE_BRICKS_STAIRS.get())
                .add(UnusualEndBlocks.WARPED_STONE_BRICKS_SLAB.get())
                .add(UnusualEndBlocks.WARPED_STONE_BRICKS.get())
                .add(UnusualEndBlocks.WARPED_STONE_BRICK_WALL.get())
                .add(UnusualEndBlocks.WARPED_STONE.get())
                .add(UnusualEndBlocks.WARPED_STONE_TILES.get())
                .add(UnusualEndBlocks.WARPED_STONE_TILES_SLAB.get())
                .add(UnusualEndBlocks.WARPED_STONE_TILES_STAIRS.get())
                .add(UnusualEndBlocks.WARPED_STONE_EMBEDDED_CITRINE.get())
                .add(UnusualEndBlocks.WEAK_END_STONE_BRICKS.get())
                .add(UnusualEndBlocks.WARPING_WAYSTONE.get())
                .add(UnusualEndBlocks.WARPED_LAMP.get())
                .add(UnusualEndBlocks.WARPED_LANTERN.get())
                .add(UnusualEndBlocks.WARPED_STONE_PILLAR.get())
                .add(UnusualEndBlocks.SHULKER_SHOOTER.get())
                .add(UnusualEndBlocks.SHINY_GLOOPSTONE.get())
                .add(UnusualEndBlocks.PURPUR_EMBEDDED_END_STONE.get())
                .add(UnusualEndBlocks.GLOOPSLATE_BRICKS.get())
                .add(UnusualEndBlocks.GLOOPSLATE_BRICKS_SLAB.get())
                .add(UnusualEndBlocks.GLOOPSLATE_BRICKS_STAIRS.get())
                .add(UnusualEndBlocks.GLOOPSTONE.get())
                .add(UnusualEndBlocks.GLOOPSTONE_BRICKS.get())
                .add(UnusualEndBlocks.GLOOPSTONE_BRICK_SLAB.get())
                .add(UnusualEndBlocks.GLOOPSTONE_BRICK_STAIRS.get())
                .add(UnusualEndBlocks.GLOOPSTONE_BRICK_WALL.get())
                .add(UnusualEndBlocks.PRISMALITIC_GLOOPSLATE.get())
                .add(UnusualEndBlocks.POLISHED_WARPED_STONE.get())
                .add(UnusualEndBlocks.POLISHED_WARPED_STONE_SLAB.get())
                .add(UnusualEndBlocks.POLISHED_WARPED_STONE_STAIRS.get())
                .add(UnusualEndBlocks.POLISHED_RAW_PURPUR_BRICK_WALL.get())
                .add(UnusualEndBlocks.POLISHED_PURPUR_TILES_STAIRS.get())
                .add(UnusualEndBlocks.POLISHED_PURPUR_TILES_SLAB.get())
                .add(UnusualEndBlocks.POLISHED_PURPUR_TILES.get())
                .add(UnusualEndBlocks.POLISHED_PURPUR_TILES_LANTERN.get())
                .add(UnusualEndBlocks.GNEISS_PILLAR.get())
                .add(UnusualEndBlocks.GNEISS_PILE.get())
                .add(UnusualEndBlocks.GNEISS.get())
                .add(UnusualEndBlocks.GNEISS_BRICKS.get())
                .add(UnusualEndBlocks.GNEISS_BRICK_SLAB.get())
                .add(UnusualEndBlocks.GNEISS_BRICK_STAIRS.get())
                .add(UnusualEndBlocks.GNEISS_BRICK_WALL.get())
                .add(UnusualEndBlocks.LENS_HARDGLASS.get())
                .add(UnusualEndBlocks.LARGE_CITRINE_BUD.get())
                .add(UnusualEndBlocks.INFUSED_END_STONE_TILES.get())
                .add(UnusualEndBlocks.INFESTED_END_STONE.get())
                .add(UnusualEndBlocks.POLISHED_CITRINE.get())
                .add(UnusualEndBlocks.POLISHED_GLOOPSTONE_STAIRS.get())
                .add(UnusualEndBlocks.POLISHED_GLOOPSTONE_SLAB.get())
                .add(UnusualEndBlocks.POLISHED_GLOOPSTONE.get())
                .add(UnusualEndBlocks.POLISHED_PURPUR_BRICKS.get())
                .add(UnusualEndBlocks.POLISHED_PURPUR_BRICK_SLAB.get())
                .add(UnusualEndBlocks.POLISHED_PURPUR_BRICK_STAIRS.get())

                ;
    }
}
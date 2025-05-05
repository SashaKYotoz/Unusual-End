package net.sashakyotoz.unusualend.common.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.item.ItemConvertible;
import net.sashakyotoz.unusualend.common.ModRegistry;

import java.util.Map;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {
    public ModBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        for (Map.Entry<Block, ItemConvertible> entry : ModRegistry.BLOCK_DROPS.entrySet()) {
            if (ModRegistry.BLOCK_MODELS.get(ModRegistry.Models.SLAB) != null && ModRegistry.BLOCK_MODELS.get(ModRegistry.Models.SLAB).contains(entry.getKey()))
                addDrop(entry.getKey(), slabDrops(entry.getKey()));
            else if (ModRegistry.BLOCK_MODELS.get(ModRegistry.Models.DOOR) != null && ModRegistry.BLOCK_MODELS.get(ModRegistry.Models.DOOR).contains(entry.getKey()))
                addDrop(entry.getKey(), doorDrops(entry.getKey()));
            else if (ModRegistry.BLOCK_SILK_DROPS.containsKey(entry.getKey()))
                oreDrops(entry.getKey(), entry.getValue().asItem());
            else
                addDrop(entry.getKey(), entry.getValue());
        }
//        addDrop(ModBlocks.AMETHYST_LEAVES, leavesDrops(ModBlocks.AMETHYST_LEAVES, ModBlocks.AMETHYST_SAPLING, 0.1f));
    }
}
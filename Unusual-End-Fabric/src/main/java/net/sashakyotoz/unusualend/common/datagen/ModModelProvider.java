package net.sashakyotoz.unusualend.common.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.sashakyotoz.unusualend.common.ModRegistry;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        BlockStateModelGenerator.BlockTexturePool pool;
        BlockStateModelGenerator.LogTexturePool poollog;

        for (Block block : ModRegistry.getModelList(ModRegistry.Models.CUBE))
            generator.registerSimpleCubeAll(block);
        for (Block block : ModRegistry.getModelList(ModRegistry.Models.GRASS))
            registerDynamicTopSoils(TextureMap.getId(block), generator, block);
        for (Block block : ModRegistry.getModelList(ModRegistry.Models.PILLAR))
            generator.registerLog(block).log(block);
        for (Block block : ModRegistry.getModelList(ModRegistry.Models.CROSS))
            generator.registerTintableCross(block, BlockStateModelGenerator.TintType.NOT_TINTED);
        for (Block block : ModRegistry.getModelList(ModRegistry.Models.CROSS_ITEMLESS))
            registerItemlessCross(generator, block, BlockStateModelGenerator.TintType.NOT_TINTED);
        for (Block block : ModRegistry.getModelList(ModRegistry.Models.DOOR))
            generator.registerDoor(block);
        for (Block block : ModRegistry.getModelList(ModRegistry.Models.TRAPDOOR))
            generator.registerTrapdoor(block);
        for (Block block : ModRegistry.getModelList(ModRegistry.Models.FLUID))
            generator.registerSimpleState(block);
        for (Block block : ModRegistry.BLOCK_SETS.keySet()) {
            if (ModRegistry.BLOCK_SETS.get(block).containsKey(ModRegistry.Models.WOOD)) {
                poollog = generator.registerLog(block);
                poollog.log(block);
                for (Map.Entry<ModRegistry.Models, Block> entry : ModRegistry.BLOCK_SETS.get(block).entrySet()) {
                    if (entry.getKey() == ModRegistry.Models.WOOD)
                        poollog.wood(entry.getValue());
                }
            } else if (ModRegistry.BLOCK_SETS.get(block).containsKey(ModRegistry.Models.PANE)) {
                for (Map.Entry<ModRegistry.Models, Block> entry : ModRegistry.BLOCK_SETS.get(block).entrySet()) {
                    if (entry.getKey() == ModRegistry.Models.PANE)
                        generator.registerGlassPane(block, entry.getValue());
                }
            } else {
                pool = generator.registerCubeAllModelTexturePool(block);
                for (Map.Entry<ModRegistry.Models, Block> entry : ModRegistry.BLOCK_SETS.get(block).entrySet()) {
                    if (entry.getKey() == ModRegistry.Models.STAIRS)
                        pool.stairs(entry.getValue());
                    if (entry.getKey() == ModRegistry.Models.SLAB)
                        pool.slab(entry.getValue());
                    if (entry.getKey() == ModRegistry.Models.BUTTON)
                        pool.button(entry.getValue());
                    if (entry.getKey() == ModRegistry.Models.PRESSURE_PLATE)
                        pool.pressurePlate(entry.getValue());
                    if (entry.getKey() == ModRegistry.Models.FENCE)
                        pool.fence(entry.getValue());
                    if (entry.getKey() == ModRegistry.Models.WALL)
                        pool.wall(entry.getValue());
                    if (entry.getKey() == ModRegistry.Models.FENCE_GATE)
                        pool.fenceGate(entry.getValue());
                    if (entry.getKey() == ModRegistry.Models.SIGN)
                        pool.family(new BlockFamily.Builder(block)
                                .sign(entry.getValue(), ModRegistry.BLOCK_SETS.get(block).get(ModRegistry.Models.WALL_SIGN))
                                .build());
                }
            }
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        for (Map.Entry<Item, Model> entry : ModRegistry.ITEM_MODELS.entrySet())
            generator.register(entry.getKey(), entry.getValue());
        for (Item item : ModRegistry.ITEMS) {
            if (item instanceof ArmorItem armorItem)
                generator.registerArmor(armorItem);
            if (item.getTranslationKey().contains("spawn_egg"))
                generator.register(item, new Model(Optional.of(Identifier.of("minecraft", "item/template_spawn_egg")),
                        Optional.empty()));
        }
    }

    private void registerItemlessCross(BlockStateModelGenerator generator, Block block, BlockStateModelGenerator.TintType tintType) {
        generator.registerTintableCrossBlockState(block, tintType);
    }

    private void registerDynamicTopSoils(Identifier bottomTexture, BlockStateModelGenerator generator, Block... topSoilBlocks) {
        for (Block topSoil : topSoilBlocks) {
            TextureMap textureMap = new TextureMap()
                    .put(TextureKey.BOTTOM, bottomTexture)
                    .inherit(TextureKey.BOTTOM, TextureKey.PARTICLE)
                    .put(TextureKey.TOP, TextureMap.getSubId(topSoil, "_top"))
                    .put(TextureKey.SIDE, TextureMap.getSubId(topSoil, "_side"));

            BlockStateVariant blockStateVariant = BlockStateVariant.create()
                    .put(VariantSettings.MODEL, Models.CUBE_BOTTOM_TOP.upload(topSoil, "_snow", textureMap, generator.modelCollector));

            Identifier modelId = TexturedModel.CUBE_BOTTOM_TOP
                    .get(topSoil)
                    .textures(textures -> textures.put(TextureKey.BOTTOM, bottomTexture))
                    .upload(topSoil, generator.modelCollector);

            List<BlockStateVariant> list = Arrays.asList(BlockStateModelGenerator.createModelVariantWithRandomHorizontalRotations(modelId));

            generator.blockStateCollector.accept(
                    VariantsBlockStateSupplier.create(topSoil)
                            .coordinate(BlockStateVariantMap.create(Properties.SNOWY)
                                    .register(true, blockStateVariant)
                                    .register(false, list))
            );
        }
    }
    public final void registerCrystalLike(BlockStateModelGenerator generator,Block block) {
        generator.registerItemModel(block.asItem());
        generator.blockStateCollector
                .accept(
                        VariantsBlockStateSupplier.create(
                                        block, BlockStateVariant.create().put(VariantSettings.MODEL, Models.CROSS.upload(block, TextureMap.cross(block), generator.modelCollector))
                                )
                                .coordinate(generator.createUpDefaultFacingVariantMap())
                );
    }
}
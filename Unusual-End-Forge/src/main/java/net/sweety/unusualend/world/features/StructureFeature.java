package net.sweety.unusualend.world.features;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.sweety.unusualend.world.features.configurations.StructureFeatureConfiguration;

public class StructureFeature extends Feature<StructureFeatureConfiguration> {


	public StructureFeature(Codec<StructureFeatureConfiguration> codec) {
		super(codec);
	}

	public boolean place(FeaturePlaceContext<StructureFeatureConfiguration> context) {
		RandomSource random = context.random();
		WorldGenLevel worldGenLevel = context.level();
		StructureFeatureConfiguration config = context.config();
		Rotation rotation = config.randomRotation() ? Rotation.getRandom(random) : Rotation.NONE;
		Mirror mirror = config.randomMirror() ? Mirror.values()[random.nextInt(2)] : Mirror.NONE;
		BlockPos placePos = context.origin().offset(config.offset());
		// Load the structure template
		StructureTemplateManager structureManager = worldGenLevel.getLevel().getServer().getStructureManager();
		StructureTemplate template = structureManager.getOrCreate(config.structure());
		StructurePlaceSettings placeSettings = (new StructurePlaceSettings()).setRotation(rotation).setMirror(mirror).setRandom(random).setIgnoreEntities(false)
				.addProcessor(new BlockIgnoreProcessor(config.ignoredBlocks().stream().map(Holder::get).toList()));
		template.placeInWorld(worldGenLevel, placePos, placePos, placeSettings, random, 4);
		return true;
	}
}

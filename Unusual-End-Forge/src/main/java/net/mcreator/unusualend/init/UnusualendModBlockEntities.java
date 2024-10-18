
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.unusualend.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.unusualend.block.entity.WarpingWaystoneBlockEntity;
import net.mcreator.unusualend.block.entity.WarpedChestBlockEntity;
import net.mcreator.unusualend.block.entity.PurpurTankBlockEntity;
import net.mcreator.unusualend.block.entity.PearlescentInfuserBlockEntity;
import net.mcreator.unusualend.block.entity.GloopslatePedestralBlockEntity;
import net.mcreator.unusualend.block.entity.FadingBlockBlockEntity;
import net.mcreator.unusualend.block.entity.BuildingInhibitorBlockEntity;
import net.mcreator.unusualend.block.entity.AncientPodiumBlockEntity;
import net.mcreator.unusualend.UnusualendMod;

public class UnusualendModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, UnusualendMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> PURPUR_TANK = register("purpur_tank", UnusualendModBlocks.PURPUR_TANK, PurpurTankBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> FADING_BLOCK = register("fading_block", UnusualendModBlocks.FADING_BLOCK, FadingBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WARPING_WAYSTONE = register("warping_waystone", UnusualendModBlocks.WARPING_WAYSTONE, WarpingWaystoneBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GLOOPSLATE_PEDESTRAL = register("gloopslate_pedestral", UnusualendModBlocks.GLOOPSLATE_PEDESTRAL, GloopslatePedestralBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PEARLESCENT_INFUSER = register("pearlescent_infuser", UnusualendModBlocks.PEARLESCENT_INFUSER, PearlescentInfuserBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BUILDING_INHIBITOR = register("building_inhibitor", UnusualendModBlocks.BUILDING_INHIBITOR, BuildingInhibitorBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ANCIENT_PODIUM = register("ancient_podium", UnusualendModBlocks.ANCIENT_PODIUM, AncientPodiumBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WARPED_CHEST = register("warped_chest", UnusualendModBlocks.WARPED_CHEST, WarpedChestBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}

package net.mcreator.unusualend.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;

import net.mcreator.unusualend.block.entity.WarpingWaystoneBlockEntity;
import net.mcreator.unusualend.block.entity.WarpedChestBlockEntity;
import net.mcreator.unusualend.block.entity.PurpurTankBlockEntity;
import net.mcreator.unusualend.block.entity.PearlescentInfuserBlockEntity;
import net.mcreator.unusualend.block.entity.GloopslatePedestralBlockEntity;
import net.mcreator.unusualend.block.entity.FadingBlockBlockEntity;
import net.mcreator.unusualend.block.entity.BuildingInhibitorBlockEntity;
import net.mcreator.unusualend.block.entity.AncientPodiumBlockEntity;
import net.mcreator.unusualend.UnusualEnd;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class UnusualendModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, UnusualEnd.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> PURPUR_TANK = register("purpur_tank", UnusualendModBlocks.PURPUR_TANK, PurpurTankBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> FADING_BLOCK = register("fading_block", UnusualendModBlocks.FADING_BLOCK, FadingBlockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> WARPING_WAYSTONE = register("warping_waystone", UnusualendModBlocks.WARPING_WAYSTONE, WarpingWaystoneBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> GLOOPSLATE_PEDESTRAL = register("gloopslate_pedestral", UnusualendModBlocks.GLOOPSLATE_PEDESTRAL, GloopslatePedestralBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> PEARLESCENT_INFUSER = register("pearlescent_infuser", UnusualendModBlocks.PEARLESCENT_INFUSER, PearlescentInfuserBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> BUILDING_INHIBITOR = register("building_inhibitor", UnusualendModBlocks.BUILDING_INHIBITOR, BuildingInhibitorBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> ANCIENT_PODIUM = register("ancient_podium", UnusualendModBlocks.ANCIENT_PODIUM, AncientPodiumBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> WARPED_CHEST = register("warped_chest", UnusualendModBlocks.WARPED_CHEST, WarpedChestBlockEntity::new);

	private static DeferredHolder<BlockEntityType<?>,BlockEntityType<?>> register(String registryname, DeferredBlock<?> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}

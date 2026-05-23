package net.sweety.unusualend.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.block.entity.*;

public class UnusualEndBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, UnusualEnd.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> PURPUR_TANK = register("purpur_tank", UnusualEndBlocks.PURPUR_TANK, PurpurTankBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> FADING_BLOCK = register("fading_block", UnusualEndBlocks.FADING_BLOCK, FadingBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> WARPING_WAYSTONE = register("warping_waystone", UnusualEndBlocks.WARPING_WAYSTONE, WarpingWaystoneBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> GLOOPSLATE_PEDESTRAL = register("gloopslate_pedestral", UnusualEndBlocks.GLOOPSLATE_PEDESTRAL, GloopslatePedestralBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> PEARLESCENT_INFUSER = register("pearlescent_infuser", UnusualEndBlocks.PEARLESCENT_INFUSER, PearlescentInfuserBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> BUILDING_INHIBITOR = register("building_inhibitor", UnusualEndBlocks.BUILDING_INHIBITOR, BuildingInhibitorBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> ANCIENT_PODIUM = register("ancient_podium", UnusualEndBlocks.ANCIENT_PODIUM, AncientPodiumBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> WARPED_CHEST = register("warped_chest", UnusualEndBlocks.WARPED_CHEST, WarpedChestBlockEntity::new);

	private static DeferredHolder<BlockEntityType<?>,BlockEntityType<?>> register(String registryname, DeferredBlock<?> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}

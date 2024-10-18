package net.mcreator.unusualend.mixins;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.ChorusPlantBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModBlocks;

@Mixin(ChorusPlantBlock.class)
public abstract class ChorusPlantBlockMixin extends Block {
	public ChorusPlantBlockMixin(Properties settings) {
		super(settings);
	}

	@Inject(method = "canSurvive", at = @At("HEAD"), cancellable = true)
	private void canSurvive(BlockState state, LevelReader world, BlockPos pos, CallbackInfoReturnable<Boolean> info) {
		BlockState blockstate = world.getBlockState(pos.below());
		if (blockstate.is(UnusualendModBlocks.RAW_PURPUR_BLOCK.get()) || blockstate.is(UnusualendModBlocks.INFESTED_END_STONE.get()) || blockstate.is(UnusualendModBlocks.ROOTED_RAW_PURPUR.get()) || blockstate.is(UnusualendModBlocks.GLOOPSLATE.get())
				|| blockstate.is(UnusualendModBlocks.GLOOPSTONE.get()) || blockstate.is(UnusualendModBlocks.WARPED_END_STONE.get()) || blockstate.is(UnusualendModBlocks.PURPUR_EMBEDDED_END_STONE.get()) || blockstate.is(Blocks.END_STONE)) {
			info.setReturnValue(true);
		}
	}

	@Inject(method = "updateShape", at = @At("RETURN"), cancellable = true)
	private void updateShape(BlockState state, Direction direction, BlockState newState, LevelAccessor world, BlockPos pos, BlockPos posFrom, CallbackInfoReturnable<BlockState> info) {
		BlockState plant = info.getReturnValue();
		BlockState blockstate = world.getBlockState(pos.below());
		if (plant.is(Blocks.CHORUS_PLANT) && (blockstate.is(UnusualendModBlocks.RAW_PURPUR_BLOCK.get()) || blockstate.is(UnusualendModBlocks.INFESTED_END_STONE.get()) || blockstate.is(UnusualendModBlocks.ROOTED_RAW_PURPUR.get())
				|| blockstate.is(UnusualendModBlocks.GLOOPSLATE.get()) || blockstate.is(UnusualendModBlocks.GLOOPSTONE.get()) || blockstate.is(UnusualendModBlocks.WARPED_END_STONE.get())
				|| blockstate.is(UnusualendModBlocks.PURPUR_EMBEDDED_END_STONE.get()) || blockstate.is(Blocks.END_STONE))) {
			plant = plant.setValue(BlockStateProperties.DOWN, true);
			info.setReturnValue(plant);
		}
	}

	@Inject(method = "getStateForPlacement(Lnet/minecraft/world/item/context/BlockPlaceContext;)Lnet/minecraft/world/level/block/state/BlockState;", at = @At("RETURN"), cancellable = true)
	private void getStateForPlacement(BlockPlaceContext ctx, CallbackInfoReturnable<BlockState> info) {
		BlockPos pos = ctx.getClickedPos();
		Level world = ctx.getLevel();
		BlockState plant = info.getReturnValue();
		BlockState blockstate = world.getBlockState(pos.below());
		if (ctx.canPlace() && plant.is(Blocks.CHORUS_PLANT)
				&& (blockstate.is(UnusualendModBlocks.RAW_PURPUR_BLOCK.get()) || blockstate.is(UnusualendModBlocks.INFESTED_END_STONE.get()) || blockstate.is(UnusualendModBlocks.ROOTED_RAW_PURPUR.get())
						|| blockstate.is(UnusualendModBlocks.GLOOPSLATE.get()) || blockstate.is(UnusualendModBlocks.GLOOPSTONE.get()) || blockstate.is(UnusualendModBlocks.WARPED_END_STONE.get())
						|| blockstate.is(UnusualendModBlocks.PURPUR_EMBEDDED_END_STONE.get()) || blockstate.is(Blocks.END_STONE))) {
			info.setReturnValue(plant.setValue(BlockStateProperties.DOWN, true));
		}
	}

	@Inject(method = "Lnet/minecraft/world/level/block/ChorusPlantBlock;getStateForPlacement" + "(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)"
			+ "Lnet/minecraft/world/level/block/state/BlockState;", at = @At("RETURN"), cancellable = true)
	private void getStateForPlacement(BlockGetter blockGetter, BlockPos blockPos, CallbackInfoReturnable<BlockState> info) {
		BlockState plant = info.getReturnValue();
		BlockState blockstate = blockGetter.getBlockState(blockPos.below());
		if (plant.is(Blocks.CHORUS_PLANT) && (blockstate.is(UnusualendModBlocks.RAW_PURPUR_BLOCK.get()) || blockstate.is(UnusualendModBlocks.INFESTED_END_STONE.get()) || blockstate.is(UnusualendModBlocks.ROOTED_RAW_PURPUR.get())
				|| blockstate.is(UnusualendModBlocks.GLOOPSLATE.get()) || blockstate.is(UnusualendModBlocks.GLOOPSTONE.get()) || blockstate.is(UnusualendModBlocks.WARPED_END_STONE.get())
				|| blockstate.is(UnusualendModBlocks.PURPUR_EMBEDDED_END_STONE.get()) || blockstate.is(Blocks.END_STONE))) {
			info.setReturnValue(plant.setValue(BlockStateProperties.DOWN, true));
		}
	}
}

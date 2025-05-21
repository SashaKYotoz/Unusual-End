//water
package net.mcreator.unusualend.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.procedures.SmallWarpedAlgaeOnBoneMealSuccessProcedure;
import net.mcreator.unusualend.procedures.ChorusRootsBoneMealSuccessConditionProcedure;
import net.mcreator.unusualend.init.UnusualendModBlocks;

public class SmallWarpedAlgaeBlock extends FlowerBlock implements BonemealableBlock, SimpleWaterloggedBlock {
	public SmallWarpedAlgaeBlock() {
		super(() -> MobEffects.DAMAGE_RESISTANCE, 100, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).sound(SoundType.ROOTS).instabreak().noCollission().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
		this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false));
	}

	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		Vec3 offset = state.getOffset(world, pos);
		return box(2, 0, 2, 14, 3, 14).move(offset.x, offset.y, offset.z);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return this.defaultBlockState().setValue(WATERLOGGED, flag);
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}

	@Override
	public int getEffectDuration() {
		return 100;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 100;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
		return groundState.is(UnusualendModBlocks.INFESTED_END_STONE.get()) || groundState.is(Blocks.END_STONE) || groundState.is(Blocks.WARPED_NYLIUM) || groundState.is(Blocks.CRIMSON_NYLIUM) || groundState.is(Blocks.GRASS_BLOCK)
				|| groundState.is(Blocks.DIRT) || groundState.is(Blocks.COARSE_DIRT) || groundState.is(Blocks.PODZOL) || groundState.is(Blocks.MYCELIUM) || groundState.is(UnusualendModBlocks.GNEISS.get())
				|| groundState.is(UnusualendModBlocks.WARPED_END_STONE.get()) || groundState.is(UnusualendModBlocks.GNEISS_BRICKS.get()) || groundState.is(UnusualendModBlocks.POLISHED_GNEISS.get())
				|| groundState.is(UnusualendModBlocks.CHISELED_GNEISS_BRICK.get()) || groundState.is(UnusualendModBlocks.BOLOK_SCALE_BLOCK.get()) || groundState.is(UnusualendModBlocks.WARPED_STONE.get())
				|| groundState.is(UnusualendModBlocks.POLISHED_WARPED_STONE.get()) || groundState.is(UnusualendModBlocks.CHISELED_POLISHED_WARPED_STONE.get()) || groundState.is(UnusualendModBlocks.WARPED_STONE_BRICKS.get())
				|| groundState.is(UnusualendModBlocks.WARPED_STONE_TILES.get()) || groundState.is(UnusualendModBlocks.WARPED_STONE_PILLAR.get());
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		return this.mayPlaceOn(groundState, worldIn, blockpos);
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader worldIn, BlockPos pos, BlockState blockstate, boolean clientSide) {
		return true;
	}

	@Override
	public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState blockstate) {
		return ChorusRootsBoneMealSuccessConditionProcedure.execute();
	}

	@Override
	public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState blockstate) {
		SmallWarpedAlgaeOnBoneMealSuccessProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}


package net.mcreator.unusualend.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModBlocks;

public class GloopyTendrilsBlock extends FlowerBlock {
	public static final BooleanProperty GLOOPY = BooleanProperty.create("gloopy");

	public GloopyTendrilsBlock() {
		super(() -> MobEffects.WEAKNESS, 100, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.ROOTS).strength(0.1f, 0f).speedFactor(0.98f).jumpFactor(0.95f).noCollission().replaceable()
				.offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		Vec3 offset = state.getOffset(world, pos);
		return box(2, 0, 2, 14, 5, 14).move(offset.x, offset.y, offset.z);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(GLOOPY);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		//BlockPos blockpos = context.getClickedPos();
		if ((context.getLevel().getBlockState(context.getClickedPos().below())).getBlock() == Blocks.END_STONE)
			return this.defaultBlockState().setValue(GLOOPY, false);
		return this.defaultBlockState().setValue(GLOOPY, true);
	}//(world.getBlockState(BlockPos.containing(x,y-1,z)))
		//		if (context.getLevel().getBlockState(blockpos.containing(blockpos.below())).getBlock() == Blocks.END_STONE)

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
		return groundState.is(Blocks.WARPED_NYLIUM) || groundState.is(Blocks.CRIMSON_NYLIUM) || groundState.is(Blocks.GRASS_BLOCK) || groundState.is(Blocks.DIRT) || groundState.is(Blocks.COARSE_DIRT) || groundState.is(Blocks.PODZOL)
				|| groundState.is(Blocks.MYCELIUM) || groundState.is(UnusualendModBlocks.GLOOPSTONE.get()) || groundState.is(UnusualendModBlocks.GLOOPSLATE.get()) || groundState.is(UnusualendModBlocks.SHINY_GLOOPSTONE.get())
				|| groundState.is(UnusualendModBlocks.BOUNCY_GLOOPSLATE.get()) || groundState.is(UnusualendModBlocks.RAW_PURPUR_BLOCK.get()) || groundState.is(UnusualendModBlocks.ROOTED_RAW_PURPUR.get()) || groundState.is(Blocks.END_STONE)
				|| groundState.is(UnusualendModBlocks.GLOOPSTONE_BRICKS.get()) || groundState.is(UnusualendModBlocks.POLISHED_GLOOPSTONE.get()) || groundState.is(UnusualendModBlocks.GLOOPY_ENDSTONE.get())
				|| groundState.is(UnusualendModBlocks.BOUNCY_GLOOPSTONE.get());
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		return this.mayPlaceOn(groundState, worldIn, blockpos);
	}
	//@Override
	//public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
	//	super.onPlace(blockstate, world, pos, oldState, moving);
	//	EndstoneTendrilsProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	//}
}

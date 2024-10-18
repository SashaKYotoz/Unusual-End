
package net.mcreator.unusualend.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.procedures.EndstoneSproutsOnBoneMealSuccessProcedure;
import net.mcreator.unusualend.procedures.EndstoneSproutsAdditionalPlacinggrowthConditionProcedure;
import net.mcreator.unusualend.procedures.ChorusRootsBoneMealSuccessConditionProcedure;
import net.mcreator.unusualend.init.UnusualendModBlocks;

public class EndstoneSproutsBlock extends FlowerBlock implements BonemealableBlock {
	public EndstoneSproutsBlock() {
		super(() -> MobEffects.LEVITATION, 100,
				BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.NETHER_SPROUTS).instabreak().noCollission().replaceable().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		Vec3 offset = state.getOffset(world, pos);
		return box(2, 0, 2, 14, 3, 14).move(offset.x, offset.y, offset.z);
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
		boolean additionalCondition = true;
		if (worldIn instanceof LevelAccessor world) {
			int x = pos.getX();
			int y = pos.getY() + 1;
			int z = pos.getZ();
			BlockState blockstate = world.getBlockState(pos.above());
			additionalCondition = EndstoneSproutsAdditionalPlacinggrowthConditionProcedure.execute(world, x, y, z);
		}
		return (groundState.is(UnusualendModBlocks.INFESTED_END_STONE.get()) || groundState.is(Blocks.END_STONE) || groundState.is(Blocks.WARPED_NYLIUM) || groundState.is(Blocks.CRIMSON_NYLIUM) || groundState.is(Blocks.GRASS_BLOCK)
				|| groundState.is(Blocks.DIRT) || groundState.is(Blocks.COARSE_DIRT) || groundState.is(Blocks.PODZOL) || groundState.is(Blocks.MYCELIUM) || groundState.is(UnusualendModBlocks.RAW_PURPUR_BLOCK.get())
				|| groundState.is(UnusualendModBlocks.ROOTED_RAW_PURPUR.get()) || groundState.is(Blocks.END_STONE_BRICKS) || groundState.is(UnusualendModBlocks.ENDSTONE_TILES.get()) || groundState.is(UnusualendModBlocks.POLISHED_PURPUR_BRICKS.get())
				|| groundState.is(UnusualendModBlocks.POLISHED_PURPUR.get()) || groundState.is(UnusualendModBlocks.POLISHED_PURPUR_TILES.get())) && additionalCondition;
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
		EndstoneSproutsOnBoneMealSuccessProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}


package net.sweety.unusualend.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class EnderblobMoultWallBlock extends WallBlock {
	public EnderblobMoultWallBlock() {
		super(BlockBehaviour.Properties.of(Material.VEGETABLE, MaterialColor.COLOR_PURPLE).sound(SoundType.STEM).strength(0.4f, 5f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false)
				.dynamicShape());
	}

	@Override
	public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
		return adjacentBlockState.getBlock() == this ? true : super.skipRendering(state, adjacentBlockState, side);
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}
}

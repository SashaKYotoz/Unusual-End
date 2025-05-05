
//better random tick
package net.mcreator.unusualend.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModBlocks;

public class GloopslateBlock extends Block {
	public GloopslateBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.COLOR_PURPLE).sound(SoundType.CORAL_BLOCK).strength(0.85f, 5f).randomTicks());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.END_STONE) {
			world.setBlockAndUpdate(BlockPos.containing(x, y - 1, z), UnusualendModBlocks.GLOOPY_ENDSTONE.get().defaultBlockState());
		}
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == UnusualendModBlocks.GLOOPY_ENDSTONE.get()) {
			world.setBlockAndUpdate(BlockPos.containing(x, y + 1, z), UnusualendModBlocks.GLOOPSLATE.get().defaultBlockState());
		}
	}
}


package net.mcreator.unusualend.block;

import net.minecraftforge.common.IPlantable;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModBlocks;

public class WarpedEndStoneBlock extends Block {
	public WarpedEndStoneBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.COLOR_CYAN).sound(SoundType.STONE).strength(3f, 9f).requiresCorrectToolForDrops().randomTicks());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction direction, IPlantable plantable) {
		return true;
	}

	@Override
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
		if (player.getInventory().getSelected().getItem() instanceof PickaxeItem tieredItem)
			return tieredItem.getTier().getLevel() >= -1;
		return false;
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		if (world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude() && !((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == UnusualendModBlocks.GNEISS.get())
				&& !((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.WARPED_WART_BLOCK)) {
			world.setBlockAndUpdate(BlockPos.containing(x, y, z), Blocks.END_STONE.defaultBlockState());
		}
	}
}

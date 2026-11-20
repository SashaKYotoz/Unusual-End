
package net.sweety.unusualend.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.IPlantable;
import net.sweety.unusualend.init.UnusualendModBlocks;

public class WarpedEndStoneBlock extends Block {
	public WarpedEndStoneBlock() {
		super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_CYAN).sound(SoundType.STONE).strength(3f, 9f).requiresCorrectToolForDrops().randomTicks());
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
		if (world.getBlockState(new BlockPos(x, y + 1, z)).canOcclude() && !((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == UnusualendModBlocks.GNEISS.get())
				&& !((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.WARPED_WART_BLOCK)) {
			world.setBlockAndUpdate(new BlockPos(x, y, z), Blocks.END_STONE.defaultBlockState());
		}
	}
}

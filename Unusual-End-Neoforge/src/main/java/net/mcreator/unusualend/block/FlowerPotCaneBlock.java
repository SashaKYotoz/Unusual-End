
package net.mcreator.unusualend.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.Blocks;

import net.mcreator.unusualend.init.UnusualendModBlocks;

public class FlowerPotCaneBlock extends FlowerPotBlock {
	public FlowerPotCaneBlock() {
		super(() -> (FlowerPotBlock) Blocks.FLOWER_POT, UnusualendModBlocks.BLOOMING_CHORUS_CANE, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));
	}
}

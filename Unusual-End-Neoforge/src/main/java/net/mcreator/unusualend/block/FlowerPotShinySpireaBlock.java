
package net.mcreator.unusualend.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.Blocks;

import net.mcreator.unusualend.init.UnusualendModBlocks;

public class FlowerPotShinySpireaBlock extends FlowerPotBlock {
	public FlowerPotShinySpireaBlock() {
		super(() -> (FlowerPotBlock) Blocks.FLOWER_POT, UnusualendModBlocks.SHINY_SPIREA, BlockBehaviour.Properties.of().instabreak().lightLevel(s -> 8).noOcclusion().pushReaction(PushReaction.DESTROY));
	}
}

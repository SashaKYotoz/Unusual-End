package net.mcreator.unusualend.mixins;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.ChorusFlowerBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModBlocks;

@Mixin(ChorusFlowerBlock.class)
public abstract class ChorusFlowerBlockMixin extends Block {
	public ChorusFlowerBlockMixin(Properties settings) {
		super(settings);
	}

	@Inject(method = "canSurvive", at = @At("HEAD"), cancellable = true)
	private void canSurvive(BlockState state, LevelReader world, BlockPos pos, CallbackInfoReturnable<Boolean> info) {
		BlockState blockstate = world.getBlockState(pos.below());
		if (blockstate.is(UnusualendModBlocks.RAW_PURPUR_BLOCK.get()) || blockstate.is(UnusualendModBlocks.INFESTED_END_STONE.get()) || blockstate.is(UnusualendModBlocks.ROOTED_RAW_PURPUR.get()) || blockstate.is(UnusualendModBlocks.GLOOPSLATE.get())
				|| blockstate.is(UnusualendModBlocks.GLOOPSTONE.get()) || blockstate.is(UnusualendModBlocks.WARPED_END_STONE.get()) || blockstate.is(UnusualendModBlocks.PURPUR_EMBEDDED_END_STONE.get())) {
			info.setReturnValue(true);
			info.cancel();
		}
	}
}

package net.sweety.unusualend.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChorusFlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.sweety.unusualend.init.UnusualendModBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

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

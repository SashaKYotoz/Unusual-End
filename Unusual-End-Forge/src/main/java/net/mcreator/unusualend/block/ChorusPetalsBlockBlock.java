
package net.mcreator.unusualend.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class ChorusPetalsBlockBlock extends FallingBlock {
	public ChorusPetalsBlockBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.RAW_IRON).sound(SoundType.MOSS).strength(0.05f, 1f).jumpFactor(0.9f));
	}

	public void fallOn(Level level, BlockState blockState, BlockPos blockPos, Entity entity, float fallDistance) {
		entity.causeFallDamage(fallDistance, 0.2F, entity.damageSources().fall());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 4;
	}
}

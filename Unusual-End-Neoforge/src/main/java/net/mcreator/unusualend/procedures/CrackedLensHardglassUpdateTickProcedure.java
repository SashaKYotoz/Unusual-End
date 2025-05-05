package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModBlocks;

import java.util.Map;

public class CrackedLensHardglassUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.5) {
			world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(UnusualendModBlocks.LENS_HARDGLASS.get().defaultBlockState()));
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = UnusualendModBlocks.LENS_HARDGLASS.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.WITCH, (x + 0.5), (y + 0.5), (z + 0.5), 5, 0.6, 0.6, 0.6, 0);
		}
	}
}

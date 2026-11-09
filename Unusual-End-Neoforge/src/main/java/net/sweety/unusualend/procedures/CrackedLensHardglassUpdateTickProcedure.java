package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.sweety.unusualend.init.UnusualEndBlocks;
import net.sweety.unusualend.util.ProcedureHelper;

public class CrackedLensHardglassUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.5) {
			world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(UnusualEndBlocks.LENS_HARDGLASS.get().defaultBlockState()));
			ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z), UnusualEndBlocks.LENS_HARDGLASS.get().defaultBlockState(), 3);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.WITCH, (x + 0.5), (y + 0.5), (z + 0.5), 5, 0.6, 0.6, 0.6, 0);
		}
	}
}

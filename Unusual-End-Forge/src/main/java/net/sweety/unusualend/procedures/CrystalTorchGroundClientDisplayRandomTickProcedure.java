package net.sweety.unusualend.procedures;

import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.sweety.unusualend.init.UnusualendModParticleTypes;
import net.sweety.unusualend.util.ProcedureHelper;

public class CrystalTorchGroundClientDisplayRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep1 ? blockstate.getValue(_getep1).toString() : "").equals("FLOOR")) {
			if (Mth.nextInt(world.getRandom(), 1, 2) == 1) {
				world.addParticle(UnusualendModParticleTypes.PINK_FLAME.get(), (x + 0.5), (y + 0.75), (z + 0.5), 0, 0, 0);
			} else {
				world.addParticle(ParticleTypes.ELECTRIC_SPARK, (x + 0.5 + Mth.nextDouble(world.getRandom(), -0.05, 0.05)), (y + 0.75 + Mth.nextDouble(world.getRandom(), -0.05, 0.05)),
						(z + 0.5 + Mth.nextDouble(world.getRandom(), -0.05, 0.05)), 0, 0, 0);
			}
		} else if ((ProcedureHelper.getDirection(blockstate)) == Direction.EAST) {
			world.addParticle(UnusualendModParticleTypes.PINK_FLAME.get(), (x + 0.22), (y + 0.88), (z + 0.5), 0, 0, 0);
			world.addParticle(ParticleTypes.ELECTRIC_SPARK, (x + 0.22 + Mth.nextDouble(world.getRandom(), -0.05, 0.05)), (y + 0.88 + Mth.nextDouble(world.getRandom(), -0.05, 0.05)),
					(z + 0.5 + Mth.nextDouble(world.getRandom(), -0.05, 0.05)), 0, 0, 0);
		} else if ((ProcedureHelper.getDirection(blockstate)) == Direction.NORTH) {
			world.addParticle(UnusualendModParticleTypes.PINK_FLAME.get(), (x + 0.5), (y + 0.88), (z + 0.78), 0, 0, 0);
			world.addParticle(ParticleTypes.ELECTRIC_SPARK, (x + 0.5 + Mth.nextDouble(world.getRandom(), -0.05, 0.05)), (y + 0.88 + Mth.nextDouble(world.getRandom(), -0.05, 0.05)),
					(z + 0.78 + Mth.nextDouble(world.getRandom(), -0.05, 0.05)), 0, 0, 0);
		} else if ((ProcedureHelper.getDirection(blockstate)) == Direction.SOUTH) {
			world.addParticle(UnusualendModParticleTypes.PINK_FLAME.get(), (x + 0.5), (y + 0.88), (z + 0.22), 0, 0, 0);
			world.addParticle(ParticleTypes.ELECTRIC_SPARK, (x + 0.5 + Mth.nextDouble(world.getRandom(), -0.05, 0.05)), (y + 0.88 + Mth.nextDouble(world.getRandom(), -0.05, 0.05)),
					(z + 0.22 + Mth.nextDouble(world.getRandom(), -0.05, 0.05)), 0, 0, 0);
		} else if ((ProcedureHelper.getDirection(blockstate)) == Direction.WEST) {
			world.addParticle(UnusualendModParticleTypes.PINK_FLAME.get(), (x + 0.78), (y + 0.88), (z + 0.5), 0, 0, 0);
			world.addParticle(ParticleTypes.ELECTRIC_SPARK, (x + 0.78 + Mth.nextDouble(world.getRandom(), -0.05, 0.05)), (y + 0.88 + Mth.nextDouble(world.getRandom(), -0.05, 0.05)),
					(z + 0.5 + Mth.nextDouble(world.getRandom(), -0.05, 0.05)), 0, 0, 0);
		}
	}
}

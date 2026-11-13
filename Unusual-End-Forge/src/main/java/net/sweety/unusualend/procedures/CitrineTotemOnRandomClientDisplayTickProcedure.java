package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.sweety.unusualend.init.UnusualendModParticleTypes;
import net.sweety.unusualend.init.UnusualendModTags;

public class CitrineTotemOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(UnusualendModTags.Blocks.CITRINE_TOTEM_BASE)
				&& (blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep3 ? blockstate.getValue(_getep3).toString() : "").equals("FLOOR")
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(UnusualendModTags.Blocks.CITRINE_TOTEM_BASE)
						&& (blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep7 ? blockstate.getValue(_getep7).toString() : "").equals("CEILING")) {
			if (Math.random() < 0.3) {
				world.addParticle(UnusualendModParticleTypes.CITRINE_SHINE.get(), (x + Mth.nextDouble(world.getRandom(), -0.1, 1.1)), (y + Mth.nextDouble(world.getRandom(), -0.1, 1.1)),
						(z + Mth.nextDouble(world.getRandom(), -0.1, 1.1)), 0, 0, 0);
			}
		}
	}
}

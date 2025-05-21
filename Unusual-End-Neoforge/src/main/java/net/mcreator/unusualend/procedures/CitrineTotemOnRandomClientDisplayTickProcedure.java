package net.mcreator.unusualend.procedures;

import net.mcreator.unusualend.UnusualEnd;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModParticleTypes;

public class CitrineTotemOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(UnusualEnd.makeUEID("citrine_totem_base")))
				&& (blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep3 ? blockstate.getValue(_getep3).toString() : "").equals("FLOOR")
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(UnusualEnd.makeUEID("citrine_totem_base")))
						&& (blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep7 ? blockstate.getValue(_getep7).toString() : "").equals("CEILING")) {
			if (Math.random() < 0.3) {
				world.addParticle(UnusualendModParticleTypes.CITRINE_SHINE.get(), (x + Mth.nextDouble(RandomSource.create(), -0.1, 1.1)), (y + Mth.nextDouble(RandomSource.create(), -0.1, 1.1)),
						(z + Mth.nextDouble(RandomSource.create(), -0.1, 1.1)), 0, 0, 0);
			}
		}
	}
}

package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.configuration.UEConfig;
import net.sweety.unusualend.init.UnusualEndMiscRegister;
import net.sweety.unusualend.util.ParticleHelper;
import net.sweety.unusualend.util.ProcedureHelper;

public class CitrineTotemUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		double X;
		double Y;
		double Z;
		double dividedby;
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(UnusualEnd.makeUEID("citrine_totem_base")))
				&& (blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep3 ? blockstate.getValue(_getep3).toString() : "").equals("FLOOR")
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(UnusualEnd.makeUEID("citrine_totem_base")))
						&& (blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep7 ? blockstate.getValue(_getep7).toString() : "").equals("CEILING")) {
			for (int index0 = 0; index0 < (int) (double) UEConfig.CITRINE_TOTEM_ACCURACY.get(); index0++) {
				X = x + Mth.nextInt(world.getRandom(), -8, 8);
				Y = y + Mth.nextInt(world.getRandom(), -3, 1);
				Z = z + Mth.nextInt(world.getRandom(), -8, 8);
				if ((world.getBlockState(BlockPos.containing(X, Y, Z))).getBlock() instanceof BonemealableBlock) {
					if (world instanceof Level _level) {
						BlockPos _bp = BlockPos.containing(X, Y, Z);
						if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
							if (!_level.isClientSide())
								_level.levelEvent(2005, _bp, 0);
						}
					}
					ProcedureHelper.playSound(world, x, y, z, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, (float) 1.5, (float) Mth.nextDouble(world.getRandom(), 0.5, 0.7));
					dividedby = 1;
					for (int index1 = 0; index1 < 15; index1++) {
						ParticleHelper.spawn(world, ParticleHelper.dust(1.0f, 0.7f, 0.3f, 0.4f), new Vec3((x + 0.5 + (X - (x + 0.5)) / dividedby), (y + 0.5 + (Y - (y + 0.5)) / dividedby), (z + 0.5 + (Z - (z + 0.5)) / dividedby)).add(0, 0.5, 0), 8, 0.1, 0.1, 0.1, 0);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(UnusualEndMiscRegister.CITRINE_SHINE.get(), (x + 0.5 + (X - (x + 0.5)) / dividedby + Mth.nextDouble(world.getRandom(), -0.2, 0.2)),
									(y + 0.5 + (Y - (y + 0.5)) / dividedby + Mth.nextDouble(world.getRandom(), -0.2, 0.2)), (z + 0.5 + (Z - (z + 0.5)) / dividedby + Mth.nextDouble(world.getRandom(), -0.2, 0.2)), 1, 0, 0, 0, 0);
						dividedby = dividedby + 0.5;
					}
				}
				break;
			}
		}
	}
}

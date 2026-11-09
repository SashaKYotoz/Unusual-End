package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.sweety.unusualend.util.ProcedureHelper;

public class ConsumeShinyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double value) {
		if (entity == null)
			return;
		if (ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "Shiny") >= value) {
			if (ShinyCheckProcedure.execute(world, x, y, z)) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Shiny", ((ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "Shiny")) - value));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.HEALTH_BOOST, (int) (value * 6000), 1, false, false));
				ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.REGENERATION, 200, 1, false, false));
				InfuserEffectsProcedure.execute(world, x, y, z, entity);
			} else {
				InvalidBaseProcedure.execute(world, x, y, z, entity);
			}
		}
	}
}

package net.sweety.unusualend.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.configuration.UEConfig;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.util.ProcedureHelper;

public class WarpedBalloonProjProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (UEConfig.SAVE_BALLOON.get()) {
			ProcedureHelper.dropItem(world, x, y, z, new ItemStack(UnusualEndItems.WARPED_BALLOON.get()), 10);
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
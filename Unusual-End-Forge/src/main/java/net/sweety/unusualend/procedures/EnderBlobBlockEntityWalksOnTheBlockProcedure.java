package net.sweety.unusualend.procedures;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.config.Config;
import net.sweety.unusualend.util.ProcedureHelper;

public class EnderBlobBlockEntityWalksOnTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.fallDistance = 0;
		if (entity instanceof Player) {
			if (world.isClientSide()) {
				entity.setDeltaMovement(new Vec3(0, 0.9, 0));
			}
		} else {
			if (Config.BLOB_BLOCK_BOUNCE.get() == true) {
				if (!world.isClientSide()) {
					entity.setDeltaMovement(new Vec3(0, 0.9, 0));
					ProcedureHelper.playSound(world, x, y, z, SoundEvents.HONEY_BLOCK_STEP, SoundSource.BLOCKS, 1, 1);
				}
			}
		}
	}
}

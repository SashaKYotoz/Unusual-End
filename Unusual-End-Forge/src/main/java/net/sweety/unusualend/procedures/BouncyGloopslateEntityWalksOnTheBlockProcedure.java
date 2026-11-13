package net.sweety.unusualend.procedures;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import net.sweety.unusualend.util.ProcedureHelper;

public class BouncyGloopslateEntityWalksOnTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			if (!entity.isShiftKeyDown()) {
				entity.setDeltaMovement(new Vec3(0, 0.85, 0));
				entity.fallDistance = 0;
				if (world.isClientSide()) {
					ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.slime.jump")), SoundSource.BLOCKS, (float) 0.9, (float) 1.5);
				}
			}
		}
	}
}

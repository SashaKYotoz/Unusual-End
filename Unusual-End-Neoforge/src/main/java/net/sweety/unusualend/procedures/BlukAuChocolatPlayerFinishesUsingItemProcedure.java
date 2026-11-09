package net.sweety.unusualend.procedures;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.configuration.UEConfig;
import net.sweety.unusualend.init.UnusualEndSounds;
import net.sweety.unusualend.util.ProcedureHelper;

public class BlukAuChocolatPlayerFinishesUsingItemProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (UEConfig.CHOCOLAT_BLUK.get()) {
			if (world.isClientSide()) {
				ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), UnusualEndSounds.FLUTE_FISHE.get(), SoundSource.PLAYERS, 1, 1);
			}
		}
	}
}
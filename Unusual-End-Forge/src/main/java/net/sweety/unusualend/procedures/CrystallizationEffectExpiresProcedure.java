package net.sweety.unusualend.procedures;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import net.sweety.unusualend.util.ProcedureHelper;

public class CrystallizationEffectExpiresProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("CrystalDamages", 0);
		for (int index0 = 0; index0 < 3; index0++) {
			ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.PLAYERS, (float) Mth.nextDouble(world.getRandom(), 0.9, 1.1), (float) Mth.nextDouble(world.getRandom(), 0.9, 1.2));
		}
	}
}

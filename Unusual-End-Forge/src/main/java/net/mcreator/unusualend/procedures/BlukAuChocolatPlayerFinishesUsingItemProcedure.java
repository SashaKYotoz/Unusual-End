package net.mcreator.unusualend.procedures;

import net.mcreator.unusualend.configuration.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class BlukAuChocolatPlayerFinishesUsingItemProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (Config.CHOCOLAT_BLUK.get() == true) {
			if (world.isClientSide()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_fishe")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_fishe")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
			}
		}
	}
}

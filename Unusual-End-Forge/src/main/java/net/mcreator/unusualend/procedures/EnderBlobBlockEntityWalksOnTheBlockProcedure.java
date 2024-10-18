package net.mcreator.unusualend.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.configuration.ConfigurationFileConfiguration;

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
			if (ConfigurationFileConfiguration.BLOB_BLOCK_BOUNCE.get() == true) {
				if (!world.isClientSide()) {
					entity.setDeltaMovement(new Vec3(0, 0.9, 0));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.step")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.step")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
				}
			}
		}
	}
}

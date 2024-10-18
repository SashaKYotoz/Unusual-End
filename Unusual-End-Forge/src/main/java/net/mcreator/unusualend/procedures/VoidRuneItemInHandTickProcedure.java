package net.mcreator.unusualend.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class VoidRuneItemInHandTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) > 0) {
				if (entity instanceof Player _player)
					_player.giveExperiencePoints(-(5));
				itemstack.getOrCreateTag().putDouble("XP", (itemstack.getOrCreateTag().getDouble("XP") + 5));
				if (world.isClientSide()) {
					if (Math.random() < 0.2) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.PLAYERS, (float) 0.1,
										(float) Mth.nextDouble(RandomSource.create(), 0.5, 0.7));
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.PLAYERS, (float) 0.1,
										(float) Mth.nextDouble(RandomSource.create(), 0.5, 0.7), false);
							}
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.pointed_dripstone.drip_water_into_cauldron")), SoundSource.PLAYERS,
									1, (float) 0.5);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.pointed_dripstone.drip_water_into_cauldron")), SoundSource.PLAYERS, 1, (float) 0.5,
									false);
						}
					}
				}
			}
		}
	}
}

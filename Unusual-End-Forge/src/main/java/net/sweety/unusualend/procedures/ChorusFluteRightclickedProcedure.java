package net.sweety.unusualend.procedures;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import net.sweety.unusualend.util.ProcedureHelper;

public class ChorusFluteRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double random = 0;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
		ProcedureHelper.awardAdvancement(entity, "using_chorus_flute");
		if ((itemstack.getOrCreateTag().getString("track")).equals("Circus")) {
			if (!world.isClientSide()) {
				ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_circus")), SoundSource.RECORDS, 6, 1);
			}
		} else if ((itemstack.getOrCreateTag().getString("track")).equals("Suspicious")) {
			if (!world.isClientSide()) {
				ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_strange")), SoundSource.RECORDS, 6, 1);
			}
		} else if ((itemstack.getOrCreateTag().getString("track")).equals("Storms")) {
			if (!world.isClientSide()) {
				ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_storms")), SoundSource.RECORDS, 6, 1);
			}
		} else if ((itemstack.getOrCreateTag().getString("track")).equals("Saria")) {
			if (!world.isClientSide()) {
				ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_saria")), SoundSource.RECORDS, 6, 1);
			}
		} else if ((itemstack.getOrCreateTag().getString("track")).equals("Party")) {
			if (!world.isClientSide()) {
				ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_party")), SoundSource.RECORDS, 6, 1);
			}
		} else if ((itemstack.getOrCreateTag().getString("track")).equals("Docks")) {
			if (!world.isClientSide()) {
				ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_docks")), SoundSource.RECORDS, 6, 1);
			}
		} else if ((itemstack.getOrCreateTag().getString("track")).equals("Tapion")) {
			if (!world.isClientSide()) {
				ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_tapion")), SoundSource.RECORDS, 6, 1);
			}
		} else if ((itemstack.getOrCreateTag().getString("track")).equals("Drift")) {
			if (!world.isClientSide()) {
				ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_drift")), SoundSource.RECORDS, 6, 1);
			}
		} else if ((itemstack.getOrCreateTag().getString("track")).equals("Doctor")) {
			if (!world.isClientSide()) {
				ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_doctor")), SoundSource.RECORDS, 6, 1);
			}
		} else if ((itemstack.getOrCreateTag().getString("track")).equals("Fishe")) {
			if (!world.isClientSide()) {
				ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_fishe")), SoundSource.RECORDS, 6, 1);
			}
		} else if ((itemstack.getOrCreateTag().getString("track")).equals("Aria")) {
			if (!world.isClientSide()) {
				ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_aria")), SoundSource.RECORDS, 6, 1);
			}
		} else if ((itemstack.getOrCreateTag().getString("track")).equals("Moog")) {
			if (!world.isClientSide()) {
				ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_moog")), SoundSource.RECORDS, 6, 1);
			}
		} else if ((itemstack.getOrCreateTag().getString("track")).equals("Wilds")) {
			if (!world.isClientSide()) {
				ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_wilds")), SoundSource.RECORDS, 6, 1);
			}
		} else {
			random = Mth.nextInt(world.getRandom(), 1, 13);
			if (!world.isClientSide()) {
				if (random == 1) {
					ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_circus")), SoundSource.RECORDS, 6, 1);
				} else if (random == 2) {
					ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_tapion")), SoundSource.RECORDS, 6, 1);
				} else if (random == 3) {
					ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_strange")), SoundSource.RECORDS, 6, 1);
				} else if (random == 4) {
					ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_storms")), SoundSource.RECORDS, 6, 1);
				} else if (random == 5) {
					ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_saria")), SoundSource.RECORDS, 6, 1);
				} else if (random == 6) {
					ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_party")), SoundSource.RECORDS, 6, 1);
				} else if (random == 7) {
					ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_docks")), SoundSource.RECORDS, 6, 1);
				} else if (random == 8) {
					ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_drift")), SoundSource.RECORDS, 6, 1);
				} else if (random == 9) {
					ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_doctor")), SoundSource.RECORDS, 6, 1);
				} else if (random == 10) {
					ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_aria")), SoundSource.RECORDS, 6, 1);
				} else if (random == 11) {
					ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_moog")), SoundSource.RECORDS, 6, 1);
				} else if (random == 12) {
					ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_fishe")), SoundSource.RECORDS, 6, 1);
				} else if (random == 13) {
					ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_wilds")), SoundSource.RECORDS, 6, 1);
				}
			}
		}
	}
}

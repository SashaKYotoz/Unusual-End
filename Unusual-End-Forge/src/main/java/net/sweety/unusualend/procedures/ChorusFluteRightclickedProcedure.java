package net.sweety.unusualend.procedures;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.RegistryObject;
import net.sweety.unusualend.init.UnusualendModSounds;
import net.sweety.unusualend.util.ProcedureHelper;

import java.util.List;
import java.util.Map;

public class ChorusFluteRightclickedProcedure {
	private static final Map<String, RegistryObject<SoundEvent>> TRACKS = Map.ofEntries(
			Map.entry("Circus", UnusualendModSounds.FLUTE_CIRCUS),
			Map.entry("Suspicious", UnusualendModSounds.FLUTE_STRANGE),
			Map.entry("Storms", UnusualendModSounds.FLUTE_STORMS),
			Map.entry("Saria", UnusualendModSounds.FLUTE_SARIA),
			Map.entry("Party", UnusualendModSounds.FLUTE_PARTY),
			Map.entry("Docks", UnusualendModSounds.FLUTE_DOCKS),
			Map.entry("Tapion", UnusualendModSounds.FLUTE_TAPION),
			Map.entry("Drift", UnusualendModSounds.FLUTE_DRIFT),
			Map.entry("Doctor", UnusualendModSounds.FLUTE_DOCTOR),
			Map.entry("Fishe", UnusualendModSounds.FLUTE_FISHE),
			Map.entry("Aria", UnusualendModSounds.FLUTE_ARIA),
			Map.entry("Moog", UnusualendModSounds.FLUTE_MOOG),
			Map.entry("Wilds", UnusualendModSounds.FLUTE_WILDS));
	private static final List<RegistryObject<SoundEvent>> ALL_TRACKS = List.copyOf(TRACKS.values());

	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player player)
			player.getCooldowns().addCooldown(itemstack.getItem(), 100);
		ProcedureHelper.awardAdvancement(entity, "using_chorus_flute");
		if (world.isClientSide())
			return;
		RegistryObject<SoundEvent> track = TRACKS.get(itemstack.getOrCreateTag().getString("track"));
		if (track == null)
			track = ALL_TRACKS.get(world.getRandom().nextInt(ALL_TRACKS.size()));
		ProcedureHelper.playSound(world, entity.getX(), entity.getY() + 2, entity.getZ(), track.get(), SoundSource.RECORDS, 6, 1);
	}
}

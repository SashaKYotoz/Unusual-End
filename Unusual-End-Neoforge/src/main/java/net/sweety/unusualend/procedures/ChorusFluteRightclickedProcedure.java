package net.sweety.unusualend.procedures;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.init.UnusualEndSounds;

import java.util.List;
import java.util.Map;

public class ChorusFluteRightclickedProcedure {
    private static final Map<String, DeferredHolder<SoundEvent, SoundEvent>> TRACKS = Map.ofEntries(
            Map.entry("Circus", UnusualEndSounds.FLUTE_CIRCUS),
            Map.entry("Suspicious", UnusualEndSounds.FLUTE_STRANGE),
            Map.entry("Storms", UnusualEndSounds.FLUTE_STORMS),
            Map.entry("Saria", UnusualEndSounds.FLUTE_SARIA),
            Map.entry("Party", UnusualEndSounds.FLUTE_PARTY),
            Map.entry("Docks", UnusualEndSounds.FLUTE_DOCKS),
            Map.entry("Tapion", UnusualEndSounds.FLUTE_TAPION),
            Map.entry("Drift", UnusualEndSounds.FLUTE_DRIFT),
            Map.entry("Doctor", UnusualEndSounds.FLUTE_DOCTOR),
            Map.entry("Fishe", UnusualEndSounds.FLUTE_FISHE),
            Map.entry("Aria", UnusualEndSounds.FLUTE_ARIA),
            Map.entry("Moog", UnusualEndSounds.FLUTE_MOOG)
    );
    private static final List<DeferredHolder<SoundEvent, SoundEvent>> SHUFFLE_POOL = List.copyOf(TRACKS.values());

    public static void execute(Level level, Player player, ItemStack itemstack) {
        player.getCooldowns().addCooldown(itemstack.getItem(), 100);
        if (level.isClientSide() || !(player instanceof ServerPlayer serverPlayer))
            return;
        awardAdvancement(serverPlayer);
        DeferredHolder<SoundEvent, SoundEvent> track = TRACKS.get(NBTProcessor.getNBTString(itemstack, "track"));
        if (track == null)
            track = SHUFFLE_POOL.get(level.random.nextInt(SHUFFLE_POOL.size()));
        level.playSound(null, player.getX(), player.getY() + 2, player.getZ(), track.get(), SoundSource.RECORDS, 6, 1);
    }

    private static void awardAdvancement(ServerPlayer player) {
        AdvancementHolder advancement = player.server.getAdvancements().get(UnusualEnd.makeUEID("using_chorus_flute"));
        if (advancement == null)
            return;
        AdvancementProgress progress = player.getAdvancements().getOrStartProgress(advancement);
        if (!progress.isDone()) {
            for (String criteria : progress.getRemainingCriteria())
                player.getAdvancements().award(advancement, criteria);
        }
    }
}

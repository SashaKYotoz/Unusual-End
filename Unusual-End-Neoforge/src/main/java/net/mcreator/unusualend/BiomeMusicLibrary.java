package net.mcreator.unusualend;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.Music;
import net.minecraft.client.sounds.MusicManager;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BiomeMusicLibrary {
	public static String[] MusicTracks = {"endstone_golem_theme", "endblob_queen_theme"};

	public BiomeMusicLibrary() {
	}

	public static String getOSTTrack(int id) {
		return MusicTracks[id];
	}

	public static void playTrack(int trackID) {
		Musics.END = new Music(SoundEvents.MUSIC_END, 6000, 24000, false);
		Musics.END_BOSS = new Music(SoundEvents.MUSIC_DRAGON, 0, 0, false);
		MusicManager musicManager = Minecraft.getInstance().getMusicManager();
		if (trackID < 0) {
			stopAllModTracks();
			return;
		}
		Music track = new Music(BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID(MusicTracks[trackID]))), 0, 0, true);
		if (!(musicManager.isPlayingMusic(track))) {
			musicManager.stopPlaying();
			musicManager.startPlaying(track);
		}
	}

	public static void stopTrack(int trackID) {
		MusicManager musicManager = Minecraft.getInstance().getMusicManager();
		Music track = new Music(BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID(MusicTracks[trackID]))), 0, 0, true);
		if (musicManager.isPlayingMusic(track)) {
			musicManager.stopPlaying();
		}
	}

	public static void stopAllModTracks() {
		for (int i = 0; i < MusicTracks.length; i++) {
			stopTrack(i);
		}
	}
}

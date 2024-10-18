package net.mcreator.unusualend;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.Music;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.sounds.MusicManager;
import net.minecraft.client.Minecraft;

@OnlyIn(Dist.CLIENT)
public class BiomeMusicLibrary {
	public static String[] MusicTracks = {"unusualend:endstone_golem_theme", "unusualend:endblob_queen_theme"};

	public BiomeMusicLibrary() {
	}

	public static String getOSTTrack(int id) {
		return MusicTracks[id];
	}

	public static void PlayTrack(int trackID) {
		Musics.END = new Music(SoundEvents.MUSIC_END, 6000, 24000, false);
		Musics.END_BOSS = new Music(SoundEvents.MUSIC_DRAGON, 0, 0, false);
		MusicManager musicManager = Minecraft.getInstance().getMusicManager();
		if (trackID < 0) {
			StopAllModTracks();
			return;
		}
		Music track = new Music(ForgeRegistries.SOUND_EVENTS.getHolder(new ResourceLocation(MusicTracks[trackID])).get(), 0, 0, true);
		if (!(musicManager.isPlayingMusic(track))) {
			musicManager.stopPlaying();
			musicManager.startPlaying(track);
		}
	}

	public static void StopTrack(int trackID) {
		MusicManager musicManager = Minecraft.getInstance().getMusicManager();
		Music track = new Music(ForgeRegistries.SOUND_EVENTS.getHolder(new ResourceLocation(MusicTracks[trackID])).get(), 0, 0, true);
		if (musicManager.isPlayingMusic(track)) {
			musicManager.stopPlaying();
		}
	}

	public static void StopAllModTracks() {
		for (int i = 0; i < MusicTracks.length; i++) {
			StopTrack(i);
		}
	}
}

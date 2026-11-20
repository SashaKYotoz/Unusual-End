package net.sweety.unusualend.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sweety.unusualend.UnusualEnd;

public class UnusualendModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, UnusualEnd.MODID);
	public static final RegistryObject<SoundEvent> MUSIC_DISC_FLYING_SHIPS = REGISTRY.register("music_disc_flying_ships", () -> new SoundEvent(new ResourceLocation("unusualend", "music_disc_flying_ships")));
	public static final RegistryObject<SoundEvent> MUSIC_DISC_ENDSTONE_GOLEM_THEME = REGISTRY.register("music_disc_endstone_golem_theme",
			() -> new SoundEvent(new ResourceLocation("unusualend", "music_disc_endstone_golem_theme")));
	public static final RegistryObject<SoundEvent> ENDSTONE_GOLEM_THEME = REGISTRY.register("endstone_golem_theme", () -> new SoundEvent(new ResourceLocation("unusualend", "endstone_golem_theme")));
	public static final RegistryObject<SoundEvent> ENDSTONE_GOLEM_DEATH = REGISTRY.register("endstone_golem_death", () -> new SoundEvent(new ResourceLocation("unusualend", "endstone_golem_death")));
	public static final RegistryObject<SoundEvent> PETER_HONT_ASTRAY_ARCHIPELAGO = REGISTRY.register("peter_hont_astray_archipelago", () -> new SoundEvent(new ResourceLocation("unusualend", "peter_hont_astray_archipelago")));
	public static final RegistryObject<SoundEvent> FIRCH_PROPHET = REGISTRY.register("firch_prophet", () -> new SoundEvent(new ResourceLocation("unusualend", "firch_prophet")));
	public static final RegistryObject<SoundEvent> FLUTE_CIRCUS = REGISTRY.register("flute_circus", () -> new SoundEvent(new ResourceLocation("unusualend", "flute_circus")));
	public static final RegistryObject<SoundEvent> FLUTE_STORMS = REGISTRY.register("flute_storms", () -> new SoundEvent(new ResourceLocation("unusualend", "flute_storms")));
	public static final RegistryObject<SoundEvent> FLUTE_STRANGE = REGISTRY.register("flute_strange", () -> new SoundEvent(new ResourceLocation("unusualend", "flute_strange")));
	public static final RegistryObject<SoundEvent> FLUTE_DOCTOR = REGISTRY.register("flute_doctor", () -> new SoundEvent(new ResourceLocation("unusualend", "flute_doctor")));
	public static final RegistryObject<SoundEvent> FLUTE_PARTY = REGISTRY.register("flute_party", () -> new SoundEvent(new ResourceLocation("unusualend", "flute_party")));
	public static final RegistryObject<SoundEvent> FLUTE_SARIA = REGISTRY.register("flute_saria", () -> new SoundEvent(new ResourceLocation("unusualend", "flute_saria")));
	public static final RegistryObject<SoundEvent> FLUTE_DOCKS = REGISTRY.register("flute_docks", () -> new SoundEvent(new ResourceLocation("unusualend", "flute_docks")));
	public static final RegistryObject<SoundEvent> FLUTE_DRIFT = REGISTRY.register("flute_drift", () -> new SoundEvent(new ResourceLocation("unusualend", "flute_drift")));
	public static final RegistryObject<SoundEvent> OHEIGHT_MOOG_IN_SPACE = REGISTRY.register("oheight-moog-in-space", () -> new SoundEvent(new ResourceLocation("unusualend", "oheight-moog-in-space")));
	public static final RegistryObject<SoundEvent> FLUTE_TAPION = REGISTRY.register("flute_tapion", () -> new SoundEvent(new ResourceLocation("unusualend", "flute_tapion")));
	public static final RegistryObject<SoundEvent> FLUTE_MOOG = REGISTRY.register("flute_moog", () -> new SoundEvent(new ResourceLocation("unusualend", "flute_moog")));
	public static final RegistryObject<SoundEvent> FLUTE_ARIA = REGISTRY.register("flute_aria", () -> new SoundEvent(new ResourceLocation("unusualend", "flute_aria")));
	public static final RegistryObject<SoundEvent> ENDBLOB_QUEEN_THEME = REGISTRY.register("endblob_queen_theme", () -> new SoundEvent(new ResourceLocation("unusualend", "endblob_queen_theme")));
	public static final RegistryObject<SoundEvent> BOLOK_AMBIENT = REGISTRY.register("bolok_ambient", () -> new SoundEvent(new ResourceLocation("unusualend", "bolok_ambient")));
	public static final RegistryObject<SoundEvent> BOLOK_DIES = REGISTRY.register("bolok_dies", () -> new SoundEvent(new ResourceLocation("unusualend", "bolok_dies")));
	public static final RegistryObject<SoundEvent> BOLOK_HURTS = REGISTRY.register("bolok_hurts", () -> new SoundEvent(new ResourceLocation("unusualend", "bolok_hurts")));
	public static final RegistryObject<SoundEvent> FLUTE_FISHE = REGISTRY.register("flute_fishe", () -> new SoundEvent(new ResourceLocation("unusualend", "flute_fishe")));
	public static final RegistryObject<SoundEvent> MUSIC_DISC_QUEEN = REGISTRY.register("music_disc_queen", () -> new SoundEvent(new ResourceLocation("unusualend", "music_disc_queen")));
	public static final RegistryObject<SoundEvent> BLUK_EAT = REGISTRY.register("bluk_eat", () -> new SoundEvent(new ResourceLocation("unusualend", "bluk_eat")));
	public static final RegistryObject<SoundEvent> THE_GREAT_ABYSS = REGISTRY.register("the_great_abyss", () -> new SoundEvent(new ResourceLocation("unusualend", "the_great_abyss")));
	public static final RegistryObject<SoundEvent> FLUTE_WILDS = REGISTRY.register("flute_wilds", () -> new SoundEvent(new ResourceLocation("unusualend", "flute_wilds")));
}

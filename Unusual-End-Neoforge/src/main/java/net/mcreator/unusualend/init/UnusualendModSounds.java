
package net.mcreator.unusualend.init;

import net.mcreator.unusualend.UnusualEnd;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class UnusualendModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, UnusualEnd.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_FLYING_SHIPS = REGISTRY.register("music_disc_flying_ships", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("music_disc_flying_ships")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_ENDSTONE_GOLEM_THEME = REGISTRY.register("music_disc_endstone_golem_theme",
			() -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("music_disc_endstone_golem_theme")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ENDSTONE_GOLEM_THEME = REGISTRY.register("endstone_golem_theme", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("endstone_golem_theme")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ENDSTONE_GOLEM_DEATH = REGISTRY.register("endstone_golem_death", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("endstone_golem_death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> PETER_HONT_ASTRAY_ARCHIPELAGO = REGISTRY.register("peter_hont_astray_archipelago", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("peter_hont_astray_archipelago")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FIRCH_PROPHET = REGISTRY.register("firch_prophet", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("firch_prophet")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FLUTE_CIRCUS = REGISTRY.register("flute_circus", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("flute_circus")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FLUTE_STORMS = REGISTRY.register("flute_storms", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("flute_storms")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FLUTE_STRANGE = REGISTRY.register("flute_strange", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("flute_strange")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FLUTE_DOCTOR = REGISTRY.register("flute_doctor", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("flute_doctor")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FLUTE_PARTY = REGISTRY.register("flute_party", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("flute_party")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FLUTE_SARIA = REGISTRY.register("flute_saria", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("flute_saria")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FLUTE_DOCKS = REGISTRY.register("flute_docks", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("flute_docks")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FLUTE_DRIFT = REGISTRY.register("flute_drift", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("flute_drift")));
	public static final DeferredHolder<SoundEvent, SoundEvent> OHEIGHT_MOOG_IN_SPACE = REGISTRY.register("oheight-moog-in-space", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("oheight-moog-in-space")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FLUTE_TAPION = REGISTRY.register("flute_tapion", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("flute_tapion")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FLUTE_MOOG = REGISTRY.register("flute_moog", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("flute_moog")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FLUTE_ARIA = REGISTRY.register("flute_aria", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("flute_aria")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ENDBLOB_QUEEN_THEME = REGISTRY.register("endblob_queen_theme", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("endblob_queen_theme")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BOLOK_AMBIENT = REGISTRY.register("bolok_ambient", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("bolok_ambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BOLOK_DIES = REGISTRY.register("bolok_dies", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("bolok_dies")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BOLOK_HURTS = REGISTRY.register("bolok_hurts", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("bolok_hurts")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FLUTE_FISHE = REGISTRY.register("flute_fishe", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("flute_fishe")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_QUEEN = REGISTRY.register("music_disc_queen", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("music_disc_queen")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLUK_EAT = REGISTRY.register("bluk_eat", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("bluk_eat")));
	public static final DeferredHolder<SoundEvent, SoundEvent> THE_GREAT_ABYSS = REGISTRY.register("the_great_abyss", () -> SoundEvent.createVariableRangeEvent(UnusualEnd.makeUEID("the_great_abyss")));
}

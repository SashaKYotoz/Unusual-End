package net.mcreator.unusualend.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigurationFileConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Double> BREAKING_CHORUS_SUMMON_ENDERMITE_PERCENTAGE;
	public static final ForgeConfigSpec.ConfigValue<Double> BREAKING_POT_SUMMON_ENDERMITE_PERCENTAGE;
	public static final ForgeConfigSpec.ConfigValue<Double> CHORUS_HELMET_PROBABILITY_TO_TELEPORT;
	public static final ForgeConfigSpec.ConfigValue<Double> MAX_DAMAGE_CHORUS_HELMET_CAN_DODGE_WITH_TP_;
	public static final ForgeConfigSpec.ConfigValue<Double> ENDERMITES_PROBABILITY_TO_INFECT;
	public static final ForgeConfigSpec.ConfigValue<Double> MAX_WARPED_INFUSION;
	public static final ForgeConfigSpec.ConfigValue<Double> CITRINE_TOTEM_ACCURACY;
	public static final ForgeConfigSpec.ConfigValue<Double> DRAGLING_DISRUPTION;
	public static final ForgeConfigSpec.ConfigValue<Boolean> CHOCOLAT_BLUK;
	public static final ForgeConfigSpec.ConfigValue<Boolean> SHIELD_PVP;
	public static final ForgeConfigSpec.ConfigValue<Boolean> BLOB_BLOCK_BOUNCE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> REGULAR_BONEMEAL;
	public static final ForgeConfigSpec.ConfigValue<Boolean> PURPUR_BONEMEAL;
	public static final ForgeConfigSpec.ConfigValue<Boolean> GLOOPY_BONEMEAL;
	public static final ForgeConfigSpec.ConfigValue<Boolean> SAVE_BALLOON;
	public static final ForgeConfigSpec.ConfigValue<Double> ENDERLING_MASK;
	public static final ForgeConfigSpec.ConfigValue<Boolean> CRYSTAL_NAUSEA;
	public static final ForgeConfigSpec.ConfigValue<Double> VOID_TOTEM_Y;
	public static final ForgeConfigSpec.ConfigValue<Double> PODIUM_ITEM;
	public static final ForgeConfigSpec.ConfigValue<Double> PODIUM_BLOCK;
	public static final ForgeConfigSpec.ConfigValue<Boolean> EVERLASTING;
	public static final ForgeConfigSpec.ConfigValue<Double> ORB_TRIGGER;
	public static final ForgeConfigSpec.ConfigValue<Double> PRISMATIC_MIRROR;
	public static final ForgeConfigSpec.ConfigValue<Double> VOID_TOTEM;
	public static final ForgeConfigSpec.ConfigValue<Double> POUCH;
	public static final ForgeConfigSpec.ConfigValue<Double> SHINY_CHARGE;
	public static final ForgeConfigSpec.ConfigValue<Double> WARPED_BALLOON;
	public static final ForgeConfigSpec.ConfigValue<Boolean> CAN_USE_TELEPORTATION_ANCHOR;
	public static final ForgeConfigSpec.ConfigValue<Boolean> CAN_LINK_VOID_TOTEM;
	public static final ForgeConfigSpec.ConfigValue<Boolean> CAN_LINK_TOTEM;
	public static final ForgeConfigSpec.ConfigValue<Boolean> NEED_ANCHOR;
	public static final ForgeConfigSpec.ConfigValue<Boolean> NEED_ANCHOR_FOR_TOTEMS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> GLOOPY_FOG;
	public static final ForgeConfigSpec.ConfigValue<Boolean> WARPED_FOG;
	public static final ForgeConfigSpec.ConfigValue<Boolean> HIGHLAND_PLANTS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> RAW_PURPUR;
	public static final ForgeConfigSpec.ConfigValue<Boolean> INFESTED_ENDSTONE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> PURPUR_ISLANDS;
	public static final ForgeConfigSpec.ConfigValue<Double> STEW_TIME;
	public static final ForgeConfigSpec.ConfigValue<Double> BOLOK_FIN_TIME;
	public static final ForgeConfigSpec.ConfigValue<Double> COOKED_BOLOK_FIN_TIME;
	public static final ForgeConfigSpec.ConfigValue<Double> TENACITY_TIME;
	static {
		BUILDER.push("Main Config");
		BREAKING_CHORUS_SUMMON_ENDERMITE_PERCENTAGE = BUILDER.comment("Probability in % for Chorus to summon an Endermite when broken. Includes all blocks in the 'unusualend:endermites_infested' tag").define("Endermite Infestation Probability",
				(double) 8);
		BREAKING_POT_SUMMON_ENDERMITE_PERCENTAGE = BUILDER.comment("Probability in % for Gloopy Urns to summon an Endermite when broken. Includes all blocks in the 'unusualend:more_endermites_infested' tag")
				.define("Frequent Endermite Infestation Probability", (double) 20);
		CHORUS_HELMET_PROBABILITY_TO_TELEPORT = BUILDER.comment("Probability in % for the Chorus Helmet ability to trigger").define("Chorus Helmet Trigger Probability", (double) 20);
		MAX_DAMAGE_CHORUS_HELMET_CAN_DODGE_WITH_TP_ = BUILDER.comment("Maximal amount of damages the Chorus Helmet will negate when dodging an attack. Attacks superior to this value won't be affected or reduced")
				.define("Chorus Helmet Dodged Damages", (double) 8);
		ENDERMITES_PROBABILITY_TO_INFECT = BUILDER.comment("Probability in % for an Endermite or Enderblob to infect you when hurt").define("Blob Infection Probability", (double) 10);
		MAX_WARPED_INFUSION = BUILDER.comment("Maximal amount of Warped Infusions a player can drink in a row with the Warped Tenacity effect stacking").define("Max Warped Infusions", (double) 5);
		CITRINE_TOTEM_ACCURACY = BUILDER.comment("Number of attempts the Citrine Totem will do to try and find a plant to fertilize (every 2 seconds)").define("Citrine Totem Accuracy", (double) 3);
		DRAGLING_DISRUPTION = BUILDER.comment("Probability in % for Draglings to inflict Disruption").define("Dragling Disruption", (double) 20);
		CHOCOLAT_BLUK = BUILDER.comment("Whether 'Le Fishe au Chocolat' should play each time a Chocolate Bluk is eaten").define("Fishe Music", false);
		SHIELD_PVP = BUILDER.comment("Whether players will be affected by the Endblob Shield knockback (Multiplayer PvP)").define("Blob Shields PvP", true);
		BLOB_BLOCK_BOUNCE = BUILDER.comment("Whether Endblob bouncing properties should apply to all mobs. Standing on an Endblob block will make entities bounce infinitely, which could be abused").define("Universal Bounce", true);
		REGULAR_BONEMEAL = BUILDER.comment("Whether players can bonemeal End Stone").define("Endstone Bonemeal", true);
		PURPUR_BONEMEAL = BUILDER.comment("Whether players can bonemeal Raw Purpur").define("Purpur Bonemeal", true);
		GLOOPY_BONEMEAL = BUILDER.comment("Whether players can bonemeal Gloopstone and Gloopslate").define("Gloopy Bonemeal", true);
		SAVE_BALLOON = BUILDER.comment("Whether a Warped Balloon that missed or is unable to capture its target will drop the Warped Ballon back at the target's localisation.").define("Get Warped Ballons Back", true);
		ENDERLING_MASK = BUILDER.comment("Probability in % for an Undead Enderling to spawn with an Enderling Mask").define("Enderling Mask Probability", (double) 22);
		CRYSTAL_NAUSEA = BUILDER.comment("Whether the Crystal Flower should inflict Nausea to entities interacting with it").define("Crystal Flower Nausea", true);
		VOID_TOTEM_Y = BUILDER.comment("The Y altitude under which the Void Totem will be triggered").define("Void Totem Altitude", (double) -1);
		PODIUM_ITEM = BUILDER.comment("The scale the Ancient Podium will display items as").define("Podium Item Size", (double) 0.55);
		PODIUM_BLOCK = BUILDER.comment("The scale the Ancient Podium will display blocks at").define("Podium Block Size", (double) 0.4);
		EVERLASTING = BUILDER.comment("Whether the player will be able to obtain Everlasting (makes items never despawn)").define("Can Everlasting be obtained", true);
		ORB_TRIGGER = BUILDER.comment("Probability in % for Orbs to trigger").define("Orb Activation", (double) 5);
		BUILDER.pop();
		BUILDER.push("Cooldowns (in tick)");
		PRISMATIC_MIRROR = BUILDER.define("Prismatic Mirror", (double) 6000);
		VOID_TOTEM = BUILDER.define("Totem of the Void", (double) 120);
		POUCH = BUILDER.define("Floating Pouch", (double) 100);
		SHINY_CHARGE = BUILDER.define("Shiny Charge", (double) 100);
		WARPED_BALLOON = BUILDER.define("Warped Balloon", (double) 100);
		BUILDER.pop();
		BUILDER.push("Teleportation Anchor");
		CAN_USE_TELEPORTATION_ANCHOR = BUILDER.comment("Can players link the Teleportation Anchor to a Prismatic Mirror").define("Mirror Link", true);
		CAN_LINK_VOID_TOTEM = BUILDER.comment("Can players link the Teleportation Anchor to a Totem of the Void").define("Void Totem Link", true);
		CAN_LINK_TOTEM = BUILDER.comment("Can players link the Teleportation Anchor to a Totem of Undying").define("Undying Totem Link", true);
		NEED_ANCHOR = BUILDER.comment(
				"Whether a Teleportation Anchor is needed to teleport with a Linked Prismatic Mirror to it. If false, teleporting to a broken Anchor will instead randomly teleport the player in a 1000 block radius around the dimension's center")
				.define("Mirror requiere Anchor", true);
		NEED_ANCHOR_FOR_TOTEMS = BUILDER.comment(
				"Whether a Teleportation Anchor is needed to teleport with a Totem of the Void or Totem of Undying. If false, teleporting to a broken Anchor will instead randomly teleport the player in a 1000 block radius around the dimension's center")
				.define("Totems requiere Anchor", false);
		BUILDER.pop();
		BUILDER.push("Biomes");
		GLOOPY_FOG = BUILDER.define("Fog inside of the Gloopstone Biomes", false);
		WARPED_FOG = BUILDER.define("Fog inside of the Warped Reef", false);
		BUILDER.pop();
		BUILDER.push("Generation");
		HIGHLAND_PLANTS = BUILDER.define("End Highlands Vegetation", true);
		RAW_PURPUR = BUILDER.define("End Highlands Raw Purpur", true);
		INFESTED_ENDSTONE = BUILDER.define("Infested Endstone", true);
		PURPUR_ISLANDS = BUILDER.define("Overgrown Small End Islands", true);
		BUILDER.pop();
		BUILDER.push("Potion Effect Durations (in seconds)");
		STEW_TIME = BUILDER.define("Wandering Stew", (double) 600);
		BOLOK_FIN_TIME = BUILDER.define("Bolok Fin", (double) 600);
		COOKED_BOLOK_FIN_TIME = BUILDER.define("Cooked Bolok Fin", (double) 1200);
		TENACITY_TIME = BUILDER.define("Warped Infusion", (double) 60);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}

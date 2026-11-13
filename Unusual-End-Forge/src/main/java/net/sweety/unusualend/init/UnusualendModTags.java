package net.sweety.unusualend.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.sweety.unusualend.UnusualEnd;

public final class UnusualendModTags {
	private UnusualendModTags() {
	}

	public static final class Blocks {
		public static final TagKey<Block> CHORUS_FUNGUS_MAY_PLACE_ON = tag("chorus_fungus_may_place_on");
		public static final TagKey<Block> CHORUS_GRASS_MAY_PLACE_ON = tag("chorus_grass_may_place_on");
		public static final TagKey<Block> CHORUS_ROOTS_MAY_PLACE_ON = tag("chorus_roots_may_place_on");
		public static final TagKey<Block> CRYSTAL_FLOWER_MAY_PLACE_ON = tag("crystal_flower_may_place_on");
		public static final TagKey<Block> FLOWERING_GLOOPY_PILE_MAY_PLACE_ON = tag("flowering_gloopy_pile_may_place_on");
		public static final TagKey<Block> GLOOPY_BUSH_MAY_PLACE_ON = tag("gloopy_bush_may_place_on");
		public static final TagKey<Block> GLOOPY_TENDRILS_MAY_PLACE_ON = tag("gloopy_tendrils_may_place_on");
		public static final TagKey<Block> GROWN_WARPED_BUSH_MAY_PLACE_ON = tag("grown_warped_bush_may_place_on");
		public static final TagKey<Block> SMALL_WARPED_ALGAE_MAY_PLACE_ON = tag("small_warped_algae_may_place_on");
		public static final TagKey<Block> WARPED_SPROUTS_MAY_PLACE_ON = tag("warped_sprouts_may_place_on");
		public static final TagKey<Block> CANDLE_SHINY_FLAMES = tag("candle_shiny_flames");
		public static final TagKey<Block> CANDLE_SOUL_FLAMES = tag("candle_soul_flames");
		public static final TagKey<Block> CHORUS_LIB_END_STONES = tag("chorus_lib", "end_stones");
		public static final TagKey<Block> CITRINE_TOTEM_BASE = tag("citrine_totem_base");
		public static final TagKey<Block> ENDERMITES_INFESTED = tag("endermites_infested");
		public static final TagKey<Block> GLOOPSTONE_VALID_PLACEMENT = tag("gloopstone_valid_placement");
		public static final TagKey<Block> GNEISS = tag("gneiss");
		public static final TagKey<Block> MORE_ENDERMITES_INFESTED = tag("more_endermites_infested");
		public static final TagKey<Block> STRIPPABLE = tag("strippable");
		public static final TagKey<Block> VALID_LANTERN = tag("valid_lantern");
		public static final TagKey<Block> WARPED_BLOCKS = tag("warped_blocks");

		private Blocks() {
		}

		private static TagKey<Block> tag(String name) {
			return tag(UnusualEnd.MODID, name);
		}

		private static TagKey<Block> tag(String namespace, String name) {
			return TagKey.create(Registries.BLOCK, new ResourceLocation(namespace, name));
		}
	}

	public static final class Items {
		public static final TagKey<Item> CAN_TELEPORT_TO_WARPING_WAYSTONE = tag("forge", "can_teleport_to_warping_waystone");
		public static final TagKey<Item> CITRINE_BASE = tag("forge", "citrine_base");
		public static final TagKey<Item> ENDERLING_MASK = tag("enderling_mask");
		public static final TagKey<Item> EXPLOSIVE_IGNITER = tag("explosive_igniter");
		public static final TagKey<Item> PRISMATIC_BASE = tag("forge", "prismatic_base");
		public static final TagKey<Item> SHINY_BASE = tag("forge", "shiny_base");

		private Items() {
		}

		private static TagKey<Item> tag(String name) {
			return tag(UnusualEnd.MODID, name);
		}

		private static TagKey<Item> tag(String namespace, String name) {
			return TagKey.create(Registries.ITEM, new ResourceLocation(namespace, name));
		}
	}
}

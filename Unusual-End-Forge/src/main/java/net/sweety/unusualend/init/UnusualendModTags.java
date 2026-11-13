package net.sweety.unusualend.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
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

		private Blocks() {
		}

		private static TagKey<Block> tag(String name) {
			return TagKey.create(Registries.BLOCK, new ResourceLocation(UnusualEnd.MODID, name));
		}
	}
}

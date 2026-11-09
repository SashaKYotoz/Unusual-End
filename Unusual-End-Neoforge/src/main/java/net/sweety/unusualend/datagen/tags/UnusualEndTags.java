package net.sweety.unusualend.datagen.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.sweety.unusualend.UnusualEnd;

public class UnusualEndTags {
    public static class Blocks {
        public static final TagKey<Block> CHORUS_FUNGUS_MAY_PLACE_ON = tag("chorus_fungus_may_place_on");
        public static final TagKey<Block> CHORUS_GRASS_MAY_PLACE_ON = tag("chorus_grass_may_place_on");
        public static final TagKey<Block> CHORUS_ROOTS_MAY_PLACE_ON = tag("chorus_roots_may_place_on");
        public static final TagKey<Block> CRYSTAL_FLOWER_MAY_PLACE_ON = tag("crystal_flower_may_place_on");
        public static final TagKey<Block> GLOOPY_PILE_MAY_PLACE_ON = tag("gloopy_pile_may_place_on");
        public static final TagKey<Block> GLOOPY_BUSH_MAY_PLACE_ON = tag("gloopy_bush_may_place_on");
        public static final TagKey<Block> GLOOPY_TENDRILS_MAY_PLACE_ON = tag("gloopy_tendrils_may_place_on");
        public static final TagKey<Block> WARPED_BUSH_MAY_PLACE_ON = tag("warped_bush_may_place_on");
        public static final TagKey<Block> SHINY_SPIREA_MAY_PLACE_ON = tag("shiny_spirea_may_place_on");
        public static final TagKey<Block> WARPED_ALGAE_MAY_PLACE_ON = tag("warped_algae_may_place_on");

        private static TagKey<Block> tag(String name) {
            return TagKey.create(Registries.BLOCK, UnusualEnd.makeUEID(name));
        }
    }

    public static class Items {
        public static TagKey<Item> LEECHING_WAND_ENCHANTABLE = tag("leeching_wand_enchantable");
        public static TagKey<Item> ARCANE_ENCHANTABLE = tag("arcane_enchantable");
        public static TagKey<Item> SPEAR_ENCHANTABLE = tag("spear_enchantable");
        public static TagKey<Item> BOLOK_ENCHANTABLE = tag("bolok_enchantable");
        public static TagKey<Item> ELYTRA_ENCHANTABLE = tag("elytra_enchantable");

        private static TagKey<Item> tag(String name) {
            return TagKey.create(Registries.ITEM, UnusualEnd.makeUEID(name));
        }
    }
}
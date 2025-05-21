
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.unusualend.init;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.block.ComposterBlock;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusualendModCompostableItems {
	@SubscribeEvent
	public static void addComposterItems(FMLCommonSetupEvent event) {
		ComposterBlock.COMPOSTABLES.put(UnusualendModBlocks.CHORUS_CANE_FLOWER.get().asItem(), 0.85f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModBlocks.CHORUS_CANE.get().asItem(), 0.3f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModBlocks.BLOOMING_CHORUS_CANE.get().asItem(), 0.3f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModBlocks.CHORUS_FUNGUS.get().asItem(), 0.65f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModBlocks.CHORUS_ROOTS.get().asItem(), 0.65f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModBlocks.ENDSTONE_SPROUTS.get().asItem(), 0.5f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModBlocks.PURPUR_GRASS.get().asItem(), 0.65f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModBlocks.FLOWERING_PURPUR_GRASS.get().asItem(), 0.65f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModBlocks.WARPED_MOSS.get().asItem(), 0.3f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModItems.CHORUS_PIE.get(), 1f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModItems.CHORUS_PETAL.get(), 0.3f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModBlocks.DRIPPING_GLOOPSTONE.get().asItem(), 0.3f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModBlocks.GLOOPY_BUSH.get().asItem(), 0.5f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModBlocks.SHINY_SPIREA.get().asItem(), 0.65f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModItems.WARPED_SPORES.get(), 0.65f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModBlocks.WARPED_ALGAE.get().asItem(), 0.5f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModBlocks.SMALL_WARPED_ALGAE.get().asItem(), 0.3f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModBlocks.WARPED_ENDSTONE_SPROUTS.get().asItem(), 0.3f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModBlocks.CRYSTAL_FLOWER.get().asItem(), 1f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModItems.WARPED_BERRIES.get(), 0.85f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModBlocks.GLOOPY_TENDRILS.get().asItem(), 0.3f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModBlocks.WARPED_BUSH.get().asItem(), 0.5f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModBlocks.WARPED_SQUASH.get().asItem(), 0.65f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModItems.WARPED_SQUASH_WEDGE.get(), 0.5f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModBlocks.SMALL_WARPED_SQUASH.get().asItem(), 0.5f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModItems.GLOOPILON_SLICE.get(), 0.85f);
		ComposterBlock.COMPOSTABLES.put(UnusualendModBlocks.GLOOPILON_SEEDS.get().asItem(), 0.85f);
	}
}

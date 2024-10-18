
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.unusualend.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class UnusualendModTrades {
	@SubscribeEvent
	public static void registerWanderingTrades(WandererTradesEvent event) {
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 5),

				new ItemStack(UnusualendModItems.ENDERFIREFLY_BUCKET.get()), 2, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 15),

				new ItemStack(UnusualendModItems.VOID_TOTEM.get()), 1, 5, 0.05f));
	}
}

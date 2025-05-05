package net.mcreator.unusualend.init;

import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;

@Mod.EventBusSubscriber
public class UnusualendModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == UnusualendModItems.GOLEM_ORB.get())
			event.setBurnTime(640000);
		else if (itemstack.getItem() == UnusualendModBlocks.CHORUS_CANE.get().asItem())
			event.setBurnTime(50);
		else if (itemstack.getItem() == UnusualendModBlocks.BLOOMING_CHORUS_CANE.get().asItem())
			event.setBurnTime(50);
		else if (itemstack.getItem() == UnusualendModBlocks.CHORUS_CANE_BLOCK.get().asItem())
			event.setBurnTime(400);
		else if (itemstack.getItem() == UnusualendModBlocks.STRIPPED_CHORUS_CANE_BLOCK.get().asItem())
			event.setBurnTime(400);
	}
}

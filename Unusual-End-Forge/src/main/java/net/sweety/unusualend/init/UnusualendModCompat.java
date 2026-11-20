package net.sweety.unusualend.init;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.compat.CuriosCompat;

@Mod.EventBusSubscriber(modid = UnusualEnd.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusualendModCompat {
	@SubscribeEvent
	public static void enqueueIMC(InterModEnqueueEvent event) {
		if (ModList.get().isLoaded("curios"))
			CuriosCompat.enqueueSlotTypes();
	}
}
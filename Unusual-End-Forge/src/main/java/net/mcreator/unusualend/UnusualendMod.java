package net.mcreator.unusualend;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.util.thread.SidedThreadGroups;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.unusualend.world.features.StructureFeature;
import net.mcreator.unusualend.init.UnusualendModTabs;
import net.mcreator.unusualend.init.UnusualendModSounds;
import net.mcreator.unusualend.init.UnusualendModPotions;
import net.mcreator.unusualend.init.UnusualendModParticleTypes;
import net.mcreator.unusualend.init.UnusualendModPaintings;
import net.mcreator.unusualend.init.UnusualendModMobEffects;
import net.mcreator.unusualend.init.UnusualendModMenus;
import net.mcreator.unusualend.init.UnusualendModItems;
import net.mcreator.unusualend.init.UnusualendModFeatures;
import net.mcreator.unusualend.init.UnusualendModEntities;
import net.mcreator.unusualend.init.UnusualendModEnchantments;
import net.mcreator.unusualend.init.UnusualendModBlocks;
import net.mcreator.unusualend.init.UnusualendModBlockEntities;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import java.util.AbstractMap;

@Mod("unusualend")
public class UnusualendMod {
	public static final Logger LOGGER = LogManager.getLogger(UnusualendMod.class);
	public static final String MODID = "unusualend";

	public UnusualendMod() {
		// Start of user code block mod constructor
		// End of user code block mod constructor
		MinecraftForge.EVENT_BUS.register(this);
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		UnusualendModSounds.REGISTRY.register(bus);
		UnusualendModBlocks.REGISTRY.register(bus);
		UnusualendModBlockEntities.REGISTRY.register(bus);
		UnusualendModItems.REGISTRY.register(bus);
		UnusualendModEntities.REGISTRY.register(bus);
		UnusualendModEnchantments.REGISTRY.register(bus);
		UnusualendModTabs.REGISTRY.register(bus);
		UnusualendModFeatures.REGISTRY.register(bus);
		StructureFeature.REGISTRY.register(bus);
		UnusualendModMobEffects.REGISTRY.register(bus);
		UnusualendModPotions.REGISTRY.register(bus);
		UnusualendModPaintings.REGISTRY.register(bus);
		UnusualendModParticleTypes.REGISTRY.register(bus);

		UnusualendModMenus.REGISTRY.register(bus);
		// Start of user code block mod init
		// End of user code block mod init
	}

	// Start of user code block mod methods
	// End of user code block mod methods
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	private static int messageID = 0;

	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
			workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
	}

	@SubscribeEvent
	public void tick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
			workQueue.forEach(work -> {
				work.setValue(work.getValue() - 1);
				if (work.getValue() == 0)
					actions.add(work);
			});
			actions.forEach(e -> e.getKey().run());
			workQueue.removeAll(actions);
		}
	}
}

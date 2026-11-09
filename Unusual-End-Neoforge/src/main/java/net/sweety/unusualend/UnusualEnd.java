package net.sweety.unusualend;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStoppedEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.sweety.unusualend.configuration.UEConfig;
import net.sweety.unusualend.init.*;
import net.sweety.unusualend.network.UnusualEndVariables;
import net.sweety.unusualend.world.features.StructureFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Mod("unusualend")
public class UnusualEnd {
    public static final Logger LOGGER = LogManager.getLogger(UnusualEnd.class);
    public static final String MODID = "unusualend";

    public UnusualEnd(IEventBus bus, ModContainer container) {
        NeoForge.EVENT_BUS.addListener(this::tick);
        NeoForge.EVENT_BUS.addListener(this::onServerStopped);
        UnusualEndSounds.REGISTRY.register(bus);
        UnusualEndBlocks.REGISTRY.register(bus);
        UnusualEndBlockEntities.REGISTRY.register(bus);
        UnusualEndItems.REGISTRY.register(bus);
        UnusualEndEntities.REGISTRY.register(bus);
        UnusualEndTabs.REGISTRY.register(bus);
        StructureFeature.REGISTRY.register(bus);
        UnusualEndPotions.REGISTRY.register(bus);
        UnusualEndVariables.ATTACHMENT_TYPES.register(bus);
        UnusualEndStructures.STRUCTURES.register(bus);
        UnusualEndMiscRegister.register(bus);
        container.registerConfig(ModConfig.Type.COMMON, UEConfig.SPEC, "unusualend-common.toml");
    }

    public static ResourceLocation makeUEID(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    private static final Queue<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

    public static void queueServerWork(int tick, Runnable action) {
        MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
        if (server == null || !server.isSameThread())
            return;
        workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
    }

    private void onServerStopped(ServerStoppedEvent event) {
        workQueue.clear();
    }

    public void tick(ServerTickEvent.Post event) {
        if (workQueue.isEmpty()) return;
        List<AbstractMap.SimpleEntry<Runnable, Integer>> currentWork = new ArrayList<>();
        AbstractMap.SimpleEntry<Runnable, Integer> work;
        while ((work = workQueue.poll()) != null)
            currentWork.add(work);
        List<AbstractMap.SimpleEntry<Runnable, Integer>> delayedBacklog = new ArrayList<>();
        for (AbstractMap.SimpleEntry<Runnable, Integer> entry : currentWork) {
            entry.setValue(entry.getValue() - 1);
            if (entry.getValue() <= 0) {
                try {
                    entry.getKey().run();
                } catch (RuntimeException exception) {
                    LOGGER.error("Failed to run delayed Unusual End task", exception);
                }
            } else {
                delayedBacklog.add(entry);
            }
        }
        workQueue.addAll(delayedBacklog);
    }
}
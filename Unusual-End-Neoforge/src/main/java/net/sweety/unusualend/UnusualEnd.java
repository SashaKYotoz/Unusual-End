package net.sweety.unusualend;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.sweety.unusualend.configuration.UEConfig;
import net.sweety.unusualend.init.*;
import net.sweety.unusualend.network.UnusualEndVariables;
import net.sweety.unusualend.world.features.StructureFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

@Mod("unusualend")
public class UnusualEnd {
    public static final Logger LOGGER = LogManager.getLogger(UnusualEnd.class);
    public static final String MODID = "unusualend";

    public UnusualEnd(IEventBus bus, ModContainer container) {
        NeoForge.EVENT_BUS.addListener(this::tick);
        UnusualEndSounds.REGISTRY.register(bus);
        UnusualEndBlocks.REGISTRY.register(bus);
        UnusualendModBlockEntities.REGISTRY.register(bus);
        UnusualEndItems.REGISTRY.register(bus);
        UnusualendModEntities.REGISTRY.register(bus);
        UnusualendModTabs.REGISTRY.register(bus);
        StructureFeature.REGISTRY.register(bus);
        UnusualEndPotions.REGISTRY.register(bus);
        UnusualEndVariables.ATTACHMENT_TYPES.register(bus);
        UnusualendStructures.STRUCTURES.register(bus);
        UnusualEndMiscRegister.register(bus);
        container.registerConfig(ModConfig.Type.COMMON, UEConfig.SPEC, "unusualend-common.toml");
    }

    public static ResourceLocation makeUEID(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    private static final Queue<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

    public static void queueServerWork(int tick, Runnable action) {
        workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
    }

    public void tick(ServerTickEvent.Post event) {
        if (workQueue.isEmpty()) return;
        List<AbstractMap.SimpleEntry<Runnable, Integer>> delayedBacklog = new ArrayList<>();
        AbstractMap.SimpleEntry<Runnable, Integer> work;
        while ((work = workQueue.poll()) != null) {
            work.setValue(work.getValue() - 1);
            if (work.getValue() <= 0) {
                work.getKey().run();
            } else {
                delayedBacklog.add(work);
            }
        }
        workQueue.addAll(delayedBacklog);
    }
}
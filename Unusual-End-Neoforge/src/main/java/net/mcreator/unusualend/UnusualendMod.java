package net.mcreator.unusualend;

import net.mcreator.unusualend.init.*;
import net.mcreator.unusualend.network.UnusualendModVariables;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.network.handling.IPlayPayloadHandler;
import net.neoforged.neoforge.network.registration.IPayloadRegistrar;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.unusualend.world.features.StructureFeature;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

@Mod("unusualend")
public class UnusualendMod {
    public static final Logger LOGGER = LogManager.getLogger(UnusualendMod.class);
    public static final String MODID = "unusualend";

    public UnusualendMod(IEventBus bus) {
        NeoForge.EVENT_BUS.addListener(this::tick);
        bus.addListener(this::registerNetworking);
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
        UnusualendModParticleTypes.REGISTRY.register(bus);
        UnusualendModLootModifier.LOOT_MODIFIERS.register(bus);
        UnusualendModMiscRegister.SERIALIZERS.register(bus);
        UnusualendModMiscRegister.PAINTINGS.register(bus);
        UnusualendModMenus.REGISTRY.register(bus);
        UnusualendCapabilities.ATTACHMENT_TYPE.register(bus);
        UnusualendModVariables.ATTACHMENT_TYPES.register(bus);
    }

    private static boolean networkingRegistered = false;
    private static final Map<ResourceLocation, NetworkMessage<?>> MESSAGES = new HashMap<>();

    private record NetworkMessage<T extends CustomPacketPayload>(FriendlyByteBuf.Reader<T> reader,
                                                                 IPlayPayloadHandler<T> handler) {
    }

    public static <T extends CustomPacketPayload> void addNetworkMessage(ResourceLocation id, FriendlyByteBuf.Reader<T> reader, IPlayPayloadHandler<T> handler) {
        if (networkingRegistered)
            throw new IllegalStateException("Cannot register new network messages after networking has been registered");
        MESSAGES.put(id, new NetworkMessage<>(reader, handler));
    }

    @SuppressWarnings({"rawtypes", "unchecked"})

    private void registerNetworking(final RegisterPayloadHandlerEvent event) {
        final IPayloadRegistrar registrar = event.registrar(MODID);
        MESSAGES.forEach((id, networkMessage) -> registrar.play(id, ((NetworkMessage) networkMessage).reader(), networkMessage.handler()));
        networkingRegistered = true;
    }

    private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

    public static void queueServerWork(int tick, Runnable action) {
        workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
    }

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
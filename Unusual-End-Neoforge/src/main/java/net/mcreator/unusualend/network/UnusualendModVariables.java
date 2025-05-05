package net.mcreator.unusualend.network;


import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;

import net.mcreator.unusualend.UnusualendMod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.EntityCapability;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.common.util.FakePlayer;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.items.wrapper.PlayerInvWrapper;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.network.handlers.ClientPayloadHandler;
import net.neoforged.neoforge.network.handlers.ServerPayloadHandler;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import net.neoforged.neoforge.network.registration.IPayloadRegistrar;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Optional;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusualendModVariables {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, UnusualendMod.MODID);
    public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(PlayerVariables::new).build());


    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        UnusualendMod.addNetworkMessage(PlayerVariablesSyncMessage.ID, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handleData);
    }


    @Mod.EventBusSubscriber

    public static class EventBusVariableHandlers {

        @SubscribeEvent

        public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
            if (event.getEntity() instanceof ServerPlayer player)
                player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
        }


        @SubscribeEvent

        public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {

            if (event.getEntity() instanceof ServerPlayer player)

                player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());

        }


        @SubscribeEvent

        public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {

            if (event.getEntity() instanceof ServerPlayer player)

                player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());

        }


        @SubscribeEvent

        public static void clonePlayer(PlayerEvent.Clone event) {

            PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);

            PlayerVariables clone = new PlayerVariables();

            clone.PlayerMusic = original.PlayerMusic;

            if (!event.isWasDeath()) {

            }
            event.getEntity().setData(PLAYER_VARIABLES, clone);
        }
    }


    public static class PlayerVariables implements INBTSerializable<CompoundTag> {

        public double tpX = 0;
        public double tpY = 0;
        public double tpZ = 0;
        public boolean isTeleporting = false;
        public double PlayerMusic = -1.0;
        public double SpectralSwing = 0;
        public double ScrapeOverlay = 0;


        @Override

        public CompoundTag serializeNBT() {
            CompoundTag nbt = new CompoundTag();
            nbt.putDouble("tpX", tpX);
            nbt.putDouble("tpY", tpY);
            nbt.putDouble("tpZ", tpZ);
            nbt.putBoolean("isTeleporting", isTeleporting);
            nbt.putDouble("PlayerMusic", PlayerMusic);
            nbt.putDouble("SpectralSwing", SpectralSwing);
            nbt.putDouble("ScrapeOverlay", ScrapeOverlay);
            return nbt;
        }

        @Override

        public void deserializeNBT(CompoundTag nbt) {
            tpX = nbt.getDouble("tpX");
            tpY = nbt.getDouble("tpY");
            tpZ = nbt.getDouble("tpZ");
            isTeleporting = nbt.getBoolean("isTeleporting");
            PlayerMusic = nbt.getDouble("PlayerMusic");
            SpectralSwing = nbt.getDouble("SpectralSwing");
            ScrapeOverlay = nbt.getDouble("ScrapeOverlay");
        }


        public void syncPlayerVariables(Entity entity) {
            if (entity instanceof ServerPlayer serverPlayer)
                PacketDistributor.PLAYER.with(serverPlayer).send(new PlayerVariablesSyncMessage(this));
        }
    }


    public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {

        public static final ResourceLocation ID = new ResourceLocation(UnusualendMod.MODID, "player_variables_sync");


        public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {

            this(new PlayerVariables());

            this.data().deserializeNBT(buffer.readNbt());

        }

        @Override

        public void write(final FriendlyByteBuf buffer) {
            buffer.writeNbt(data.serializeNBT());
        }

        @Override
        public ResourceLocation id() {
            return ID;
        }


        public static void handleData(final PlayerVariablesSyncMessage message, final PlayPayloadContext context) {

            if (context.flow() == PacketFlow.CLIENTBOUND && message.data() != null) {

                context.workHandler().submitAsync(() -> Minecraft.getInstance().player.getData(PLAYER_VARIABLES).deserializeNBT(message.data().serializeNBT())).exceptionally(e -> {

                    context.packetHandler().disconnect(Component.translatable(e.getLocalizedMessage()));

                    return null;

                });

            }
        }
    }
}

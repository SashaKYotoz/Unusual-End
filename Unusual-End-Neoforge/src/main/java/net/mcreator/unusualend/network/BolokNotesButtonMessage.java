package net.mcreator.unusualend.network;

import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.world.inventory.BolokNotesMenu;
import net.mcreator.unusualend.UnusualendMod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;

import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BolokNotesButtonMessage implements CustomPacketPayload {
    private final int buttonID, x, y, z;
    public static final ResourceLocation ID = new ResourceLocation(UnusualendMod.MODID, "bolok_notes_button_message_id");

    public BolokNotesButtonMessage(FriendlyByteBuf buffer) {
        this.buttonID = buffer.readInt();
        this.x = buffer.readInt();
        this.y = buffer.readInt();
        this.z = buffer.readInt();
    }

    public BolokNotesButtonMessage(int buttonID, int x, int y, int z) {
        this.buttonID = buttonID;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void write(FriendlyByteBuf buffer) {
        buffer.writeInt(this.buttonID);
        buffer.writeInt(this.x);
        buffer.writeInt(this.y);
        buffer.writeInt(this.z);
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }

    public static void handler(BolokNotesButtonMessage message, final PlayPayloadContext context) {
        if (context.flow() == PacketFlow.SERVERBOUND) {
            context.workHandler().submitAsync(() -> {
                Player entity = context.player().get();
                int buttonID = message.buttonID;
                int x = message.x;
                int y = message.y;
                int z = message.z;
                handleButtonAction(entity, buttonID, x, y, z);
            }).exceptionally(e -> {
                context.packetHandler().disconnect(Component.literal(e.getLocalizedMessage()));
                return null;
            });
        }
    }

    public static void handleButtonAction(Player player, int buttonID, int x, int y, int z) {
        Level world = player.level();
        HashMap guistate = BolokNotesMenu.guistate;
        // security measure to prevent arbitrary chunk generation
        if (!world.hasChunkAt(new BlockPos(x, y, z)))
            return;
        if (buttonID == 0)
            player.closeContainer();
    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        UnusualendMod.addNetworkMessage(ID, BolokNotesButtonMessage::new, BolokNotesButtonMessage::handler);
    }
}
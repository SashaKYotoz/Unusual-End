
package net.mcreator.unusualend.network;

import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.procedures.ConsumeShinyProcedure;
import net.mcreator.unusualend.procedures.ConsumePrismaticProcedure;
import net.mcreator.unusualend.procedures.ConsumeCitrineProcedure;
import net.mcreator.unusualend.UnusualEnd;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class InfuserGUIButtonMessage implements CustomPacketPayload {
    private final int buttonID, x, y, z;
    public static final ResourceLocation ID = UnusualEnd.makeUEID("infuser_gui_button_message_id");

    public InfuserGUIButtonMessage(FriendlyByteBuf buffer) {
        this.buttonID = buffer.readInt();
        this.x = buffer.readInt();
        this.y = buffer.readInt();
        this.z = buffer.readInt();
    }

    public InfuserGUIButtonMessage(int buttonID, int x, int y, int z) {
        this.buttonID = buttonID;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void handler(InfuserGUIButtonMessage message, final PlayPayloadContext context) {
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

    public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
        Level world = entity.level();
        if (!world.hasChunkAt(new BlockPos(x, y, z)))
            return;
        if (buttonID == 0) {
            ConsumeCitrineProcedure.execute(world, x, y, z, entity, 1);
        }
        if (buttonID == 1) {
            ConsumeShinyProcedure.execute(world, x, y, z, entity, 1);
        }
        if (buttonID == 2) {
            ConsumePrismaticProcedure.execute(world, x, y, z, entity, 1);
        }
        if (buttonID == 3) {
            ConsumeCitrineProcedure.execute(world, x, y, z, entity, 4);
        }
        if (buttonID == 4) {
            ConsumeShinyProcedure.execute(world, x, y, z, entity, 4);
        }
        if (buttonID == 5) {
            ConsumePrismaticProcedure.execute(world, x, y, z, entity, 4);
        }
        if (buttonID == 6) {
            ConsumeCitrineProcedure.execute(world, x, y, z, entity, 8);
        }
        if (buttonID == 7) {
            ConsumeShinyProcedure.execute(world, x, y, z, entity, 8);
        }
        if (buttonID == 8) {
            ConsumePrismaticProcedure.execute(world, x, y, z, entity, 8);
        }
    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        UnusualEnd.addNetworkMessage(ID, InfuserGUIButtonMessage::new, InfuserGUIButtonMessage::handler);
    }

    @Override
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
}

package net.mcreator.unusualend.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.world.inventory.InfuserGUIMenu;
import net.mcreator.unusualend.procedures.ConsumeShinyProcedure;
import net.mcreator.unusualend.procedures.ConsumePrismaticProcedure;
import net.mcreator.unusualend.procedures.ConsumeCitrineProcedure;
import net.mcreator.unusualend.UnusualendMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class InfuserGUIButtonMessage {
	private final int buttonID, x, y, z;

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

	public static void buffer(InfuserGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(InfuserGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = InfuserGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
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
		UnusualendMod.addNetworkMessage(InfuserGUIButtonMessage.class, InfuserGUIButtonMessage::buffer, InfuserGUIButtonMessage::new, InfuserGUIButtonMessage::handler);
	}
}

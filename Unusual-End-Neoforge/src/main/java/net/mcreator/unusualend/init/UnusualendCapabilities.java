package net.mcreator.unusualend.init;

import net.mcreator.unusualend.UnusualEnd;
import net.mcreator.unusualend.block.entity.*;
import net.mcreator.unusualend.item.inventory.BolokResearchNotesInventoryCapability;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusualendCapabilities {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPE = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, UnusualEnd.MODID);
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<BolokResearchNotesInventoryCapability>> BOLOK_NOTE_INVENTORY = ATTACHMENT_TYPE.register("bolok_note_inventory", () -> AttachmentType.serializable(BolokResearchNotesInventoryCapability::new).build());

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerItem(Capabilities.ItemHandler.ITEM, (stack, content) -> stack.getData(BOLOK_NOTE_INVENTORY), UnusualendModItems.BOLOK_RESEARCH_NOTES.get());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UnusualendModBlockEntities.ANCIENT_PODIUM.get(), (block, side) -> ((AncientPodiumBlockEntity) block).getHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UnusualendModBlockEntities.PURPUR_TANK.get(), (block, side) -> ((PurpurTankBlockEntity) block).getHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UnusualendModBlockEntities.GLOOPSLATE_PEDESTRAL.get(), (block, side) -> ((GloopslatePedestralBlockEntity) block).getHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UnusualendModBlockEntities.BUILDING_INHIBITOR.get(), (block, side) -> ((BuildingInhibitorBlockEntity) block).getHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UnusualendModBlockEntities.FADING_BLOCK.get(), (block, side) -> ((FadingBlockBlockEntity) block).getHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UnusualendModBlockEntities.PEARLESCENT_INFUSER.get(), (block, side) -> ((PearlescentInfuserBlockEntity) block).getHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UnusualendModBlockEntities.WARPED_CHEST.get(), (block, side) -> ((WarpedChestBlockEntity) block).getHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UnusualendModBlockEntities.WARPING_WAYSTONE.get(), (block, side) -> ((WarpingWaystoneBlockEntity) block).getHandler());
    }
}
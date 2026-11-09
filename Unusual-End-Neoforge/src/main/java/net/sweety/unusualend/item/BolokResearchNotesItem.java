package net.sweety.unusualend.item;

import io.netty.buffer.Unpooled;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.capabilities.ItemCapability;
import net.neoforged.neoforge.items.IItemHandler;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.procedures.BolokResearchNotesRightclickedProcedure;
import net.sweety.unusualend.world.inventory.BolokNotesMenu;

import java.util.List;

public class BolokResearchNotesItem extends Item {
    public static final ItemCapability<IItemHandler, Void> NOTES_ITEM_HANDLER =
            ItemCapability.createVoid(
                    UnusualEnd.makeUEID("notes_item_handler"),
                    IItemHandler.class);

    public BolokResearchNotesItem() {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
    }

    @Override
    public void appendHoverText(ItemStack itemstack, TooltipContext context, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, context, list, flag);
        list.add(Component.translatable("tooltip.unusualend.bolok_research_notes.0"));
        list.add(Component.translatable("tooltip.unusualend.bolok_research_notes.1"));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player pPlayer, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(level, pPlayer, hand);
        if (pPlayer instanceof ServerPlayer serverPlayer) {
            serverPlayer.openMenu(new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return Component.translatable("tooltip.unusualend.bolok_research_notes.2");
                }

                @Override
                public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                    FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                    packetBuffer.writeBlockPos(pPlayer.blockPosition());
                    packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
                    return new BolokNotesMenu(id, inventory, packetBuffer);
                }
            }, buf -> {
                buf.writeBlockPos(pPlayer.blockPosition());
                buf.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
            });
        }
        BolokResearchNotesRightclickedProcedure.execute(level, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), pPlayer);
        return ar;
    }
}

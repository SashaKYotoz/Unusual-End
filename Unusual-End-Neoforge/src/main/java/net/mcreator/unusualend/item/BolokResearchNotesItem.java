package net.mcreator.unusualend.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.unusualend.world.inventory.BolokNotesMenu;
import net.mcreator.unusualend.procedures.BolokResearchNotesRightclickedProcedure;

import java.util.List;

import io.netty.buffer.Unpooled;

public class BolokResearchNotesItem extends Item {
    public BolokResearchNotesItem() {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, level, list, flag);
        list.add(Component.literal("\u00A78Detailled explanations of the"));
        list.add(Component.literal("\u00A78Bolok's related mechanics"));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player pPlayer, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, pPlayer, hand);
        if (pPlayer instanceof ServerPlayer serverPlayer) {
            serverPlayer.openMenu(new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return Component.literal("Boloks Research Notes");
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
        BolokResearchNotesRightclickedProcedure.execute(world, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), pPlayer);
        return ar;
    }
}


package net.mcreator.unusualend.item.inventory;

import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.unusualend.init.UnusualendModItems;
import net.mcreator.unusualend.client.gui.BolokNotesScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.neoforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class BolokResearchNotesInventoryCapability extends ItemStackHandler {
    public BolokResearchNotesInventoryCapability() {
        super(1);
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onItemDropped(ItemTossEvent event) {
        if (event.getEntity().getItem().getItem() == UnusualendModItems.BOLOK_RESEARCH_NOTES.get()) {
            if (Minecraft.getInstance().screen instanceof BolokNotesScreen) {
                Minecraft.getInstance().player.closeContainer();
            }
        }
    }

    @Override
    public int getSlotLimit(int slot) {
        return 64;
    }

    @Override
    public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
        return stack.getItem() != UnusualendModItems.BOLOK_RESEARCH_NOTES.get();
    }

    @Override
    public void setSize(int size) {
    }
}

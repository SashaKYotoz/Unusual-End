
package net.sweety.unusualend.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.sweety.unusualend.procedures.NBTProcessor;
import net.sweety.unusualend.procedures.VoidTotemItemInInventoryTickProcedure;

public class VoidTotemItem extends Item {
    public VoidTotemItem() {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).component(DataComponents.CUSTOM_DATA, CustomData.EMPTY));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemstack) {
        return UseAnim.EAT;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isFoil(ItemStack stack) {
        return NBTProcessor.getNBTBoolean(stack, "LinkedMirror") || NBTProcessor.getNBTBoolean(stack, "LinkedTotem");
    }

    @Override
    public void inventoryTick(ItemStack itemstack, Level level, Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemstack, level, entity, slot, selected);
        if (entity instanceof Player && slot >= 0 && slot <= 40)
            VoidTotemItemInInventoryTickProcedure.execute(level, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
    }
}

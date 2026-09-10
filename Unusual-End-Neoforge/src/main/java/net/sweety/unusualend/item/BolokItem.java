
package net.sweety.unusualend.item;

import com.google.common.collect.Iterables;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.init.UnusualEndMiscRegister;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class BolokItem extends ArmorItem {
    public BolokItem(ArmorItem.Type type, Item.Properties properties) {
        super(ModArmorMaterials.BOLOK_ARMOR_MATERIAL, type, properties.stacksTo(1));
    }

    public static class Chestplate extends BolokItem {
        public Chestplate() {
            super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
        }

        @Override
        public void appendHoverText(ItemStack itemstack, TooltipContext context, List<Component> list, TooltipFlag flag) {
            super.appendHoverText(itemstack, context, list, flag);
            list.add(Component.translatable("lore.unusualend.when_hurt").withStyle(ChatFormatting.GRAY));
            list.add(Component.literal("\u00A79Speed (0:03)"));
            list.add(Component.literal("\u00A79Inflict Heaviness II (0:03)"));
            list.add(Component.translatable("lore.unusualend.to_attacker").withStyle(ChatFormatting.BLUE));
        }

        @Override
        public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
            return UnusualEnd.makeUEID("textures/models/armor/warped_bolok__layer_1.png");
        }
    }

    public static class Boots extends BolokItem {
        public Boots() {
            super(ArmorItem.Type.BOOTS, new Item.Properties());
        }

        @Override
        public void appendHoverText(ItemStack itemstack, TooltipContext context, List<Component> list, TooltipFlag flag) {
            super.appendHoverText(itemstack, context, list, flag);
            list.add(Component.translatable("lore.unusualend.warped_boot_1").withStyle(ChatFormatting.BLUE));
            list.add(Component.translatable("lore.unusualend.warped_boot_2").withStyle(ChatFormatting.BLUE));
        }

        @Override
        public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
            return UnusualEnd.makeUEID("textures/models/armor/warped_bolok__layer_1.png");
        }

        @Override
        public void inventoryTick(ItemStack itemstack, Level level, Entity entity, int slot, boolean selected) {
            super.inventoryTick(itemstack, level, entity, slot, selected);
            if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)
                    && level instanceof ServerLevel serverLevel)
                serverLevel.sendParticles(UnusualEndMiscRegister.BOLOK_PARTICLE.get(), entity.getX(), entity.getY() + 0.1, entity.getZ(), 1, 0.2, 0.2, 0.2, 0);
        }
    }
}

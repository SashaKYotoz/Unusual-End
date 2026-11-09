
package net.sweety.unusualend.item;

import com.google.common.collect.Iterables;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.procedures.EnderlingScrapLeggingsTickEventProcedure;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class EnderlingScrapItem extends ArmorItem {
	public EnderlingScrapItem(ArmorItem.Type type, Item.Properties properties) {
		super(ModArmorMaterials.ENDERLING_ARMOR_MATERIAL, type, properties);
	}

	public static class Leggings extends EnderlingScrapItem {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.translatable("lore.unusualend.when_sprint").withStyle(ChatFormatting.GRAY));
			list.add(Component.translatable("tooltip.unusualend.enderling_scrap.0").withStyle(ChatFormatting.BLUE));
		}

		@Override
		public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
			return UnusualEnd.makeUEID("textures/models/armor/ender_scrap__layer_2.png");
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				EnderlingScrapLeggingsTickEventProcedure.execute(entity);
			}
		}
	}
}
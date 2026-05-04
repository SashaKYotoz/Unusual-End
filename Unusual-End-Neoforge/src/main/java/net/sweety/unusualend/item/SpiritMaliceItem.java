
package net.sweety.unusualend.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.client.model.ModelSpiritMaskBase;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public abstract class SpiritMaliceItem extends ArmorItem {
	public SpiritMaliceItem(ArmorItem.Type type, Item.Properties properties) {
		super(ModArmorMaterials.SPIRIT_ARMOR_MATERIAL, type, properties);
	}

	public static class Helmet extends SpiritMaliceItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties());
		}
		@SuppressWarnings("removal")
		@Override
		public void initializeClient(Consumer<IClientItemExtensions> consumer) {
			consumer.accept(new IClientItemExtensions() {
				@Override
				public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
					HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(),
							Map.of("head", new ModelSpiritMaskBase(Minecraft.getInstance().getEntityModels().bakeLayer(ModelSpiritMaskBase.LAYER_LOCATION)).head, "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body",
									new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm",
									new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg",
									new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
					armorModel.crouching = living.isShiftKeyDown();
					armorModel.riding = defaultModel.riding;
					armorModel.young = living.isBaby();
					return armorModel;
				}
			});
		}

		@Override
		public void appendHoverText(ItemStack itemstack, TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.literal("\u00A77Malice"));
			list.add(Component.translatable("lore.unusualend.mask_1").withStyle(ChatFormatting.BLUE));
			list.add(Component.translatable("lore.unusualend.mask_2").withStyle(ChatFormatting.BLUE));
		}

		@Override
		public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
			return UnusualEnd.makeUEID("textures/entities/spirit_mask_malice.png");
		}

		@Override
		public boolean isEnderMask(ItemStack stack, Player player, EnderMan endermanEntity) {
			return true;
		}
	}
}

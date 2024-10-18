
package net.mcreator.unusualend.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.unusualend.procedures.BolokBootsBootsTickEventProcedure;
import net.mcreator.unusualend.init.UnusualendModItems;

import java.util.List;

import com.google.common.collect.Iterables;

public abstract class BolokBootsItem extends ArmorItem {
	public BolokBootsItem(ArmorItem.Type type, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForType(ArmorItem.Type type) {
				return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 30;
			}

			@Override
			public int getDefenseForType(ArmorItem.Type type) {
				return new int[]{2, 0, 8, 0}[type.getSlot().getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 12;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_leather"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(UnusualendModItems.BOLOK_SCALE.get()));
			}

			@Override
			public String getName() {
				return "warped";
			}

			@Override
			public float getToughness() {
				return 0f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.3f;
			}
		}, type, properties);
	}

	public static class Chestplate extends BolokBootsItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("\u00A77When Hurt:"));
			list.add(Component.literal("\u00A79Speed (0:03)"));
			list.add(Component.literal("\u00A79Inflict Heaviness II (0:03)"));
			list.add(Component.literal("\u00A79to the Attacker"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "unusualend:textures/models/armor/warped_bolok__layer_1.png";
		}
	}

	public static class Boots extends BolokBootsItem {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("\u00A79Allows to walk on"));
			list.add(Component.literal("\u00A79Warped Bubbles"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "unusualend:textures/models/armor/warped_bolok__layer_1.png";
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				BolokBootsBootsTickEventProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ());
			}
		}
	}
}

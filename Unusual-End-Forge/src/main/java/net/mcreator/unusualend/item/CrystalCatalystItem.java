//lore + block rclick
package net.mcreator.unusualend.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import net.mcreator.unusualend.procedures.CrystalCatalystRightclickedProcedure;
import net.mcreator.unusualend.procedures.CrystalCatalystItemInInventoryTickProcedure;
import net.mcreator.unusualend.init.UnusualendModEnchantments;

import java.util.Set;
import java.util.List;

import com.google.common.collect.ImmutableSet;

public class CrystalCatalystItem extends Item {
	public CrystalCatalystItem() {
		super(new Item.Properties().durability(64).rarity(Rarity.UNCOMMON));
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		Set e = ImmutableSet.of(Enchantments.UNBREAKING, UnusualendModEnchantments.ARCANE_RECOVERY.get());
		return e.contains(enchantment);
	}

	@Override
	public int getEnchantmentValue() {
		return 8;
	}

	@Override
	public boolean isEnchantable(ItemStack stack) {
		return true;
	}

	@Override
	public boolean isBarVisible(ItemStack stack) {
		if (stack.getDamageValue() > 0 || stack.getOrCreateTag().getDouble("cataCooldown") < 400 && stack.getOrCreateTag().getDouble("cataCooldown") > 0 || stack.getDamageValue() > 0 && stack.getOrCreateTag().getDouble("cataCooldown") < 400) {
			return true;
		}
		return false;
	}

	@Override
	public int getBarColor(ItemStack stack) {
		if (stack.getOrCreateTag().getDouble("cataCooldown") < 400) {
			return 11050480;
		}
		return Mth.hsvToRgb(Math.max(0.0F, 1.0F - (float) stack.getDamageValue() / stack.getMaxDamage()) / 3.0F, 1.0F, 1.0F);
	}

	@Override
	public int getBarWidth(ItemStack stack) {
		if (stack.getOrCreateTag().getDouble("cataCooldown") < 400) {
			return (int) (stack.getOrCreateTag().getDouble("cataCooldown") * 0.0025f * 14f);
		}
		return (int) Math.round(13.0F - (float) stack.getDamageValue() / stack.getMaxDamage() * 13.0F);
	}

	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return false;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		String buff = "none";
		super.appendHoverText(itemstack, world, list, flag);
		buff = (String) ((itemstack).getOrCreateTag().getString("buff"));
		if ((itemstack.getOrCreateTag().getString("buff")).equals("")) {
			itemstack.getOrCreateTag().putString("buff", Component.translatable("text.unusualend.no_buff_defined").getString());
		}
		list.add(Component.literal("\u00A77" + Component.translatable("lore.unusualend.when_rightclick").getString()));
		list.add(Component.literal("\u00A79" + Component.translatable("lore.unusualend.consume_effects").getString()));
		list.add(Component.literal("\u00A79" + Component.translatable("lore.unusualend.current_buff").getString()));
		list.add(Component.literal("\u00A79 - " + ((buff))));
		list.add(Component.literal("\u00A78" + Component.translatable("lore.unusualend.valid_blocs").getString()));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		CrystalCatalystRightclickedProcedure.execute(world, x, y, z, entity, itemstack);
		return ar;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		CrystalCatalystItemInInventoryTickProcedure.execute(itemstack);
	}
}

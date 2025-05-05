
package net.mcreator.unusualend.item;

import net.mcreator.unusualend.configuration.ConfigurationFileConfiguration;
import net.minecraft.ChatFormatting;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;

import net.mcreator.unusualend.procedures.WanderingStewPlayerFinishesUsingItemProcedure;

import java.util.List;

public class WanderingStewItem extends Item {
	public WanderingStewItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.6f).alwaysEat().build()));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		double minute = (ConfigurationFileConfiguration.STEW_TIME.get() / 60);
		double seconds = (ConfigurationFileConfiguration.STEW_TIME.get() - (Math.floor(minute) * 60));
		String time = new java.text.DecimalFormat("00").format(minute) + ":" + new java.text.DecimalFormat("00").format(seconds);
		list.add(Component.literal("\u00A77" + Component.translatable("lore.unusualend.another_dim").getString()));
		list.add(Component.literal("\u00A79" + Component.translatable("lore.unusualend.tp_overworld").getString()));
		list.add(Component.literal("\u00A77" + Component.translatable("lore.unusualend.in_overworld").getString()));
		list.add(Component.literal("\u00A79" + Component.translatable("effect.minecraft.invisibility").getString() + " (" + time + ")"));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = new ItemStack(Items.BOWL);
		super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		WanderingStewPlayerFinishesUsingItemProcedure.execute(world, x, y, z, entity);
		if (itemstack.isEmpty()) {
			return retval;
		} else {
			if (entity instanceof Player player && !player.getAbilities().instabuild) {
				if (!player.getInventory().add(retval))
					player.drop(retval, false);
			}
			return itemstack;
		}
	}
}

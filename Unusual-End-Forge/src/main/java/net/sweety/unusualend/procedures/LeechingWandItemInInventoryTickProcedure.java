package net.sweety.unusualend.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.init.UnusualendModEnchantments;
import net.sweety.unusualend.util.ProcedureHelper;

public class LeechingWandItemInInventoryTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("rayCooldown") < 400) {
			itemstack.getOrCreateTag().putDouble("rayCooldown", (itemstack.getOrCreateTag().getDouble("rayCooldown") + 1));
			if (EnchantmentHelper.getItemEnchantmentLevel(UnusualendModEnchantments.ARCANE_RECOVERY.get(), itemstack) != 0) {
				if (itemstack.getOrCreateTag().getDouble("rayCooldown") + 0.25 * itemstack.getEnchantmentLevel(UnusualendModEnchantments.ARCANE_RECOVERY.get()) >= 400) {
					itemstack.getOrCreateTag().putDouble("rayCooldown", 400);
				} else {
					itemstack.getOrCreateTag().putDouble("rayCooldown", (itemstack.getOrCreateTag().getDouble("rayCooldown") + 0.25 * itemstack.getEnchantmentLevel(UnusualendModEnchantments.ARCANE_RECOVERY.get())));
				}
			}
		} else {
			itemstack.getOrCreateTag().putDouble("rayCooldown", 400);
		}
		if (itemstack.getOrCreateTag().getBoolean("rayEnd")) {
			UnusualEnd.queueServerWork(20, () -> {
				if (itemstack.getOrCreateTag().getBoolean("rayEnd")) {
					if (!(ProcedureHelper.isCreative(entity))) {
						{
							ItemStack _ist = itemstack;
							if (_ist.hurt(1, world.getRandom(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					}
					itemstack.getOrCreateTag().putBoolean("rayEnd", false);
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), 10);
					itemstack.getOrCreateTag().putDouble("rayCooldown", 0);
				}
			});
		}
	}
}

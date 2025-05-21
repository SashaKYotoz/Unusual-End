package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.unusualend.init.UnusualendModEnchantments;
import net.mcreator.unusualend.UnusualEnd;

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
		if (itemstack.getOrCreateTag().getBoolean("rayEnd") == true) {
			UnusualEnd.queueServerWork(20, () -> {
				if (itemstack.getOrCreateTag().getBoolean("rayEnd") == true) {
					if (!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity))) {
						{
							ItemStack _ist = itemstack;
							if (_ist.hurt(1, RandomSource.create(), null)) {
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

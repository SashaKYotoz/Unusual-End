package net.sweety.unusualend.procedures;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.util.ProcedureHelper;

public class VoidRuneRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!entity.isShiftKeyDown()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualendModItems.VOID_RUNE.get()) {
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
			} else {
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.OFF_HAND, true);
			}
			if (entity instanceof Player _player)
				_player.giveExperiencePoints((int) itemstack.getOrCreateTag().getDouble("XP"));
			itemstack.getOrCreateTag().putDouble("XP", 0);
			if (world.isClientSide()) {
				ProcedureHelper.playSound(world, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1, 2);
			}
		}
	}
}

package net.sweety.unusualend.procedures;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.sweety.unusualend.init.UnusualEndItems;

public class VoidRuneRightclickedProcedure {
    public static void execute(Level level, Entity entity, ItemStack stack) {
        if (entity == null)
            return;
        if (!entity.isShiftKeyDown()) {
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualEndItems.VOID_RUNE.get()) {
                if (entity instanceof LivingEntity _entity)
                    _entity.swing(InteractionHand.MAIN_HAND, true);
            } else {
                if (entity instanceof LivingEntity _entity)
                    _entity.swing(InteractionHand.OFF_HAND, true);
            }
            if (entity instanceof Player player)
                player.giveExperiencePoints((int) NBTProcessor.getNBTDouble(stack, "XP"));
            NBTProcessor.setNBTDouble(stack, "XP", 0);
            if (level.isClientSide()) {
                level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1, 2, false);
            }
        }
    }
}

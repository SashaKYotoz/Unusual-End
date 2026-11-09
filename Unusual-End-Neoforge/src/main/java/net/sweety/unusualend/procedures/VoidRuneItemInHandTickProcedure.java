package net.sweety.unusualend.procedures;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.util.ProcedureHelper;

public class VoidRuneItemInHandTickProcedure {
    public static void execute(LevelAccessor world, Entity entity, ItemStack stack) {
        if (entity == null)
            return;
        if (entity.isShiftKeyDown()) {
            if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) > 0) {
                if (entity instanceof Player _player)
                    _player.giveExperiencePoints(-(5));
                NBTProcessor.setNBTDouble(stack, "XP", NBTProcessor.getNBTDouble(stack, "XP") + 5);
                NBTProcessor.setNBTDouble(stack,"XP", NBTProcessor.getNBTDouble(stack,"XP") + 5);
                if (world.isClientSide()) {
                    if (Math.random() < 0.2) {
                        ProcedureHelper.playSound(world, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.PLAYERS, (float) 0.1, (float) Mth.nextDouble(world.getRandom(), 0.5, 0.7));
                    }
                    ProcedureHelper.playSound(world, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.POINTED_DRIPSTONE_DRIP_LAVA_INTO_CAULDRON, SoundSource.PLAYERS, 1, (float) 0.5);
                }
            }
        }
    }
}

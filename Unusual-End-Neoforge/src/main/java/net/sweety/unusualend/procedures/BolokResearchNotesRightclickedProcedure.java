package net.sweety.unusualend.procedures;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.util.ProcedureHelper;

public class BolokResearchNotesRightclickedProcedure {
    public static void execute(Level level, double x, double y, double z, LivingEntity entity) {
        if (entity == null)
            return;
        ProcedureHelper.playSound(level, x, y, z, SoundEvents.BOOK_PAGE_TURN, SoundSource.PLAYERS, 1, 1);
        if (entity.getMainHandItem().is(UnusualEndItems.BOLOK_RESEARCH_NOTES.get())) {
            entity.swing(InteractionHand.MAIN_HAND, true);
        } else
            entity.swing(InteractionHand.OFF_HAND, true);
    }
}

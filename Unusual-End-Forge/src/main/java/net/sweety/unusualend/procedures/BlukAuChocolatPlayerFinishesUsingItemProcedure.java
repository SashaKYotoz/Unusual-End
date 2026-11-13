package net.sweety.unusualend.procedures;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import net.sweety.unusualend.config.Config;
import net.sweety.unusualend.util.ProcedureHelper;

public class BlukAuChocolatPlayerFinishesUsingItemProcedure {
    public static void execute(Level level, Entity entity) {
        if (entity == null)
            return;
        if (Config.CHOCOLAT_BLUK.get()) {
            ProcedureHelper.playSound(level, entity.getX(), entity.getY() + 2, entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("unusualend:flute_fishe")), SoundSource.PLAYERS, 1, 1);
        }
    }
}

package net.sweety.unusualend.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sweety.unusualend.BiomeMusicLibrary;
import net.sweety.unusualend.network.UnusualendModVariables;

@Mod.EventBusSubscriber
public class PlayerTickPlayMusicProcedure {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END)
            execute(event.player.level(), event.player);
    }

    private static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (world.isClientSide())
            BiomeMusicLibrary.PlayTrack((int) (entity.getCapability(UnusualendModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UnusualendModVariables.PlayerVariables())).PlayerMusic);
    }
}

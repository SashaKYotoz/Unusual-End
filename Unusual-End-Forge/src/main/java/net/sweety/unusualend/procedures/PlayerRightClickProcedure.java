package net.sweety.unusualend.procedures;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sweety.unusualend.entity.GlubEntity;

@Mod.EventBusSubscriber
public class PlayerRightClickProcedure {
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        if (event.getHand() != InteractionHand.MAIN_HAND || !player.isShiftKeyDown())
            return;
        if (player.getFirstPassenger() instanceof GlubEntity glub)
            glub.takeOff(player);
    }
}
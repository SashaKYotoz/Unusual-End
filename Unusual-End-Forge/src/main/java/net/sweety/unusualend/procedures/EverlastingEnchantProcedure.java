package net.sweety.unusualend.procedures;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sweety.unusualend.init.UnusualendModEnchantments;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.init.UnusualendModParticleTypes;

@Mod.EventBusSubscriber
public class EverlastingEnchantProcedure {
    @SubscribeEvent
    public static void onItemExpire(ItemExpireEvent event) {
        ItemEntity item = event.getEntity();
        ItemStack stack = item.getItem();
        boolean everlasting = stack.getEnchantmentLevel(UnusualendModEnchantments.EVERLASTING.get()) > 0;
        if (!everlasting && !stack.is(UnusualendModItems.GOLEM_ORB.get()))
            return;
        item.setUnlimitedLifetime();
        event.setCanceled(true);
        if (everlasting && item.level() instanceof ServerLevel level)
            level.sendParticles(UnusualendModParticleTypes.WARPED_BUBBLES.get(), item.getX(), item.getY(), item.getZ(), 10, 0.1, 0.1, 0.1, 0);
    }
}
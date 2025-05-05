package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.unusualend.init.UnusualendModParticleTypes;
import net.mcreator.unusualend.init.UnusualendModItems;
import net.mcreator.unusualend.init.UnusualendModEnchantments;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.item.ItemExpireEvent;

@Mod.EventBusSubscriber
public class EverlastingEnchantProcedure {
    @SubscribeEvent
    public static void onItemExpire(ItemExpireEvent event) {
        execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity().getItem());
    }

    private static void execute(ItemExpireEvent event, LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
        if (EnchantmentHelper.getItemEnchantmentLevel(UnusualendModEnchantments.EVERLASTING.get(), itemstack) != 0) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(UnusualendModParticleTypes.WARPED_BUBBLES.get(), x, y, z, 10, 0.1, 0.1, 0.1, 0);
            if (event != null) {
                event.setCanceled(true);
            }
        }
        if (itemstack.getItem() == UnusualendModItems.GOLEM_ORB.get()) {
            if (event != null) {
                event.setCanceled(true);
            }
        }
    }
}

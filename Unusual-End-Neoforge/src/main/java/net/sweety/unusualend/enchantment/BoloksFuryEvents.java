package net.sweety.unusualend.enchantment;

import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.init.UnusualEndEnchantments;

@EventBusSubscriber(modid = UnusualEnd.MODID, bus = EventBusSubscriber.Bus.GAME)
public class BoloksFuryEvents {
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onDamageDealt(LivingDamageEvent.Post event) {
        LivingEntity victim = event.getEntity();
        if (!(victim.level() instanceof ServerLevel level) || event.getNewDamage() <= 0)
            return;
        ItemStack weapon = event.getSource().getWeaponItem();
        if (weapon == null || weapon.isEmpty())
            return;
        int furyLevel = level.registryAccess().registryOrThrow(Registries.ENCHANTMENT)
                .getHolder(UnusualEndEnchantments.BOLOKS_FURY)
                .map(weapon::getEnchantmentLevel)
                .orElse(0);
        if (furyLevel <= 0)
            return;
        if (victim.getHealth() + event.getNewDamage() >= victim.getMaxHealth())
            BoloksFuryEnchantment.playFuryEffects(level, victim);
    }
}

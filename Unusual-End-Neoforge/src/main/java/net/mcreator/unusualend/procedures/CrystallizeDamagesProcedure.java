package net.mcreator.unusualend.procedures;

import net.minecraft.world.entity.LivingEntity;

import net.mcreator.unusualend.init.UnusualendModMobEffects;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingHurtEvent;

@Mod.EventBusSubscriber
public class CrystallizeDamagesProcedure {
    @SubscribeEvent
    public static void onEntityAttacked(LivingHurtEvent event) {
        if (event != null && event.getEntity() != null) {
            LivingEntity entity = event.getEntity();
            if (entity.hasEffect(UnusualendModMobEffects.CRYSTALLIZATION.get())) {
                entity.getPersistentData().putDouble("CrystalDamages", (entity.getPersistentData().getDouble("CrystalDamages") + event.getAmount()));
                event.setCanceled(true);
            }
        }
    }
}

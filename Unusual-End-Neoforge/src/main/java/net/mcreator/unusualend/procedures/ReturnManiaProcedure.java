package net.mcreator.unusualend.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.unusualend.init.UnusualendModItems;

public class ReturnManiaProcedure {
    public static boolean execute(LivingEntity entity) {
        if (entity == null)
            return false;
        return entity.getItemBySlot(EquipmentSlot.HEAD).is(UnusualendModItems.SPIRIT_MANIA_HELMET.get());
    }
}
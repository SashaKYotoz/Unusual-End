package net.sweety.unusualend.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.sweety.unusualend.init.UnusualendModEnchantments;
import net.sweety.unusualend.init.UnusualendModMobEffects;
import net.sweety.unusualend.util.ProcedureHelper;

public class WarpedSpearToolInHandTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (EnchantmentHelper.getItemEnchantmentLevel(UnusualendModEnchantments.JOUST.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
			if (entity.isPassenger()) {
				ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.DAMAGE_BOOST, 25, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(UnusualendModEnchantments.JOUST.get()) - 1,
							false, false));
				ProcedureHelper.addEffect(entity, new MobEffectInstance(UnusualendModMobEffects.SWIFT_STRIKES.get(), 25,
                            (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(UnusualendModEnchantments.JOUST.get()) - 1, false, false));
			}
		}
	}
}

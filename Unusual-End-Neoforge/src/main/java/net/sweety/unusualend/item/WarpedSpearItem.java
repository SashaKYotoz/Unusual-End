
package net.sweety.unusualend.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.sweety.unusualend.init.UnusualEndEnchantments;
import net.sweety.unusualend.init.UnusualEndMiscRegister;

public class WarpedSpearItem extends SwordItem {
    public WarpedSpearItem() {
        super(ModTiers.SPEAR, new Item.Properties().attributes(SwordItem.createAttributes(ModTiers.SPEAR, 8, -3.4f)));
    }

    @Override
    public void inventoryTick(ItemStack itemstack, Level level, Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemstack, level, entity, slot, selected);
        if (entity instanceof LivingEntity livingEntity && livingEntity.isPassenger()) {
            int enchantLevel = EnchantmentHelper.getTagEnchantmentLevel(level.holderOrThrow(UnusualEndEnchantments.JOUST), itemstack);
            if (enchantLevel != 0) {
                if (!livingEntity.level().isClientSide() && !livingEntity.hasEffect(MobEffects.DAMAGE_BOOST)) {
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 25, enchantLevel - 1,
                            false, false));
                    livingEntity.addEffect(new MobEffectInstance(UnusualEndMiscRegister.SWIFT_STRIKES, 25,
                            enchantLevel - 1, false, false));
                }
            }
        }
    }
}
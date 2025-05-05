
//clear lev
package net.mcreator.unusualend.item;

import net.mcreator.unusualend.init.UnusualendModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.unusualend.procedures.WarpedAnchorLivingEntityIsHitWithToolProcedure;

import java.util.List;

public class WarpedAnchorItem extends PickaxeItem {
    public WarpedAnchorItem() {
        super(new Tier() {
            public int getUses() {
                return 1561;
            }

            public float getSpeed() {
                return 7.5f;
            }

            public float getAttackDamageBonus() {
                return 13f;
            }

            public int getLevel() {
                return 3;
            }

            public int getEnchantmentValue() {
                return 12;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.of(new ItemStack(Blocks.IRON_BLOCK));
            }
        }, 1, -3.3f, new Item.Properties());
    }

    @Override
    public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        WarpedAnchorLivingEntityIsHitWithToolProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
        return super.hurtEnemy(itemstack, entity, sourceentity);
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("lore.unusualend.on_hit").withStyle(ChatFormatting.GRAY));
        list.add(Component.literal("Heaviness II (0:05)").withStyle(ChatFormatting.BLUE));
        list.add(Component.translatable("lore.unusualend.when_offhand").withStyle(ChatFormatting.GRAY));
        list.add(Component.translatable("lore.unusualend.clear_levitation").withStyle(ChatFormatting.BLUE));
    }

    @Override
    public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemstack, world, entity, slot, selected);
        if (entity instanceof LivingEntity livingEntity && livingEntity.getOffhandItem().is(UnusualendModItems.WARPED_ANCHOR.get())) {
            if (livingEntity.hasEffect(MobEffects.LEVITATION))
                livingEntity.removeEffect(MobEffects.LEVITATION);

        }
    }
}
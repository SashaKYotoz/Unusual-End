
package net.mcreator.unusualend.item;

import net.mcreator.unusualend.UnusualEnd;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class AncientShortbowItem extends Item {
    public AncientShortbowItem() {
        super(new Item.Properties().durability(1024).fireResistant().rarity(Rarity.UNCOMMON));
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
            list.add(Component.literal("\u00A78Hold when shooting"));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemstack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack itemstack) {
        return 1;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        entity.startUsingItem(hand);
        return InteractionResultHolder.success(entity.getItemInHand(hand));
    }

    @Override
    public void onUseTick(Level world, LivingEntity entity, ItemStack itemstack, int count) {
        if (!world.isClientSide() && entity instanceof ServerPlayer player) {
            itemstack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(entity.getUsedItemHand()));
            UnusualEnd.queueServerWork(20, () -> {
                if (!(player.getCooldowns().getCooldownPercent(itemstack.getItem(), 0f) * 100 > 0)) {
                    if (entity instanceof Player _player)
                        _player.getCooldowns().addCooldown(itemstack.getItem(), 40);
                }
            });
        }
        entity.releaseUsingItem();
    }
}

package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.configuration.UEConfig;
import net.sweety.unusualend.entity.WarpedBalloonProjEntity;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.init.UnusualendModEntities;

public class WarpedBalloonRangedItemShootsProjectileProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Player player, ItemStack itemstack) {
        player.getCooldowns().addCooldown(itemstack.getItem(), (int) (double) UEConfig.WARPED_BALLOON.get());
        if (!player.isCreative()) {
            itemstack.shrink(1);
        }
        if (player.getMainHandItem().is(UnusualEndItems.WARPED_BALLOON.get()))
            player.swing(InteractionHand.MAIN_HAND, true);
        else
            player.swing(InteractionHand.OFF_HAND, true);
        if (world instanceof Level _level) {
            if (!_level.isClientSide()) {
                _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, (float) 0.3, (float) 1.4);
            } else {
                _level.playLocalSound(x, y, z, SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, (float) 0.3, (float) 1.4, false);
            }
        }
        Level projectileLevel = player.level();
        if (!projectileLevel.isClientSide()) {
            Projectile projectile = new Object() {
                public Projectile getArrow(Level level, float damage) {
                    AbstractArrow entityToSpawn = new WarpedBalloonProjEntity(UnusualendModEntities.WARPED_BALLOON_PROJ.get(), level);
                    entityToSpawn.setBaseDamage(damage);
                    entityToSpawn.setSilent(true);
                    return entityToSpawn;
                }
            }.getArrow(projectileLevel, 0);
            projectile.setPos(player.getX(), player.getEyeY() - 0.1, player.getZ());
            projectile.shoot(player.getLookAngle().x, player.getLookAngle().y, player.getLookAngle().z, (float) 1.5, (float) 0.3);
            projectileLevel.addFreshEntity(projectile);
        }
    }
}
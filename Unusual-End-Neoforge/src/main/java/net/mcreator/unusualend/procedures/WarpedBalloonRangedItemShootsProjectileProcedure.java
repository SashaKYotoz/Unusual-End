package net.mcreator.unusualend.procedures;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModItems;
import net.mcreator.unusualend.init.UnusualendModEntities;
import net.mcreator.unusualend.entity.WarpedBalloonProjEntity;
import net.mcreator.unusualend.configuration.ConfigurationFileConfiguration;

public class WarpedBalloonRangedItemShootsProjectileProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Player player, ItemStack itemstack) {
        player.getCooldowns().addCooldown(itemstack.getItem(), (int) (double) ConfigurationFileConfiguration.WARPED_BALLOON.get());
        if (!player.isCreative()) {
            itemstack.shrink(1);
        }
        if (player.getMainHandItem().is(UnusualendModItems.WARPED_BALLOON.get()))
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
                public Projectile getArrow(Level level, float damage, int knockback) {
                    AbstractArrow entityToSpawn = new WarpedBalloonProjEntity(UnusualendModEntities.WARPED_BALLOON_PROJ.get(), level);
                    entityToSpawn.setBaseDamage(damage);
                    entityToSpawn.setKnockback(knockback);
                    entityToSpawn.setSilent(true);
                    return entityToSpawn;
                }
            }.getArrow(projectileLevel, 0, 0);
            projectile.setPos(player.getX(), player.getEyeY() - 0.1, player.getZ());
            projectile.shoot(player.getLookAngle().x, player.getLookAngle().y, player.getLookAngle().z, (float) 1.5, (float) 0.3);
            projectileLevel.addFreshEntity(projectile);
        }
    }
}
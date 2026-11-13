package net.sweety.unusualend.procedures;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.config.Config;
import net.sweety.unusualend.entity.WarpedBalloonProjEntity;
import net.sweety.unusualend.init.UnusualendModEntities;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.util.ProcedureHelper;

public class WarpedBalloonRangedItemShootsProjectileProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), (int) (double) Config.WARPED_BALLOON.get());
		if (!(ProcedureHelper.isCreative(entity))) {
			itemstack.shrink(1);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualendModItems.WARPED_BALLOON.get()) {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.OFF_HAND, true);
		}
		ProcedureHelper.playSound(world, x, y, z, SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, (float) 0.3, (float) 1.4);
		{
			Entity _shootFrom = entity;
			Level projectileLevel = _shootFrom.level();
			if (!projectileLevel.isClientSide()) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getArrow(Level level, float damage, int knockback) {
						AbstractArrow entityToSpawn = new WarpedBalloonProjEntity(UnusualendModEntities.WARPED_BALLOON_PROJ.get(), level);
						entityToSpawn.setBaseDamage(damage);
						entityToSpawn.setKnockback(knockback);
						entityToSpawn.setSilent(true);
						return entityToSpawn;
					}
				}.getArrow(projectileLevel, 0, 0);
				_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                Vec3 _look = _shootFrom.getLookAngle();
                _entityToSpawn.shoot(_look.x, _look.y, _look.z, 1.5f, 0.3f);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
		}
	}
}
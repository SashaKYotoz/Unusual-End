package net.sweety.unusualend.procedures;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sweety.unusualend.entity.BenevolentLeechingChargeProjectileEntity;
import net.sweety.unusualend.entity.BondLeechingChargeProjectileEntity;
import net.sweety.unusualend.entity.LeechingChargeProjectileEntity;
import net.sweety.unusualend.init.UnusualendModEnchantments;
import net.sweety.unusualend.init.UnusualendModEntities;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.util.ProcedureHelper;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class LeechingWandRightClickProcedure {
	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualendModItems.LEECHING_WAND.get()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("rayCooldown") >= 400) {
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				ProcedureHelper.playSound(world, x, y, z, SoundEvents.FIREWORK_ROCKET_LAUNCH, SoundSource.PLAYERS, 1, 2);
				if (EnchantmentHelper.getItemEnchantmentLevel(UnusualendModEnchantments.BONDING.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
									AbstractArrow entityToSpawn = new BondLeechingChargeProjectileEntity(UnusualendModEntities.BOND_LEECHING_CHARGE_PROJECTILE.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									entityToSpawn.setPierceLevel(piercing);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, 0, 0, (byte) 1);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                            Vec3 _look = _shootFrom.getLookAngle();
                            _entityToSpawn.shoot(_look.x, _look.y, _look.z, 3, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				} else if (EnchantmentHelper.getItemEnchantmentLevel(UnusualendModEnchantments.BENEVOLENCE.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
									AbstractArrow entityToSpawn = new BenevolentLeechingChargeProjectileEntity(UnusualendModEntities.BENEVOLENT_LEECHING_CHARGE_PROJECTILE.get(), level);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									entityToSpawn.setPierceLevel(piercing);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, 0, 0, (byte) 1);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                            Vec3 _look = _shootFrom.getLookAngle();
                            _entityToSpawn.shoot(_look.x, _look.y, _look.z, 3, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				} else {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
									AbstractArrow entityToSpawn = new LeechingChargeProjectileEntity(UnusualendModEntities.LEECHING_CHARGE_PROJECTILE.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									entityToSpawn.setPierceLevel(piercing);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, 0, 0, (byte) 1);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                            Vec3 _look = _shootFrom.getLookAngle();
                            _entityToSpawn.shoot(_look.x, _look.y, _look.z, 3, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putBoolean("rayEnd", true);
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == UnusualendModItems.LEECHING_WAND.get()) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
	}
}
package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.sweety.unusualend.entity.BenevolentLeechingChargeProjectileEntity;
import net.sweety.unusualend.entity.BondLeechingChargeProjectileEntity;
import net.sweety.unusualend.entity.LeechingChargeProjectileEntity;
import net.sweety.unusualend.init.UnusualEndEnchantments;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.init.UnusualEndEntities;

@EventBusSubscriber
public class LeechingWandRightClickProcedure {
    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
    }

    private static void execute(PlayerInteractEvent.RightClickItem event, LevelAccessor level, double x, double y, double z, Player player) {
        if (player == null)
            return;
        ItemStack stack = player.getMainHandItem();
        if (stack.is(UnusualEndItems.LEECHING_WAND.get())) {
            if (NBTProcessor.getNBTDouble(stack,"rayCooldown") >= 400) {
                player.swing(InteractionHand.MAIN_HAND, true);
                if (level instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.FIREWORK_ROCKET_LAUNCH, SoundSource.PLAYERS, 1, 2);
                    } else {
                        _level.playLocalSound(x, y, z, SoundEvents.FIREWORK_ROCKET_LAUNCH, SoundSource.PLAYERS, 1, 2, false);
                    }
                }
                if (EnchantmentHelper.getItemEnchantmentLevel(level.holderOrThrow(UnusualEndEnchantments.BENEVOLENCE), (player instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
                    Entity _shootFrom = player;
                    Level projectileLevel = _shootFrom.level();
                    if (!projectileLevel.isClientSide()) {
                        Projectile _entityToSpawn = new Object() {
                            public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                                AbstractArrow entityToSpawn = new BondLeechingChargeProjectileEntity(UnusualEndEntities.BOND_LEECHING_CHARGE_PROJECTILE.get(), level);
                                entityToSpawn.setOwner(shooter);
                                entityToSpawn.setBaseDamage(damage);
                                entityToSpawn.setSilent(true);
                                return entityToSpawn;
                            }
                        }.getArrow(projectileLevel, player, 0, 0, (byte) 1);
                        _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                        _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, 0);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }
                } else if (EnchantmentHelper.getTagEnchantmentLevel(level.holderOrThrow(UnusualEndEnchantments.BENEVOLENCE), (player instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
                    Level projectileLevel = player.level();
                    if (!projectileLevel.isClientSide()) {
                        Projectile _entityToSpawn = new Object() {
                            public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
                                AbstractArrow entityToSpawn = new BenevolentLeechingChargeProjectileEntity(UnusualEndEntities.BENEVOLENT_LEECHING_CHARGE_PROJECTILE.get(), level);
                                entityToSpawn.setBaseDamage(damage);
                                entityToSpawn.setSilent(true);
                                return entityToSpawn;
                            }
                        }.getArrow(projectileLevel, 0, 0, (byte) 1);
                        _entityToSpawn.setPos(player.getX(), player.getEyeY() - 0.1, player.getZ());
                        _entityToSpawn.shoot(player.getLookAngle().x, player.getLookAngle().y, player.getLookAngle().z, 3, 0);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }
                } else {
                    {
                        Entity _shootFrom = player;
                        Level projectileLevel = _shootFrom.level();
                        if (!projectileLevel.isClientSide()) {
                            Projectile _entityToSpawn = new Object() {
                                public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                                    AbstractArrow entityToSpawn = new LeechingChargeProjectileEntity(UnusualEndEntities.LEECHING_CHARGE_PROJECTILE.get(), level);
                                    entityToSpawn.setOwner(shooter);
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                }
                            }.getArrow(projectileLevel, player, 0, 0, (byte) 1);
                            _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                            _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, 0);
                            projectileLevel.addFreshEntity(_entityToSpawn);
                        }
                    }
                }
                NBTProcessor.setNBTBoolean(stack,"rayEnd",true);
            }
        } else if (player.getOffhandItem().getItem() == UnusualEndItems.LEECHING_WAND.get()) {
            if (event != null) {
                event.setCanceled(true);
            }
        }
    }
}

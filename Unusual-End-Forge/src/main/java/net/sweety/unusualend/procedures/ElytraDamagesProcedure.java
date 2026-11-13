package net.sweety.unusualend.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sweety.unusualend.init.UnusualendModEnchantments;
import net.sweety.unusualend.util.ParticleHelper;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.List;

@Mod.EventBusSubscriber
public class ElytraDamagesProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.isFallFlying()) {
			if (EnchantmentHelper.getItemEnchantmentLevel(UnusualendModEnchantments.BOLOKS_WINGS.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)) != 0) {
				if (Math.abs(entity.getDeltaMovement().x()) + Math.abs(entity.getDeltaMovement().y()) + Math.abs(entity.getDeltaMovement().z()) > 1.8) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entity == entityiterator)) {
								if (!(entity instanceof FireworkRocketEntity)) {
									entityiterator.invulnerableTime = 0;
									entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FLY_INTO_WALL)),
											(float) ((Math.abs(entity.getDeltaMovement().x()) + Math.abs(entity.getDeltaMovement().y()) + Math.abs(entity.getDeltaMovement().z()) + 1)
													* (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getEnchantmentLevel(UnusualendModEnchantments.BOLOKS_WINGS.get())));
								}
							}
						}
					}
					ParticleHelper.spawn(world, ParticleHelper.dustTransition(0.067f, 0.608f, 0.522f, 1.0f, 0.737f, 0.902f, 0.922f), new Vec3(x, y, z).add(0, 0.1, 0), 1, 0.4, 0.2, 0.4, 0);
					ParticleHelper.spawn(world, ParticleHelper.dustTransition(0.094f, 0.851f, 0.729f, 1.2f, 0.98f, 0.988f, 1.0f), new Vec3(x, y, z).add(0, 0.1, 0), 1, 0.4, 0.2, 0.4, 0);
				}
			}
		}
	}
}

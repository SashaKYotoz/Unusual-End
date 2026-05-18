package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.sweety.unusualend.configuration.UEConfig;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.init.UnusualEndMiscRegister;

import java.util.Comparator;
import java.util.List;

@EventBusSubscriber
public class OrbUseProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event != null)
			execute(event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	private static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xRadius = 0;
		double loop = 0;
		double zRadius = 0;
		double particleAmount = 0;
		if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(UnusualEndItems.GOLEM_ORB.get())) : false)
				|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(UnusualEndItems.BLAZING_ORB.get())) : false)
				|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(UnusualEndItems.SHULKER_ORB.get())) : false)
				|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(UnusualEndItems.WITHERING_ORB.get())) : false)) {
			if (entity instanceof Player) {
				if (Math.random() < UEConfig.ORB_TRIGGER.get() / 100) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.ZOMBIE_BREAK_WOODEN_DOOR, SoundSource.PLAYERS, 1, (float) 0.1);
						} else {
							_level.playLocalSound(x, y, z, SoundEvents.ZOMBIE_BREAK_WOODEN_DOOR, SoundSource.PLAYERS, 1, (float) 0.1, false);
						}
					}
					world.levelEvent(2001, BlockPos.containing(x, y - 1, z), Block.getId((world.getBlockState(BlockPos.containing(x, y - 1, z)))));
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Monster) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 8);
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1, false, false));
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(UnusualEndMiscRegister.HEAVINESS, 60, 1, false, false));
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.POOF, x, y, z, 10, 3, 3, 3, 0);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.END_ROD, x, y, z, 10, 3, 3, 3, 0);
								if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(UnusualEndItems.BLAZING_ORB.get())) : false) {
									entityiterator.setRemainingFireTicks(200);
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0, false, false));
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.FLAME, x, y, z, 15, 3, 3, 3, 0);
								}
								if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(UnusualEndItems.SHULKER_ORB.get())) : false) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 60, 1, false, false));
								}
								if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(UnusualEndItems.WITHERING_ORB.get())) : false) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 60, 1, false, false));
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.SQUID_INK, x, y, z, 20, 3, 3, 3, 0);
								}
							}
						}
					}
					loop = 0;
					particleAmount = 20;
					xRadius = 3;
					zRadius = 3;
					while (loop < particleAmount) {
						world.levelEvent(2001, BlockPos.containing(x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius, y, z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius),
								Block.getId((world.getBlockState(BlockPos.containing(x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius, y - 1, z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius)))));
						loop = loop + 1;
					}
				}
			}
		}
	}
}

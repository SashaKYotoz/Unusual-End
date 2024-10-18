package net.mcreator.unusualend.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModMobEffects;
import net.mcreator.unusualend.init.UnusualendModItems;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class GolemOrbUseProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double xRadius = 0;
		double loop = 0;
		double zRadius = 0;
		double particleAmount = 0;
		if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(UnusualendModItems.GOLEM_ORB.get())) : false)
				|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(UnusualendModItems.BLAZING_ORB.get())) : false)
				|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(UnusualendModItems.SHULKER_ORB.get())) : false)
				|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(UnusualendModItems.WITHERING_ORB.get())) : false)) {
			if (entity instanceof Player) {
				if (Math.random() < 0.05) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")), SoundSource.PLAYERS, 1, (float) 0.1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")), SoundSource.PLAYERS, 1, (float) 0.1, false);
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
									_entity.addEffect(new MobEffectInstance(UnusualendModMobEffects.HEAVINESS.get(), 60, 1, false, false));
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.POOF, x, y, z, 10, 3, 3, 3, 0);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.END_ROD, x, y, z, 10, 3, 3, 3, 0);
								if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(UnusualendModItems.BLAZING_ORB.get())) : false) {
									entityiterator.setSecondsOnFire(10);
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0, false, false));
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.FLAME, x, y, z, 15, 3, 3, 3, 0);
								}
								if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(UnusualendModItems.SHULKER_ORB.get())) : false) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 60, 1, false, false));
								}
								if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(UnusualendModItems.WITHERING_ORB.get())) : false) {
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

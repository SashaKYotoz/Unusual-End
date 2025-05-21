package net.mcreator.unusualend.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModMobEffects;
import net.mcreator.unusualend.init.UnusualendModBlocks;
import net.mcreator.unusualend.entity.EndstoneGolemEntity;
import net.mcreator.unusualend.entity.DraglingEntity;
import net.mcreator.unusualend.UnusualEnd;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingHurtEvent;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class CooldownEndstoneGolemProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	private static void execute(LivingHurtEvent event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity, double amount) {
		if (damagesource == null || entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof EndstoneGolemEntity) {
			if (damagesource.is(DamageTypes.MOB_ATTACK)) {
				if ((sourceentity instanceof EndstoneGolemEntity _datEntI ? _datEntI.getEntityData().get(EndstoneGolemEntity.DATA_push) : 0) == 0) {
					if (event != null) {
						event.setCanceled(true);
					}
					if (sourceentity instanceof EndstoneGolemEntity _datEntSetI)
						_datEntSetI.getEntityData().set(EndstoneGolemEntity.DATA_push, 1);
					UnusualEnd.queueServerWork(4, () -> {
						entity.invulnerableTime = 0;
						entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.EXPLOSION)), (float) amount);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.WITCH, (entity.getX()), (entity.getY()), (entity.getZ()), 10, 1, 1, 1, 0.1);
						for (int index0 = 0; index0 < 5; index0++) {
							world.levelEvent(2001, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), Block.getId(UnusualendModBlocks.PURPUR_EMBEDDED_END_STONE.get().defaultBlockState()));
						}
					});
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof DraglingEntity) {
								if (entityiterator instanceof Mob _entity && entity instanceof LivingEntity _ent)
									_entity.setTarget(_ent);
							}
						}
					}
				}
			}
			if (damagesource.is(DamageTypes.CRAMMING)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(UnusualendModMobEffects.HEAVINESS.get(), 40, 2, false, true));
				if (!(entity instanceof Player _plrCldCheck21 && _plrCldCheck21.getCooldowns().isOnCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()))) {
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 60);
				}
				if (!(entity instanceof Player _plrCldCheck25 && _plrCldCheck25.getCooldowns().isOnCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()))) {
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem(), 60);
				}
			}
		}
	}
}

package net.mcreator.unusualend.procedures;

import net.minecraft.sounds.SoundEvents;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingHurtEvent;
import top.theillusivec4.curios.api.CuriosApi;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModItems;
import net.mcreator.unusualend.init.UnusualendModEntities;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PearlescentRingTriggerProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		execute(null, world, x, y, z, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
        if (ModList.get().isLoaded("curios")) {
			if (sourceentity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(UnusualendModItems.PEARLESCENT_RING.get(), lv).isPresent() : false) {
				sourceentity.getPersistentData().putBoolean("wasRingUsed", false);
				if (sourceentity instanceof LivingEntity lv) {
					CuriosApi.getCuriosHelper().findCurios(lv, UnusualendModItems.PEARLESCENT_RING.get()).forEach(item -> {
						ItemStack itemstackiterator = item.stack();
						if (!((sourceentity instanceof Player _plrCldRem3 ? _plrCldRem3.getCooldowns().getCooldownPercent(UnusualendModItems.PEARLESCENT_RING.get(), 0f) * 100 : 0) > 0)) {
							if (itemstackiterator.getOrCreateTag().getDouble("ringCooldown") >= 400) {
								sourceentity.getPersistentData().putBoolean("wasRingUsed", true);
								if (world instanceof ServerLevel _serverLevel) {
									Entity entitytospawn = UnusualendModEntities.SUMMONED_DRAGLING.get().spawn(_serverLevel,
											BlockPos.containing(
													(sourceentity.level()
															.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																	sourceentity))
															.getBlockPos().getX()),
													(sourceentity.level()
															.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																	sourceentity))
															.getBlockPos().getY()),
													(sourceentity.level().clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER,
															ClipContext.Fluid.NONE, sourceentity)).getBlockPos().getZ())),
											MobSpawnType.MOB_SUMMONED);
									if (entitytospawn != null) {
										entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
									}
									if ((entitytospawn) instanceof TamableAnimal _toTame && sourceentity instanceof Player _owner)
										_toTame.tame(_owner);
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.SQUID_INK, ((entitytospawn).getX()), ((entitytospawn).getY()), ((entitytospawn).getZ()), 10, 0.2, 0.2, 0.2, 0);
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.REVERSE_PORTAL, ((entitytospawn).getX()), ((entitytospawn).getY()), ((entitytospawn).getZ()), 10, 0.2, 0.2, 0.2, 0);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.ENDERMAN_TELEPORT, SoundSource.HOSTILE, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, SoundEvents.ENDERMAN_TELEPORT, SoundSource.HOSTILE, 1, 1, false);
										}
									}
								}
								if ((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("unusualend:enderling_mask")))) {
									if (world instanceof ServerLevel _serverLevel) {
										Entity entitytospawn = UnusualendModEntities.SUMMONED_DRAGLING.get().spawn(_serverLevel,
												BlockPos.containing(
														(sourceentity.level()
																.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																		sourceentity))
																.getBlockPos().getX()),
														(sourceentity.level()
																.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																		sourceentity))
																.getBlockPos().getY()),
														(sourceentity.level().clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER,
																ClipContext.Fluid.NONE, sourceentity)).getBlockPos().getZ())),
												MobSpawnType.MOB_SUMMONED);
										if (entitytospawn != null) {
											entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
										}
										if ((entitytospawn) instanceof TamableAnimal _toTame && sourceentity instanceof Player _owner)
											_toTame.tame(_owner);
									}
								}
								itemstackiterator.getOrCreateTag().putDouble("ringCooldown", 0);
								if (sourceentity instanceof Player _player)
									_player.getCooldowns().addCooldown(UnusualendModItems.PEARLESCENT_RING.get(), 10);
							}
						}
					});
				}
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == UnusualendModItems.PEARLESCENT_RING.get()) {
			if (!((sourceentity instanceof Player _plrCldRem42 ? _plrCldRem42.getCooldowns().getCooldownPercent(UnusualendModItems.PEARLESCENT_RING.get(), 0f) * 100 : 0) > 0)) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("ringCooldown") >= 400) {
					if (world instanceof ServerLevel _serverLevel) {
						Entity entitytospawn = UnusualendModEntities.SUMMONED_DRAGLING.get()
								.spawn(_serverLevel,
										BlockPos.containing(
												(sourceentity.level()
														.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																sourceentity))
														.getBlockPos().getX()),
												(sourceentity
														.level()
														.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																sourceentity))
														.getBlockPos().getY()),
												(sourceentity.level().clip(
														new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sourceentity))
														.getBlockPos().getZ())),
										MobSpawnType.MOB_SUMMONED);
						if (entitytospawn != null) {
							entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
						}
						if ((entitytospawn) instanceof TamableAnimal _toTame && sourceentity instanceof Player _owner)
							_toTame.tame(_owner);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SQUID_INK, ((entitytospawn).getX()), ((entitytospawn).getY()), ((entitytospawn).getZ()), 10, 0.2, 0.2, 0.2, 0);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.REVERSE_PORTAL, ((entitytospawn).getX()), ((entitytospawn).getY()), ((entitytospawn).getZ()), 10, 0.2, 0.2, 0.2, 0);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.ENDERMAN_TELEPORT, SoundSource.HOSTILE, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, SoundEvents.ENDERMAN_TELEPORT, SoundSource.HOSTILE, 1, 1, false);
							}
						}
					}
					if ((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("unusualend:enderling_mask")))) {
						if (world instanceof ServerLevel _serverLevel) {
							Entity entitytospawn = UnusualendModEntities.SUMMONED_DRAGLING.get()
									.spawn(_serverLevel,
											BlockPos.containing(
													(sourceentity.level()
															.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																	sourceentity))
															.getBlockPos().getX()),
													(sourceentity.level()
															.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																	sourceentity))
															.getBlockPos().getY()),
													(sourceentity.level().clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER,
															ClipContext.Fluid.NONE, sourceentity)).getBlockPos().getZ())),
											MobSpawnType.MOB_SUMMONED);
							if (entitytospawn != null) {
								entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
							}
							if ((entitytospawn) instanceof TamableAnimal _toTame && sourceentity instanceof Player _owner)
								_toTame.tame(_owner);
						}
					}
					(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("ringCooldown", 0);
					if (sourceentity instanceof Player _player)
						_player.getCooldowns().addCooldown(UnusualendModItems.PEARLESCENT_RING.get(), 10);
				}
			}
		}
	}
}

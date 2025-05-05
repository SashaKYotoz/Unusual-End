package net.mcreator.unusualend.procedures;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.unusualend.init.UnusualendModItems;
import net.mcreator.unusualend.init.UnusualendModEntities;
import net.mcreator.unusualend.entity.LargeBubbleEntity;
import net.mcreator.unusualend.configuration.ConfigurationFileConfiguration;
import net.mcreator.unusualend.UnusualendMod;

import java.util.Comparator;

public class WarpedBalloonProjProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		if (entity.getBbHeight() + entity.getBbWidth() <= 3) {
			if ((entity instanceof Player || entity instanceof AgeableMob || entity instanceof WaterAnimal) && !(entity instanceof LargeBubbleEntity)
					&& !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("unusualend:ballon_immune")))) {
				if (!entity.isPassenger()) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = UnusualendModEntities.WARPED_BALLOON.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					UnusualendMod.queueServerWork(1, () -> entity.startRiding(world.getEntitiesOfClass(LargeBubbleEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().min(new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }.compareDistOf(x, y, z)).orElse(null)));
					if (!immediatesourceentity.level().isClientSide())
						immediatesourceentity.discard();
					if (entity instanceof Player) {
						if (!(entity instanceof ServerPlayer _plr18 && _plr18.level() instanceof ServerLevel
								&& _plr18.getAdvancements().getOrStartProgress(_plr18.server.getAdvancements().get(new ResourceLocation("unusualend:use_warped_bubble"))).isDone())) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("unusualend:use_warped_bubble"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
					}
				} else {
					if (ConfigurationFileConfiguration.SAVE_BALLOON.get()) {
						if (!immediatesourceentity.level().isClientSide())
							immediatesourceentity.discard();
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(UnusualendModItems.WARPED_BALLOON.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			} else {
				if (ConfigurationFileConfiguration.SAVE_BALLOON.get()) {
					if (!immediatesourceentity.level().isClientSide())
						immediatesourceentity.discard();
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(UnusualendModItems.WARPED_BALLOON.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
		} else {
			if (ConfigurationFileConfiguration.SAVE_BALLOON.get()) {
				if (!immediatesourceentity.level().isClientSide())
					immediatesourceentity.discard();
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(UnusualendModItems.WARPED_BALLOON.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}

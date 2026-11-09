package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.configuration.UEConfig;
import net.sweety.unusualend.entity.LargeBubbleEntity;
import net.sweety.unusualend.init.UnusualEndEntities;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.util.ProcedureHelper;

public class WarpedBalloonProjProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		if (entity.getBbHeight() + entity.getBbWidth() <= 3) {
			if ((entity instanceof Player || entity instanceof AgeableMob || entity instanceof WaterAnimal) && !(entity instanceof LargeBubbleEntity)
					&& !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, UnusualEnd.makeUEID("ballon_immune")))) {
				if (!entity.isPassenger()) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = UnusualEndEntities.WARPED_BALLOON.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					UnusualEnd.queueServerWork(1, () -> entity.startRiding(world.getEntitiesOfClass(LargeBubbleEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().min(ProcedureHelper.byDistanceTo(x, y, z)).orElse(null)));
					if (!immediatesourceentity.level().isClientSide())
						immediatesourceentity.discard();
					if (entity instanceof Player) {
						ProcedureHelper.awardAdvancement(entity, "use_warped_bubble");
					}
				} else {
					if (UEConfig.SAVE_BALLOON.get()) {
						if (!immediatesourceentity.level().isClientSide())
							immediatesourceentity.discard();
						ProcedureHelper.dropItem(world, x, y, z, new ItemStack(UnusualEndItems.WARPED_BALLOON.get()), 10);
					}
				}
			} else {
				if (UEConfig.SAVE_BALLOON.get()) {
					if (!immediatesourceentity.level().isClientSide())
						immediatesourceentity.discard();
					ProcedureHelper.dropItem(world, x, y, z, new ItemStack(UnusualEndItems.WARPED_BALLOON.get()), 10);
				}
			}
		} else {
			if (UEConfig.SAVE_BALLOON.get()) {
				if (!immediatesourceentity.level().isClientSide())
					immediatesourceentity.discard();
				ProcedureHelper.dropItem(world, x, y, z, new ItemStack(UnusualEndItems.WARPED_BALLOON.get()), 10);
			}
		}
	}
}

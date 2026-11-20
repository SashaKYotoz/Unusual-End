package net.sweety.unusualend.util;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;

import javax.annotation.Nullable;

public final class EntitySpawnHelper {
	@Nullable
	public static <T extends Entity> T spawn(EntityType<T> type, ServerLevel level, BlockPos pos, MobSpawnType reason) {
		return type.spawn(level, null, null, null, pos, reason, false, false);
	}
}
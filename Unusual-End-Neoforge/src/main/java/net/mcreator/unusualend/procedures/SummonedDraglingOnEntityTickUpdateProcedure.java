package net.mcreator.unusualend.procedures;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.entity.SummonedDraglingEntity;

public class SummonedDraglingOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof SummonedDraglingEntity _datEntSetI)
			_datEntSetI.getEntityData().set(SummonedDraglingEntity.DATA_despawn, (int) ((entity instanceof SummonedDraglingEntity _datEntI ? _datEntI.getEntityData().get(SummonedDraglingEntity.DATA_despawn) : 0) - 1));
		if ((entity instanceof SummonedDraglingEntity _datEntI ? _datEntI.getEntityData().get(SummonedDraglingEntity.DATA_despawn) : 0) <= 0) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SQUID_INK, x, y, z, 5, 0.3, 0.3, 0.3, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.REVERSE_PORTAL, x, y, z, 5, 0.3, 0.3, 0.3, 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.ENDERMAN_TELEPORT, SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, SoundEvents.ENDERMAN_TELEPORT, SoundSource.HOSTILE, 1, 1, false);
				}
			}
		}
		if (Math.random() < 0.1) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 1, 0.15, 0.15, 0.15, 0);
		}
	}
}

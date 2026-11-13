package net.sweety.unusualend.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import net.sweety.unusualend.entity.SummonedDraglingEntity;
import net.sweety.unusualend.util.ProcedureHelper;

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
			ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.HOSTILE, 1, 1);
		}
		if (Math.random() < 0.1) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 1, 0.15, 0.15, 0.15, 0);
		}
	}
}

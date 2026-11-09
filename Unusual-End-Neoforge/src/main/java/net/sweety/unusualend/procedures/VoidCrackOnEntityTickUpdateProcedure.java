package net.sweety.unusualend.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.init.UnusualEndMiscRegister;
import net.sweety.unusualend.util.ParticleHelper;

public class VoidCrackOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SQUID_INK, x, y, z, 2, 0.5, 0.5, 0.5, 0);
		if (!(entity.getPersistentData().getBoolean("coords"))) {
			entity.getPersistentData().putBoolean("coords", true);
			entity.getPersistentData().putDouble("x", x);
			entity.getPersistentData().putDouble("y", y);
			entity.getPersistentData().putDouble("z", z);
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				ParticleHelper.spawn(_ent.level(), ParticleHelper.voidParticles(), _ent.position(), 3, 2, 2, 2, 0);
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				ParticleHelper.spawn(_ent.level(), ParticleHelper.voidParticles(), _ent.position(), 10, 0.5, 0.5, 0.5, 0);
			}
		}
		if (Math.random() < 0.1) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(UnusualEndMiscRegister.PINK_FLAME.get(), x, y, z, 1, 3, 3, 3, 0);
		}
		if (Math.random() < 0.2) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.END_ROD, x, y, z, 1, 0.5, 0.5, 0.5, 0);
		}
		if (!(x == entity.getPersistentData().getDouble("x")) || !(y == entity.getPersistentData().getDouble("y")) || !(z == entity.getPersistentData().getDouble("z"))) {
			{
				Entity _ent = entity;
				_ent.teleportTo((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z")));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z")), _ent.getYRot(), _ent.getXRot());
			}
		}
	}
}

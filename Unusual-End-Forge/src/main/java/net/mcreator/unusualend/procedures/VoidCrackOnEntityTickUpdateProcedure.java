package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.unusualend.init.UnusualendModParticleTypes;

public class VoidCrackOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SQUID_INK, x, y, z, 2, 0.5, 0.5, 0.5, 0);
		if (!(entity.getPersistentData().getBoolean("coords") == true)) {
			entity.getPersistentData().putBoolean("coords", true);
			entity.getPersistentData().putDouble("x", x);
			entity.getPersistentData().putDouble("y", y);
			entity.getPersistentData().putDouble("z", z);
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "particle minecraft:block unusualend:void_particles_block ~ ~ ~ 2 2 2 0 3");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "particle minecraft:block unusualend:void_particles_block ~ ~ ~ 0.5 0.5 0.5 0 10");
			}
		}
		if (Math.random() < 0.1) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (UnusualendModParticleTypes.PINK_FLAME.get()), x, y, z, 1, 3, 3, 3, 0);
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

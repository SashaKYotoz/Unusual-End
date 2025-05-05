package net.mcreator.unusualend.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class VoidExplosiveEntityOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xRadius = 0;
		double loop = 0;
		double zRadius = 0;
		double particleAmount = 0;
		{
			Entity _ent = entity;
			_ent.setYRot(0);
			_ent.setXRot(0);
			_ent.setYBodyRot(_ent.getYRot());
			_ent.setYHeadRot(_ent.getYRot());
			_ent.yRotO = _ent.getYRot();
			_ent.xRotO = _ent.getXRot();
			if (_ent instanceof LivingEntity _entity) {
				_entity.yBodyRotO = _entity.getYRot();
				_entity.yHeadRotO = _entity.getYRot();
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.LARGE_SMOKE, (entity.getX()), (entity.getY() + 1), (entity.getZ()), 1, 0.2, 0.2, 0.2, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.END_ROD, (entity.getX()), (entity.getY() + 1), (entity.getZ()), 1, 1, 1, 1, 0);
		entity.getPersistentData().putDouble("explosion", (entity.getPersistentData().getDouble("explosion") + 1));
		if (entity.getPersistentData().getDouble("explosion") >= 150 && entity.getPersistentData().getDouble("explosion") < 220) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 8, Level.ExplosionInteraction.TNT);
			loop = 0;
			particleAmount = 40;
			xRadius = 6;
			zRadius = 6;
			while (loop < particleAmount) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SQUID_INK, (x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), (y + 1), (z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 3, 0.3, 0.2, 0.3, 0.1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.END_ROD, (x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), (y + 1), (z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 3, 0.3, 0.2, 0.3, 0.1);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), (y + 1), (z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius)), Vec2.ZERO,
									_level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"particle minecraft:block unusualend:void_particles_block ~ ~ ~ 0 0.05 0 0 5");
				loop = loop + 1;
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SQUID_INK, (entity.getX()), (entity.getY() + 1), (entity.getZ()), 30, 3, 3, 3, 0.2);
		} else if (entity.getPersistentData().getDouble("explosion") >= 220) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (entity.getPersistentData().getDouble("explosion") % 6 == 0) {
			if (entity.getPersistentData().getBoolean("isWhite") == true) {
				entity.getPersistentData().putBoolean("isWhite", false);
			} else {
				entity.getPersistentData().putBoolean("isWhite", true);
			}
		}
	}
}

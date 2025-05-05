package net.mcreator.unusualend.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class BenevolentLeechingChargeProjectileProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		double duration_buff = 0;
		double level_buff = 0;
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"summon area_effect_cloud ~ ~ ~ {Particle:\"dust 0.94 0.3 0.88 1\",Potion:strong_regeneration,Radius:2,RadiusPerTick:-0.01,Duration:100}");
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.POOF, x, (y + 1.2), z, 3, 0.5, 0.2, 0.5, 0.1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.HEART, x, (y + 1.2), z, 5, 1.2, 0.2, 1.2, 0.1);
	}
}

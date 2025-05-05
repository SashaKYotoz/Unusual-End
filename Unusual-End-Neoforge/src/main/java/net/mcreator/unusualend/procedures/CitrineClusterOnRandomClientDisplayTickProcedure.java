package net.mcreator.unusualend.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.unusualend.init.UnusualendModParticleTypes;

public class CitrineClusterOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(
					new CommandSourceStack(CommandSource.NULL, new Vec3((x + Mth.nextDouble(RandomSource.create(), 0.4, 0.6)), (y + Mth.nextDouble(RandomSource.create(), 0.4, 0.6)), (z + Mth.nextDouble(RandomSource.create(), 0.4, 0.6))), Vec2.ZERO,
							_level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"particle dust 1 0.7 0.3 0.8 ~ ~0.5 ~ 0.2 0.2 0.2 0 8");
		if (Math.random() < 0.2) {
			world.addParticle((SimpleParticleType) (UnusualendModParticleTypes.CITRINE_SHINE.get()), (x + Mth.nextDouble(RandomSource.create(), 0.1, 0.9)), (y + Mth.nextDouble(RandomSource.create(), 0.1, 0.9)),
					(z + Mth.nextDouble(RandomSource.create(), 0.1, 0.9)), 0, 0, 0);
		}
	}
}

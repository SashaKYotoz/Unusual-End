package net.sweety.unusualend.procedures;

import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.init.UnusualendModParticleTypes;
import net.sweety.unusualend.util.ParticleHelper;

public class CitrineClusterOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ParticleHelper.spawn(world, ParticleHelper.dust(1.0f, 0.7f, 0.3f, 0.8f), new Vec3((x + Mth.nextDouble(world.getRandom(), 0.4, 0.6)), (y + Mth.nextDouble(world.getRandom(), 0.4, 0.6)), (z + Mth.nextDouble(world.getRandom(), 0.4, 0.6))).add(0, 0.5, 0), 8, 0.2, 0.2, 0.2, 0);
		if (Math.random() < 0.2) {
			world.addParticle(UnusualendModParticleTypes.CITRINE_SHINE.get(), (x + Mth.nextDouble(world.getRandom(), 0.1, 0.9)), (y + Mth.nextDouble(world.getRandom(), 0.1, 0.9)),
					(z + Mth.nextDouble(world.getRandom(), 0.1, 0.9)), 0, 0, 0);
		}
	}
}

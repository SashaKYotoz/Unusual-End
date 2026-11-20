package net.sweety.unusualend.util;

import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;

public final class AnimationHelper {
	public static void animateWhen(AnimationState state, boolean condition, int tickCount) {
		if (condition)
			state.startIfStopped(tickCount);
		else
			state.stop();
	}

	public static boolean isMoving(LivingEntity entity) {
		return entity.animationSpeed > 1.0E-5F;
	}
}
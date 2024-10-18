package custom.mcreator.unusualend.client.animation;

import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.AnimationChannel;

public class tameddraglingAnimation {
	public static final AnimationDefinition WINGS = AnimationDefinition.Builder.withLength(1.5f).looping()
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7916766f, KeyframeAnimations.degreeVec(2.33f, -2.2f, -0.54f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2916767f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4167667f, KeyframeAnimations.degreeVec(-0.78f, 0.26f, 0.06f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_wing", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 13.31f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.9583434f, KeyframeAnimations.degreeVec(7.5f, -11.72f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_wing", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, -13.31f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.9583434f, KeyframeAnimations.degreeVec(7.5f, 11.72f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.build();
	public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(1.5f).looping()
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(12.5f, 0f, 10f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75f, KeyframeAnimations.degreeVec(11.94f, 3.73f, -7.11f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(0.98f, -0.17f, 11f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(12.5f, 0f, -10f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75f, KeyframeAnimations.degreeVec(11.94f, -3.73f, 7.11f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(-0.98f, -0.17f, -11f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("main_body",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_wing", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 13.31f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5f, KeyframeAnimations.degreeVec(8.62f, -31.53f, -3f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 13.31f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25f, KeyframeAnimations.degreeVec(8.62f, -31.53f, -3f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_wing", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, -13.31f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5f, KeyframeAnimations.degreeVec(8.62f, 31.53f, 3f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, -13.31f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25f, KeyframeAnimations.degreeVec(8.62f, 31.53f, 3f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.build();
	public static final AnimationDefinition FLY = AnimationDefinition.Builder.withLength(1.5f).looping()
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.125f, KeyframeAnimations.degreeVec(11.63f, 2.45f, 0.5f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("main_body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(35f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(37f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.25f, KeyframeAnimations.degreeVec(30f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(35f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.4583433f, KeyframeAnimations.degreeVec(10.41f, 5.72f, 8.22f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1f, KeyframeAnimations.degreeVec(10.41f, 5.72f, 8.22f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(-7.09f, 5.72f, 8.22f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.4583433f, KeyframeAnimations.degreeVec(10.41f, -5.72f, -8.22f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1f, KeyframeAnimations.degreeVec(10.41f, -5.72f, -8.22f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(-7.09f, -5.72f, -8.22f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_wing", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 13.31f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5f, KeyframeAnimations.degreeVec(8.62f, -31.53f, -3f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 13.31f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25f, KeyframeAnimations.degreeVec(8.62f, -31.53f, -3f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_wing", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, -13.31f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5f, KeyframeAnimations.degreeVec(8.62f, 31.53f, 3f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, -13.31f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25f, KeyframeAnimations.degreeVec(8.62f, 31.53f, 3f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.build();
	public static final AnimationDefinition ATTACK = AnimationDefinition.Builder.withLength(1f)
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.041676664f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.25f, KeyframeAnimations.degreeVec(27.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167667f, KeyframeAnimations.degreeVec(26.23f, -4.52f, -2.2f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("main_body",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20834334f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 0f, -0.1f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.2916767f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("main_body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.041676664f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.08343333f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-49.72f, -31.71f, -7.27f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.08343333f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-49.72f, 31.71f, 7.27f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_wing", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 13.31f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.25f, KeyframeAnimations.degreeVec(8.62f, -31.53f, -3f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5416766f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.75f, KeyframeAnimations.degreeVec(7.5f, -11.72f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_wing", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, -13.31f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.25f, KeyframeAnimations.degreeVec(8.62f, 31.53f, 3f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5416766f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.75f, KeyframeAnimations.degreeVec(7.5f, 11.72f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.build();
}

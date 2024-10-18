package custom.mcreator.unusualend.client.animation;

import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.AnimationChannel;

public class endstonegolemAnimation {
	public static final AnimationDefinition WALK = AnimationDefinition.Builder.withLength(2f).looping()
			.addAnimation("right_leg",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.2916767f, KeyframeAnimations.posVec(0f, 0f, 4f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 4f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.7916766f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.4167667f, KeyframeAnimations.posVec(0f, 0f, -1f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.6766667f, KeyframeAnimations.posVec(0f, 0f, -6f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.8343333f, KeyframeAnimations.posVec(0f, 0f, -6f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.4167667f, KeyframeAnimations.degreeVec(10.98f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.7916766f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4167667f, KeyframeAnimations.degreeVec(-12.49f, -0.54f, -2.44f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6766667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.8343333f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_leg",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.posVec(0f, 0f, -1f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, -6f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 0f, -6f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 0f, 4f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.7083433f, KeyframeAnimations.posVec(0f, 0f, 4f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_leg",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(-12.49f, 0.54f, 2.44f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.625f, KeyframeAnimations.degreeVec(10.98f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.7083433f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_arm",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.5f, KeyframeAnimations.posVec(-1f, -0.5f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5f, KeyframeAnimations.posVec(1.75f, -3.25f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(9.92f, -1.3f, 0.2f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(-7.47f, 0.65f, 0.27f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_arm",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.5f, KeyframeAnimations.posVec(-1f, -0.5f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5f, KeyframeAnimations.posVec(2f, 1.5f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(-14.99f, -0.65f, 0.4f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(12.4f, 1.62f, 2.99f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("upper_body",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.5f, KeyframeAnimations.posVec(0f, -0.5f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5f, KeyframeAnimations.posVec(0f, -2.25f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("upper_body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, -2.19f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 2.81f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("lower_body",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, -0.75f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 0f, -0.75f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("lower_body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 2.5f, -2.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, -2.5f, 2.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.posVec(-2f, -1f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5f, KeyframeAnimations.posVec(3f, -1.5f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0.31f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, -2.19f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 2.81f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.build();
	public static final AnimationDefinition ATTACK = AnimationDefinition.Builder.withLength(1.75f)
			.addAnimation("upper_body", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5f, KeyframeAnimations.posVec(0f, -2f, -1.25f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.625f, KeyframeAnimations.posVec(0f, -3f, -3.25f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7916766f, KeyframeAnimations.posVec(0f, -0.75f, 2.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.8343334f, KeyframeAnimations.posVec(0f, 0.25f, 3.5f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875f, KeyframeAnimations.posVec(0f, 1.25f, 4f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.9167666f, KeyframeAnimations.posVec(0f, 0.25f, 3.5f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25f, KeyframeAnimations.posVec(0f, 0.25f, 3.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.7083433f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("upper_body", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.625f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7916766f, KeyframeAnimations.degreeVec(22.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(27.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9167666f, KeyframeAnimations.degreeVec(27.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.25f, KeyframeAnimations.degreeVec(27.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7083433f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("lower_body",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.625f, KeyframeAnimations.posVec(0f, -0.5f, -0.03f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.7916766f, KeyframeAnimations.posVec(0f, 0f, 2.5f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.25f, KeyframeAnimations.posVec(0f, 0f, 2.5f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.7083433f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("lower_body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.625f, KeyframeAnimations.degreeVec(-2.11f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.7916766f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.25f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.7083433f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.625f, KeyframeAnimations.posVec(0f, -11f, 12f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, -5.75f, 10.5f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7916766f, KeyframeAnimations.posVec(0f, -6f, -10f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.8343334f, KeyframeAnimations.posVec(0f, -8f, -14f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875f, KeyframeAnimations.posVec(0f, -7f, -14f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.9167666f, KeyframeAnimations.posVec(0f, -8f, -14f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25f, KeyframeAnimations.posVec(0f, -6f, -14f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.4167667f, KeyframeAnimations.posVec(0f, -3.82f, -6.91f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7083433f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5f, KeyframeAnimations.degreeVec(-122.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.625f, KeyframeAnimations.degreeVec(-152.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7916766f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.9167666f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.4167667f, KeyframeAnimations.degreeVec(-5.68f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7083433f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.625f, KeyframeAnimations.posVec(0f, -11f, 12f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, -5.75f, 10.5f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7916766f, KeyframeAnimations.posVec(0f, -6f, -10f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.8343334f, KeyframeAnimations.posVec(0f, -8f, -14f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875f, KeyframeAnimations.posVec(0f, -7f, -14f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.9167666f, KeyframeAnimations.posVec(0f, -8f, -14f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25f, KeyframeAnimations.posVec(0f, -6f, -14f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.7083433f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5f, KeyframeAnimations.degreeVec(-122.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.625f, KeyframeAnimations.degreeVec(-152.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7916766f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.9167666f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.7083433f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5f, KeyframeAnimations.posVec(0f, -2.25f, 6f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.625f, KeyframeAnimations.posVec(0f, -5f, 11f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, -2.87f, 5.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.7083434f, KeyframeAnimations.posVec(0f, -1.91f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75f, KeyframeAnimations.posVec(0f, -2.45f, -5.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.7916766f, KeyframeAnimations.posVec(0f, -4.5f, -11f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8343334f, KeyframeAnimations.posVec(0f, -5f, -13f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.875f, KeyframeAnimations.posVec(0f, -4f, -13f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.9167666f, KeyframeAnimations.posVec(0f, -5f, -13.75f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.25f, KeyframeAnimations.posVec(0f, -5f, -13.75f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5416767f, KeyframeAnimations.posVec(0f, -0.66f, -5.33f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.7083433f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.625f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7916766f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(27.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875f, KeyframeAnimations.degreeVec(27.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.9167666f, KeyframeAnimations.degreeVec(27.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25f, KeyframeAnimations.degreeVec(27.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.7083433f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.build();
	public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(4f).looping()
			.addAnimation("upper_body",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.1676667f, KeyframeAnimations.posVec(0.75f, -0.87f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.7083433f, KeyframeAnimations.posVec(0.47f, -1.3f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("upper_body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.1676667f, KeyframeAnimations.degreeVec(0f, 0f, -1f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.375f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("lower_body",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5f, KeyframeAnimations.posVec(0f, -1f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("lower_body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.7083433f, KeyframeAnimations.degreeVec(0f, 0f, 1f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_leg",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 2.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_leg",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_arm",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5f, KeyframeAnimations.posVec(0f, -1f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(3.75f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(-2.5f, 0f, -2.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(3.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_arm",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5f, KeyframeAnimations.posVec(0f, -1f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(3.75f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(-2.5f, 0f, 2.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(3.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.1676667f, KeyframeAnimations.posVec(0f, -1.15f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.7083433f, KeyframeAnimations.posVec(0f, -1.45f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.375f, KeyframeAnimations.posVec(0f, -1.05f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.25f, KeyframeAnimations.posVec(0f, -0.35f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.1676667f, KeyframeAnimations.degreeVec(0f, 0f, -1f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.7083433f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.375f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.25f, KeyframeAnimations.degreeVec(0f, -10f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.build();
	public static final AnimationDefinition PUSH = AnimationDefinition.Builder.withLength(0.4583433f).looping()
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.08343333f, KeyframeAnimations.posVec(0f, -3f, -13f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.16766666f, KeyframeAnimations.posVec(0f, -3f, -13f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.45f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.08343333f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.16766666f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.45f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_arm",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.041676664f, KeyframeAnimations.posVec(0f, -9f, -10f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.08343333f, KeyframeAnimations.posVec(0f, -9f, -11f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.posVec(0f, -9f, -10f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.4583433f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.041676664f, KeyframeAnimations.degreeVec(-7.49f, -0.33f, -2.48f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125f, KeyframeAnimations.degreeVec(-7.49f, -0.33f, -2.48f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25f, KeyframeAnimations.degreeVec(-6.51f, 0.28f, 2.82f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.4583433f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_arm",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.041676664f, KeyframeAnimations.posVec(0f, -9f, -10f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.08343333f, KeyframeAnimations.posVec(0f, -9f, -11f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.posVec(0f, -9f, -10f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.4583433f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.041676664f, KeyframeAnimations.degreeVec(-7.49f, 0.33f, 2.48f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(-7.49f, 0.33f, 2.48f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-6.51f, -0.28f, -2.82f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.4583433f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("lower_body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.08343333f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.16766666f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.45f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("upper_body",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.08343333f, KeyframeAnimations.posVec(0f, 0f, -0.75f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.16766666f, KeyframeAnimations.posVec(0f, 0f, -0.75f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.45f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("upper_body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.08343333f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.16766666f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.45f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.build();
}

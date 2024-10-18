package net.mcreator.unusualend.procedures;

import org.checkerframework.checker.units.qual.min;

import net.minecraft.util.Mth;

public class EndMathProcedure extends Mth {
	public static boolean inRange(int value, int min, int max) {
		return value >= min && value <= max;
	}

	public static boolean inRange(float value, float min, float max) {
		return value >= min && value <= max;
	}

	public static boolean inRange(double value, double min, double max) {
		return value >= min && value <= max;
	}

	public static boolean inAverage(int value, int average, int range) {
		return value >= average - range && value <= average + range;
	}
}

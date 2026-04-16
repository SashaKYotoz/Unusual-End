package net.mcreator.unusualend.procedures;

import net.mcreator.unusualend.configuration.Config;

public class RawPurpurFeatureAdditionalGenerationConditionProcedure {
	public static boolean execute() {
		return Config.RAW_PURPUR.get() == true;
	}
}

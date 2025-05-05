package net.mcreator.unusualend.procedures;

import net.mcreator.unusualend.configuration.ConfigurationFileConfiguration;

public class RawPurpurFeatureAdditionalGenerationConditionProcedure {
	public static boolean execute() {
		return ConfigurationFileConfiguration.RAW_PURPUR.get() == true;
	}
}

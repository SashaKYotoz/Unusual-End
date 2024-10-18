package net.mcreator.unusualend.procedures;

import net.mcreator.unusualend.configuration.ConfigurationFileConfiguration;

public class InfestedEndstoneAdditionalGenerationConditionProcedure {
	public static boolean execute() {
		return ConfigurationFileConfiguration.INFESTED_ENDSTONE.get() == true;
	}
}

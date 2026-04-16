package net.mcreator.unusualend.procedures;

import net.mcreator.unusualend.configuration.Config;

public class InfestedEndstoneAdditionalGenerationConditionProcedure {
	public static boolean execute() {
		return Config.INFESTED_ENDSTONE.get() == true;
	}
}

package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.util.ProcedureHelper;

public class ReturnBuildingInhibIsActiveProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		return Component.translatable("text.unusualend.inhibit_gui").getString() + Math.round((ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "isActive")) / 10) + "s";
	}
}

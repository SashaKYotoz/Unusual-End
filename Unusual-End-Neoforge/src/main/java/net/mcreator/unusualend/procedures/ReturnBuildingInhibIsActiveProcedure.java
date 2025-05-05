package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class ReturnBuildingInhibIsActiveProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		return Component.translatable("text.unusualend.inhibit_gui").getString() + "" + Math.round((new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "isActive")) / 10) + "s";
	}
}

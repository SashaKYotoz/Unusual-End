package net.mcreator.unusualend.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;

public class ReturnNotSneakingProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !((new Object() {
			public boolean getValue() {
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getBoolean("Sitting");
			}
		}.getValue()));
	}
}

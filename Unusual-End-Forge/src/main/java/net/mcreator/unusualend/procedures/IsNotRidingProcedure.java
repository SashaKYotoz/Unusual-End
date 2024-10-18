package net.mcreator.unusualend.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

public class IsNotRidingProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !entity.isPassenger() && !((new Object() {
			public boolean getValue() {
				CompoundTag dataIndex1 = new CompoundTag();
				entity.saveWithoutId(dataIndex1);
				return dataIndex1.getBoolean("Sitting");
			}
		}.getValue()) == true);
	}
}

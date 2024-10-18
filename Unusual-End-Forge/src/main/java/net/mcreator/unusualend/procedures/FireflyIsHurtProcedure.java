package net.mcreator.unusualend.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

public class FireflyIsHurtProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((new Object() {
			public boolean getValue() {
				CompoundTag dataIndex0 = new CompoundTag();
				entity.saveWithoutId(dataIndex0);
				return dataIndex0.getBoolean("Sitting");
			}
		}.getValue()) == true) {
			CompoundTag dataIndex1 = new CompoundTag();
			entity.saveWithoutId(dataIndex1);
			dataIndex1.putBoolean("Sitting", false);
			entity.load(dataIndex1);
		}
	}
}

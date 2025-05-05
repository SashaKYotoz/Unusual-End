package net.mcreator.unusualend.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

public class FireflyIsHurtProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((new Object() {
			public boolean getValue() {
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getBoolean("Sitting");
			}
		}.getValue()) == true) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.putBoolean("Sitting", false);
				entity.load(dataIndex);
			}
		}
	}
}

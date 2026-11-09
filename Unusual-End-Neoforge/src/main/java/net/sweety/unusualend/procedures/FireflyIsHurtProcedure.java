package net.sweety.unusualend.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.sweety.unusualend.util.ProcedureHelper;

public class FireflyIsHurtProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((ProcedureHelper.isOrderedToSit(entity))) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.putBoolean("Sitting", false);
				entity.load(dataIndex);
			}
		}
	}
}

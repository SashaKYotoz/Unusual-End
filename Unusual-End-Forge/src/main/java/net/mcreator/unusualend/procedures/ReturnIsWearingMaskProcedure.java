package net.mcreator.unusualend.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class ReturnIsWearingMaskProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
				.is(ItemTags.create(new ResourceLocation("unusualend:enderling_mask"))));
	}
}

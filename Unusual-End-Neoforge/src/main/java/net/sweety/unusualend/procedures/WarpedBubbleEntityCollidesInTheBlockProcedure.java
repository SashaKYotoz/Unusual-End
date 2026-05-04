package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.entity.BlukEntity;
import net.sweety.unusualend.entity.BolokEntity;
import net.sweety.unusualend.entity.GlubEntity;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.init.UnusualEndMiscRegister;

public class WarpedBubbleEntityCollidesInTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof BolokEntity || entity instanceof GlubEntity || entity instanceof BlukEntity)) {
			entity.fallDistance = 0;
			if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == UnusualEndItems.WARPED_BOOTS.get())) {
				world.destroyBlock(BlockPos.containing(x, y, z), false);
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x), (entity.getDeltaMovement().y() + 0.5 + entity.getLookAngle().y), (entity.getDeltaMovement().z() + entity.getLookAngle().z)));
				if (world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.BUBBLE_COLUMN_BUBBLE_POP, SoundSource.NEUTRAL, (float) 1.2, (float) 1.3);
						} else {
							_level.playLocalSound(x, y, z, SoundEvents.BUBBLE_COLUMN_BUBBLE_POP, SoundSource.NEUTRAL, (float) 1.2, (float) 1.3, false);
						}
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(UnusualEndMiscRegister.WARPED_BUBBLES.get(), (x + 0.5), (y + 0.5), (z + 0.5), 5, 0.2, 0.2, 0.2, 0);
			}
		}
	}
}

package net.mcreator.unusualend.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModParticleTypes;
import net.mcreator.unusualend.init.UnusualendModItems;
import net.mcreator.unusualend.entity.WarpedJellyfishEntity;
import net.mcreator.unusualend.entity.BolokEntity;
import net.mcreator.unusualend.entity.BlukEntity;
import net.mcreator.unusualend.UnusualendMod;

public class WarpedBubbleEntityCollidesInTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double dis = 0;
		if (!(entity instanceof BolokEntity || entity instanceof WarpedJellyfishEntity || entity instanceof BlukEntity)) {
			entity.fallDistance = 0;
			if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == UnusualendModItems.WARPED_BOOTS.get())) {
				world.destroyBlock(BlockPos.containing(x, y, z), false);
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x), (entity.getDeltaMovement().y() + 1.5 + entity.getLookAngle().y), (entity.getDeltaMovement().z() + entity.getLookAngle().z)));
				UnusualendMod.queueServerWork(40, () -> {
					entity.fallDistance = 0;
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (UnusualendModParticleTypes.WARPED_BUBBLES.get()), (entity.getX() + 0.5), (entity.getY() + 0.5), (entity.getZ() + 0.5), 5, 0.8, 0.8, 0.8, 0);
					UnusualendMod.queueServerWork(40, () -> {
						entity.fallDistance = 0;
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (UnusualendModParticleTypes.WARPED_BUBBLES.get()), (entity.getX() + 0.5), (entity.getY() + 0.5), (entity.getZ() + 0.5), 5, 0.8, 0.8, 0.8, 0);
						UnusualendMod.queueServerWork(40, () -> {
							entity.fallDistance = 0;
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (UnusualendModParticleTypes.WARPED_BUBBLES.get()), (entity.getX() + 0.5), (entity.getY() + 0.5), (entity.getZ() + 0.5), 5, 0.8, 0.8, 0.8, 0);
						});
					});
				});
				if (world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bubble_column.bubble_pop")), SoundSource.NEUTRAL, (float) 1.2, (float) 1.3);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bubble_column.bubble_pop")), SoundSource.NEUTRAL, (float) 1.2, (float) 1.3, false);
						}
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (UnusualendModParticleTypes.WARPED_BUBBLES.get()), (x + 0.5), (y + 0.5), (z + 0.5), 5, 0.2, 0.2, 0.2, 0);
			}
		}
	}
}

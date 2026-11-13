package net.sweety.unusualend.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import net.sweety.unusualend.entity.EnderblobEntity;
import net.sweety.unusualend.init.UnusualendModBlocks;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.util.ParticleHelper;
import net.sweety.unusualend.util.ProcedureHelper;

public class EnderblobRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BRUSH) {
			if ((entity instanceof EnderblobEntity _datEntI ? _datEntI.getEntityData().get(EnderblobEntity.DATA_BrushTimer) : 0) == 0) {
				if (!(ProcedureHelper.isCreative(entity))) {
					{
						ItemStack _ist = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						if (_ist.hurt(1, world.getRandom(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
				if (sourceentity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				ProcedureHelper.dropItem(world, (entity.getX()), (entity.getY() + 0.3), (entity.getZ()), new ItemStack(UnusualendModItems.ENDERBLOB_MOULT.get()), 10);
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) 0.1);
				ParticleHelper.spawn(world, ParticleHelper.block(UnusualendModBlocks.ENDERBLOB_BLOCK.get()), (entity.getX()), (entity.getY() + 0.2), (entity.getZ()), 15, 0.3, 0.3, 0.3, 0);
				if (world.isClientSide()) {
					ProcedureHelper.playSound(world, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.brush.brushing.generic")), SoundSource.NEUTRAL, 1, (float) 1.3);
					ProcedureHelper.playSound(world, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.pickup")), SoundSource.NEUTRAL, 1, (float) 0.85);
				}
				if (entity instanceof EnderblobEntity _datEntSetI)
					_datEntSetI.getEntityData().set(EnderblobEntity.DATA_BrushTimer, 120);
			}
		}
	}
}

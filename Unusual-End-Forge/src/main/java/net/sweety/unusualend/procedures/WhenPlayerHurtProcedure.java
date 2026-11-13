package net.sweety.unusualend.procedures;

import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.config.Config;
import net.sweety.unusualend.entity.*;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.init.UnusualendModMobEffects;
import net.sweety.unusualend.util.ProcedureHelper;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WhenPlayerHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double dividedby = 0;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == UnusualendModItems.WARPED_CHESTPLATE.get()) {
			ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, false, true));
			if (!(entity == sourceentity)) {
				ProcedureHelper.addEffect(sourceentity, new MobEffectInstance(UnusualendModMobEffects.HEAVINESS.get(), 40, 1, false, true));
			}
		}
		if (entity instanceof VoidBombEntity || entity instanceof VoidCrackEntity) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
		if (sourceentity instanceof DraglingEntity) {
			if (Math.random() < (double) Config.DRAGLING_DISRUPTION.get() / 100) {
				ProcedureHelper.addEffect(entity, new MobEffectInstance(UnusualendModMobEffects.DISRUPTION.get(), 60, 0));
			}
		}
		if (sourceentity instanceof EnderbulbEntity) {
			dividedby = 1;
			{
				Entity _ent = sourceentity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.lookAt(EntityAnchorArgument.Anchor.FEET, entity.position());
				}
			}
			for (int index0 = 0; index0 < 25; index0++) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.WITCH, (sourceentity.getX() + (entity.getX() - sourceentity.getX()) / dividedby), (sourceentity.getY() + 0.8 + (entity.getY() - sourceentity.getY()) / dividedby),
							(sourceentity.getZ() + (entity.getZ() - sourceentity.getZ()) / dividedby), 1, 0, 0, 0, 0);
				dividedby = dividedby + 0.4;
			}
			ProcedureHelper.addEffect(sourceentity, new MobEffectInstance(MobEffects.REGENERATION, 60, 2));
			ProcedureHelper.playSound(world, sourceentity.getX(), sourceentity.getY(), sourceentity.getZ(), SoundEvents.EVOKER_CAST_SPELL, SoundSource.HOSTILE, 1, 2);
		}
		if (sourceentity instanceof DraglingEntity) {
			if ((sourceentity instanceof DraglingEntity _datEntL28 && _datEntL28.getEntityData().get(DraglingEntity.DATA_atk)) == true) {
				if (sourceentity instanceof DraglingEntity _datEntSetL)
					_datEntSetL.getEntityData().set(DraglingEntity.DATA_atk, false);
				UnusualEnd.queueServerWork(1, () -> {
					if (sourceentity instanceof DraglingEntity _datEntSetL)
						_datEntSetL.getEntityData().set(DraglingEntity.DATA_atk, true);
				});
			} else {
				if (sourceentity instanceof DraglingEntity _datEntSetL)
					_datEntSetL.getEntityData().set(DraglingEntity.DATA_atk, true);
			}
			UnusualEnd.queueServerWork(20, () -> {
				if ((sourceentity instanceof DraglingEntity _datEntL33 && _datEntL33.getEntityData().get(DraglingEntity.DATA_atk)) == true) {
					if (sourceentity instanceof DraglingEntity _datEntSetL)
						_datEntSetL.getEntityData().set(DraglingEntity.DATA_atk, false);
				}
			});
		}
		if (sourceentity instanceof SummonedDraglingEntity) {
			if ((sourceentity instanceof SummonedDraglingEntity _datEntL37 && _datEntL37.getEntityData().get(SummonedDraglingEntity.DATA_atk)) == true) {
				if (sourceentity instanceof SummonedDraglingEntity _datEntSetL)
					_datEntSetL.getEntityData().set(SummonedDraglingEntity.DATA_atk, false);
				UnusualEnd.queueServerWork(1, () -> {
					if (sourceentity instanceof SummonedDraglingEntity _datEntSetL)
						_datEntSetL.getEntityData().set(SummonedDraglingEntity.DATA_atk, true);
				});
			} else {
				if (sourceentity instanceof SummonedDraglingEntity _datEntSetL)
					_datEntSetL.getEntityData().set(SummonedDraglingEntity.DATA_atk, true);
			}
			UnusualEnd.queueServerWork(20, () -> {
				if ((sourceentity instanceof SummonedDraglingEntity _datEntL42 && _datEntL42.getEntityData().get(SummonedDraglingEntity.DATA_atk)) == true) {
					if (sourceentity instanceof SummonedDraglingEntity _datEntSetL)
						_datEntSetL.getEntityData().set(SummonedDraglingEntity.DATA_atk, false);
				}
			});
		}
	}
}

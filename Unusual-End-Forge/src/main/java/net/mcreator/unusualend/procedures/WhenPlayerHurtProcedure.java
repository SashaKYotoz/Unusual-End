package net.mcreator.unusualend.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.unusualend.init.UnusualendModMobEffects;
import net.mcreator.unusualend.init.UnusualendModItems;
import net.mcreator.unusualend.entity.VoidCrackEntity;
import net.mcreator.unusualend.entity.VoidBombEntity;
import net.mcreator.unusualend.entity.SummonedDraglingEntity;
import net.mcreator.unusualend.entity.EnderbulbEntity;
import net.mcreator.unusualend.entity.DraglingEntity;
import net.mcreator.unusualend.configuration.ConfigurationFileConfiguration;
import net.mcreator.unusualend.UnusualendMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WhenPlayerHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double dis = 0;
		double dividedby = 0;
		boolean wasRingUsed = false;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == UnusualendModItems.WARPED_CHESTPLATE.get()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, false, true));
			if (!(entity == sourceentity)) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(UnusualendModMobEffects.HEAVINESS.get(), 40, 1, false, true));
			}
		}
		if (entity instanceof VoidBombEntity || entity instanceof VoidCrackEntity) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
		if (sourceentity instanceof DraglingEntity) {
			if (Math.random() < (double) ConfigurationFileConfiguration.DRAGLING_DISRUPTION.get() / 100) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(UnusualendModMobEffects.DISRUPTION.get(), 60, 0));
			}
		}
		if (sourceentity instanceof EnderbulbEntity) {
			dividedby = 1;
			{
				Entity _ent = sourceentity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("tp @s ~ ~ ~ facing entity " + entity));
				}
			}
			for (int index0 = 0; index0 < 25; index0++) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.WITCH, (sourceentity.getX() + (entity.getX() - sourceentity.getX()) / dividedby), (sourceentity.getY() + 0.8 + (entity.getY() - sourceentity.getY()) / dividedby),
							(sourceentity.getZ() + (entity.getZ() - sourceentity.getZ()) / dividedby), 1, 0, 0, 0, 0);
				dividedby = dividedby + 0.4;
			}
			if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 2));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.evoker.cast_spell")), SoundSource.HOSTILE, 1, 2);
				} else {
					_level.playLocalSound((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.evoker.cast_spell")), SoundSource.HOSTILE, 1, 2, false);
				}
			}
		}
		if (sourceentity instanceof DraglingEntity) {
			if ((sourceentity instanceof DraglingEntity _datEntL28 && _datEntL28.getEntityData().get(DraglingEntity.DATA_atk)) == true) {
				if (sourceentity instanceof DraglingEntity _datEntSetL)
					_datEntSetL.getEntityData().set(DraglingEntity.DATA_atk, false);
				UnusualendMod.queueServerWork(1, () -> {
					if (sourceentity instanceof DraglingEntity _datEntSetL)
						_datEntSetL.getEntityData().set(DraglingEntity.DATA_atk, true);
				});
			} else {
				if (sourceentity instanceof DraglingEntity _datEntSetL)
					_datEntSetL.getEntityData().set(DraglingEntity.DATA_atk, true);
			}
			UnusualendMod.queueServerWork(20, () -> {
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
				UnusualendMod.queueServerWork(1, () -> {
					if (sourceentity instanceof SummonedDraglingEntity _datEntSetL)
						_datEntSetL.getEntityData().set(SummonedDraglingEntity.DATA_atk, true);
				});
			} else {
				if (sourceentity instanceof SummonedDraglingEntity _datEntSetL)
					_datEntSetL.getEntityData().set(SummonedDraglingEntity.DATA_atk, true);
			}
			UnusualendMod.queueServerWork(20, () -> {
				if ((sourceentity instanceof SummonedDraglingEntity _datEntL42 && _datEntL42.getEntityData().get(SummonedDraglingEntity.DATA_atk)) == true) {
					if (sourceentity instanceof SummonedDraglingEntity _datEntSetL)
						_datEntSetL.getEntityData().set(SummonedDraglingEntity.DATA_atk, false);
				}
			});
		}
	}
}

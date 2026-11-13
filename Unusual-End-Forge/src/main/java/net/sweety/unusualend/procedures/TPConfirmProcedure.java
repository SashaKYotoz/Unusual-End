package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sweety.unusualend.init.UnusualendModBlocks;
import net.sweety.unusualend.network.UnusualendModVariables;
import net.sweety.unusualend.util.ProcedureHelper;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TPConfirmProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(UnusualendModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UnusualendModVariables.PlayerVariables())).isTeleporting == true) {
			if ((entity.getPersistentData().getString("TargetDimension")).equals("" + entity.level().dimension())) {
				if (!((world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("TargetX"), entity.getPersistentData().getDouble("TargetY") - 1, entity.getPersistentData().getDouble("TargetZ"))))
						.getBlock() == UnusualendModBlocks.TELEPORTATION_ANCHOR.get())) {
					{
						Entity _ent = entity;
						_ent.teleportTo((Mth.nextDouble(world.getRandom(), -1000, 1000)), (Mth.nextDouble(world.getRandom(), 100, 120)), (Mth.nextDouble(world.getRandom(), -1000, 1000)));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((Mth.nextDouble(world.getRandom(), -1000, 1000)), (Mth.nextDouble(world.getRandom(), 100, 120)), (Mth.nextDouble(world.getRandom(), -1000, 1000)), _ent.getYRot(),
									_ent.getXRot());
					}
					ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.SLOW_FALLING, 300, 1));
					ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.DARKNESS, 80, 0));
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.translatable("text.unusualend.tp_error"), true);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.PORTAL, (entity.getX()), (entity.getY()), (entity.getZ()), 50, 0.5, 1.5, 0.5, 0);
					if (!world.isClientSide()) {
						ProcedureHelper.playSound(world, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ENDER_EYE_DEATH, SoundSource.PLAYERS, 1, 1);
					}
				}
				{
					boolean _setval = false;
					entity.getCapability(UnusualendModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.isTeleporting = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == UnusualendModBlocks.DRAGLING_PLUSH.get().asItem()
				&& !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualendModBlocks.DRAGLING_PLUSH.get().asItem())) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(UnusualendModBlocks.DRAGLING_PLUSH.get().asItem(), 20);
		}
	}
}

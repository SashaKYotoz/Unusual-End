package net.mcreator.unusualend.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.network.UnusualendModVariables;
import net.mcreator.unusualend.init.UnusualendModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TPConfirmProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
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
						_ent.teleportTo((Mth.nextDouble(RandomSource.create(), -1000, 1000)), (Mth.nextDouble(RandomSource.create(), 100, 120)), (Mth.nextDouble(RandomSource.create(), -1000, 1000)));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((Mth.nextDouble(RandomSource.create(), -1000, 1000)), (Mth.nextDouble(RandomSource.create(), 100, 120)), (Mth.nextDouble(RandomSource.create(), -1000, 1000)), _ent.getYRot(),
									_ent.getXRot());
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 300, 1));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 80, 0));
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("text.unusualend.tp_error").getString())), true);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.PORTAL, (entity.getX()), (entity.getY()), (entity.getZ()), 50, 0.5, 1.5, 0.5, 0);
					if (!world.isClientSide()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_eye.death")), SoundSource.PLAYERS, 1, 1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_eye.death")), SoundSource.PLAYERS, 1, 1, false);
							}
						}
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

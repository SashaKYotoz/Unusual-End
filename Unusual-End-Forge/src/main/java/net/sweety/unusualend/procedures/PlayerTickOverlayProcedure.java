package net.sweety.unusualend.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.sweety.unusualend.network.UnusualendModVariables;
import net.sweety.unusualend.util.ParticleHelper;
import net.sweety.unusualend.util.ProcedureHelper;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerTickOverlayProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(UnusualendModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UnusualendModVariables.PlayerVariables())).ScrapeOverlay == 1) {
			{
				double _setval = 0;
				entity.getCapability(UnusualendModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ScrapeOverlay = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (world instanceof ServerLevel _level)
				{
				PlayerTeam team = _level.getScoreboard().getPlayerTeam(entity.getStringUUID());
				if (team != null)
					_level.getScoreboard().removePlayerTeam(team);
			}
			ParticleHelper.spawn(world, ParticleHelper.enderClothDust(), new Vec3(x, y, z).add(0, 1, 0), 40, 0.4, 0.5, 0.4, 0);
			if (world.isClientSide()) {
				ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.burn")), SoundSource.PLAYERS, (float) 0.3, 1);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.POOF, x, (y + 1), z, 10, 0.5, 0.5, 0.5, 0);
		} else if ((entity.getCapability(UnusualendModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UnusualendModVariables.PlayerVariables())).ScrapeOverlay > 0) {
			{
				double _setval = (entity.getCapability(UnusualendModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UnusualendModVariables.PlayerVariables())).ScrapeOverlay - 1;
				entity.getCapability(UnusualendModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ScrapeOverlay = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (!(entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(MobEffects.INVISIBILITY))) {
				{
					double _setval = 1;
					entity.getCapability(UnusualendModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ScrapeOverlay = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}

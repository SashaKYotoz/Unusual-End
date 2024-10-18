package net.mcreator.unusualend.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.unusualend.network.UnusualendModVariables;
import net.mcreator.unusualend.entity.EndstoneGolemEntity;
import net.mcreator.unusualend.entity.EnderblobQueenEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ReturnMusicProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		return execute(null, world, x, y, z, entity);
	}

	private static boolean execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		boolean music = false;
		music = false;
		if (!world.getEntitiesOfClass(EndstoneGolemEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
			{
				double _setval = 0;
				entity.getCapability(UnusualendModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerMusic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			music = true;
		} else if (!world.getEntitiesOfClass(EnderblobQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
			{
				double _setval = 1;
				entity.getCapability(UnusualendModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerMusic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			music = true;
		} else {
			{
				double _setval = -1;
				entity.getCapability(UnusualendModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerMusic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		return music;
	}
}

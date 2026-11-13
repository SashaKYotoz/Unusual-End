package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sweety.unusualend.config.Config;
import net.sweety.unusualend.init.UnusualendModTags;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OnBreakChorusProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(UnusualendModTags.Blocks.ENDERMITES_INFESTED)) {
			if (Math.random() < Config.BREAKING_CHORUS_SUMMON_ENDERMITE_PERCENTAGE.get() / 100) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.ENDERMITE.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.POOF, x, y, z, 5, 0.1, 0.1, 0.1, 0);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).is(UnusualendModTags.Blocks.MORE_ENDERMITES_INFESTED)) {
			if (Math.random() < Config.BREAKING_POT_SUMMON_ENDERMITE_PERCENTAGE.get() / 100) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.ENDERMITE.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.POOF, x, y, z, 5, 0.1, 0.1, 0.1, 0);
			}
		}
	}
}

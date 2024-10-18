package net.mcreator.unusualend.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.Entity;
import net.minecraft.stats.StatsCounter;
import net.minecraft.stats.Stats;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.entity.EnderlingEntity;

import java.util.List;
import java.util.Comparator;

public class CitrineCandleOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(128 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Phantom) {
					entityiterator.setSecondsOnFire(30);
				}
				if (entityiterator instanceof EnderlingEntity) {
					if (!entityiterator.level().isClientSide())
						entityiterator.discard();
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.POOF, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 10, 0.3, 0.3, 0.3, 0.05);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.WITCH, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 10, 0.3, 0.3, 0.3, 0.05);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.EFFECT, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 10, 0.3, 0.3, 0.3, 0.05);
					if (world.isClientSide()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.extinguish_fire")), SoundSource.HOSTILE, 1, (float) 0.75);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.extinguish_fire")), SoundSource.HOSTILE, 1, (float) 0.75, false);
							}
						}
					}
				}
				if (entityiterator instanceof ServerPlayer restingPlayer) {
					StatsCounter statisticsManager = restingPlayer.getStats();
					if ((float) statisticsManager.getValue(Stats.CUSTOM.get(Stats.TIME_SINCE_REST)) > 100) {
						statisticsManager.increment(restingPlayer, Stats.CUSTOM.get(Stats.TIME_SINCE_REST), -100);
					}
				}
			}
		}
	}
}

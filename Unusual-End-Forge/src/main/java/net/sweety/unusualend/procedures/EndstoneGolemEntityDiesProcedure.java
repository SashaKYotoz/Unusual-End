package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.init.UnusualendModSounds;
import net.sweety.unusualend.util.ProcedureHelper;

public class EndstoneGolemEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 10, 1, 1, 1, 0);
		ProcedureHelper.playSound(world, x, y, z, SoundEvents.GENERIC_EXPLODE, SoundSource.HOSTILE, 1, 1);
		if (world instanceof ServerLevel _level) {
			LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
			entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
			entityToSpawn.setVisualOnly(true);
			_level.addFreshEntity(entityToSpawn);
		}
		for (int index0 = 0; index0 < 5; index0++) {
			UnusualEnd.queueServerWork((int) Mth.nextDouble(world.getRandom(), 5, 10), () -> {
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
					entityToSpawn.setVisualOnly(true);
					_level.addFreshEntity(entityToSpawn);
				}
				ProcedureHelper.playSound(world, x, y, z, SoundEvents.GENERIC_EXPLODE, SoundSource.HOSTILE, 1, 1);
			});
		}
		for (int index1 = 0; index1 < 3; index1++) {
			UnusualEnd.queueServerWork(15, () -> {
				ProcedureHelper.playSound(world, x, y, z, UnusualendModSounds.ENDSTONE_GOLEM_DEATH.get(), SoundSource.HOSTILE, 2, 1);
			});
		}
		if (world instanceof ServerLevel _level)
			ProcedureHelper.spawnProtectedItem(_level, x, y, z, new ItemStack(UnusualendModItems.GOLEM_ORB.get()), true);
		for (int index2 = 0; index2 < Mth.nextInt(world.getRandom(), 2, 4); index2++) {
			if (world instanceof ServerLevel _level)
				ProcedureHelper.spawnProtectedItem(_level, x, y, z, new ItemStack(UnusualendModItems.ANCIENT_SHARD.get()), false);
		}
		if (world instanceof ServerLevel _level) {
			ExperienceOrb orb = new ExperienceOrb(_level, x, y, z, 5000);
			orb.setInvulnerable(true);
			_level.addFreshEntity(orb);
		}
		if (Math.random() < 0.3) {
			if (world instanceof ServerLevel _level)
				ProcedureHelper.spawnProtectedItem(_level, x, y, z, new ItemStack(UnusualendModItems.MUSIC_DISC_ENDSTONE_GOLEM_THEME.get()), false);
		}
	}
}

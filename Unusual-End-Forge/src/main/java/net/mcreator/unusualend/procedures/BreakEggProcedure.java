package net.mcreator.unusualend.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModEntities;
import net.mcreator.unusualend.init.UnusualendModBlocks;

public class BreakEggProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(UnusualendModBlocks.CRACKED_ENDERMITE_EGGS.get().defaultBlockState()));
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.turtle.egg_crack")), SoundSource.BLOCKS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.turtle.egg_crack")), SoundSource.BLOCKS, 1, 1, false);
			}
		}
		world.destroyBlock(BlockPos.containing(x, y, z), false);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.POOF, (x + 0.5), (y + 0.2), (z + 0.5), 20, 1.3, 1.3, 1.3, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.REVERSE_PORTAL, (x + 0.5), (y + 0.2), (z + 0.5), 10, 1.3, 1.3, 1.3, 0);
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 2, 3); index0++) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = EntityType.ENDERMITE.spawn(_level, BlockPos.containing(x + 0.5, y + 0.2, z + 0.5), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = UnusualendModEntities.SMALL_ENDERBULB.get().spawn(_level, BlockPos.containing(x + 0.5, y + 0.2, z + 0.5), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
			}
		}
	}
}

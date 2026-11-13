package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import net.sweety.unusualend.init.UnusualendModBlocks;
import net.sweety.unusualend.init.UnusualendModEntities;
import net.sweety.unusualend.util.ProcedureHelper;

import java.util.Comparator;
import java.util.List;

public class WeakEndermiteEggUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		double proba = 0;
		boolean nearby_player = false;
		boolean hidden = false;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
			nearby_player = false;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (!(ProcedureHelper.isSpectator(entityiterator) || ProcedureHelper.isCreative(entityiterator))) {
							nearby_player = true;
							if (entityiterator.isShiftKeyDown() || entityiterator instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(MobEffects.INVISIBILITY)) {
								hidden = true;
							} else {
								hidden = false;
							}
						}
					}
				}
			}
			if (nearby_player == true) {
				world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(UnusualendModBlocks.CRACKED_ENDERMITE_EGGS.get().defaultBlockState()));
				ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.turtle.egg_crack")), SoundSource.BLOCKS, 1, 1);
				if (hidden == true) {
					proba = 0.3;
				} else {
					proba = 0.9;
				}
				if (Math.random() < proba) {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.POOF, (x + 0.5), (y + 0.2), (z + 0.5), 20, 1.3, 1.3, 1.3, 0);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.REVERSE_PORTAL, (x + 0.5), (y + 0.2), (z + 0.5), 10, 1.3, 1.3, 1.3, 0);
					for (int index0 = 0; index0 < Mth.nextInt(world.getRandom(), 3, 4); index0++) {
						if (Math.random() < 0.8) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.ENDERMITE.spawn(_level, BlockPos.containing(x + 0.5, y + 0.2, z + 0.5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						} else {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = UnusualendModEntities.SMALL_ENDERBULB.get().spawn(_level, BlockPos.containing(x + 0.5, y + 0.2, z + 0.5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						}
					}
				}
			}
		}
		if (!((blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep16 ? blockstate.getValue(_getep16).toString() : "").equals("FLOOR") && world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()
				|| (blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep19 ? blockstate.getValue(_getep19).toString() : "").equals("CEILING")
						&& world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()
				|| (ProcedureHelper.getDirection(blockstate)) == Direction.NORTH && world.getBlockState(BlockPos.containing(x, y, z + 1)).canOcclude() || (ProcedureHelper.getDirection(blockstate)) == Direction.EAST && world.getBlockState(BlockPos.containing(x - 1, y, z)).canOcclude() || (ProcedureHelper.getDirection(blockstate)) == Direction.SOUTH && world.getBlockState(BlockPos.containing(x, y, z - 1)).canOcclude() || (ProcedureHelper.getDirection(blockstate)) == Direction.WEST && world.getBlockState(BlockPos.containing(x + 1, y, z)).canOcclude())) {
			BreakEggProcedure.execute(world, x, y, z);
		}
	}
}

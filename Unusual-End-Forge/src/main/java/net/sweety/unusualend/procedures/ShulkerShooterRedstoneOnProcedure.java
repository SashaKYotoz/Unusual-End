package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.util.ProcedureHelper;

public class ShulkerShooterRedstoneOnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double face = 0;
		if (!(world instanceof Level _level0 && _level0.hasNeighborSignal(BlockPos.containing(x, y, z)))) {
			if (!(world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16, 16, 16), e -> true).stream().sorted(ProcedureHelper.byDistanceTo(x, y, z)).findFirst().orElse(null) == null)) {
				if (!(ProcedureHelper.isCreative(world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16, 16, 16), e -> true).stream().sorted(ProcedureHelper.byDistanceTo(x, y, z)).findFirst().orElse(null)) || ProcedureHelper.isSpectator(world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16, 16, 16), e -> true).stream().sorted(ProcedureHelper.byDistanceTo(x, y, z)).findFirst().orElse(null)))) {
					face = Mth.nextInt(world.getRandom(), 1, 4);
					if (face == 1) {
						if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
							if (world.isClientSide()) {
								ProcedureHelper.playSound(world, x, y, z, SoundEvents.SHULKER_SHOOT, SoundSource.BLOCKS, 1, (float) 0.6);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.POOF, (x + 0.5), (y + 0.5), (z - 0.1), 3, 0.2, 0.2, 0.2, 0.1);
						}
					} else if (face == 2) {
						if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
							if (world.isClientSide()) {
								ProcedureHelper.playSound(world, x, y, z, SoundEvents.SHULKER_SHOOT, SoundSource.BLOCKS, 1, (float) 0.6);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.POOF, (x + 0.5), (y + 0.5), (z + 1.1), 3, 0.2, 0.2, 0.2, 0.1);
						}
					} else if (face == 3) {
						if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
							if (world.isClientSide()) {
								ProcedureHelper.playSound(world, x, y, z, SoundEvents.SHULKER_SHOOT, SoundSource.BLOCKS, 1, (float) 0.6);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.POOF, (x - 0.1), (y + 0.5), (z + 0.5), 3, 0.2, 0.2, 0.2, 0.1);
						}
					} else if (face == 4) {
						if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
							if (world.isClientSide()) {
								ProcedureHelper.playSound(world, x, y, z, SoundEvents.SHULKER_SHOOT, SoundSource.BLOCKS, 1, (float) 0.6);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.POOF, (x + 1.1), (y + 0.5), (z + 0.5), 3, 0.2, 0.2, 0.2, 0.1);
						}
					}
				}
			}
		}
	}
}

package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sweety.unusualend.init.UnusualendModBlocks;
import net.sweety.unusualend.init.UnusualendModEntities;
import net.sweety.unusualend.util.ProcedureHelper;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ShinyGloopstoneBlockDestroyedByPlayerProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState(), event.getPlayer());
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		boolean nearby_player = false;
		if (blockstate.getBlock() == UnusualendModBlocks.SHINY_GLOOPSTONE.get()) {
			if (!(ProcedureHelper.isCreative(entity))) {
				if (Math.random() < 0.02) {
					ProcedureHelper.playSound(world, x, y, z, SoundEvents.TURTLE_EGG_CRACK, SoundSource.BLOCKS, 1, 1);
					for (int index0 = 0; index0 < Mth.nextInt(world.getRandom(), 1, 2); index0++) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.ENDERMITE.spawn(_level, BlockPos.containing(x + 0.5, y + 0.2, z + 0.5), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.POOF, (x + 0.5), (y + 0.2), (z + 0.5), 10, 1.3, 1.3, 1.3, 0);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.REVERSE_PORTAL, (x + 0.5), (y + 0.2), (z + 0.5), 5, 1.3, 1.3, 1.3, 0);
					}
					for (int index1 = 0; index1 < Mth.nextInt(world.getRandom(), 0, 1); index1++) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = UnusualendModEntities.ENDER_BLOB.get().spawn(_level, BlockPos.containing(x + 0.5, y + 0.2, z + 0.5), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
				}
			}
		}
	}
}

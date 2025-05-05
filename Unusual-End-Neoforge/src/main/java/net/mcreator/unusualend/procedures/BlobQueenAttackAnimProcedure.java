package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.unusualend.entity.EnderblobQueenEntity;
import net.mcreator.unusualend.UnusualendMod;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingAttackEvent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BlobQueenAttackAnimProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity sourceentity) {
		execute(null, world, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity sourceentity) {
		if (sourceentity == null)
			return;
        double swing_curve;
		double swing_offset;
		double original_curve;
		if (sourceentity instanceof EnderblobQueenEntity) {
			sourceentity.setSprinting(true);
			swing_offset = 2;
			swing_curve = 1;
			original_curve = swing_curve;
			for (int index0 = 0; index0 < 30; index0++) {
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										("execute anchored eyes positioned ^" + swing_offset + " ^" + (swing_curve + 0.6) + " ^2 run particle minecraft:block unusualend:void_particles_block ~ ~ ~ 0.1 0.1 0.1 0 3"));
					}
				}
				if (Math.random() < 0.1) {
					{
						Entity _ent = sourceentity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("execute anchored eyes positioned ^" + swing_offset + " ^" + (swing_curve + 0.6) + " ^2 run particle minecraft:end_rod ~ ~ ~"));
						}
					}
				}
				if (Math.random() < 0.3) {
					{
						Entity _ent = sourceentity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
									("execute anchored eyes positioned ^" + swing_offset + " ^" + (swing_curve + 0.6) + " ^2 run particle minecraft:squid_ink ~ ~ ~"));
						}
					}
				}
				swing_offset = swing_offset - 0.1;
				swing_curve = swing_curve - original_curve / 10;
			}
			UnusualendMod.queueServerWork(11, () -> {
				sourceentity.setSprinting(false);
			});
		}
	}
}

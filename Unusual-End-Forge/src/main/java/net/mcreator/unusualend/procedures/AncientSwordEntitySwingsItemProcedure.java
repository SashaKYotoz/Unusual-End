package net.mcreator.unusualend.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.unusualend.init.UnusualendModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AncientSwordEntitySwingsItemProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		execute(null, entity, immediatesourceentity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		boolean swing = false;
		double swing_curve = 0;
		double original_curve = 0;
		double swing_offset = 0;
		double dis = 0;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualendModItems.ANCIENT_SWORD.get()) {
			if (immediatesourceentity == sourceentity) {
				swing_offset = 1.5;
				swing_curve = Mth.nextDouble(RandomSource.create(), -0.5, 0.5);
				original_curve = swing_curve;
				if (swing_curve > 0.1) {
					swing = true;
				} else if (swing_curve < -0.1) {
					swing = false;
				} else {
					if (Math.random() < 0.5) {
						swing = true;
						swing_curve = Mth.nextDouble(RandomSource.create(), 0.2, 0.5);
						original_curve = swing_curve;
					} else {
						swing = false;
						swing_curve = Mth.nextDouble(RandomSource.create(), -0.5, -0.2);
						original_curve = swing_curve;
					}
				}
				for (int index0 = 0; index0 < 30; index0++) {
					{
						Entity _ent = sourceentity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
											_ent.level().getServer(), _ent),
									("execute anchored eyes positioned ^" + swing_offset + " ^" + (swing_curve - 0.5) + " ^1.8 run particle minecraft:block unusualend:void_particles_block ~ ~ ~ 0.1 0.1 0.1 0 3"));
						}
					}
					if (Math.random() < 0.1) {
						{
							Entity _ent = sourceentity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands()
										.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
												_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												("execute anchored eyes positioned ^" + swing_offset + " ^" + (swing_curve - 0.5) + " ^1.8 run particle minecraft:end_rod ~ ~ ~"));
							}
						}
					}
					if (Math.random() < 0.3) {
						{
							Entity _ent = sourceentity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands()
										.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
												_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												("execute anchored eyes positioned ^" + swing_offset + " ^" + (swing_curve - 0.5) + " ^1.8 run particle minecraft:squid_ink ~ ~ ~"));
							}
						}
					}
					swing_offset = swing_offset - 0.1;
					if (swing == true) {
						swing_curve = swing_curve - original_curve / 10;
					} else if (swing == false) {
						swing_curve = swing_curve - original_curve / 10;
					}
				}
			}
			dis = Math.sqrt(Math.pow(entity.getX() - sourceentity.getX(), 2) + Math.pow(entity.getY() - sourceentity.getY(), 2) + Math.pow(entity.getZ() - sourceentity.getZ(), 2));
			if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:bosses")))) {
				entity.setDeltaMovement(new Vec3((((sourceentity.getX() - entity.getX()) / dis) * 1), (((sourceentity.getY() - entity.getY()) / dis) * 1), (((sourceentity.getZ() - entity.getZ()) / dis) * 1)));
			}
		}
	}
}

package net.sweety.unusualend.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.util.ParticleHelper;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AncientSwordEntitySwingsItemProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity());
		}
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
				swing_curve = Mth.nextDouble(entity.level().getRandom(), -0.5, 0.5);
				original_curve = swing_curve;
				if (swing_curve > 0.1) {
					swing = true;
				} else if (swing_curve < -0.1) {
					swing = false;
				} else {
					if (Math.random() < 0.5) {
						swing = true;
						swing_curve = Mth.nextDouble(entity.level().getRandom(), 0.2, 0.5);
						original_curve = swing_curve;
					} else {
						swing = false;
						swing_curve = Mth.nextDouble(entity.level().getRandom(), -0.5, -0.2);
						original_curve = swing_curve;
					}
				}
				for (int index0 = 0; index0 < 30; index0++) {
					{
						Entity _ent = sourceentity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							ParticleHelper.spawn(_ent.level(), ParticleHelper.voidParticles(), ParticleHelper.localToEyes(_ent, swing_offset, swing_curve - 0.5, 1.8), 3, 0.1, 0.1, 0.1, 0);
						}
					}
					if (Math.random() < 0.1) {
						{
							Entity _ent = sourceentity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								ParticleHelper.spawn(_ent.level(), ParticleTypes.END_ROD, ParticleHelper.localToEyes(_ent, swing_offset, swing_curve - 0.5, 1.8), 0, 0, 0, 0, 0);
							}
						}
					}
					if (Math.random() < 0.3) {
						{
							Entity _ent = sourceentity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								ParticleHelper.spawn(_ent.level(), ParticleTypes.SQUID_INK, ParticleHelper.localToEyes(_ent, swing_offset, swing_curve - 0.5, 1.8), 0, 0, 0, 0, 0);
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

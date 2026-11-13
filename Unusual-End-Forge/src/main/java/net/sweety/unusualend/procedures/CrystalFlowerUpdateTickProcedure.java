package net.sweety.unusualend.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.util.ProcedureHelper;

import java.util.Comparator;
import java.util.List;

public class CrystalFlowerUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.WITCH, (x + 0.5), (y + 0.5), (z + 0.5), 5, 0.3, 0.3, 0.3, 0.1);
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:blobqueen_immune")))) {
					ProcedureHelper.addEffect(entityiterator, new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1, false, false));
				}
				if (entityiterator instanceof Player) {
					ProcedureHelper.addEffect(entityiterator, new MobEffectInstance(MobEffects.WEAKNESS, 200, 0, false, false));
				}
			}
		}
	}
}

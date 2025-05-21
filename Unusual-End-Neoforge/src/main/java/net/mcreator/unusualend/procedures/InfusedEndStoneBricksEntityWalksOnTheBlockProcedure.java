package net.mcreator.unusualend.procedures;

import net.mcreator.unusualend.UnusualEnd;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;

public class InfusedEndStoneBricksEntityWalksOnTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, UnusualEnd.makeUEID("infused_immunity")))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 5, 0, false, false));
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.DRAGON_BREATH, (x + 0.5), (y + 0.8), (z + 0.5), 1, 0.3, 0.5, 0.3, 0);
	}
}

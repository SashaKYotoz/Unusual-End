package net.mcreator.unusualend.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.unusualend.configuration.UEConfig;

public class CrystalFlowerMobplayerCollidesWithPlantProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (UEConfig.CRYSTAL_NAUSEA.get()) {
			if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("neoforge:blobqueen_immune")))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 120, 0));
			}
		}
	}
}
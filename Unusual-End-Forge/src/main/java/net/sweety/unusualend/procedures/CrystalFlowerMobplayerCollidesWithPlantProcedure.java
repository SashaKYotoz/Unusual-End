package net.sweety.unusualend.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.sweety.unusualend.config.Config;
import net.sweety.unusualend.util.ProcedureHelper;

public class CrystalFlowerMobplayerCollidesWithPlantProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Config.CRYSTAL_NAUSEA.get()) {
			if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:blobqueen_immune")))) {
				ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.CONFUSION, 120, 0));
			}
		}
	}
}

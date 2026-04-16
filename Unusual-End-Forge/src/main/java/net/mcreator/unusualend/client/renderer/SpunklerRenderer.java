
package net.mcreator.unusualend.client.renderer;

import net.mcreator.unusualend.client.model.ModelSpunkler;
import net.mcreator.unusualend.entity.SpunklerEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SpunklerRenderer extends MobRenderer<SpunklerEntity, ModelSpunkler<SpunklerEntity>> {
	public SpunklerRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelSpunkler(context.bakeLayer(ModelSpunkler.LAYER_LOCATION)), 0.4f);
	}

	@Override
	public ResourceLocation getTextureLocation(SpunklerEntity entity) {
		return new ResourceLocation("unusualend:textures/entities/spunkler.png");
	}
}

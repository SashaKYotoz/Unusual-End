
package net.sweety.unusualend.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.client.model.ModelSpunkler;
import net.sweety.unusualend.entity.SpunklerEntity;

public class SpunklerRenderer extends MobRenderer<SpunklerEntity, ModelSpunkler<SpunklerEntity>> {
	public SpunklerRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelSpunkler(context.bakeLayer(ModelSpunkler.LAYER_LOCATION)), 0.4f);
	}

	@Override
	public ResourceLocation getTextureLocation(SpunklerEntity entity) {
		return UnusualEnd.makeUEID("textures/entities/spunkler.png");
	}
}

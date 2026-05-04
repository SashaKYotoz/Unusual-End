
package net.sweety.unusualend.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.client.model.ModelBolok;
import net.sweety.unusualend.entity.BolokEntity;

public class BolokRenderer extends MobRenderer<BolokEntity, ModelBolok<BolokEntity>> {
	public BolokRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelBolok(context.bakeLayer(ModelBolok.LAYER_LOCATION)), 0.4f);
	}

	@Override
	public ResourceLocation getTextureLocation(BolokEntity entity) {
		return UnusualEnd.makeUEID("textures/entities/bolok.png");
	}
}

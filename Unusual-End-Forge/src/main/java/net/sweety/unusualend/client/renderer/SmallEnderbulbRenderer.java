
package net.sweety.unusualend.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.sweety.unusualend.client.model.ModelSmallEnderBulb;
import net.sweety.unusualend.entity.SmallEnderbulbEntity;

public class SmallEnderbulbRenderer extends MobRenderer<SmallEnderbulbEntity, ModelSmallEnderBulb<SmallEnderbulbEntity>> {
	public SmallEnderbulbRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelSmallEnderBulb(context.bakeLayer(ModelSmallEnderBulb.LAYER_LOCATION)), 0.4f);
	}

	@Override
	public ResourceLocation getTextureLocation(SmallEnderbulbEntity entity) {
		return new ResourceLocation("unusualend:textures/entities/enderbulb_open.png");
	}
}

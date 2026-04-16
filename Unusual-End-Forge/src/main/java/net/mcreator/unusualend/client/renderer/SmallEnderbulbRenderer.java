
package net.mcreator.unusualend.client.renderer;

import net.mcreator.unusualend.client.model.ModelSmallEnderBulb;
import net.mcreator.unusualend.entity.SmallEnderbulbEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SmallEnderbulbRenderer extends MobRenderer<SmallEnderbulbEntity, ModelSmallEnderBulb<SmallEnderbulbEntity>> {
	public SmallEnderbulbRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelSmallEnderBulb(context.bakeLayer(ModelSmallEnderBulb.LAYER_LOCATION)), 0.4f);
	}

	@Override
	public ResourceLocation getTextureLocation(SmallEnderbulbEntity entity) {
		return new ResourceLocation("unusualend:textures/entities/enderbulb_open.png");
	}
}

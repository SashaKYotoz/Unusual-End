
package net.sweety.unusualend.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.sweety.unusualend.client.model.ModelEnderBulb;
import net.sweety.unusualend.entity.EnderbulbEntity;

public class EnderbulbRenderer extends MobRenderer<EnderbulbEntity, ModelEnderBulb<EnderbulbEntity>> {
	public EnderbulbRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelEnderBulb(context.bakeLayer(ModelEnderBulb.LAYER_LOCATION)), 0.6f);
	}

	@Override
	public ResourceLocation getTextureLocation(EnderbulbEntity entity) {
		if (entity.getPersistentData().getBoolean("BulbClose") == true) {
			return new ResourceLocation("unusualend:textures/entities/enderbulb_close.png");
		} else {
			return new ResourceLocation("unusualend:textures/entities/enderbulb_open.png");
		}
	}
}

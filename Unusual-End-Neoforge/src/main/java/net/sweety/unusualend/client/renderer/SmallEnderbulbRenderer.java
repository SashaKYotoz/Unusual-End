
package net.sweety.unusualend.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.client.model.ModelSmallEnderbulb;
import net.sweety.unusualend.entity.SmallEnderbulbEntity;

public class SmallEnderbulbRenderer extends MobRenderer<SmallEnderbulbEntity, ModelSmallEnderbulb<SmallEnderbulbEntity>> {
	public SmallEnderbulbRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelSmallEnderbulb(context.bakeLayer(ModelSmallEnderbulb.LAYER_LOCATION)), 0.4f);
	}

	@Override
	public ResourceLocation getTextureLocation(SmallEnderbulbEntity entity) {
		return UnusualEnd.makeUEID("textures/entities/enderbulb_open.png");
	}
}


package net.sweety.unusualend.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.sweety.unusualend.client.model.ModelEnderBlob;
import net.sweety.unusualend.entity.EnderblobEntity;

public class EnderblobRenderer extends MobRenderer<EnderblobEntity, ModelEnderBlob<EnderblobEntity>> {
	public EnderblobRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelEnderBlob(context.bakeLayer(ModelEnderBlob.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EnderblobEntity entity) {
		return new ResourceLocation("unusualend:textures/entities/enderblob.png");
	}
}

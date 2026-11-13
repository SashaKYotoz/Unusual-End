
package net.sweety.unusualend.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.sweety.unusualend.client.model.ModelVoidExplosive;
import net.sweety.unusualend.entity.VoidBombEntity;

public class VoidBombRenderer extends MobRenderer<VoidBombEntity, ModelVoidExplosive<VoidBombEntity>> {
	public VoidBombRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelVoidExplosive(context.bakeLayer(ModelVoidExplosive.LAYER_LOCATION)), 0.4f);
	}

	@Override
	public ResourceLocation getTextureLocation(VoidBombEntity entity) {
		if (entity.getPersistentData().getBoolean("isWhite")) {
			return new ResourceLocation("unusualend:textures/entities/primed_void_explosive.png");
		}
		return new ResourceLocation("unusualend:textures/entities/void_explosive.png");
	}
}

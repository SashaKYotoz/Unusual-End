
package net.mcreator.unusualend.client.renderer;

import net.mcreator.unusualend.client.model.ModelVoidExplosive;
import net.mcreator.unusualend.entity.VoidBombEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

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

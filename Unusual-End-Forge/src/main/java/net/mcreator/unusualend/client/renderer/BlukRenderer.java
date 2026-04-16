
package net.mcreator.unusualend.client.renderer;

import net.mcreator.unusualend.client.model.ModelBluk;
import net.mcreator.unusualend.entity.BlukEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BlukRenderer extends MobRenderer<BlukEntity, ModelBluk<BlukEntity>> {
	public BlukRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelBluk(context.bakeLayer(ModelBluk.LAYER_LOCATION)), 0.3f);
	}

	@Override
	public ResourceLocation getTextureLocation(BlukEntity entity) {
		return new ResourceLocation("unusualend:textures/entities/bluk.png");
	}
}

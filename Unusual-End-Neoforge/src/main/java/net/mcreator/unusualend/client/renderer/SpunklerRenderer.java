
package net.mcreator.unusualend.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.unusualend.entity.SpunklerEntity;
import net.mcreator.unusualend.client.model.Modelspunkler;

public class SpunklerRenderer extends MobRenderer<SpunklerEntity, Modelspunkler<SpunklerEntity>> {
	public SpunklerRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelspunkler(context.bakeLayer(Modelspunkler.LAYER_LOCATION)), 0.4f);
	}

	@Override
	public ResourceLocation getTextureLocation(SpunklerEntity entity) {
		return new ResourceLocation("unusualend:textures/entities/spunkler.png");
	}
}

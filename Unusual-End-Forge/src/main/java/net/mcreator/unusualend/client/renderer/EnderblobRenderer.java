
package net.mcreator.unusualend.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.unusualend.entity.EnderblobEntity;
import net.mcreator.unusualend.client.model.Modelenderblob;

public class EnderblobRenderer extends MobRenderer<EnderblobEntity, Modelenderblob<EnderblobEntity>> {
	public EnderblobRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelenderblob(context.bakeLayer(Modelenderblob.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EnderblobEntity entity) {
		return new ResourceLocation("unusualend:textures/entities/enderblob.png");
	}
}

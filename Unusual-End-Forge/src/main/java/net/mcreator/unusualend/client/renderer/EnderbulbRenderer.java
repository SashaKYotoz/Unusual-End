
package net.mcreator.unusualend.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.unusualend.entity.EnderbulbEntity;
import net.mcreator.unusualend.client.model.Modelenderbulb;

public class EnderbulbRenderer extends MobRenderer<EnderbulbEntity, Modelenderbulb<EnderbulbEntity>> {
	public EnderbulbRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelenderbulb(context.bakeLayer(Modelenderbulb.LAYER_LOCATION)), 0.6f);
	}

	@Override
	public ResourceLocation getTextureLocation(EnderbulbEntity entity) {
		if (entity.getPersistentData().getBoolean("BulbClose")) {
			return new ResourceLocation("unusualend:textures/entities/enderbulb_close.png");
		}
		return new ResourceLocation("unusualend:textures/entities/enderbulb_open.png");
	}
}

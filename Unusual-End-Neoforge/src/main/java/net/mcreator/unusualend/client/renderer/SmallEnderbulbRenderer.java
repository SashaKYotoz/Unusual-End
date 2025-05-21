
package net.mcreator.unusualend.client.renderer;

import net.mcreator.unusualend.UnusualEnd;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.unusualend.entity.SmallEnderbulbEntity;
import net.mcreator.unusualend.client.model.Modelsmall_enderbulb;

public class SmallEnderbulbRenderer extends MobRenderer<SmallEnderbulbEntity, Modelsmall_enderbulb<SmallEnderbulbEntity>> {
	public SmallEnderbulbRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelsmall_enderbulb(context.bakeLayer(Modelsmall_enderbulb.LAYER_LOCATION)), 0.4f);
	}

	@Override
	public ResourceLocation getTextureLocation(SmallEnderbulbEntity entity) {
		return UnusualEnd.makeUEID("textures/entities/enderbulb_open.png");
	}
}

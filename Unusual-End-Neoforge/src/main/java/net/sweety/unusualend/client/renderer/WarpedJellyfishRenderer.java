
package net.sweety.unusualend.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.client.model.ModelGlub;
import net.sweety.unusualend.entity.FlampyrEntity;
import net.sweety.unusualend.entity.GlubEntity;

public class WarpedJellyfishRenderer extends MobRenderer<GlubEntity, ModelGlub<GlubEntity>> {
	public WarpedJellyfishRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelGlub(context.bakeLayer(ModelGlub.LAYER_LOCATION)), 0.3f);
	}

	protected void scale(FlampyrEntity entity, PoseStack posestack, float partialTicks) {
		posestack.scale(entity.getScale(), entity.getScale(), entity.getScale());
	}

	@Override
	public ResourceLocation getTextureLocation(GlubEntity entity) {
		return UnusualEnd.makeUEID("textures/entities/glub.png");
	}
}
